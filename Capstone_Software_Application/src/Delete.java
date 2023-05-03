import java.io.File;

public class Delete {

	public static void main(String[] args) {
		//Defining file that needs to be deleted
		 File myObj = new File("/Users/bhautman/Desktop/Rasmussen/Computer Science Bachelor Capstone 2:8:23-3:18:23/unsorted.txt"); 
		    if (myObj.delete()) { 
		      System.out.println("Deleted the file: " + myObj.getName());
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
		    
	}

	

}
