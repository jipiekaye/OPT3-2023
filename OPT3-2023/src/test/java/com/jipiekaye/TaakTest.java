package com.jipiekaye;

import com.jipiekaye.opt32023.TemplateMethodPattern.Taak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaakTest {
    @Test
    public void experienceCalculatorTest() {
        assertEquals ( Taak.experienceCalculator(1,true,2,true), 200);
        assertEquals ( Taak.experienceCalculator(1,false,0,false), 100);
        assertEquals ( Taak.experienceCalculator(2,true,0,true), 75);
        assertEquals ( Taak.experienceCalculator(2,false,2,false), 150);
        assertEquals ( Taak.experienceCalculator(3,true,2,false), 50);
        assertEquals ( Taak.experienceCalculator(3,false,0,true), 83);
    }
}
