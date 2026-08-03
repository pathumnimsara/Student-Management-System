package com.pathum.sms.studentmanagementsystem;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard {

    public void show() {

        Stage stage = new Stage();

        Label title = new Label("Dashboard");

        Label welcome = new Label("Welcome Admin!");

        Button btnExit = new Button("Exit");

        btnExit.setOnAction(e -> stage.close());

        VBox root = new VBox(20);

        root.getChildren().addAll(title, welcome, btnExit);

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();

    }

}