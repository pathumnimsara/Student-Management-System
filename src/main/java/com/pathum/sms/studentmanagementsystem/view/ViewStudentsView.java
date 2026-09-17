package com.pathum.sms.studentmanagementsystem.view;

import com.pathum.sms.studentmanagementsystem.model.Student;
import com.pathum.sms.studentmanagementsystem.dao.StudentDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewStudentsView {

    public void show() {

        Stage stage = new Stage();

        // Create table
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
        colId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        colName.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        colAge.setCellValueFactory(
                new PropertyValueFactory<>("age")
        );

        colCourse.setCellValueFactory(
                new PropertyValueFactory<>("course")
        );

        colEmail.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        // Add columns to table
        table.getColumns().addAll(
                colId,
                colName,
                colAge,
                colCourse,
                colEmail
        );

        // Load students from database
        StudentDAO studentDAO = new StudentDAO();

        List<Student> students =
                studentDAO.getAllStudents();

        ObservableList<Student> list =
                FXCollections.observableArrayList(students);

        table.setItems(list);


        // Create buttons
        Button updateButton =
                new Button("Update Student");

        Button deleteButton =
                new Button("Delete Student");


        // UPDATE BUTTON
        updateButton.setOnAction(e -> {

            Student selectedStudent =
                    table.getSelectionModel().getSelectedItem();

            if (selectedStudent == null) {

                Alert alert =
                        new Alert(Alert.AlertType.WARNING);

                alert.setTitle("No Student Selected");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a student first."
                );

                alert.showAndWait();

            } else {

                UpdateStudentView updateView =
                        new UpdateStudentView();

                // Refresh table after update
                updateView.setOnUpdate(() -> {

                    StudentDAO dao =
                            new StudentDAO();

                    List<Student> updatedStudents =
                            dao.getAllStudents();

                    ObservableList<Student> updatedList =
                            FXCollections.observableArrayList(
                                    updatedStudents
                            );

                    table.setItems(updatedList);
                });

                updateView.show(selectedStudent);
            }
        });


        // DELETE BUTTON
        deleteButton.setOnAction(e -> {

            Student selectedStudent =
                    table.getSelectionModel().getSelectedItem();

            if (selectedStudent == null) {

                Alert alert =
                        new Alert(Alert.AlertType.WARNING);

                alert.setTitle("No Student Selected");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a student first."
                );

                alert.showAndWait();

            } else {

                // Confirmation dialog
                Alert confirm =
                        new Alert(Alert.AlertType.CONFIRMATION);

                confirm.setTitle("Delete Student");
                confirm.setHeaderText(null);

                confirm.setContentText(
                        "Are you sure you want to delete "
                                + selectedStudent.getName()
                                + "?"
                );

                if (confirm.showAndWait().get()
                        == ButtonType.OK) {

                    StudentDAO dao =
                            new StudentDAO();

                    boolean deleted =
                            dao.deleteStudent(
                                    selectedStudent.getId()
                            );

                    if (deleted) {

                        Alert success =
                                new Alert(
                                        Alert.AlertType.INFORMATION
                                );

                        success.setTitle("Success");
                        success.setHeaderText(null);
                        success.setContentText(
                                "Student deleted successfully!"
                        );

                        success.showAndWait();

                        // Remove from table
                        table.getItems()
                                .remove(selectedStudent);

                    } else {

                        Alert error =
                                new Alert(
                                        Alert.AlertType.ERROR
                                );

                        error.setTitle("Error");
                        error.setHeaderText(null);
                        error.setContentText(
                                "Student deletion failed."
                        );

                        error.showAndWait();
                    }
                }
            }
        });


        // Create layout
        VBox root = new VBox(10);

        root.setPadding(new Insets(10));

        root.getChildren().addAll(
                table,
                updateButton,
                deleteButton
        );


        // Create scene
        Scene scene =
                new Scene(root, 700, 450);

        stage.setTitle("All Students");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
