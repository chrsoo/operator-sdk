package com.richemont.dms.catalog;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrigramTest {

    @Test
    public void validate() {
        Trigram.validate("ABC");
        Trigram.validate("A12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_space() {
        Trigram.validate(" ABC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_twoLetters() {
        Trigram.validate("AB");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_fourLetters() {
        Trigram.validate("ABCD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_allLowerCase() {
        Trigram.validate("abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_trailingLowerCase() {
        Trigram.validate("Abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_leadingNumber() {
        Trigram.validate("1AB");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_isoLetters() {
        Trigram.validate("ÅÄÖ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_punctation() {
        Trigram.validate("A.B");
    }

}