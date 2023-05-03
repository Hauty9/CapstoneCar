import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
	


	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		
		
		
		String username;
		String password;
		
		
		//Holds Instance of a user who successfully logged in
		User loggedInEmployee = null;
		
		//Create an empty array to hold users
		List<User> listOfEmployees = new ArrayList<>();
		
		//4 Employee's name and password that could log in
		listOfEmployees.add(new User("Braden", "Yoshi"));
		listOfEmployees.add(new User("Jenni", "Peach"));
		listOfEmployees.add(new User("Hadley", "Daisy"));
		listOfEmployees.add(new User("Piper", "Toad"));
		
            
		//Get user input
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//Greeting/Login screen for employee's to log into to
		System.out.println("******************************************************");
		System.out.println("*           Farm To Bar's Inventory System           *");
		System.out.println("******************************************************");
		System.out.println();
		System.out.println("          Please Enter In Employee Name:           ");
		username = br.readLine();
		System.out.println("         Please Enter In Employee Password:        ");
		password = br.readLine();
		
		
		System.out.println();
		
		
		
		
		//Iterate through list of employees to see if there is a match
		for (User Employee : listOfEmployees)
		{
			if(Employee.getUsername().equals(username))
			{
				if (Employee.getPassword().equals(password))
				{
					loggedInEmployee = Employee;
					
					//Once employee is found program will stop
					break;
				}
			}
		}

		//if LoggedInEmployee was changed from null, the log in was successful
		if (loggedInEmployee !=null)
		{
			System.out.println("Successful Login " +loggedInEmployee.getUsername());
			System.out.println();
			
			//Start product choice class
			Product_Choice.productChoice(args);
		}
		
		else
		{
			//Username/Password Invalid starts the class over
			System.out.println("Invalid Username/Password.  Please Try Again");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			Main.main(args);
		}
	}
	

}

