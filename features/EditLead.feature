Feature: Test EditLead Functionality
@Functional @Regression
Scenario Outline: TC#03 EditLead with positive flow
Given click on find leads
Given click on email
And Search lead with emailid as <emailid>
And click on findlead button
And click on first listed leadid
And click on edit
And update description as <update_description>
When click on update button
Then lead should be updated and verify updated details

Examples:
|emailid|update_description|
|'ss@gmail.com'|'update13'|


@Functional 
Scenario Outline: TC#04 EditLead with negative flow
Given click on find leads
Given click on email
And Search lead with emailid as <emailid>
And click on findlead button
And click on first listed leadid
And click on edit
And clear firstname field
And update description as <update_description>
When click on update button
But Error message is displayed

Examples:
|emailid|update_description|
|'ss@gmail.com'|'update1'|


