package hibernate_assignment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_assignment.entity.*;

public class OfficeDemo {


	static SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	static Session session=sessionFactory.openSession();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Office ofc=new Office("office1");
		Employee emp1=new Employee("emp1",10000,new GregorianCalendar(2019, 4, 31));
		Employee emp2=new Employee("emp2",20000,new GregorianCalendar(2019, 2, 26));
		Course course=new Course("samplecourse");
		SpecialCourse scourse=new SpecialCourse("special",4);
		OutsideCourse ocourse=new OutsideCourse("outside","hyd");
		List<Course> emp1_course=new ArrayList<Course>();
		emp1_course.add(course);
		emp1_course.add(scourse);
		emp1.setCourses(emp1_course);
		List<Course> emp2_course=new ArrayList<Course>();
		emp2_course.add(course);
		emp2_course.add(ocourse);
		emp2.setCourses(emp2_course);
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(emp1);
		emps.add(emp2);
		ofc.setEmps(emps);
		session.beginTransaction();
		session.save(scourse);
		session.save(ocourse);
		session.save(course);
		session.save(emp1);
		session.save(emp2);
		session.save(ofc);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
