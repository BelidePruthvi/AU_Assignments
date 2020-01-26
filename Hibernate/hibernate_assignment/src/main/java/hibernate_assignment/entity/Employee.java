package hibernate_assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	int salary;
	
	@Temporal(TemporalType.DATE)
    private Calendar joinDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Employee_course", joinColumns={@JoinColumn(referencedColumnName="id")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="id")})  
    private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee(){}
	
	public Employee(String name,int salary,Calendar date)
	{
		this.name=name;
		this.salary=salary;
		this.joinDate=date;
	}
	public Calendar getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
