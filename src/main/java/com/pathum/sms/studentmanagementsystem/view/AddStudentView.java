package com.pathum.sms.studentmanagementsystem.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.pathum.sms.studentmanagementsystem.database.StudentDatabase;
import com.pathum.sms.studentmanagementsystem.model.Student;
import javafx.scene.control.Alert;
import com.pathum.sms.studentmanagementsystem.dao.StudentDAO;

public class AddStudentView {

    public void show() {

        Stage stage = new Stage();

        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label title = new Label("Add New Student");
        title.setStyle("-fx-font-size:20px; -fx-font-weight:bold;");

        Label lblId = new Label("Student ID");
        Label lblName = new Label("Name");
        Label lblAge = new Label("Age");
        Label lblCourse = new Label("Course");
        Label lblEmail = new Label("Email");

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

        Button btnSave = new Button("Save");
        Button btnClear = new Button("Clear");
        Button btnBack = new Button("Back");

        btnSave.setOnAction(e -> {

            Student student = new Student(
                    Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    Integer.parseInt(txtAge.getText()),
                    txtCourse.getText(),
                    txtEmail.getText()
            );

            StudentDAO studentDAO = new StudentDAO();

            boolean saved = studentDAO.addStudent(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Student saved successfully!");
            alert.showAndWait();

            System.out.println(StudentDatabase.students);

        });

        grid.add(title, 0, 0, 2, 1);

        grid.add(lblId,0,1);
        grid.add(txtId,1,1);

        grid.add(lblName,0,2);
        grid.add(txtName,1,2);

        grid.add(lblAge,0,3);
        grid.add(txtAge,1,3);

        grid.add(lblCourse,0,4);
        grid.add(txtCourse,1,4);

        grid.add(lblEmail,0,5);
        grid.add(txtEmail,1,5);

        grid.add(btnSave,0,6);
        grid.add(btnClear,1,6);
        grid.add(btnBack,1,7);

        Scene scene = new Scene(grid,450,320);

        stage.setTitle("Add Student");
        stage.setScene(scene);
        stage.show();
    }

}