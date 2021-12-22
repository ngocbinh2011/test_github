package com.practise.qlsv;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.List;

public class StudentDAO {
    private IConnection connector;
    private Student.Mapper studentMapper;

    public StudentDAO() {
        this.connector = new MysqlConnection();
        this.studentMapper = new Student.Mapper();
    }

    public boolean save(Student student){
        Connection connection = connector.getConnection();
        String sql = "INSERT INTO tbl_hssinhvien VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getCode());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setTimestamp(3, new Timestamp(student.getDob().getTime()));
            preparedStatement.setBoolean(4, student.isSex());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void save(List<Student> list){
        for(Student student: list){
            save(student);
        }
    }

    public Student findOneById(String studentId){
        Connection connection = connector.getConnection();
        String sql = "SELECT * FROM tbl_hssinhvien WHERE stu_code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return studentMapper.mapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
