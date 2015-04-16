package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumNumberTest {
    @Test
    public void convertToTitle() {
        Assert.assertEquals(1, new ExcelSheetColumnNumber().titleToNumber("A"));
        Assert.assertEquals(2, new ExcelSheetColumnNumber().titleToNumber("B"));
        Assert.assertEquals(3, new ExcelSheetColumnNumber().titleToNumber("C"));
        Assert.assertEquals(26, new ExcelSheetColumnNumber().titleToNumber("Z"));
        Assert.assertEquals(27, new ExcelSheetColumnNumber().titleToNumber("AA"));
        Assert.assertEquals(28, new ExcelSheetColumnNumber().titleToNumber("AB"));
        Assert.assertEquals(52, new ExcelSheetColumnNumber().titleToNumber("AZ"));
        Assert.assertEquals(2603, new ExcelSheetColumnNumber().titleToNumber("CVC"));
    }
}
