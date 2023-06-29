module com.example.opt32023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.jipiekaye.opt32023 to javafx.fxml;
    exports com.jipiekaye.opt32023;
    exports com.jipiekaye.opt32023.observerPattern;
    opens com.jipiekaye.opt32023.observerPattern to javafx.fxml;
}