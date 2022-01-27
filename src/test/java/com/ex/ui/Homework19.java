package com.ex.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Homework19 extends BaseTest {

    @Test
    public void testFileUpload() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        WebElement photo = webDriver.findElement(By.xpath("//input[@id='photo']"));
        scrollToElement(webDriver, photo);
        File file = new File("src/main/resources/documents/arbuz.jpg");
        webDriver.findElement(By.xpath("//input[@id='photo']")).sendKeys(file.getAbsolutePath());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectFromTable() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        WebElement tableHeader = webDriver.findElement(By.xpath("//h3/a[text()='Sample Table of Div']"));
        scrollToElement(webDriver, tableHeader);
        List<WebElement> tableRows = webDriver.findElements(By.xpath("//div[@id='post-body-7264005679624427339']//*[@class='divTableRow']"));
        int delt = tableRows.size() - 1;
        int index = (int) (Math.random() * ++delt) + 1;
        waitForElementClickable(webDriver, By.xpath("//div[@id='post-body-7264005679624427339']//*[@class='divTableRow'][" + index + "]//input")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTabs() {
        webDriver.get("https://www.gurock.com/testrail/");
        List<WebElement>  tabs = webDriver.findElements(By.xpath("//ul[@class='gk-header-sticky-main-menu']/li[@class='gk-header-sticky-main-menu-item']/a"));
        int delta = tabs.size() - 1;
        int index = (int) (Math.random() * ++delta);
        String selectedTab = tabs.get(index).getText();
        waitForElementClickable(webDriver, tabs.get(index)).click();

        switch (selectedTab) {
            case "Product expand_more":
            case "Resources expand_more":
                findElement(webDriver, By.xpath("//ul[@class='gk-header-sticky-main-menu']//li[contains(@class, 'show')]"));
                break;
            case "Enterprise":
                findElement(webDriver, By.xpath("//h1"));
                findElement(webDriver, By.xpath("//h1[text()='TestRail Enterprise']"));
                break;
            case "Pricing":
                findElement(webDriver, By.xpath("//h1"));
                findElement(webDriver, By.xpath("//h1[text()='TestRail Pricing']"));
                break;
            default:
                System.out.println("No such tab!");
                break;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalc() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        WebElement result = webDriver.findElement(By.xpath("//input[@id='result']"));
        if (!result.getAttribute("value").isEmpty()) {
            waitForElementClickable(webDriver, By.xpath("//input[@value='c']")).click();
        }
        String check = "4+11=";
        Calculator calc = new Calculator();
        calc.inputInCalculator(check);
        Assert.assertTrue(result.getAttribute("value").equals("15"));
    }

 }
