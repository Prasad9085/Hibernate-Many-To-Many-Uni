package ManyToMany_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToMany_uni.dto.Course;
import ManyToMany_uni.dto.Student;

public class CourseDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mayur");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveCourse(Course course) {
		entityTransaction.begin();
		entityManager.persist(course);
		entityTransaction.commit();

	}

	public void deleteCourse(int id) {
		Query query = entityManager.createQuery("select u from Student u");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			List<Course> courses = student.getCourses();
			for (Course course : courses) {
				if (course.getId() == id) {
					courses.remove(course);
				}
			}
			student.setCourses(courses);
		}
		Course course =entityManager.find(Course.class, id);
		entityTransaction.begin();
		entityManager.remove(course);
		entityTransaction.commit();

	}

	public void updateCourse(int id, Course course) {
		Course course2 = entityManager.find(Course.class, id);
		if (course2 != null) {
			course.setId(course2.getId());
			entityTransaction.begin();
			entityManager.merge(course);
			entityTransaction.commit();
		}
	}

	public void findCourseById(int id) {

		Course course = entityManager.find(Course.class, id);
		if (course != null) {
			System.out.println(course);
		}
	}

	public void findAll() {
		Query query = entityManager.createQuery("select u from Course u");
		List<Course> courses = query.getResultList();
		for (Course course : courses) {
			System.out.println(course);
			System.out.println(course.getName() + " " + course.getId() + " here are all the courses");
		}
	}

}
