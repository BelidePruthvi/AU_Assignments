package au1711;

import java.io.Serializable;

public class User implements Serializable {
	int age;
	String name;
	User(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	
	public String toString()
	{
		return this.age +" " + this.name;
	}

}
