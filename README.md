# Java Framework

## General
Comments are provided in the code for specific explanations

## Waiting in tests
tread.sleep(miliseconds) --> Is a hard coded way that always works but not great to use
driver.timeouts().implicitlyWait(5, TimeUnit.SECONDS) --> Is a hard coded way that's a general set-up for every test, not great to use
WebDriverWaitWebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(...))) --> Is the best way, it only slows down for the time needed, not longer and not shorter. Expected conditions can be further specified

> Waiting in tests can be a solution for certain errors
