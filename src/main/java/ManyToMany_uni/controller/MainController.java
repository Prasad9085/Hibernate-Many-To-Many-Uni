package ManyToMany_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import ManyToMany_uni.dao.CourseDao;
import ManyToMany_uni.dao.StudentDao;
import ManyToMany_uni.dto.Course;
import ManyToMany_uni.dto.Student;

public class MainController {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		CourseDao courseDao =  new CourseDao();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1.save student \n2.delete sttudent \n3.update sttudent \n4.find sttudent by id \n5.find all sttudent \n6 add course \n 7 delete course \n 8.update course \n 9.find course \n 10 find all course \n 11.stop");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			List<Integer> integers = new ArrayList<Integer>();
			
			
			Student s1 = new Student();
			System.out.println("enter student name ");
			s1.setName(scanner.next());
			
			System.out.println("enter phone");
			s1.setPhone(scanner.nextLong());
			
			System.out.println("enter address");
			s1.setAddress(scanner.next());
			
			
			courseDao.findAll();
			
			for(;;) {
				System.out.println("1 add 2 stop");
				switch(scanner.nextInt())
				{
				case 1 :{
					System.out.println("select course from this");
					System.out.println("enter course id");
					integers.add(scanner.nextInt());
					
				break;
				}
				case 2 :{
					dao.saveStudent(s1, integers);
					return;
				}
				
				}
			}
		}
		case 2: {
			System.out.println("enter student id");
			int id = scanner.nextInt();
			dao.deleteStudent(id);
			
			break;
		}
		case 3: {
			Student s1 = new Student();
			System.out.println("enter id");
			int id = scanner.nextInt()
					
			System.out.println("enter new  student name ");
			s1.setName(scanner.next());
			
			System.out.println("enter new phone");
			s1.setPhone(scanner.nextLong());
			
			System.out.println("enter new  address");
			s1.setAddress(scanner.next());
			
			
			dao.updateStudent(id, s1);
			
			break;
		}
		case 4: {
			System.out.println("enter student id ");
			int id = scanner.nextInt();
			
			dao.findStudenById(id);
			
			break;
		}
		case 5: {
			dao.finAllStudents();
			break;
		}
		case 6: {
			Course c1 =  new Course();
			System.out.println("enter course name");
			c1.setName(scanner.next());
			
			System.out.println("enter course fees");
			c1.setFees(scanner.nextLong());
			
			System.out.println("enter course duration");
			c1.setDuration(scanner.nextDouble());
			
			
			
			courseDao.saveCourse(c1);
			
			break;
		}
		case 7: {
			System.out.println("enter course id");
			int id = scanner.nextInt();
			courseDao.deleteCourse(id);
			break;
		}
		case 8: {
			System.out.println("enter id");
			int id = scanner.nextInt();
			Course c1 =  new Course();
			System.out.println("enter  new course name");
			c1.setName(scanner.next());
			
			System.out.println("enter new course fees");
			c1.setFees(scanner.nextLong());
			
			System.out.println("enter new  course duration");
			c1.setDuration(scanner.nextDouble());
			
			
			
			courseDao.updateCourse(id,c1);
			
			break;
		}
		case 9: {
			System.out.println("enter id");
			int id = scanner.nextInt();
			courseDao.findCourseById(id);
		
			break;
		}
		case 10: {
			courseDao.findAll();
			break;
		}
		case 11: {
			break;
		}
		}
	}
}
