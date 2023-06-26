package testCases;

import pages.*;
import base.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

//@Execution(ExecutionMode.CONCURRENT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testCases {

    private WebDriverWait wait;
    private appHome page;

    @BeforeEach
    public void setUp() throws MalformedURLException, InterruptedException {
        common.setUpEmulator1();
        common.setUpEmulator2();
        wait = new WebDriverWait(appDriver.getDriver(), 30);
        page = new appHome();
        page.btn_continuePermission.click();
        Thread.sleep(1000);
        page.btn_closePopup.click();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Verify tapping the Show Progress Bar for a while displays the progress bar")
    public void TC1() throws InterruptedException{
        try {
            page.tap_btnShowProgressBar();
            Thread.sleep(1000);
            Assertions.assertTrue(page.popup_progressBar.isDisplayed());
        }
        finally {
            appDriver.getDriver().closeApp();
        }
    }
    @Test
    @DisplayName("Verify tapping the Display text view button displays “Text is sometimes displayed”")
    public void TC2() throws InterruptedException{
        try {
            page.tap_btnDisplayTextView();
            Thread.sleep(1000);
            Assertions.assertTrue(page.txt_displayed.isDisplayed());
            Assertions.assertEquals("Text is sometimes displayed",page.txt_displayed.getText());
        }
        finally {
            appDriver.getDriver().closeApp();
        }
    }
    @Test
    @DisplayName("Unable to Automate since popup is not catchable at all-will modify after researched-Verify tapping the Display Popup Window button displays a popup window with Dismiss\n" +
            "button")
    public void TC3() throws InterruptedException{
        try {
            page.tap_btnDisplayPopupWindow();
            Thread.sleep(1000);
            Assertions.assertTrue(page.searchTxtOnPopup("Dismiss"));
        }
        finally {
            appDriver.getDriver().closeApp();
        }
    }
    @Test
    @DisplayName("Verify tapping the Display and focus on layout button displays “Should only be found\n" +
            "once” text below")
    public void TC4() throws InterruptedException{
        try {
            page.tap_btnDisplayAndFocusOnLayout();
            Thread.sleep(1000);
            Assertions.assertTrue(page.txt_focused.isDisplayed());
            Assertions.assertEquals("Should only be found once",page.txt_focused.getText());
        }
        finally {
            appDriver.getDriver().closeApp();
        }
    }

    @AfterEach
    public void tearDown()
    {
        appDriver.quitDriver();
    }
}
