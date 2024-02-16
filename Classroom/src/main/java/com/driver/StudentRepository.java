package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studDB = new HashMap<>();
    HashMap<String,Teacher> teacherDB = new HashMap<>();
    HashMap<String, List<String>> studTeacherDB = new HashMap<>();
    public String addStudent(Student student){
        studDB.put(student.getName(),student);
        return "Student added successfully";
    }
    public String addTeacher(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
        return "Teacher added successfully";
    }
    public String addStudentTeacherPair(String student, String teacher){
        List<String> studList = studTeacherDB.getOrDefault(teacher,new ArrayList<>());
        studList.add(student);
        studTeacherDB.put(teacher,studList);
        Teacher teacherObj = teacherDB.get(teacher);
        teacherObj.setNumberOfStudents(studList.size());
        return "Teacher-student pair added successfully";
    }
    public Student getStudentByName(String name){
        if(studDB.containsKey(name)==true){
            return studDB.get(name);
        }
        return null;
    }
    public Teacher getTeacherByName(String name){
        if(teacherDB.containsKey(name)==true){
            return teacherDB.get(name);
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> studentList = studTeacherDB.getOrDefault(teacher,new ArrayList<>());
        return studentList;
    }
    public List<String> getAllStudents(){
        List<String> teacherList = new ArrayList<>();
        for(String stud:studDB.keySet()){
            teacherList.add(stud);
        }
        return teacherList;
    }
    public String deleteTeacherByName(String teacher){
        List<String> studentList = studTeacherDB.getOrDefault(teacher,new ArrayList<>());
        studTeacherDB.remove(teacher);
        teacherDB.remove(teacher);
        for(String stud:studentList){
            studDB.remove(stud);
        }
        return "Deleted Successfully";
    }
    public String deleteAllTeachers(){

        for(String directorName:teacherDB.keySet()){
            List<String> studList = studTeacherDB.getOrDefault(directorName,new ArrayList<>());
            for(String movieName:studList){
                studDB.remove(movieName);
            }
        }

        teacherDB.clear();
        studTeacherDB.clear();

        return "All Deleted Successfully";
    }
}