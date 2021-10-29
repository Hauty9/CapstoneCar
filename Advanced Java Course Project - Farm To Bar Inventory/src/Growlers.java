import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Growlers {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException  {
		
		Scanner sc = new Scanner(System.in);
		int edit;
		edit=sc.nextInt();
		
		
		
		//Switch Case Used to determine if user is adding or deleting products and how many
		switch(edit) {
		case 1:
			

			String urlConnA = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
			Connection connectionA = DriverManager.getConnection(urlConnA, "root", "Hauty029!");
			
			System.out.println("How Many Growlers Would You like To Add?");
			
			String UnitsA = sc.next();
			
			String sqlA = "UPDATE Growlers SET Inventory = Inventory + ?";
			PreparedStatement myStmtA = connectionA.prepareStatement(sqlA);
			
			
			myStmtA.setString(1,UnitsA);
			
			myStmtA.executeUpdate();
			
			System.out.println( UnitsA + " More Growlers Have Been Added To The Inventory");
			break;
			
		case 2:
			String urlConnD = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
			Connection connectionD = DriverManager.getConnection(urlConnD, "root", "Hauty029!");
			
			System.out.println("How Many Growlers Would You like To Delete?");
			
			String UnitsD = sc.next();
			
			String sqlD = "UPDATE Growlers SET Inventory = Inventory - ?";
			PreparedStatement myStmt = connectionD.prepareStatement(sqlD);
			
			
			myStmt.setString(1,UnitsD);
			
			myStmt.executeUpdate();
			
			System.out.println( UnitsD + " Growlers Have Been Deleted From The Inventory");
			break;
			
		case 3:
			System.out.println("You Have Been Logged Out");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			Main.main(args);
			break;
		}
		System.out.println();
		TimeUnit.SECONDS.sleep(1);
		Current_Inventory_Growlers.main(args);
		sc.close();
	}
	
}

