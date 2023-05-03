import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Pint_Glasses {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException  {
		
		Scanner sc = new Scanner(System.in);
		int edit;
		edit=sc.nextInt();
		
		
		
		//Switch Case Used to determine if user is adding or deleting products and how many
		switch(edit) {
		case 1:
			
			//Connection to MYSQL Database
			String urlConnA = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
			Connection connectionA = DriverManager.getConnection(urlConnA, "root", "Hauty029!");
			
			System.out.println("How Many Pint Glasses Would You like To Add?");
			
			String UnitsA = sc.next();
			
			//String that will be sent to MYSQL
			String sqlA = "UPDATE Pint_Glasses SET Inventory = Inventory + ?";
			PreparedStatement myStmtA = connectionA.prepareStatement(sqlA);
			
			
			myStmtA.setString(1,UnitsA);
			
			//Sending String
			myStmtA.executeUpdate();
			
			System.out.println( UnitsA + " More Pint Glasses Have Been Added To The Inventory");
			break;
			
		case 2:
			
			//Connection to MYSQL Database
			String urlConnD = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
			Connection connectionD = DriverManager.getConnection(urlConnD, "root", "Hauty029!");
			
			System.out.println("How Many Pint Glasses Would You like To Delete?");
			
			String UnitsD = sc.next();
			
			//String that will be sent to MYSQL
			String sqlD = "UPDATE Pint_Glasses SET Inventory = Inventory - ?";
			PreparedStatement myStmt = connectionD.prepareStatement(sqlD);
			
			
			myStmt.setString(1,UnitsD);
			
			//Sending String To MYSQL
			myStmt.executeUpdate();
			
			System.out.println( UnitsD + " Pint Glasses Have Been Deleted From The Inventory");
			break;
			
		case 3:
			
			//Starting Connection to MYSQL
			String urlConnP = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
			Connection connectionP = DriverManager.getConnection(urlConnP, "root", "Hauty029!");
			
			System.out.println("What Would You Like To Change Crowler Price To?");
			
			String Price = sc.next();
			
			//String to send to MYSQL
			String sqlP = "UPDATE Pint_Glasses SET Price = ?";
			PreparedStatement myStmtP = connectionP.prepareStatement(sqlP);
			
			
			myStmtP.setString(1,Price);
			
			
			//Sending String To MYSQL
			myStmtP.executeUpdate();
			
			System.out.println("Pint Glasses Price Has Been Changed To: " + Price);
			break;
			
		case 4:
			System.out.println("You Have Been Logged Out");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			
			//Starting Main Class To Start Program Over
			Main.main(args);
			break;
		}
		System.out.println();
		TimeUnit.SECONDS.sleep(1);
		
		//Starting Current Inventory of Pint Glasses
		Current_Inventory_Pint_Glasses.main(args);
		System.out.println();
		sc.close();
	}
	
}

