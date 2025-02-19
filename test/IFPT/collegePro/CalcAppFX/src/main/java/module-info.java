module calc.calcappfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens calc.calcappfx to javafx.fxml;
    exports calc.calcappfx;
}