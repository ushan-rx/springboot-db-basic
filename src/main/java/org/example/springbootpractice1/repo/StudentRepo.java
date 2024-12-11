package org.example.springbootpractice1.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.springbootpractice1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;



    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql="insert into student(rollno,name,marks) values(?,?,?)";

        int rows=jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows);
    }

    public List<Student> findAll() {

        String sql = "select * from student";

        return jdbc.query(sql, (rs, rowNum)-> {
            Student st = new Student();
            st.setRollNo(rs.getInt("rollNo"));
            st.setName(rs.getString("name"));
            st.setMarks(rs.getInt("marks"));
            return st;
        });
    }


}