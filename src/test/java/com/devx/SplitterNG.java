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

    @Test
    public void test1(){
        assertEquals(1,1);
    }
}
