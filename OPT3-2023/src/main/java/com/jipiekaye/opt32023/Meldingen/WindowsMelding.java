package com.jipiekaye.opt32023.Meldingen;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
public class WindowsMelding implements Melding{
    private String titel;
    public WindowsMelding(String titel) {
        this.titel = titel;
    }

    @Override
    public String toString() {
        return "Taak: " + titel + "  Moet nu gedaan worden!";
    }

    public void doMelding() {
        if (SystemTray.isSupported()) {
            WindowsMelding td = new WindowsMelding(titel);
            try {
                td.displayTray();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("System tray not supported!");
        }
    }
    private void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //als icon.png bestaat
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //alternatief (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //resizes icon.png als het nodig is

        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage(toString(), "MELDING", MessageType.INFO);
    }
}
