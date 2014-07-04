package com.gu.automation.core

import java.net.URL
import java.util.concurrent.TimeUnit

import com.gu.automation.support.{Config, TestLogging}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.{Augmenter, DesiredCapabilities, RemoteWebDriver}
import org.openqa.selenium.support.events.EventFiringWebDriver

object WebDriverManagement extends TestLogging {

  val browser: String = Config().getBrowser()
  val webDriverRemoteUrl: String = Config().getWebDriverRemoteUrl()

  def startWebDriver(testName: String): WebDriver = {
    if (webDriverRemoteUrl == "") {
      return getLocalWebDriver()
    } else {
      val caps = getCapabilities()
      caps.setCapability("name", testName) // saucelabs title
      val driver = new EventFiringWebDriver(new Augmenter().augment(new RemoteWebDriver(new URL(webDriverRemoteUrl), caps)))
          .register(new DriverEventListener())
      driver.manage.timeouts.implicitlyWait(30, TimeUnit.SECONDS)
      val userAgent = driver.executeScript("return navigator.userAgent")
      logger.info("Started browser: " + userAgent)
      return driver
    }
  }

  private def getLocalWebDriver(): WebDriver = browser match {
    case "firefox" => new FirefoxDriver()
    case "chrome" => new ChromeDriver()
    case "ie" => new InternetExplorerDriver()
  }
  private def getCapabilities(): DesiredCapabilities = browser match {
    case "chrome" => DesiredCapabilities.chrome()
    case "firefox" => DesiredCapabilities.firefox()
    case "ie" => DesiredCapabilities.internetExplorer()
  }
}
