package au2001;

class BarberChair
{
	boolean barber_available=false;
	int no_of_customers;
	BarberChair(int no_of_customers)
	{
		this.no_of_customers=no_of_customers;
	}
	public synchronized void get_haircut(int i)
	{
		System.out.println("Customer " + i + "  waiting for haircut");
		while(!barber_available)
		{
			try {
				wait();
			}catch(InterruptedException e)
			{
					e.printStackTrace();
			}
		}
		System.out.println("Haircut for customer "+i);
		this.no_of_customers-=1;
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		barber_available=false;
		notifyAll();
	}
	public synchronized void do_haircut()
	{
		while(barber_available)
		{
			try {
				wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		barber_available=true;
		System.out.println("Barber available");
		notifyAll();
	}
}
class Barber extends Thread{
	BarberChair bc;
	Barber(BarberChair bc)
	{
		this.bc=bc;
	}
	public void run()
	{
		while(bc.no_of_customers!=0)
		{
			bc.do_haircut();
		}
	}
}
class Customer extends Thread
{
	BarberChair bc;
	int number;
	Customer(BarberChair bc,int number)
	{
		this.bc=bc;
		this.number=number;
	}
	public void run()
	{
		
		bc.get_haircut(number);
	}
}
public class BarberDemo {
		public static void main(String args[]){
		BarberChair bc=new BarberChair(10);
		int n=bc.no_of_customers;
		Barber b=new Barber(bc);
		b.start();
		for(int i=0;i<n;i++)
		{
			Customer c=new Customer(bc,i+1);
			c.start();
		}
		
		}
}
