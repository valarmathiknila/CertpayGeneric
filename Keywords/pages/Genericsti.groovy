package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.locks.Condition

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utilities.DynamicLocators
import utilities.SafeActions

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Genericsti {
	SafeActions safe=new SafeActions()


	

	// Entering user personal details like card number
	@Keyword
	def setUserPaymentDetails(String cardNum){

		
		safe.safeType(findTestObject('Object Repository/CERTPAY_GENERICSTI/Payment_Information_Page/CARD_NUMBER')
				, cardNum, 'CardNum', (([GlobalVariable.pageLoadTime]) as int[]))
		String cardNumber=null;

		if(cardNum.startsWith("3")){
			cardNumber=cardNum.substring(11)
		}
		else {
			cardNumber=cardNum.substring(12)
		}

		return cardNumber;

	}
	

	// set expiration date of credit or debit card
	@Keyword
	def setExpDate(String sExpMonth,String sExpYear,String securityCode){

		safe.safeSelectOptionInDropdownByVisibleText(findTestObject('Object Repository/CERTPAY_GENERICSTI/Payment_Information_Page/EXP_MONTH'), sExpMonth, 'expMonth', (([GlobalVariable.pageLoadTime]) as int[]))


		safe.safeSelectOptionInDropdownByVisibleText(findTestObject('Object Repository/CERTPAY_GENERICSTI/Payment_Information_Page/EXP_YEAR'), sExpYear,' expYear', (([GlobalVariable.pageLoadTime]) as int[]))

		safe.safeType(findTestObject('Object Repository/CERTPAY_GENERICSTI/Payment_Information_Page/SECURITY_CODE'), securityCode, 'securityCode',  (([GlobalVariable.pageLoadTime]) as int[]))
	}


//verification of Payment Approval
	@Keyword
	def verifyPaymentApproval(TestObject testObject){

		String paymentId=WebUI.getText(	findTestObject('Object Repository/CERTPAY_GENERICSTI/Payment_Details_Verification_Page/PAYMENT_ID'))

		if(WebUI.verifyElementPresent(	testObject, 30))
		{
			KeywordUtil.markPassed("Payment is approved")
			//WebUI.executeJavaScript("alert('Payment is approved')", null)
			Thread.sleep(2000);
		}
		else
		{
			KeywordUtil.markFailed("Payment is not approved")
			//WebUI.executeJavaScript("alert('Payment is not approved')", null)
		}
		println paymentId;
		return paymentId;
	}
	


}
