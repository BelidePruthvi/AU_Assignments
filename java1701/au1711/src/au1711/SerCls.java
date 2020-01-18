package au1711;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class SerCls {
			static int count=0;
	       static User user[]=new User[100];
			public static void main(String...args) throws IOException
			{
				File f=new File("./userdata.txt");
		 		FileInputStream fi=new FileInputStream(f);
		 		ObjectInputStream os = null;
		 		try{os=new ObjectInputStream(fi);
		 		User temp=null;
		 		while((temp=(User) os.readObject())!=null) {
		 		System.out.println(temp);
		 		user[count++]=temp;	
		 		}
		 		os.close();
		 		}
		 		catch(EOFException e)
		 		{
		 			//System.out.println(e);
		 		}
		 		catch(Exception e)
		 		{
		 			System.out.println(e);
		 		}
		 		int num;
		 		Scanner sc=new Scanner(System.in);
		 		System.out.println("enter no of users");
		 		num=sc.nextInt();
		 		for(int i=0;i<num;i++)
		 		{
		 			System.out.println("enter age,name");
		 			User temp=new User(sc.nextInt(),sc.next());
		 			user[count++]=temp;
		 			
		 		}
				FileOutputStream fo;
				try {
					fo = new FileOutputStream("./userdata.txt");
				ObjectOutputStream oo=new ObjectOutputStream(fo);
				for(int i=0;i<count;i++)
					
				{   System.out.println(user[i]);
					oo.writeObject(user[i]);
				}
				oo.flush();
				oo.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc.close();
		
			}
}