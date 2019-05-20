package com.richemont.dms.catalog;

import org.junit.Test;

import static com.richemont.dms.catalog.Region.BO;
import static com.richemont.dms.catalog.Region.VA;
import static org.junit.Assert.*;

public class RegionTest {

    @Test
    public void testConstructor() {
        assertEquals("Holy See", VA.getShortName());
        assertEquals("the Holy See", VA.getLongName());
        assertEquals("Holy See (the)", VA.getLexicographicName());

        assertEquals("Bolivia", BO.getShortName());
        assertEquals("Plurinational State of Bolivia", BO.getLongName());
        assertEquals("Bolivia (Plurinational State of)", BO.getLexicographicName());

    }

}