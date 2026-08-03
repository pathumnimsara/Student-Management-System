module com.pathum.sms.studentmanagementsystem {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.pathum.sms.studentmanagementsystem to javafx.fxml;
    opens com.pathum.sms.studentmanagementsystem.controller to javafx.fxml;
    opens com.pathum.sms.studentmanagementsystem.model to javafx.base;

    exports com.pathum.sms.studentmanagementsystem;
    exports com.pathum.sms.studentmanagementsystem.controller;
}