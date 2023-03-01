# Java Framework

## General
- Framework can be used for web and mobile testing
- Comments are provided in the code for specific explanations
- Some basic flows from apps are already provided to speed up testing. Or te be used as examples for other tests.

## Waiting in tests
- tread.sleep(miliseconds) --> Is a hard coded way that always works but not great to use
- driver.timeouts().implicitlyWait(5, TimeUnit.SECONDS) --> Is a hard coded way that's a general set-up for every test, not great to use
- WebDriverWaitWebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(...))) --> Is the best way, it only slows down for the time needed, not longer and not shorter. Expected conditions can be further specified

> Waiting in tests can be a solution for certain errors
