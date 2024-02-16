package com.driver;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }
    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }
    public String addStudentTeacherPair(String student, String teacher){
        return studentRepository.addStudentTeacherPair(student, teacher);
    }
    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public String deleteTeacherByName(String teacher){
        return studentRepository.deleteTeacherByName(teacher);
    }
    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }
}