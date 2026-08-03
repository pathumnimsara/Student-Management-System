package com.pathum.sms.studentmanagementsystem;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import com.pathum.sms.studentmanagementsystem.view.AddStudentView;

public class Dashboard {

    public void show(String username) {

        Stage stage = new Stage();

        Label title = new Label("STUDENT MANAGEMENT SYSTEM");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label welcome = new Label("Welcome, " + username + "!");
        welcome.setStyle("-fx-font-size: 16px;");

        Button btnAddStudent = new Button("Add Student");
        btnAddStudent.setOnAction(e -> {

            AddStudentView view = new AddStudentView();
            view.show();

        });
        Button btnViewStudents = new Button("View Students");
        Button btnAbout = new Button("About");
        Button btnLogout = new Button("Logout");
        Button btnExit = new Button("Exit");

        btnAddStudent.setPrefWidth(200);
        btnViewStudents.setPrefWidth(200);
        btnAbout.setPrefWidth(200);
        btnLogout.setPrefWidth(200);
        btnExit.setPrefWidth(200);

        VBox root = new VBox(15);

        root.setStyle("-fx-padding:30;");
        root.getChildren().addAll(
                title,
                welcome,
                btnAddStudent,
                btnViewStudents,
                btnAbout,
                btnLogout,
                btnExit
        );

        btnExit.setOnAction(e -> stage.close());

        btnAbout.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Student Management System");
            alert.setContentText(
                    "Version 1.0\n\nDeveloped by Pathum Nimsara"
            );

            alert.showAndWait();

        });

        Scene scene = new Scene(root, 500, 450);

        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();

    }
}