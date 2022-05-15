package week1;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void whenCalledisBlank_thenCorrect() {
        assertTrue(StringUtils.isBlank(" "));
    }

    @Test
    public void whenCalledisEmpty_thenCorrect() {
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void whenCalledisAllLowerCase_thenCorrect() {
        assertTrue(StringUtils.isAllLowerCase("abd"));
    }

    @Test
    public void whenCalledisAllUpperCase_thenCorrect() {
        assertTrue(StringUtils.isAllUpperCase("ABC"));
    }

    @Test
    public void whenCalledisMixedCase_thenCorrect() {
        assertTrue(StringUtils.isMixedCase("abC"));
    }

    @Test
    public void whenCalledisAlpha_thenCorrect() {
        assertTrue(StringUtils.isAlpha("abc"));
    }

    @Test
    public void whenCalledisAlphanumeric_thenCorrect() {
        assertTrue(StringUtils.isAlphanumeric("abc123"));
    }
}
