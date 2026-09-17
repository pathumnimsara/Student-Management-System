package com.pathum.sms.studentmanagementsystem.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard {

    public void show() {

        Stage stage = new Stage();

        // Title
        Label title = new Label("🎓  STUDENT MANAGEMENT SYSTEM");
        title.setStyle(
                "-fx-font-size: 25px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #111827;"
        );

        // Welcome message
        Label welcomeLabel = new Label(
                "Welcome to your dashboard"
        );
        welcomeLabel.setStyle(
                "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #374151;"
        );

        Label subtitle = new Label(
                "Manage student information easily and efficiently"
        );
        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                        "-fx-text-fill: #6b7280;"
        );

        // Main buttons
        Button addStudentButton = new Button("➕  Add Student");
        Button viewStudentsButton = new Button("👥  View Students");

        // Bottom buttons
        Button aboutButton = new Button("ℹ  About");
        Button logoutButton = new Button("↪  Logout");
        Button exitButton = new Button("✕  Exit");

        addStudentButton.setPrefSize(210, 55);
        viewStudentsButton.setPrefSize(210, 55);

        aboutButton.setPrefSize(110, 40);
        logoutButton.setPrefSize(110, 40);
        exitButton.setPrefSize(110, 40);

        // Main button styles
        String mainStyle =
                "-fx-background-color: #2563eb;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-cursor: hand;";

        String mainHover =
                "-fx-background-color: #1d4ed8;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-cursor: hand;";

        // Small button styles
        String smallStyle =
                "-fx-background-color: #4f46e5;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;";

        String smallHover =
                "-fx-background-color: #4338ca;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;";

        String exitStyle =
                "-fx-background-color: #dc2626;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;";

        String exitHover =
                "-fx-background-color: #b91c1c;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;";

        // Apply normal styles
        addStudentButton.setStyle(mainStyle);
        viewStudentsButton.setStyle(mainStyle);

        aboutButton.setStyle(smallStyle);
        logoutButton.setStyle(smallStyle);
        exitButton.setStyle(exitStyle);

        // Add Student hover
        addStudentButton.setOnMouseEntered(e ->
                addStudentButton.setStyle(mainHover)
        );

        addStudentButton.setOnMouseExited(e ->
                addStudentButton.setStyle(mainStyle)
        );

        // View Students hover
        viewStudentsButton.setOnMouseEntered(e ->
                viewStudentsButton.setStyle(mainHover)
        );

        viewStudentsButton.setOnMouseExited(e ->
                viewStudentsButton.setStyle(mainStyle)
        );

        // About hover
        aboutButton.setOnMouseEntered(e ->
                aboutButton.setStyle(smallHover)
        );

        aboutButton.setOnMouseExited(e ->
                aboutButton.setStyle(smallStyle)
        );

        // Logout hover
        logoutButton.setOnMouseEntered(e ->
                logoutButton.setStyle(smallHover)
        );

        logoutButton.setOnMouseExited(e ->
                logoutButton.setStyle(smallStyle)
        );

        // Exit hover
        exitButton.setOnMouseEntered(e ->
                exitButton.setStyle(exitHover)
        );

        exitButton.setOnMouseExited(e ->
                exitButton.setStyle(exitStyle)
        );

        // Add Student
        addStudentButton.setOnAction(e -> {
            AddStudentView addStudentView = new AddStudentView();
            addStudentView.show();
        });

        // View Students
        viewStudentsButton.setOnAction(e -> {
            ViewStudentsView viewStudentsView = new ViewStudentsView();
            viewStudentsView.show();
        });

        // About
        aboutButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("About");
            alert.setHeaderText("Student Management System");

            alert.setContentText(
                    "A JavaFX Student Management System\n\n" +
                            "Developed using Java, JavaFX, MySQL and JDBC."
            );

            alert.showAndWait();
        });

        // Logout
        logoutButton.setOnAction(e -> {
            stage.close();
        });

        // Exit
        exitButton.setOnAction(e -> {
            Platform.exit();
        });

        // Main buttons
        HBox mainButtons = new HBox(20);
        mainButtons.setAlignment(Pos.CENTER);

        mainButtons.getChildren().addAll(
                addStudentButton,
                viewStudentsButton
        );

        // Bottom buttons
        HBox bottomButtons = new HBox(15);
        bottomButtons.setAlignment(Pos.CENTER);

        bottomButtons.getChildren().addAll(
                aboutButton,
                logoutButton,
                exitButton
        );

        // Content card
        VBox contentCard = new VBox(18);
        contentCard.setAlignment(Pos.CENTER);
        contentCard.setPadding(new Insets(40));

        contentCard.setMaxWidth(600);
        contentCard.setMaxHeight(400);

        contentCard.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 18;" +
                        "-fx-effect: dropshadow(" +
                        "three-pass-box, rgba(0,0,0,0.20), " +
                        "15, 0, 0, 4);"
        );

        contentCard.getChildren().addAll(
                title,
                welcomeLabel,
                subtitle,
                mainButtons,
                bottomButtons
        );

        // Main background
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.setStyle(
                "-fx-background-color: linear-gradient(" +
                        "to bottom right, #1e3a8a, #4f46e5);"
        );

        root.getChildren().add(contentCard);

        // Scene
        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
