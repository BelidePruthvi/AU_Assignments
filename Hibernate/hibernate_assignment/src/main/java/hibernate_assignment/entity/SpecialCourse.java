package hibernate_assignment.entity;

import javax.persistence.Entity;

@Entity
public class SpecialCourse extends Course{
	
	int credits;

	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public SpecialCourse(String course_name,int credits)
	{
		this.course_name=course_name;
		this.credits=credits;
	}
	
	public SpecialCourse(){}
}
