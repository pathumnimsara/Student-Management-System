package com.pathum.sms.studentmanagementsystem.view;

import com.pathum.sms.studentmanagementsystem.dao.StudentDAO;
import com.pathum.sms.studentmanagementsystem.model.Student;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpdateStudentView {

    private Runnable onUpdate;

    public void setOnUpdate(Runnable onUpdate) {
        this.onUpdate = onUpdate;
    }

    public void show(Student student) {

        Stage stage = new Stage();

        // Create input fields
        TextField nameField = new TextField(student.getName());
        TextField ageField = new TextField(String.valueOf(student.getAge()));
        TextField courseField = new TextField(student.getCourse());
        TextField emailField = new TextField(student.getEmail());

        // Create labels
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label courseLabel = new Label("Course:");
        Label emailLabel = new Label("Email:");

        // Create Update button
        Button updateButton = new Button("Update Student");

        // Button action
        updateButton.setOnAction(e -> {

            try {

                student.setName(nameField.getText());
                student.setAge(Integer.parseInt(ageField.getText()));
                student.setCourse(courseField.getText());
                student.setEmail(emailField.getText());

                StudentDAO studentDAO = new StudentDAO();

                boolean updated = studentDAO.updateStudent(student);

                if (updated) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Student updated successfully!");
                    alert.showAndWait();

                    if (onUpdate != null) {
                        onUpdate.run();
                    }

                    stage.close();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Student update failed.");
                    alert.showAndWait();
                }

            } catch (NumberFormatException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Age");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number for age.");
                alert.showAndWait();
            }
        });

        // Create layout
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Add components
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);

        grid.add(courseLabel, 0, 2);
        grid.add(courseField, 1, 2);

        grid.add(emailLabel, 0, 3);
        grid.add(emailField, 1, 3);

        grid.add(updateButton, 1, 4);

        // Create scene
        Scene scene = new Scene(grid, 400, 300);

        stage.setTitle("Update Student");
        stage.setScene(scene);
        stage.show();
    }
}