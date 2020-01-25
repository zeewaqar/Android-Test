package com.Automation.androidTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

public class Keyboard_Focus {

    public static void main(String[] args) throws MalformedParameterizedTypeException, MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.getCapability("JBAAGF08A507CPA device");
        dc.getCapability("android");
        dc.getCapability("saarland.cispa.androidtest");
        dc.getCapability( ".Keyboard_Focus");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4473"), dc);


        MobileElement el1 = (MobileElement) driver.findElementById("saarland.cispa.androidtest:id/btn_keyboard");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("saarland.cispa.androidtest:id/editText");
        el2.click();

    }
}
