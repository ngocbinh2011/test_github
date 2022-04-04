package com.practise.qlsv;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        //dsadasd
        while(true){
            System.out.println("\n----------------MENU---------------");
            System.out.println("1.Nhap vao danh sach sinh vien");
            System.out.println("2.Kiem tra sinh vien co ton tai");
            System.out.println("0.thoat");
            System.out.println("----------------------------------");
            System.out.print("ban chon: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose){
                case 1:{
                    System.out.print("\nnhap vao so luong sinh vien: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    List<Student> list = new ArrayList<>();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    for(int i=0; i<n; i++){
                        Student student = new Student();
                        System.out.print("\nnhao vao ma sv: ");
                        student.setCode(scanner.nextLine());
                        System.out.print("\nnhao vao ten sv: ");
                        student.setName(scanner.nextLine());
                        System.out.print("\nnhao vao ngay sinh sv: ");
                        try {
                            student.setDob(simpleDateFormat.parse(scanner.nextLine()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.print("\nnhao vao gioi tinh sv (1-MALE/0-FEMALE): ");
                        student.setSex(Integer.parseInt(scanner.nextLine()) == 0? true : false);
                        System.out.print("\nnhao vao que quan sv: ");
                        student.setAddress(scanner.nextLine());
                        System.out.print("\nnhao vao so dien thoai sv: ");
                        student.setPhone(scanner.nextLine());

                        list.add(student);
                    }
                    studentDAO.save(list);
                    System.out.println("save to database successfull!");

                    FileIO fileIO = new FileIO("hssinhvien.txt");
                    try {
                        fileIO.append(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("save to file hssinhvien.txt successfull!");
                    break;
                }
                case 2:{
                    System.out.print("nhap vao ma so sv: ");
                    String code = scanner.nextLine();
                    Student student = studentDAO.findOneById(code);
                    if(student == null){
                        System.out.println("Sinh vien khong ton tai");
                    } else{
                        System.out.println("------Thong tin sinh vien---------");
                        student.showInfo();
                    }
                    break;
                }
                default: return;
            }
        }
    }
}
