package com.practise.qlsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileIO {

    private File file;

    public FileIO(String fileName){
        this.file = new File(fileName);
    }

    public void append(Student student) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.file, true));
        bufferedWriter.write(student.toString());
        bufferedWriter.write("\n");
        bufferedWriter.close();
    }

    public void append(List<Student> list) throws IOException {
        for(Student student: list){
            append(student);
        }
    }
}
