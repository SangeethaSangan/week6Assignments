Feature: Test DuplicateLead Functionality
@Functional @Regression
Scenario Outline: TC#05 DuplicateLead with positive flow
Given click on find leads
Given click on email
And Search lead with emailid as <emailid>
And click on findlead button
And click on first listed leadid
And click on duplicateLead
And Clear previous company name
And update companyname field as <companyname>
When click on create 
Then Duplicatelead should be created 
Then Updated company name should be displayed

Examples:
|emailid|companyname|
|'ss@gmail.com'|'CTS'|


@Functional @Regression
Scenario Outline: TC#06 DuplicateLead with negative flow
Given click on find leads
Given click on email
And Search lead with emailid as <emailid>
And click on findlead button
And click on first listed leadid
And click on duplicateLead
And clear lastname field
And update companyname field as <companyname>
When click on create 
But Duplicated lead should not be created 

Examples:
|emailid|companyname|
|'ss@gmail.com'|'CTS'|



