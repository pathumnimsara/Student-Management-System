module com.pathum.sms.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pathum.sms.studentmanagementsystem to javafx.fxml;
    exports com.pathum.sms.studentmanagementsystem;
}