package wisemen.mobile.screenObjects;

import org.openqa.selenium.WebElement;

public interface ConnectChargerScreen {
    WebElement getScanBarcode();
    boolean scanBarcodeIsDisplayed();
}
