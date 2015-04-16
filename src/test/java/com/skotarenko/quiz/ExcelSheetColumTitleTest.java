package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumTitleTest {
    @Test
    public void convertToTitle() {
        Assert.assertEquals("A", new ExcelSheetColumnTitle().convertToTitle(1));
        Assert.assertEquals("B", new ExcelSheetColumnTitle().convertToTitle(2));
        Assert.assertEquals("C", new ExcelSheetColumnTitle().convertToTitle(3));
        Assert.assertEquals("Z", new ExcelSheetColumnTitle().convertToTitle(26));
        Assert.assertEquals("AA", new ExcelSheetColumnTitle().convertToTitle(27));
        Assert.assertEquals("AB", new ExcelSheetColumnTitle().convertToTitle(28));
        Assert.assertEquals("AZ", new ExcelSheetColumnTitle().convertToTitle(52));
        Assert.assertEquals("CVC", new ExcelSheetColumnTitle().convertToTitle(2603));
    }
}
