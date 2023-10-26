package ManyToMany_uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToMany_uni.dto.Course;
import ManyToMany_uni.dto.Student;

public class StudentDao {
	
	EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("prasad");
	EntityManager entityManager =  entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction =  entityManager.getTransaction();
	public void saveStudent(Student s1 ,List<Integer> ids ) {
		
		entityTransaction.begin();
		List<Course>  courses =  new ArrayList<Course>();
		for (Integer integer : ids) {
			Course course2 =  entityManager.find(Course.class, integer);
			courses.add(course2);
		}
		s1.setCourses(courses);
		entityManager.persist(s1);entityTransaction.commit();
		
	}
	
	
	public void deleteStudent(int id )
	{
		Student student =entityManager.find(Student.class, id);
		if(student!=null)
		{
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		}
	}
	
	public void updateStudent(int id , Student student)
	{
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			student.setId(dbStudent.getId());
			student.setCourses(dbStudent.getCourses());
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
	}
	
	public void findStudenById(int id) {
		
		Student student = entityManager.find(Student.class, id);
		if(student!=null) {
			System.out.println(student);
		}
	}
	
	public void finAllStudents() {
		
		Query query = entityManager.createQuery("select u from Student u");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
}
