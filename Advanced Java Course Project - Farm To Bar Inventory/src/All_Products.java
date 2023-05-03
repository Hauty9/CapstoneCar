import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class All_Products {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		
		
				//Start The Connection
				Connection connection = null;
				
				String urlConn = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
					connection = DriverManager.getConnection(urlConn, "root", "Hauty029!");
					
					System.out.println();
					
				
			
				//Select statement to show all tables
				try {
					
					PreparedStatement sql = connection.prepareStatement("Show Tables");
					ResultSet rs = sql.executeQuery();
					System.out.println("******************************************************");	
					System.out.println("*                Current Inventory:                  *");
						while(rs.next()) {
							
						
							System.out.print("*                     " + rs.getString(1) + "                       *");
							System.out.println();
						 
						}
						System.out.println("******************************************************");
						
					//Starting Product Choice Class
					Product_Choice.productChoice(args);

					
				}catch (Exception e) {
					System.out.println("There Was An Error Getting Data: ");
				}
	}
	}