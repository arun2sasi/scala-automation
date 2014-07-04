package com.gu.automation.support

import com.gu.automation.core.WebDriverManagement
import org.openqa.selenium.WebDriver

/**
 * Created by ipamer on 04/07/2014.
 */
class WebDriverFeatureSpec extends BaseFeatureSpec[WebDriver] {

    override implicit var driver: WebDriver = null

    protected def startDriver(): WebDriver = {
      WebDriverManagement.startWebDriver()
    }

}
