import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LoginStep {
	@Given("I am on the Home page")
	def navigateToTheHomePage(){
		WebUI.openBrowser(GlobalVariable.baseUrl)
	}

	@Given("I navigate to the sign in page")
	def navigateToTheSignInPage() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_My Store/a_Sign in'), 10)

		WebUI.click(findTestObject('Object Repository/Page_My Store/a_Sign in'))
	}

	@When("I enter the email as '(.*)' and password as '(.*)'")
	def enterEmaiandPassword(String email, String password) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email'), 10)
		WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email'), email)
		WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Password_passwd'), password)
	}

	@And("I click Sign in button")
	def clickSignInBtn() {
		WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Sign in'))
	}
	@Then("I should see the My Account page")
	def verifyHomePage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_My account - My Store/h1_My account'), 0)
	}
	@Then("I should see the message: '(.*)'")
	def verifyEmailMsg(String expectMsg) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Login - My Store/li_Authentication failed'), 10)
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Login - My Store/li_Authentication failed'), expectMsg)
	}
}