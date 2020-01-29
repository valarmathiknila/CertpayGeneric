import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
ExcelData data = findTestData('Certpay/SingleBureau_SingleLine_MSC')

for (def index : (1..data.getRowNumbers())) {
	
    cardNum = data.getValue('CardNumber', index)

    expMonth = data.getValue('ExpMonth', index)

    expYear = data.getValue('ExpYear', index)

    securityCode = data.getValue('SecurityCode', index)

    cardType = data.getValue('CardType', index)
	
	Comments= data.getValue('Comments', index)
	
    'Open Certpay Genericsti application'
    CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.Genericsti_url, (([GlobalVariable.pageLoadTime]) as int[]))

    'Click on \'Demo pages\''
    CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Demo_Pages/BEGIN_PAYMENT'), 'Begin Payment', 
            (([GlobalVariable.pageLoadTime]) as int[]))

    'Click on \'Submit XML\''
    CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/XML_Page/SUBMIT'), 'Submit XML', 
            (([GlobalVariable.pageLoadTime]) as int[]))

    'Click on \'MASTER CARD\''
    CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/MASTER_CARD'), 
        'Master Card', (([GlobalVariable.pageLoadTime]) as int[]))
	
	'Enter Comments'
	CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/COMMENTS'), 'Testing',
		'Comments', (([GlobalVariable.pageLoadTime]) as int[]))

    'Enter card number'
    CardNumber = CustomKeywords.'pages.Genericsti.setUserPaymentDetails'(cardNum)

    'ENter exp date,security code'
    CustomKeywords.'pages.Genericsti.setExpDate'(expMonth, expYear, securityCode)

    'Click on \'Next\''
    CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Information_Page/NEXT'), 
        'Next', (([GlobalVariable.pageLoadTime]) as int[]))

    'Click on \'Process Payment\''
    CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Review_Payment_Page/PROCESS_PAYMENT'), 
        'Process payment', (([GlobalVariable.pageLoadTime]) as int[]))
	
	
	'Click on \'Confirm Payment\''
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Confirm_Payment_Page/CONFIRM_YES'),
		'Process payment', (([GlobalVariable.pageLoadTime]) as int[]))
	
	CustomKeywords.'utilities.SafeActions.safeClick'(findTestObject('CERTPAY_GENERICSTI/Payment_Details_Verification_Page/NEXT'),
		'Process payment', (([GlobalVariable.pageLoadTime]) as int[]))
	
	
}
