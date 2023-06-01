package com.jipiekaye;

import com.jipiekaye.opt32023.Melding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeldingTest {
    @Test
    void testPopupsAan() {
        Melding melding = new Melding("test");
        Assertions.assertFalse(melding.popupsAan(true, true, false));
        Assertions.assertFalse(melding.popupsAan(true, false, true));
        Assertions.assertFalse(melding.popupsAan(false, true, true));
        Assertions.assertTrue(melding.popupsAan(true, true, true));
    }
}
