
Feature: Title of your feature


 Scenario Outline: Login Data Driven
  Given User Launch Chorme Broswer
  When User open url "https://admin-demo.nopcommerce.com/login"
  And User enter Email as "<email>" and password as "<password>"
  And User click on Login button
  Then User verify the page title should be "Dashboard / nopCommerce administration"
  Then Close broswer

  Examples:
|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin12|
