package com.pathum.sms.studentmanagementsystem.dao;


import com.pathum.sms.studentmanagementsystem.database.DBConnection;
import com.pathum.sms.studentmanagementsystem.model.Student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



public class StudentDAO {



    public List<Student> getAllStudents(){


        List<Student> students = new ArrayList<>();


        String sql = "SELECT * FROM students";


        try{


            Connection con = DBConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                Student student = new Student(

                        rs.getInt("id"),

                        rs.getString("name"),

                        rs.getInt("age"),

                        rs.getString("course"),

                        rs.getString("email")

                );


                students.add(student);


            }


        }catch(Exception e){

            e.printStackTrace();

        }


        return students;


    }





    public boolean addStudent(Student student){


        String sql =
                "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";


        try{


            Connection con = DBConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setString(1, student.getName());

            ps.setInt(2, student.getAge());

            ps.setString(3, student.getCourse());

            ps.setString(4, student.getEmail());


            int result = ps.executeUpdate();


            return result > 0;


        }catch(Exception e){

            e.printStackTrace();

            return false;

        }


    }


}