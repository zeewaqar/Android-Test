package com.Automation.androidTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

public class PiP {

    public static void main(String[] args) throws MalformedParameterizedTypeException, MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.getCapability("JBAAGF08A507CPA device");
        dc.getCapability("android");
        dc.getCapability("saarland.cispa.androidtest");
        dc.getCapability( ".PIP");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4473"), dc);

        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.marvin.talkback:id/next_button");
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout");
        el1.click();
        el1.click();

    }
}