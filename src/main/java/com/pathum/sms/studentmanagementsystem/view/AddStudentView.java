package com.pathum.sms.studentmanagementsystem.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import com.pathum.sms.studentmanagementsystem.model.Student;
import com.pathum.sms.studentmanagementsystem.dao.StudentDAO;

public class AddStudentView {

    public void show() {

        Stage stage = new Stage();

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Title
        Label title = new Label("Add New Student");
        title.setStyle("-fx-font-size:20px; -fx-font-weight:bold;");

        // Labels
        Label lblId = new Label("Student ID");
        Label lblName = new Label("Name");
        Label lblAge = new Label("Age");
        Label lblCourse = new Label("Course");
        Label lblEmail = new Label("Email");

        // Text fields
        TextField txtId = new TextField();
        TextField txtName = new TextField();
        TextField txtAge = new TextField();
        TextField txtCourse = new TextField();
        TextField txtEmail = new TextField();

        txtId.setPrefWidth(250);
        txtName.setPrefWidth(250);
        txtAge.setPrefWidth(250);
        txtCourse.setPrefWidth(250);
        txtEmail.setPrefWidth(250);

        // Buttons
        Button btnSave = new Button("Save");
        Button btnClear = new Button("Clear");
        Button btnBack = new Button("Back");



        // SAVE BUTTON
        btnSave.setOnAction(e -> {

            // Get values from text fields
            String idText = txtId.getText().trim();
            String name = txtName.getText().trim();
            String ageText = txtAge.getText().trim();
            String course = txtCourse.getText().trim();
            String email = txtEmail.getText().trim();


            // Check empty fields
            if (idText.isEmpty() ||
                    name.isEmpty() ||
                    ageText.isEmpty() ||
                    course.isEmpty() ||
                    email.isEmpty()) {

                Alert alert =
                        new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Missing Information");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please fill in all fields."
                );

                alert.showAndWait();

                return;
            }


            try {

                // Convert ID and Age to numbers
                int id = Integer.parseInt(idText);
                int age = Integer.parseInt(ageText);


                // Check ID
                if (id <= 0) {

                    Alert alert =
                            new Alert(Alert.AlertType.WARNING);

                    alert.setTitle("Invalid Student ID");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Student ID must be greater than 0."
                    );

                    alert.showAndWait();

                    return;
                }


                // Check age
                if (age <= 0) {

                    Alert alert =
                            new Alert(Alert.AlertType.WARNING);

                    alert.setTitle("Invalid Age");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Age must be greater than 0."
                    );

                    alert.showAndWait();

                    return;
                }


                // Check email
                if (!email.contains("@")
                        || !email.contains(".")) {

                    Alert alert =
                            new Alert(Alert.AlertType.WARNING);

                    alert.setTitle("Invalid Email");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Please enter a valid email address."
                    );

                    alert.showAndWait();

                    return;
                }


                // Create DAO
                StudentDAO studentDAO =
                        new StudentDAO();


                // Check duplicate Student ID
                if (studentDAO.studentIdExists(id)) {

                    Alert alert =
                            new Alert(Alert.AlertType.WARNING);

                    alert.setTitle("Duplicate Student ID");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Student ID " + id
                                    + " already exists."
                    );

                    alert.showAndWait();

                    return;
                }


                // Create Student object
                Student student = new Student(
                        id,
                        name,
                        age,
                        course,
                        email
                );


                // Save student to database
                boolean saved =
                        studentDAO.addStudent(student);


                if (saved) {

                    Alert alert =
                            new Alert(
                                    Alert.AlertType.INFORMATION
                            );

                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Student saved successfully!"
                    );

                    alert.showAndWait();


                    // Clear fields after successful save
                    txtId.clear();
                    txtName.clear();
                    txtAge.clear();
                    txtCourse.clear();
                    txtEmail.clear();

                } else {

                    Alert alert =
                            new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Student could not be saved."
                    );

                    alert.showAndWait();
                }


            } catch (NumberFormatException ex) {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Invalid Number");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Student ID and Age must contain numbers only."
                );

                alert.showAndWait();
            }
        });



        // CLEAR BUTTON

        btnClear.setOnAction(e -> {

            txtId.clear();
            txtName.clear();
            txtAge.clear();
            txtCourse.clear();
            txtEmail.clear();

        });



        // BACK BUTTON

        btnBack.setOnAction(e -> {

            stage.close();

        });



        // ADD COMPONENTS TO GRID

        grid.add(title, 0, 0, 2, 1);

        grid.add(lblId, 0, 1);
        grid.add(txtId, 1, 1);

        grid.add(lblName, 0, 2);
        grid.add(txtName, 1, 2);

        grid.add(lblAge, 0, 3);
        grid.add(txtAge, 1, 3);

        grid.add(lblCourse, 0, 4);
        grid.add(txtCourse, 1, 4);

        grid.add(lblEmail, 0, 5);
        grid.add(txtEmail, 1, 5);

        grid.add(btnSave, 0, 6);
        grid.add(btnClear, 1, 6);
        grid.add(btnBack, 1, 7);


        // Create scene
        Scene scene =
                new Scene(grid, 450, 320);

        stage.setTitle("Add Student");
        stage.setScene(scene);
        stage.show();
    }
}
