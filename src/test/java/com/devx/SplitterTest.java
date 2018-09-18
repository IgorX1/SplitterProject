package com.devx;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitParamsRunner.class)
public class SplitterTest {
    private Splitter splitter;

    @Before
    public void setUp(){
        splitter = new Splitter();
    }

    private static final Object[] getWrongLetter(){
        return $(
             "1", Character.MIN_VALUE, "-", "{", "+", "?"
        );
    }

    @Test
    @Parameters(method = "getWrongLetter")
    public void isLetter_notLetter_false(char c){
        assertFalse(splitter.isLetter(c));
    }

    private static final Object[] getCorrectLetter(){
        return $(
            'a', 'b', 'c', 'd', 'e', 'f', 'z', 'A', 'B', 'C', 'U'
        );

    }

    @Test
    @Parameters(method = "getCorrectLetter")
    public void isLetter_realLetter_true(char c){
        assertTrue(splitter.isLetter(c));
    }

    private static final Object[] getText(){
        return $(
          $("123x --don't {{self-control", 3),
          $("aaa_aaa-vv1cc zza", 4),
          $("", 0),
          $("oneword__12",1)
        );
    }

    @Test
    @Parameters(method="getText")
    public void split_fillList_correctNumberOfWords(String text, int n){
        splitter.setText(text);
        List res = splitter.split();
        assertThat(res.size(), is(n));
    }

    @Test
    public void split_fillList_correctWords(){
        splitter.setText("*aba$yellow+ ,vw/oledb{db}ctrl)(land(*etx.self-assured fox __don't...");
        List<String> res = splitter.split();
        assertThat(res, containsInAnyOrder(
                "aba",
                "yellow",
                "vw",
                "oledb",
                "db",
                "ctrl",
                "land",
                "etx",
                "self-assured",
                "fox",
                "don't"));
    }

}
