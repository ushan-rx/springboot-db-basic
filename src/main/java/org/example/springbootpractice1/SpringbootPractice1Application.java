package org.example.springbootpractice1;

import org.example.springbootpractice1.model.Student;
import org.example.springbootpractice1.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootPractice1Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringbootPractice1Application.class, args);

        Student std = context.getBean(Student.class);
        std.setRollNo(4);
        std.setName("ushan");
        std.setMarks(89);

        StudentService stdService = context.getBean(StudentService.class);
        stdService.addStudent(std);

        System.out.println(stdService.getAllStudents());
    }
}
