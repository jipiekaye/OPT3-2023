package com.jipiekaye;

import com.jipiekaye.opt32023.Melding;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeldingTest {
    @Test
    void testPopupsAan() {
        Melding melding = new Melding("test");
        assertFalse (melding.popupsAan(true, true, false));
        assertFalse (melding.popupsAan(true, false, true));
        assertFalse (melding.popupsAan(false, true, true));
        assertTrue (melding.popupsAan(true, true, true));
    }
}
