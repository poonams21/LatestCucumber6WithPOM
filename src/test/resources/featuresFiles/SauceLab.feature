Feature: SauceLabAccount Page Feature

Background:
Given user has already logged in to sauceApplication
|username|password|
|standard_user|secret_sauce|

@accounts
Scenario: Inventory page title
Given user is on Inventory page
When user gets the title of the SauceLabPage
Then SauceLabPage title should be "Swag Labs"