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
#### Use case name:
	Verify login with valid “@colorado.edu” and password
	
#### Description:
	Test the SocialBuff login page
	
#### Pre-conditions:
	User has valid username (“@colorado”) and password (enough long)
	
#### Test steps:
1. Navigate to login page
2. Provide valid user name (“XXX@colorado.edu”)
3. Provide valid password (enough long)
4. Click login button

#### Expected result:
	User should be able to login
	
#### Actual result:
	User is navigated to mainActivity with successful login
	
#### Status (Pass/Fail):
	Pass
	
#### Notes:
	N/A
	
#### Post-conditions:
	User is validated with database and successfully signed into their account.
 	The account session details are logged in database.
	
	
### Sign out

#### Use case name:

    Verify Sign Out function for Socialbuff app
    
#### Description:

    Test the sign out function when the people who have already login in that want to sign out their account.
    
#### Pre-conditions:

    User has already login in their @colorado.edu account.
    
#### Test steps:

    1. Click the sign out button.
    2. The user will sign out their account and return to the login page

#### Expected result:
    
    User should be able to sign out and return to the login page.
    
#### Actual result:

    User is navigated to login in page again with successful sign out.
    
#### Status (Pass/Fail):

    Pass
    
#### Notes:
    N/A
#### Post-conditions:
    User will go back to the login page or they can sign in with another account.
    
    
### Activity navigation (Open and close activity)

#### Use case name:

    Verify user open and close activity
    
#### Description:

    Test the SocialBuff activity page
#### Pre-conditions:

    User has successful login and click activity button
#### Test steps:

    1. Navigate to activity page
    2. Click activity button  
    3. Pop up activity page
    4. Click return button
    5. Go back main page
    
#### Expected result:

    User should be able to get in activity page and return main page
#### Actual result:

    User is navigated to activity page and return main page successful
    
#### Status (Pass/Fail):

    Pass
    
#### Notes:

    We just built login page and main activity page right and we still work on different activity(message, gallery, setting). After we finish it, we can retest it. 
#### Post-conditions:

    User is able to access to any interface in the app and when they touch the go back button they can go back to the previous interface and access to another interfa
