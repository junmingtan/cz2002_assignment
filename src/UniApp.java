import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class UniApp {
	// test
private static final String filepath="C:\\Users\\benny\\git\\repository\\OODP Assignment\\StudentDatabase.txt";

	public static void main(String[] args) {
	
		int choice;
		do {
			System.out.println( "Enter integer to choose the following functions:");
			System.out.println(	"1:  Add or Remove a Student into the University");
			System.out.println( "2:  Add a Course into the University");
			System.out.println( "3:  Register student for a Course");
			System.out.println( "4:  Check avaliable slot in a Class");
			System.out.println( "5:  Print student list by lecture, tutorial or laboratory session for a Course");
			System.out.println(	"6:  Enter course assessment compenents weightage");
			System.out.println( "7:  Enter Coursework mark - inclusive of its components ");
			System.out.println( "8:  Enter Examination mark");
			System.out.println( "9:  Print Course Stastistic");
			System.out.println( "10: Prints Student Transcript");
			System.out.println( "11: quit");
			
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch (choice) {
			case 1:
				manageStudent();
				
				break;
				
				
			case 2: 
			
				break;
				
				
			case 3: 
				break;
				
				
			case 4:
				System.out.println( "Enter a positive integer");


			break;
			
			case 5 : 
				
			break;
		
			case 6 : 
				
			break;
			
			case 7 : 
			break;
			
			}
		
			}	while (choice < 11);
	
	}
	

	
	private static void manageStudent() {
		int stdId; 
		ArrayList<Student> list = new ArrayList<Student>();
		String fName , lName;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Student ID");
		stdId = in.nextInt();
		System.out.println("Enter Student First Name ");
		fName = in.next();
		System.out.println("Enter Student Last Name ");
		lName = in.next();
		
		try	{
			// read from serialized file the list of professors
			list = (ArrayList<Student>)UniApp.readSerializedObject("src/StudentDatabase.txt");
			

			// write to serialized file - update/insert/delete
			// example - add one more professor
			Student s = new Student(fName,lName,stdId);
			
			System.out.println("Enter the integer of choice\n" + "(1) Add this student \n" + "(2) Remove this student \n \n");
			int choice = in.nextInt(),check =0;
			
			switch (choice) {
			
			case 1 : 
				list.add(s);
				break;
			case 2 : 
				Iterator itr = list.iterator(); 
		        while (itr.hasNext()) 
		        { 
		            Student x = (Student)itr.next(); 
		            if (x.getId() == s.getId()) {
		                itr.remove();
		                check = 1;
		                System.out.println("Student was successfully deleted"); // remove if s equals object in the list
		            }
		            
				}
				 if (check == 0) {
					 System.out.println("Student is not in the System");
				 }
			}
			
			UniApp.writeSerializedObject("StudentDatabase.txt", list);
			System.out.println("The following students are now in the University");
			
			for (int i = 0 ; i < list.size() ; i++) {
				s = list.get(i);
				System.out.println("Student name is " + s.getFirstName() + " " + s.getLastName() );
				System.out.println("Student ID is " + s.getId() + "\n \n \n");
			}

	}  catch ( Exception e ) {
				System.out.println( "Exception >> " + e.getMessage() );
	}
		
	}
	
	
	public static ArrayList readSerializedObject(String filename) {
		ArrayList<Student> pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList<Student>) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, ArrayList<Student> list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
