package com.gu.example

import com.gu.automation.support.TestLogger
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers._

/**
 * Created by ipamer on 02/06/2014.
 */
case class ExampleSteps(implicit driver: WebDriver, logger: TestLogger) /*extends LoggingIn*/ {

  def loggedIn() = {
    logger.step("I am logged in")
    /*
    We use the API to log in and put the cookies into the browser
    your local.conf needs to contain something like:

      loginEmail : "test.user@guardian.co.uk"
      loginPassword : "asdf"

     */
//    val loginPage = logInToGUPage(LoginPage.goto)
//    loginPage//.doSomethingElse("asdf")
    LoginPage.goto
    this
  }

  def goToTheEventsPage() = {
    logger.step("I go to the events page")
    this
  }

  def seeAListOfEvents() = {
    logger.step("I see a list of events")
    "hello" should be("hello")
    this
  }

}