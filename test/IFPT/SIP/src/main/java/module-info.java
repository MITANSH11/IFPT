module com.mitansh.sip {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mitansh.sip to javafx.fxml;
    exports com.mitansh.sip;
}