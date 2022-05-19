package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //set up an Arraylist which you can put the student inside it
        ArrayList<Student> list = new ArrayList<>();

        lo:
        while(true){
            // build up the main menu
            System.out.println("-----Welcome to the student management system-----");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Edit student");
            System.out.println("4. Have a view of the student");
            System.out.println("5. Quit");
            System.out.println("Please type in your choice");

            String choice = sc.next();

            switch (choice){
                case "1":
                    System.out.println("Add student");
                    addStudent(list);
                    break;
                case "2":
                    System.out.println("Delete student");
                    deleteStudent(list);
                    break;
                case "3":
                    System.out.println("Edit student");
                    editStudent(list);
                    break;
                case "4":
                    System.out.println("Have a view of the student");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("Thank you.");
                    break lo;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    public static void editStudent(ArrayList<Student> list) {
        System.out.println("Please input the id you want to update");
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        int index = getIndex(list,updateSid);
        if(index == -1){
            System.out.println("This person is not exist, pls input again.");
        }else{
            System.out.println("Input new name");
            String name = sc.next();
            System.out.println("Input new age");
            int age = sc.nextInt();
            System.out.println("Input new birthday");
            String birthday = sc.next();

            Student stu = new Student(updateSid, name, age, birthday);

            list.set(index, stu);
            System.out.println("Edit successfully.");
        }
    }


    //method to add the student
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the id");
        String id = sc.next();
        System.out.println("Please input the name");
        String name = sc.next();
        System.out.println("please input the age");
        int age = sc.nextInt();
        System.out.println("Please input the birthday");
        String birthday = sc.next();
        //fengzhuang
        Student stu = new Student(id,name,age,birthday);
        //put the student into the list
        list.add(stu);

        System.out.println("Add successfully.");
    }

    //have a look of the student
    public static void queryStudent(ArrayList<Student> list) {
        if(list.size() == 0){
            System.out.println("Now there are no student");
            return;
        }
        //show the title
        System.out.println("id\tname\tage\tbirthday");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
        }
    }

    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("Please input the id you want to delete");
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
        int index = getIndex(list,deleteSid);
        if(index == -1){
            System.out.println("This person is not exist, pls input again.");
        }else{
            list.remove(index);
            System.out.println("Deleted successfully.");
        }
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
