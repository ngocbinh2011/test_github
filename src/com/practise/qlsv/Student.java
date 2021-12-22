package com.practise.qlsv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String code;
    private String name;
    private Date dob;
    private boolean sex;
    private String address;
    private String phone;

    public Student() {

    }

    public Student(String code, String name, Date dob, boolean sex, String address, String phone) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public static class Mapper{
        public Student mapping(ResultSet resultSet){
            Student student = new Student();
            try {
                student.setCode(resultSet.getString("stu_code"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getDate("dob"));
                student.setSex(resultSet.getBoolean("sex"));
                student.setAddress(resultSet.getString("address"));
                student.setPhone(resultSet.getString("phone"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return student;
        }

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void showInfo(){
        String info = "code= " + code + '\n' +
                "name= " + name + '\n' +
                "dob= " + dob + '\n' +
                "sex= " + (sex? "Male" : "Female") + '\n' +
                "address= " + address + '\n' +
                "phone= " + phone;
        System.out.println(info);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return code + '\n' + name + '\n' + simpleDateFormat.format(dob) + '\n' + sex
                + '\n' + address + '\n' + phone;
    }
}