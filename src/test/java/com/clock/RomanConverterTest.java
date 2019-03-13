package com.clock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanConverterTest {
    private Converter<Integer> converter;
    private final String[] romanSymbols = new String[] {"I", "V", "X", "L", "C", "D", "M"};
    private final Integer[] arabicSymbols = new Integer[] {1, 5, 10, 50, 100, 500, 1000};

    @Before
    public void prepareTests() {
        converter = new RomanConverter<>();
    }

    @Test
    public void testObjectImplementation() {
        Assert.assertNotNull(converter);
    }

    @Test
    public void testConvertionOfBasicRomanNumbers() {
        for (int i = 0; i < romanSymbols.length; i++) {
            Integer resultInArabic = converter.convert(romanSymbols[i]);
            Assert.assertEquals(arabicSymbols[i], resultInArabic);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testProvidingOfBadData() {
        converter.convert("Q");
    }

    @Test
    public void testMMVIValue() {
        Integer mmviInArabic = converter.convert("MMVI");
        Assert.assertEquals(Integer.valueOf(2006), mmviInArabic);
    }

    @Test
    public void testXXValue() {
        Integer result = converter.convert("XX");
        Assert.assertEquals(Integer.valueOf(20), result);
    }
}
