import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Add_Delete_Product {

	
	

		public static void main(String[] args) throws IOException, InterruptedException, SQLException  {
			
			Scanner sc = new Scanner(System.in);
			int edit;
			edit=sc.nextInt();
			
			
			
			//Switch Case Used to determine if user is adding or deleting products
			switch(edit) {
			case 1:
				

				String urlConnA = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
				Connection connectionA = DriverManager.getConnection(urlConnA, "root", "Hauty029!");
				
				System.out.println("What Is The Name Of The Product You Would Like To Add ?");
				
				String UnitsA = sc.next();
				
				//Creating New Table With User Input adding Inventory and Price With Both Being an Integer
				String sqlA = "CREATE TABLE " + UnitsA + " (Inventory INTEGER, Price INTEGER, ID INTEGER)";
                
				PreparedStatement myStmtA = connectionA.prepareStatement(sqlA);
				
				
				//Update MYSQL with the string created
				myStmtA.executeUpdate(sqlA);
				

				System.out.println( UnitsA + " Have Been Added To The Inventory");
				
				
				break;
				
			case 2:
				
				//Connection to MYSQL Database
				String urlConnD = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
				Connection connectionD = DriverManager.getConnection(urlConnD, "root", "Hauty029!");
				
				System.out.println("What Is The Name Of The Product You Would Like To Delete ?");
				
				String UnitsD = sc.next();
				
				//Deleting table that user input selected
				String sqlD = "DROP TABLE " + UnitsD;
                
				PreparedStatement myStmtD = connectionD.prepareStatement(sqlD);
				
				
				
				//Sending sql String
				myStmtD.executeUpdate(sqlD);
				
				System.out.println( UnitsD + " Has Been Deleted From The Inventory");
				break;
				
			
			}
			
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			All_Products.main(args);
			sc.close();
		}
		
	}