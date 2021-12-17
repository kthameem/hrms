package com.qa.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CH_EmpProfileObjects {
	public CH_EmpProfileObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Employee Profile']")
	public static WebElement empProfile;

	@FindBy(id = "prefixId")
	public static WebElement prefixCode;

	@FindBy(id = "honorific")
	public static WebElement title;

	@FindBy(id = "l_name")
	public static WebElement lastName;

	@FindBy(id = "m_name")
	public static WebElement middleName;

	@FindBy(id = "f_name")
	public static WebElement firstName;

	@FindBy(id = "nick_name")
	public static WebElement nickName;

	@FindBy(id = "dob")
	public static WebElement dob;

	@FindBy(id = "gender")
	public static WebElement gender;

	@FindBy(id = "mobile")
	public static WebElement mblNumber;

	@FindBy(id = "landline")
	public static WebElement landNumber;

	@FindBy(id = "email")
	public static WebElement email;

	@FindBy(id = "categoryId")
	public static WebElement positionCategory;

	@FindBy(id = "printCatId")
	public static WebElement payRollGroup;

	@FindBy(id = "departmentId")
	public static WebElement departMent;

	@FindBy(id = "divisionId")
	public static WebElement subDepartment;

	@FindBy(id = "costCenterId")
	public static WebElement costCenter;

	@FindBy(id = "businessUnitId")
	public static WebElement businessUnit;

	@FindBy(id = "level")
	public static WebElement jobLevel;

	@FindBy(id = "designationId")
	public static WebElement positionTitle;

	@FindBy(id = "doj")
	public static WebElement dateOfHire;

	@FindBy(id = "reportTo")
	public static WebElement lineManager;

	@FindBy(id = "departmentHead")
	public static WebElement departmentHead;

	@FindBy(id = "status")
	public static WebElement status;

	@FindBy(xpath = "//button[@id='swap']")
	public static WebElement addButton;

	@FindBy(xpath = "(//button)[1]")
	public static WebElement backButton;

	@FindBy(xpath = "(//img)[3]")
	public static WebElement coreHrmsMenu;

	@FindBy(xpath = "//div[@id='secondary-menu']//a")
	public static List<WebElement> secondarySection;

	@FindBy(xpath = "//ul[@id='tertiary-menu']//ul//li")
	public static List<WebElement> horizontalMenu;

	@FindBy(id = "imageName")
	public static WebElement chooseImage;

	@FindBy(xpath = "(//button)[3]")
	public static WebElement addEmployee;

	@FindBy(className = "ui-datepicker-month")
	public static WebElement month;

	@FindBy(className = "ui-datepicker-year")
	public static WebElement year;

	@FindBy(xpath = "(//button)[4]")
	public static WebElement reset;

	@FindBy(id = "ui-datepicker-div")
	public static WebElement toastMessag;

	@FindBy(xpath = "//*[text()='ALL']")
	public static WebElement listOfTablesCheckBox;

	@FindBy(xpath = "(//tr[@role='row']//td[8]//a[@title='Edit'])[1]")
	public static WebElement tableFirstRow;

	@FindBy(xpath = "(//tr[@role='row']//td[8]//a[@title='Edit'])[2]")
	public static WebElement tableSecondRow;

	@FindBy(xpath = "//*[text()='Show ']//select")
	public static WebElement noOfTableShow;

	@FindBy(xpath = "//input[@type='search']")
	public static WebElement searchElement;

	@FindBy(xpath = "//*[@class='pagination']//following::li")
	public static List<WebElement> nextButtons;

	// asendingdecending
	@FindBy(xpath = "//tr[@role='row']//following::td")
	public static List<WebElement> asendingDesending;

	@FindBy(xpath = "//tr[@role='row']//following::td")
	public static WebElement codeascDesec;

	// toastMessageVerify
	@FindBy(xpath = "//div[@class='toast-message']")
	public static WebElement toastMesaageVerify;

	// no of employees
	@FindBy(xpath = "(//div[@class='col-12']//following::div)[2]//span")
	public static WebElement noOfemployees;

	@FindBy(xpath = "//*[contains(text(),'Last Employee')]")
	public static WebElement lastEmployee;
	// dropdownsearch
	@FindBy(id = "printCatId")
	public static WebElement payrollDropDown;

	@FindBy(id = "categoryId")
	public static WebElement categoryDropdown;

	@FindBy(id = "departmentId")
	public static WebElement departmentDropDown;

	@FindBy(id = "divisionId")
	public static WebElement subDeptDropDown;

	@FindBy(id = "designationId")
	public static WebElement positiontitleDropdown;

	@FindBy(xpath = "(//tbody)[2]//td[3]")
	public static WebElement searchDropDownList;

	// view employeeDetails
	@FindBy(xpath = "//tr[@role='row']//td[7]//a[@title='View']")
	public static List<WebElement> listOfViewEmployee;

	@FindBy(id = "back1")
	public static WebElement viewBack;

	@FindBy(xpath = "//*[text()='Password']")
	public static WebElement password;

	@FindBy(xpath = "(//tbody[@class='tab-body']//td)[1]")
	public static WebElement passwordText;

	@FindBy(xpath = "(//button)[1]")
	public static WebElement closepaswd;

	@FindBy(xpath = "(//span[@class='checkmark'])[2]")
	public static WebElement printView;

	@FindBy(id = "back")
	public static WebElement printViewBack;

	@FindBy(xpath = "(//tr[@class='noBorder'])[1]")
	public static WebElement empCode;

	// Edit employeeDetails
	@FindBy(xpath = "//tr[@role='row']//td[8]//a[@title='Edit']")
	public static List<WebElement> listOfEditEmployee;

	@FindBy(xpath = "//tr[@class='odd'][1]")
	public static WebElement tblFirstrow;

	@FindBy(xpath = "//*[text()='Update']")
	public static WebElement updateBtn;

	@FindBy(id = "inactive_reason")
	public static WebElement inactiveReason;

	@FindBy(id = "back")
	public static WebElement updateBacckbtn;

	@FindBy(xpath = "(//tr[@class='odd']//td[6])[1]")
	public static WebElement statusTable;

	// personalDetails
	@FindBy(id = "Button")
	public static WebElement personalReset;

	@FindBy(id = "bloodId")
	public static WebElement bloodGrp;

	@FindBy(id = "nationalityId")
	public static WebElement nationality;

	@FindBy(id = "motherMaiddenName")
	public static WebElement momMaiddName;

	@FindBy(id = "personalEmail")
	public static WebElement personalEmail;

	@FindBy(id = "personalMobile")
	public static WebElement personalMbl;

	@FindBy(id = "birthPlaceId")
	public static WebElement birthPlace;

	@FindBy(id = "maritalStatus")
	public static WebElement maritalSts;

	@FindBy(id = "dow")
	public static WebElement anniversaryDate;

	@FindBy(xpath = "//div[@class='form-check']//following::label")
	public static List<WebElement> personalAllCheckBox;

	@FindBy(xpath = "//*[text()='Passport Number']//following::input[1]")
	public static WebElement passportNum;

	@FindBy(id = "dateIssue")
	public static WebElement pssportdDteIssue;

	@FindBy(id = "dateExpiry")
	public static WebElement pssportdExpiry;

	@FindBy(id = "notice_period")
	public static WebElement noticePeriod;

	@FindBy(id = "notice_period_prob")
	public static WebElement noticePerioProb;

	@FindBy(id = "hmo")
	public static WebElement hmo;

	@FindBy(id = "hmoNo")
	public static WebElement hmoNo;

	@FindBy(id = "dependency")
	public static WebElement dependency;

	@FindBy(id = "remarks")
	public static WebElement remarks;

	@FindBy(xpath = "//*[text()='Add']")
	public static WebElement firstAddPersonalInfo;

	// Adress section
	@FindBy(xpath = "//a[text()='Address']")
	public static WebElement adressLink;

	@FindBy(id = "address")
	public static WebElement address;

	@FindBy(id = "countryId")
	public static WebElement countrySelect;

	@FindBy(id = "countryIdadd")
	public static WebElement countryAdd;

	@FindBy(id = "countryIdsave")
	public static WebElement countrySave;

	@FindBy(id = "countryIdText")
	public static WebElement countryText;

	@FindBy(id = "stateId")
	public static WebElement province;

	@FindBy(id = "stateIdadd")
	public static WebElement provinceAdd;

	@FindBy(id = "stateIdsave")
	public static WebElement provinceSave;

	@FindBy(id = "stateIdText")
	public static WebElement provinceText;

	@FindBy(id = "cityId")
	public static WebElement city;

	@FindBy(id = "cityIdadd")
	public static WebElement cityAdd;

	@FindBy(id = "(//table[@id='shadetbl']//span)[12]")
	public static WebElement citySave;

	@FindBy(xpath = "(//input[@placeholder='Enter City Name'])[1]")
	public static WebElement cityText;

	@FindBy(id = "barangayId")
	public static WebElement barangay;

	@FindBy(id = "barangayIdadd")
	public static WebElement barangayAdd;

	@FindBy(id = "barangayIdsave")
	public static WebElement barangaySave;

	@FindBy(id = "barangayIdText")
	public static WebElement barangayText;

	@FindBy(id = "empAddrLandmark")
	public static WebElement landMark;

	@FindBy(id = "empAddrPincode")
	public static WebElement pinCode;

	@FindBy(id = "fillingtoo")
	public static WebElement presentSamePresent;

	// Bank Section Option
	@FindBy(xpath = "//a[text()='Bank']")
	public static WebElement bankSectionLink;

	@FindBy(id = "paymentMethod")
	public static WebElement paymentMethod;

	@FindBy(id = "bankname")
	public static WebElement bankName;

	@FindBy(id = "bankbranch")
	public static WebElement bankbranch;

	@FindBy(id = "accountNo")
	public static WebElement accountNo;

	@FindBy(id = "bankType")
	public static WebElement bankType;

	@FindBy(id = "bankType")
	public static WebElement acntType;

	@FindBy(id = "percentageSal")
	public static WebElement bankPercentage;

	@FindBy(xpath = "(//table[@id='shadetbl'])[2]//label")
	public static WebElement bankCopyDetails;

	// Education Section

	@FindBy(xpath = "//a[text()='Education']")
	public static WebElement educationSecLink;

	@FindBy(id = "qualification_1")
	public static WebElement qualification;

	@FindBy(id = "degree_1")
	public static WebElement degree;

	@FindBy(id = "course_1")
	public static WebElement course;

	@FindBy(id = "specialization_1")
	public static WebElement specialization;

	@FindBy(id = "institute_1")
	public static WebElement institute;

	@FindBy(id = "from_1")
	public static WebElement schoolFromYear;

	@FindBy(id = "to_1")
	public static WebElement schooFromlTo;

	@FindBy(id = "passing_1")
	public static WebElement passingYear;

	@FindBy(id = "qualification_2")
	public static WebElement qualification1;

	@FindBy(id = "degree_2")
	public static WebElement degree1;

	@FindBy(id = "course_2")
	public static WebElement course1;

	@FindBy(id = "specialization_2")
	public static WebElement specialization1;

	@FindBy(id = "institute_2")
	public static WebElement institute1;

	@FindBy(id = "from_2")
	public static WebElement schoolFromYear1;

	@FindBy(id = "to_2")
	public static WebElement schooFromlTo1;

	@FindBy(id = "passing_2")
	public static WebElement passingYear1;

	@FindBy(xpath = "(//form[@id='empEducationalInfo']//a)[1]")
	public static WebElement addEducationInfo;

	@FindBy(xpath = "(//form[@id='empEducationalInfo']//a)[2]")
	public static WebElement deleteEducationInfo;

	// experienceSection

	@FindBy(xpath = "//*[text()='Experience']")
	public static WebElement experienceSecLink;

	@FindBy(xpath = "(//form[@id='empExperienceInfo']//a)[1]")
	public static WebElement addExperienceInfo;

	@FindBy(xpath = "(//form[@id='empExperienceInfo']//a)[2]")
	public static WebElement deleteExperienceInfo;

	@FindBy(id = "companyName_1")
	public static WebElement company;

	@FindBy(id = "industry_1")
	public static WebElement industry;

	@FindBy(id = "strtDesigantion_1")
	public static WebElement strtDesigantion;

	@FindBy(id = "strtSalary_1")
	public static WebElement strtSalary;

	@FindBy(id = "fromm_1")
	public static WebElement experienceStartFrom;

	@FindBy(id = "too_1")
	public static WebElement experienceToDate;

	@FindBy(id = "emailId_1")
	public static WebElement immidiateSup;

	@FindBy(id = "contactNumber_1")
	public static WebElement contactNumber;

	@FindBy(id = "endDesigantion_1")
	public static WebElement endDesigination;

	@FindBy(id = "endSalary_1")
	public static WebElement endSalary;

	@FindBy(id = "address_1")
	public static WebElement companyAddress;

	@FindBy(id = "companyName_2")
	public static WebElement company1;

	@FindBy(id = "industry_2")
	public static WebElement industry1;

	@FindBy(id = "strtDesigantion_2")
	public static WebElement strtDesigantion1;

	@FindBy(id = "strtSalary_2")
	public static WebElement strtSalary1;

	@FindBy(id = "fromm_2")
	public static WebElement experienceStartFrom1;

	@FindBy(id = "too_2")
	public static WebElement experienceToDate1;

	@FindBy(id = "emailId_2")
	public static WebElement immidiateSup1;

	@FindBy(id = "contactNumber_2")
	public static WebElement contactNumber1;

	@FindBy(id = "endDesigantion_2")
	public static WebElement endDesigination1;

	@FindBy(id = "endSalary_2")
	public static WebElement endSalary1;

	@FindBy(id = "address_2")
	public static WebElement companyAddress1;

	// documentUpload

	@FindBy(id = "documentId")
	public static WebElement selectDocument;

	@FindBy(xpath = "//*[text()='Document']")
	public static WebElement documentSecLink;

	@FindBy(id = "docFile")
	public static WebElement chooseFile;

	@FindBy(xpath = "(//tbody)[4]//td[3]//a[@title='Download']")
	public static List<WebElement> downloadImgBtn;

	@FindBy(xpath = "(//tbody)[4]//td[4]//a[@title='Delete']")
	public static List<WebElement> deleteImgBtn;

	@FindBy(xpath = "(//button[text()='Yes'])[3]")
	public static WebElement deleteYes;

	@FindBy(xpath = "(//button[text()='NO'])")
	public static WebElement deleteNo;

	// family
	@FindBy(xpath = "//a[text()='Family']")
	public static WebElement familySecLink;

	@FindBy(id = "name_1")
	public static WebElement famName;

	@FindBy(id = "relationship_1")
	public static WebElement famRelationship;

	@FindBy(id = "contactNo_1")
	public static WebElement famContactNo;

	@FindBy(xpath = "((//table[@id='shadetbl'])[2]//span)[6]")
	public static WebElement famEmergencyContact;

	@FindBy(id = "DOB_1")
	public static WebElement famDob;

	@FindBy(id = "address_1")
	public static WebElement famAddress;

	@FindBy(xpath = "((//table[@id='shadetbl'])[2]//span)[12]")
	public static WebElement famHmoDependent;

	@FindBy(id = "hmoNumber_1")
	public static WebElement famHmoNumber;

	@FindBy(id = "images_1")
	public static WebElement famChooseImage;

	// statutory
	@FindBy(xpath = "//*[text()='Statutory']")
	public static WebElement statutrySecLink;

	@FindBy(id = "payType")
	public static WebElement payType;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[1]")
	public static WebElement minimumWageEarnerNYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[2]")
	public static WebElement minimumWageEarnerNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[3]")
	public static WebElement deductWithoutHoldYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[4]")
	public static WebElement deductWithoutHoldNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[5]")
	public static WebElement recurringStatutory;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[6]")
	public static WebElement deductSSYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[7]")
	public static WebElement deductSSNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[8]")
	public static WebElement recurring1Statutory;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[20]")
	public static WebElement recurring3Statutory;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[9]")
	public static WebElement empPayEasyYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[10]")
	public static WebElement empPayEasyNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[11]")
	public static WebElement deductPhilHealthYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[12]")
	public static WebElement deductPhilHealthNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[13]")
	public static WebElement recurring2Statutory;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[14]")
	public static WebElement deductvoulntaryBigYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[15]")
	public static WebElement deductvoulntaryBigNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[18]")
	public static WebElement DEDUCTPAGbagPigYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[19]")
	public static WebElement DEDUCTPAGbagPigNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[21]")
	public static WebElement voluntibigYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[22]")
	public static WebElement voluntibigNo;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[23]")
	public static WebElement MonthPayYes;

	@FindBy(xpath = "//span[@id='err_payType']//following::label[24]")
	public static WebElement MonthPayNo;

	@FindBy(id = "region")
	public static WebElement regionStatutory;

	@FindBy(id = "whtCycle")
	public static WebElement whtCycleStatutory;

	@FindBy(id = "taxIdentyNo")
	public static WebElement taxIdentyNo;

	@FindBy(id = "taxClassify")
	public static WebElement taxClassification;

	@FindBy(id = "expanTaxPercent")
	public static WebElement expandTax;

	@FindBy(id = "sssCycle")
	public static WebElement sssCycle;

	@FindBy(id = "PhilhealthNo")
	public static WebElement philHelathNum;

	@FindBy(id = "PhilhealthAmt")
	public static WebElement philHelathMaxAmnt;

	@FindBy(id = "SSSNo")
	public static WebElement sclSecurityNo;

	@FindBy(id = "philhealthCycle")
	public static WebElement philhealthCycle;

	@FindBy(id = "pagibigCycle")
	public static WebElement pagIbigCycle;

	@FindBy(id = "pagIBIGNo")
	public static WebElement pagIBIGNo;

	@FindBy(id = "pagIBIGAmt")
	public static WebElement pagIBIGAmmnt;

	@FindBy(id = "takehomePay")
	public static WebElement TackHomePay;

	@FindBy(id = "dayRate")
	public static WebElement dayRate;

	// attendance

	@FindBy(xpath = "//*[text()='Attendance']")
	public static WebElement attendancSecLink;

	@FindBy(xpath = "//*[text()='Rest Days']//following::label")
	public static List<WebElement> restDaysCheckBox;

	@FindBy(id = "noOfWorkdayinMonth")
	public static WebElement noOfWorkingMonth;

	@FindBy(id = "excessHourMethod")
	public static WebElement excessHour;

	@FindBy(id = "biometricNo")
	public static WebElement biometricNo;

	@FindBy(id = "policy")
	public static WebElement attendancePolicy;

	@FindBy(id = "policyEffectDate")
	public static WebElement policyEffectDate;

	@FindBy(id = "shiftId")
	public static WebElement shiftName;

	@FindBy(id = "shiftEffectDate")
	public static WebElement shiftEffectDate;

	@FindBy(xpath = "//*[text()='Default Attendance']//following::label")
	public static List<WebElement> defaultAttendance;

	@FindBy(id = "logPrioritization")
	public static WebElement logPrioritization;

	@FindBy(xpath = "//*[text()='Mobile Attendance']//following::span")
	public static List<WebElement> attendanceMobile;

	// trainning
	@FindBy(xpath = "//*[text()='Training']")
	public static WebElement trainingSecLink;

	@FindBy(id = "title_1")
	public static WebElement trainningTitle;

	@FindBy(id = "courseStartingDate_1")
	public static WebElement courseStartingDate;

	@FindBy(id = "CourseEndingDate_1")
	public static WebElement courseEndingDate;

	@FindBy(id = "courseCost_1")
	public static WebElement trainningCost;

	@FindBy(id = "images_1")
	public static WebElement certificateChoseImg;

	@FindBy(id = "remarks_1")
	public static WebElement remarksTrainning;

	// approval

	@FindBy(xpath = "//*[text()='Approval']")
	public static WebElement approvalSecLink;

	@FindBy(id = "leaveDet")
	public static WebElement leaveAbsenceAdd;

	@FindBy(id = "failureDet")
	public static WebElement failureTimeAdd;

	@FindBy(id = "officialDet")
	public static WebElement officialBussiAdd;

	@FindBy(id = "overtimeDet")
	public static WebElement overTimeAdd;

	@FindBy(id = "restDet")
	public static WebElement restDatAdd;

	@FindBy(id = "shiftDet")
	public static WebElement shiftCodeAdd;

	@FindBy(id = "compoffDet")
	public static WebElement toilAdd;

	@FindBy(id = "loanDet")
	public static WebElement loanAdd;

	@FindBy(id = "resigDet")
	public static WebElement resiginationAdd;

	@FindBy(xpath = "(//table[@id='shadetbl'])[2]//following::a")
	public static List<WebElement> addApproval;

	@FindBy(xpath = "(//ul)[7]//following::li")
	public static List<WebElement> listOfEmployeedetailsApprovel;

	@FindBy(xpath = "//input[@id='LeaveApprover_1']")
	public static WebElement approver1;

	@FindBy(xpath = "//input[@id='LeaveApprover_5']")
	public static WebElement leaveHrRep;

	@FindBy(xpath = "(//*[text()='Close'])[1]")
	public static WebElement approvalClose;

	@FindBy(id = "TimeApprover_1")
	public static WebElement TimeApprover;

	@FindBy(id = "TimeApprover_5")
	public static WebElement TimeApproverHrRep;

	@FindBy(id = "officialApprover_1")
	public static WebElement officialBusinessTripApprover;

	@FindBy(id = "officialApprover_5")
	public static WebElement officialBusinessTripHrRep;

	@FindBy(id = "overtimeApprover_1")
	public static WebElement ovrtimeApprover;

	@FindBy(id = "overtimeApprover_5")
	public static WebElement overtimeHrRep;

	@FindBy(id = "restdayApprover_1")
	public static WebElement restdayApprover;

	@FindBy(id = "restdayApprover_5")
	public static WebElement restdayHrRep;

	@FindBy(id = "shiftApprover_1")
	public static WebElement shifyCodeApprover;

	@FindBy(id = "shiftApprover_5")
	public static WebElement shifyCodeHrRep;

	@FindBy(id = "compoffApprover_1")
	public static WebElement toilApprover;

	@FindBy(id = "compoffApprover_5")
	public static WebElement toilHrRep;

	@FindBy(id = "loanApprover_1")
	public static WebElement loanApprover;

	@FindBy(id = "loanApprover_5")
	public static WebElement loanHrRep;

	@FindBy(id = "resigApprover_1")
	public static WebElement resigApprover;

	@FindBy(id = "resigApprover_5")
	public static WebElement resigHrRep;

	@FindBy(xpath = "(//ul)[8]//li[1]")
	public static WebElement hrRepEmployeeToolTip;

	@FindBy(id = "leave")
	public static WebElement updateApproval1;

	@FindBy(id = "Time")
	public static WebElement updateApproval2;

	@FindBy(id = "Official")
	public static WebElement updateApproval3;

	@FindBy(id = "Overtime")
	public static WebElement updateApproval4;

	@FindBy(id = "Restday")
	public static WebElement updateApproval5;

	@FindBy(id = "Shift")
	public static WebElement updateApproval6;

	@FindBy(id = "compoff")
	public static WebElement updateApproval7;

	@FindBy(id = "loan")
	public static WebElement updateApproval8;

	@FindBy(id = "FandF")
	public static WebElement updateApproval9;

	// Assets
	@FindBy(xpath = "//*[text()='Assets']")
	public static WebElement assetsLinks;

	@FindBy(xpath = "//div[@class='col-6']//label")
	public static List<WebElement> checkBoxAssets;

	@FindBy(id = "assetValue_4")
	public static WebElement bluetooth;

	@FindBy(id = "assetDate_4")
	public static WebElement bluetoothDate;
	// ----------------------------------------------------------

	@FindBy(id = "assetValue_7")
	public static WebElement deskTop;

	@FindBy(id = "assetDate_7")
	public static WebElement desktopDate;

	// ------------------------------------------------------------

	@FindBy(id = "assetValue_1")
	public static WebElement identyCard;

	@FindBy(id = "assetDate_1")
	public static WebElement idenrtCardDate;

	// -------------------------------------------------------------
	@FindBy(id = "assetValue_9")
	public static WebElement ram8GB;

	@FindBy(id = "assetDate_9")
	public static WebElement ram8GBDate;
	// ---------------------------------------------------------
	@FindBy(id = "assetValue_2")
	public static WebElement laptop;

	@FindBy(id = "assetDate_2")
	public static WebElement laptopDate;

	// ---------------------------------------------------------------

	@FindBy(id = "assetValue_10")
	public static WebElement test;

	@FindBy(id = "assetDate_10")
	public static WebElement testDate;

	// -------------------------------------------------------------------

	@FindBy(id = "assetValue_5")
	public static WebElement wirelessMouse;

	@FindBy(id = "assetDate_5")
	public static WebElement wirelessMouseDate;

	@FindBy(xpath = "(//*[text()='Update'])[2]")
	public static WebElement assetsUpdate;

	// Others
	@FindBy(xpath = "(//*[text()='Others'])[2]")
	public static WebElement othersSecLink;

	@FindBy(id = "currentWorkCityId")
	public static WebElement domicile;

	@FindBy(id = "workLocation")
	public static WebElement workLocationOthers;

	@FindBy(id = "empType")
	public static WebElement empType;

	@FindBy(id = "ceDate")
	public static WebElement contractExpDate;

	@FindBy(id = "conDate")
	public static WebElement contractDuration;

	@FindBy(id = "mktDesignation")
	public static WebElement mktDesignation;

	@FindBy(id = "sourceOfHire")
	public static WebElement sourceOfHire;

	@FindBy(id = "seatingLocation")
	public static WebElement seatingLocation;

	@FindBy(id = "extension")
	public static WebElement deskExtension;

	@FindBy(id = "remarks1")
	public static WebElement remarks1;

	@FindBy(id = "probMonth")
	public static WebElement probMonth;

	@FindBy(id = "probDays")
	public static WebElement probDays;

	@FindBy(xpath = "(//label[text()='Yes'])[3]")
	public static WebElement applicalibilityYes;

	@FindBy(id = "finalConfirmationDate")
	public static WebElement dateForConfirm;
}
