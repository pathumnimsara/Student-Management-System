package com.pathum.sms.studentmanagementsystem.view;

import com.pathum.sms.studentmanagementsystem.database.StudentDatabase;
import com.pathum.sms.studentmanagementsystem.model.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewStudentsView {

    public void show() {

        Stage stage = new Stage();

        TableView<Student> table = new TableView<>();

        // Create columns
        TableColumn<Student, Integer> colId =
                new TableColumn<>("ID");

        TableColumn<Student, String> colName =
                new TableColumn<>("Name");

        TableColumn<Student, Integer> colAge =
                new TableColumn<>("Age");

        TableColumn<Student, String> colCourse =
                new TableColumn<>("Course");

        TableColumn<Student, String> colEmail =
                new TableColumn<>("Email");

        // Connect columns to Student class
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Add columns to table
        table.getColumns().addAll(
                colId,
                colName,
                colAge,
                colCourse,
                colEmail
        );

        // Load students
        ObservableList<Student> list =
                FXCollections.observableArrayList(StudentDatabase.students);

        table.setItems(list);

        // Create scene
        Scene scene = new Scene(table, 700, 400);

        stage.setTitle("All Students");
        stage.setScene(scene);
        stage.show();

    }

}