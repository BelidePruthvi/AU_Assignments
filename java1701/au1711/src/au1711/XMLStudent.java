package au1711;
import java.io.File;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

class Sortbyroll implements Comparator<Node> 
{ 
    public int compare(Node a, Node b) 
    { 
        return Integer.valueOf(a.valueOf("@rollno")) - Integer.valueOf(b.valueOf("@rollno")); 
    } 
} 
     
public class XMLStudent {
	public static void main(String args[])
	{
		try
		{
			File file=new File("./XML_RAW_DATA.xml");
			SAXReader reader=new SAXReader();
			Document document = reader.read( file );
			ArrayList<Node> nodes = new ArrayList<Node>(document.selectNodes("/class/student" ));
			Collections.sort(nodes, new Sortbyroll());
			for (Node node : nodes) {
	            System.out.println("Student roll no : " 
	               + node.valueOf("@rollno") );
	            System.out.println("First Name : "
	               + node.selectSingleNode("firstname").getText());
	            System.out.println("Last Name : "
	               + node.selectSingleNode("lastname").getText());
	            System.out.println("Marks : "
	               + node.selectSingleNode("marks").getText());
	            System.out.println();
			}
		}
		catch (DocumentException e) {
	         e.printStackTrace();
	      }
	   
	}

}
