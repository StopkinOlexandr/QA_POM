package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(wd).getForms();
    new SidePanel(wd).selectPracticeForm().hideIframes();
  }

  @Test
  public void fillPracticeFormTestWithFinalData() {
    new PracticeFormPage(wd);
    new PracticeFormPage(wd)
        .enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.EMAIL,
            StudentData.PHONE_NUMBER)
        .selectGender(StudentData.GENDER)
//        .typeData(StudentData.B_DAY)
        .selectDate("May", "1978", "14")
        .addSubject(StudentData.SUBJECTS)
        .selectHobby(StudentData.HOBBIES)
        .upLoadFile(StudentData.PHOTO_PATH)
        .enterAddress(StudentData.ADDRESS)
        .selectState(StudentData.STATE)
        .selectCity(StudentData.CITY)
        .submit();

    new PracticeFormPage(wd).assertModalWindowMessage("Thanks for submitting the form");
//        .assertTrue(confirmResult.getText().contains("Thanks for submitting the form"));
//        .assert();

  }

//  @Test
//  public void fillPracticeFormTest() {
//    new PracticeFormPage(wd);
//    new PracticeFormPage(wd)
//        .enterPersonalData("Vasja", "Balbesov", "v.balbes@mail.com", "01234567891")
//        .selectGender("Male")
//        .typeData("25 May 1999")
//        .addSubject(new String[]{"Math", "English", "Chemistry"})
//        .selectHobby(new String[]{"Sports", "Reading", "Music"})
//        .upLoadFile("c:/my_work/QA/pepa.jpg ")
//        .enterAddress("Current address :)")
//        .selectState("NCR")
//        .selectCity("Delhi")
//        .submit();
//  }

}
