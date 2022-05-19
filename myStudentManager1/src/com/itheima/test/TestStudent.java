package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;

public class TestStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("001", "huang", 23, "1989");
        Student stu2 = new Student("002", "li", 24, "1990");
        Student stu3 = new Student("003", "ren", 25, "1991");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        int index1 = getIndex(list,"001");
        int index2 = getIndex(list, "004");

        System.out.println(index1);
        System.out.println(index2);
    }

    public static int getIndex(ArrayList<Student> list, String id){
        //if the id is not exist
        int index = -1;
        //view all the list
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if(id.equals(sid)){
                index = i;
            }
        }
        return index;
    }
}
