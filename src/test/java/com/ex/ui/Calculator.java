package com.ex.ui;

import org.openqa.selenium.By;

public class Calculator extends BaseTest{

    public void inputInCalculator(String expression) {
        int m = expression.length();
        for (int i = 0; i < m; i++)
        waitForElementClickable(webDriver, By.xpath("//input[@value='" + expression.charAt(i) + "']")).click();
    }
}
