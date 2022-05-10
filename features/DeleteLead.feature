Feature: Test DeleteLead Functionality
@Functional @Regression @Sanity
Scenario Outline: TC#07 DeleteLead with positive flow

Given click on find leads
Given click on email
And Search lead with emailid as <emailid>
And click on findlead button

And click on first listed leadid
Given Print selected leadid
When click on delete
#Then leadid is displayed and mylead page is displayed
Then verify whether leadid is deleted or not


Examples:
|emailid|
|'ss@gmail.com'|






