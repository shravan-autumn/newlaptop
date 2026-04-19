Feature: Home-page

Background: Below are the comments steps
Given Launch the browser
When user navigates to "https://letshyphen.com/"

Scenario: Verify the logo in the homepage
Then Logo is displayed 

Scenario: Verify New launches in header
When User clicks on new New Launches link
Then Verify if user is redirected to new launches page 

Scenario: Verify About us in header
When User clicks on About us link
Then Verify if user is redirected to about us page 

Scenario: Verify Hero banner
When User clicks on hero banner
Then Verify if user is redirected to all collection page 


