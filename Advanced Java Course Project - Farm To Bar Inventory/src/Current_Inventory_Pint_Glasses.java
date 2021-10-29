import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Current_Inventory_Pint_Glasses {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//Start The Connection
				Connection connection = null;
				
				try {
					String urlConn = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
					connection = DriverManager.getConnection(urlConn, "root", "Hauty029!");
					
					
				}catch (Exception e) {
					System.out.println("Error Connecting To The Database " + e.getMessage());
					System.out.println();
				}
			
				//Select statement to get Some data
				try {
					PreparedStatement sql = connection.prepareStatement("select * From Pint_Glasses");
					ResultSet rs = sql.executeQuery();
					while(rs.next()) {
						String Inventory = rs.getString("Inventory");
						String Price = rs.getString("Price");
						
				
						System.out.println("Pint Glass Inventory:" + Inventory);
						
						System.out.println("Price Of Each Pint Glass:" + Price);
						System.out.println();
						
						Product_Choice.productChoice(args);

					}
				}catch (Exception e) {
					System.out.println("There Was An Error Getting Data: ");
				}
	}
	
}
