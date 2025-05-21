package com.testing.ex08_File_Upload;

import com.testing.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Lab37_FileUpload extends CommonToAll {
    @Test
    public void test_fileupload_p5() {

        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        String working_dir=System.getProperty("user.dir");
        System.out.println(working_dir);
        String path_file=working_dir+"/src/test/java/com/testing/data.txt";
        uploadFileInput.sendKeys(path_file);
        driver.findElement(By.name("submit")).click();

    }
}