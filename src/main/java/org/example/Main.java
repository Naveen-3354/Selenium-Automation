package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            Elements elements = new Elements();
            // Text box
//            driver.get("https://demoqa.com/text-box");
//            elements.textBox(driver);

            // Check box
//            driver.get("https://demoqa.com/checkbox");
//            elements.checkbox(driver);

            // Radio Button
//            driver.get("https://demoqa.com/radio-button");
//            elements.radioButton(driver);

            // Web Table
//            driver.get("https://demoqa.com/webtables");
//            elements.webTable(driver);

            // Buttons
//            driver.get("https://demoqa.com/buttons");
//            elements.buttons(driver);

            // Links
            driver.get("https://demoqa.com/links");
            elements.links(driver);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }


    }
}