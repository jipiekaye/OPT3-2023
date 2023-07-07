module com.example.opt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.jipiekaye.opt32023 to javafx.fxml;
    exports com.jipiekaye.opt32023;
    exports com.jipiekaye.opt32023.observerPattern;
    opens com.jipiekaye.opt32023.observerPattern to javafx.fxml;
    exports com.jipiekaye.opt32023.Meldingen;
    opens com.jipiekaye.opt32023.Meldingen to javafx.fxml;
    exports com.jipiekaye.opt32023.TemplateMethodPattern;
    opens com.jipiekaye.opt32023.TemplateMethodPattern to javafx.fxml;
}