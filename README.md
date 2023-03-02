# QA: Framework for Automated Testing in Java

## General
- The framework can be used for mobile testing
- Comments are provided in the code for specific explanations
- Some basic flows from apps are already provided to speed up testing. Or te be used as examples for other tests.
- Android apps can only be tested with emulators that have the Google Playstore installed
- Link to the [Appium](https://appium.io/docs/en/about-appium/intro/) documentation 

## Running tests
(If you do it locally)
1. Have a virtual device that's turned on
2. Start appium
3. Execute the tests


## Test set-up
- Every test gets the '@Test' annotation
- Tests can be further configured, configurations can be combined and are seperated by a , Here are some configurations that are the most usefull. Other configurations are also possible but are not listed here.
   -  **@Test(description="...")**: provides information about tests
   -  **@Test(timeout=...)**: sets a timeout how long the test case can run beforeautomatically failing (in milliseconds)
   -  **@Test(priority=...)**: sets the priority for a test case, the lower the number, the higher the priority (0 = highest priority) No priority set automatically sets it to 0
   -  **@Test(dependsOnMethods-="...")**: sets a prerequisite for the current test, it will not be executed beforethe other method is executed.
   -  **@Test(enabled=...)**: enables or disables a test (can be true or false)
   -  **@Test(groups="...")**: tags a test case, grouping them together

## Waiting in tests
- **tread.sleep(miliseconds)** --> Is a hard coded way that always works but not great to use
- **driver.timeouts().implicitlyWait(5, TimeUnit.SECONDS)** --> Is a hard coded way that's a general set-up for every test, not great to use
- **WebDriverWaitWebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(...)))** --> Is the best way, it only slows down for the time needed, not longer and not shorter. Expected conditions can be further specified

> Waiting in tests can be a solution for certain errors
