package pages;

import base.appDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.Set;

public class appHome {
    public appHome()
    {
        org.openqa.selenium.support.PageFactory.initElements(new AppiumFieldDecorator(appDriver.getDriver()),this);
    }
    @AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
    public AndroidElement btn_continuePermission;
    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement btn_closePopup;

    @AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
    public AndroidElement btn_showProgressBar;

    @AndroidFindBy(id = "android:id/customPanel")
    public AndroidElement popup_progressBar;

    @AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
    public AndroidElement btn_displayTextView;

    @AndroidFindBy(id = "io.selendroid.testapp:id/visibleTextView")
    public AndroidElement txt_displayed;

    @AndroidFindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
    public AndroidElement btn_displayPopupWindow;

    @AndroidFindBy(id = "io.selendroid.testapp:id/topLevelElementTest")
    public AndroidElement btn_displayAndFocusOnLayout;

    @AndroidFindBy(id = "io.selendroid.testapp:id/focusedText")
    public AndroidElement txt_focused;

    public void tap_btnShowProgressBar()
    {
        btn_showProgressBar.click();
    }
    public void tap_btnDisplayTextView()
    {
        btn_displayTextView.click();
    }
    public void tap_btnDisplayPopupWindow()
    {
        btn_displayPopupWindow.click();
    }
    public void tap_btnDisplayAndFocusOnLayout()
    {
        btn_displayAndFocusOnLayout.click();
    }
    public boolean searchTxtOnPopup(String text) {
        Set<String> contextHandles = appDriver.getDriver().getContextHandles();
        String desiredContext = text;
        return contextHandles.contains(desiredContext);
    }
}
