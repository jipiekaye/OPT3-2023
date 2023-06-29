package com.jipiekaye;

import com.jipiekaye.opt32023.Gebruiker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GebruikerTest {
    @Test
    public void standVanTakenTest() {
        Gebruiker gebruiker = new Gebruiker("test", "test", false);
        assertEquals(gebruiker.standVanTaken(100,0), "rood");
        assertEquals(gebruiker.standVanTaken(71,29), "rood");
        assertEquals(gebruiker.standVanTaken(70,30), "geel");
        assertEquals(gebruiker.standVanTaken(31,69), "geel");
        assertEquals(gebruiker.standVanTaken(30,70), "groen");
        assertEquals(gebruiker.standVanTaken(0,100), "groen");
    }
}
