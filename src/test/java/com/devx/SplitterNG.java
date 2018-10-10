package com.devx;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class SplitterNG {

    private Splitter splitter;

    @BeforeTest
    public void setUp(){
        splitter = new Splitter();
    }

    @DataProvider
    public Object[][] getWrongLetter(){
        return new Object[][] {
                {'1'},
                {Character.MIN_VALUE},
                {'-'},
                {'{'},
                {'+'},
                {'?'}
        };
    }

    @Test(dataProvider = "getWrongLetter")
    public void isLetter_notLetter_false(char c){
        assertFalse(splitter.isLetter(c));
    }

    @DataProvider
    public Object[][] getCorrectLetter() {
        return new Object[][]{
                {'a'},
                {'b'},
                {'c'},
                {'d'},
                {'e'},
                {'f'},
                {'z'},
                {'A'},
                {'B'},
                {'C'},
                {'U'}
        };
    }

    @Test(dataProvider = "getCorrectLetter")
    public void isLetter_realLetter_true(char c){
        assertTrue(splitter.isLetter(c));
    }

    @Test(expectedExceptions = Exception.class)
    public void split_wrongInput_exception(){
        Splitter splitter1 = new Splitter(null);
        splitter1.split();
    }

}
