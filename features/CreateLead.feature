Feature: Create Lead Functionality
@Functional @Regression @Sanity
Scenario Outline: TC_01 CreateLead as positive testcase

When click on CreateLead
Then CreateLead page is displayed
Given Enter CompanyName as <companyname>
And Enter FirstName as <firstname>
And Enter LastName as <lastname>
And select source from dropdown as <sourceid>
And Enter FirstLocalName as <firstlocalname>
And Enter LastLocalName as <lastnamelocal>
And Enter DepartmentName as <deptname>
And Enter Description as <description>
And Enter emailid as <emailid>
And Select country from dropdown as <country>
When click on submit button
Then LeadId is Created

Examples:
|username|password|companyname|firstname|lastname|sourceid|firstlocalname|lastnamelocal|deptname|description|emailid|country|
|'DemosalesManager'|'crmsfa'|'TCS'|'Sangeetha'|'Sangan'|'Employee'|'Sangee'|'S'|'ECE'|'test1'|'ss@gmail.com'|'India'|


@Functional @Regression
Scenario Outline: TC_02 CreateLead without mandatory field negative testcase

When click on CreateLead
Then CreateLead page is displayed
Given Enter CompanyName as <companyname>
And Enter LastName as <lastname>
And select source from dropdown as <sourceid>
And Enter FirstLocalName as <firstlocalname>
And Enter LastLocalName as <lastnamelocal>
And Enter DepartmentName as <deptname>
And Enter Description as <description>
And Enter emailid as <emailid>
And Select country from dropdown as <country>
When click on submit button
#Then LeadId is Created
But Error messagge is displayed

Examples:
|username|password|companyname|lastname|sourceid|firstlocalname|lastnamelocal|deptname|description|emailid|country|
|'DemosalesManager'|'crmsfa'|'TCS'|'Sangan'|'Employee'|'Sangee'|'S'|'ECE'|'test1'|'ss@gmail.com'|'India'|