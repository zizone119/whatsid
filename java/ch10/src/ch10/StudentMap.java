package ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
class Student2 {
	   private String name;
	   private String department;
	   private String id;
	   private double grade;
	   public Student2(String name, String department, String id, double grade) {
	      this.name = name;
	      this.department = department;
	      this.id = id;
	      this.grade = grade;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getDepartment() {
	      return department;
	   }
	   public void setDepartment(String department) {
	      this.department = department;
	   }
	   public String getId() {
	      return id;
	   }
	   public void setId(String id) {
	      this.id = id;
	   }
	   public double getGrade() {
	      return grade;
	   }
	   public void setGrade(double grade) {
	      this.grade = grade;
	   }
	   
	   
	   
	   
	}

public class StudentMap {
   Scanner sc = new Scanner(System.in);
   HashMap<String, Student2> dept = new HashMap<String, Student2>();

   private void read() {
      System.out.println("학생 이름, 학과, 학번, 학점 평균을 입력하세요  ");
      for (int i = 0; i < 4; i++) {
         System.out.print(" >>> ");
         String name = sc.next();
         String department = sc.next();
         String id = sc.next();
         double grade = sc.nextDouble();

         Student2 student = new Student2(name, department, id, grade);
         dept.put(name, student);
      }

   }

   private void printAll() {
      Set<String> key = dept.keySet();
      Iterator<String> it = key.iterator();
      while (it.hasNext()) {
         String name = it.next();
         Student2 student = dept.get(name);
         System.out.println("-------------------------------");
         System.out.println("이름 : " + student.getName());
         System.out.println("학과 : " + student.getDepartment());
         System.out.println("학번 : " + student.getId());
         System.out.println("학점평균 : " + student.getGrade());
         System.out.println("-------------------------------");
      }
   }

   private void processQuery() {
      while (true) {
         System.out.print("학생 이름 >> ");
         String name = sc.nextLine();
         if (name.equals("그만"))
            return;

         Student2 student = dept.get(name);
         if (student == null) {
            System.out.println(name + "학생은 없습니다.");
         } else {

            System.out.print(student.getName() + ",");
            System.out.print(student.getDepartment() + " ,");
            System.out.print(student.getId() + " ,");
            System.out.print(student.getGrade());
            break;
         }
      }

   }
   
   public void run() {
      read();
      printAll();
      processQuery();
   }
   

   public static void main(String[] args) {
      new StudentMap().run();
   }

}
