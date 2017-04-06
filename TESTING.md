# Test Case

## Who: 
  -Isaiah Sierra-Baron
  -Dominic Deckys
  -Peng Yan
  -Tao Li
 
## Title: Social Buff

## Vision:
We envision a world were interconnectivity is in the palm of your hand. The constantly changing realm of social networks has become an integral part of our lives, and we strive to create the network that interacts with everything and that will move us towards a more connected world.

## Automated Test
EXPLANATION AND SCREENSHOT

## User Acceptance Tests
### LoginTest
Use case name:
	Verify login with valid “@colorado.edu” and password
Description:
	Test the SocialBuff login page
Pre-conditions:
	User has valid username (“@colorado”) and password (enough long)
Test steps:
1. Navigate to login page
2. Provide valid user name (“XXX@colorado.edu”)
3. Provide valid password (enough long)
4. Click login button
Expected result:
	User should be able to login
Actual result:
	User is navigated to mainActivity with successful login
Status (Pass/Fail):
	Pass
Notes:
	N/A
Post-conditions:
	User is validated with database and successfully signed into their account.
 	The account session details are logged in database.
