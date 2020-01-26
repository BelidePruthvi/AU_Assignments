package hibernate_assignment.entity;

import javax.persistence.Entity;

@Entity
public class OutsideCourse extends Course {

	String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public OutsideCourse(String course_name,String address)
	{
		this.address=address;
		this.course_name=course_name;
	}
	public OutsideCourse(){}
}
