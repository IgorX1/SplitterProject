package com.devx;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class SplitterNG {

    private Splitter splitter;

    @BeforeGroups(groups = {"unitLetterOperations",
    "testSplitMethod"})
    public void setUpInGroup(){
        splitter = new Splitter();
    }

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

    @Test(dataProvider = "getWrongLetter",
    groups = {"unitLetterOperations"})
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

    @Test(dataProvider = "getCorrectLetter",
    enabled = true,
    groups = {"unitLetterOperations"})
    public void isLetter_realLetter_true(char c){
        assertTrue(splitter.isLetter(c));
    }

    @Test(expectedExceptions = Exception.class,
    groups = {"testSplitMethod"})
    public void split_wrongInput_exception(){
        Splitter splitter1 = new Splitter(null);
        splitter1.split();
    }

    @DataProvider
    public Object[][] getTextSets(){
        return new Object[][]{
            {"123x --don't {{self-control", 3},
            {"aaa_aaa-vv1cc zza", 4},
            {"", 0},
            {"oneword__12",1}
        };
    }

    @Test(dataProvider = "getTextSets",
    groups = {"testSplitMethod"})
    public void split_fillList_correctNumberOfWords(String text, int words){
        splitter.setText(text);
        List res = splitter.split();
        assertEquals(res.size(), words);
    }
}
