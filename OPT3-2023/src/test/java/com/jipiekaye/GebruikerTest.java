package com.jipiekaye;

import com.jipiekaye.opt32023.Gebruiker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GebruikerTest {
    @Test
    public void standVanTakenTest() {
        Gebruiker gebruiker = new Gebruiker("test", "test", false);
        Assertions.assertEquals(gebruiker.standVanTaken(100,0), "rood");
        Assertions.assertEquals(gebruiker.standVanTaken(71,29), "rood");
        Assertions.assertEquals(gebruiker.standVanTaken(70,30), "geel");
        Assertions.assertEquals(gebruiker.standVanTaken(31,69), "geel");
        Assertions.assertEquals(gebruiker.standVanTaken(30,70), "groen");
        Assertions.assertEquals(gebruiker.standVanTaken(0,100), "groen");
    }
}
