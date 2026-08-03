package com.pathum.sms.studentmanagementsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import com.pathum.sms.studentmanagementsystem.Dashboard;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Student Management System");

        Label lblUsername = new Label("Username");
        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Enter username");

        Label lblPassword = new Label("Password");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Enter password");

        Button btnLogin = new Button("Login");

        btnLogin.setOnAction(e -> {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter username and password.");
                alert.showAndWait();

                return;
            }

            // Check username and password
            if (username.equals("admin") && password.equals("1234")) {

                Dashboard dashboard = new Dashboard();
                dashboard.show();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();

            }

        });

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                title,
                lblUsername,
                txtUsername,
                lblPassword,
                txtPassword,
                btnLogin
        );

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}