package com.gu.example

import com.gu.automation.support.{Config, LoggingIn, TestLogging}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers._

/**
 * Created by ipamer on 02/06/2014.
 */
case class ExampleSteps(implicit driver: WebDriver) extends TestLogging with LoggingIn {

  def loggedIn() = {
    logger.step("I am logged in")
    /*
    We use the API to log in and put the cookies into the browser
    your local.conf needs to contain something like:

      user: {
        username : "test.user@guardian.co.uk"
        password : "asdf"
      }

     */
    val loginPage = logInToPage(LoginPage.goto, Config().getUserValue("username"), Config().getUserValue("password"))
    loginPage//.doSomethingElse("asdf")
    this
  }

  def goToTheEventsPage() = {
    this
  }

  def seeAListOfEvents() = {
    logger.step("I see a list of events")

    "hello" should be("hello")

    this
  }

}
