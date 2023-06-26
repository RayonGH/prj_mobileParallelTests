package base;

import java.net.MalformedURLException;

public class common{
    public static void setUpEmulator1() throws MalformedURLException {
        String emulator1UDID = "emulator-5554";
        String emulator1PlatformVersion = "11";
        String portNumber1 = "4723";
        appDriver.initializeDriver(emulator1UDID, emulator1PlatformVersion, portNumber1);
    }
    public static void setUpEmulator2() throws MalformedURLException {
        String emulator2UDID = "emulator-5556";
        String emulator2PlatformVersion = "11";
        String portNumber2 = "4724";
        appDriver.initializeDriver(emulator2UDID,emulator2PlatformVersion,portNumber2);
    }
}