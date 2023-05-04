module com.example.opt32023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.opt32023 to javafx.fxml;
    exports com.example.opt32023;
}