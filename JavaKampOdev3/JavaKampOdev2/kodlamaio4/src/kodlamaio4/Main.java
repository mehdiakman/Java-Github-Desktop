package kodlamaio4;

import java.util.ArrayList;
import java.util.List;

import kodlamaio4.business.CategoryManager;
import kodlamaio4.business.CourseManager;
import kodlamaio4.business.InstructorManager;
import kodlamaio4.core.logging.DatabaseLogger;
import kodlamaio4.core.logging.FileLogger;
import kodlamaio4.core.logging.Logger;
import kodlamaio4.core.logging.MailLogger;
import kodlamaio4.dataAccess.HibernateCategoryDao;
import kodlamaio4.dataAccess.HibernateInstructorDao;
import kodlamaio4.dataAccess.JdbcCourseDao;
import kodlamaio4.entities.Category;
import kodlamaio4.entities.Course;
import kodlamaio4.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {

		Logger[] loggers = { new MailLogger(), new FileLogger(), new DatabaseLogger() };

		Course course1 = new Course(1, "Java", "Eğitim", "Engin", 1000);
		Course course2 = new Course(2, "C", "OnlineEğitim", "EnginDemirog", 20001);

		Course[] courses = { course1, course2 };

		for (int i = 0; i < courses.length; i++) {
			System.out.println(courses[i].getCourseName());
		}

		Course course3 = new Course(2, "C+", "OnlineEğitim", "EnginDemirog", 20001);
		CourseManager courseManager = new CourseManager(new JdbcCourseDao(), courses, loggers);
		courseManager.add(course3);

		Category category1 = new Category(1, "Web");
		Category category2 = new Category(2, "Mobil");

		Category[] categories = { category1, category2 };

		Category category3 = new Category(3, "Masaüstü");

		CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), categories, loggers);
		categoryManager.add(category3);

		Instructor instructor = new Instructor(1, "Engin", "Demirog");
		InstructorManager intInstructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);
		intInstructorManager.add(instructor);

	}

}
