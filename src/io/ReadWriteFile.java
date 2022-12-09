package io;

import Model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static List<Student> readFile() {
        try {
            FileInputStream fis = new FileInputStream("listStudent.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<Student>) ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void writeFile(List<Student> accounts) {
        try {
            FileOutputStream fos = new FileOutputStream("listStudent.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
