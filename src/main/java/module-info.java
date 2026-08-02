module com.pathum.sms.studentmanagementsystem {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.pathum.sms.studentmanagementsystem to javafx.fxml;
    opens com.pathum.sms.studentmanagementsystem.controller to javafx.fxml;

    exports com.pathum.sms.studentmanagementsystem;
    exports com.pathum.sms.studentmanagementsystem.controller;
}