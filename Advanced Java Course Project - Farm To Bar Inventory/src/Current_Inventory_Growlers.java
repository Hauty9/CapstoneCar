import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Current_Inventory_Growlers {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
	//Start The Connection
			Connection connection = null;
			
			try {
				String urlConn = "jdbc:mysql://localhost:3306/Farm_To_Bar_Inventory";
				connection = DriverManager.getConnection(urlConn, "root", "Hauty029!");
				System.out.println("Connecting To The Database Was Successful");
				System.out.println();
				
			}catch (Exception e) {
				System.out.println("Error Connecting To The Database " + e.getMessage());
				System.out.println();
			}
		
			//Select statement to get Some data
			try {
				
				PreparedStatement sql = connection.prepareStatement("select * From Growlers");
				ResultSet rs = sql.executeQuery();
				while(rs.next()) {
					String Inventory = rs.getString("Inventory");
					String Price = rs.getString("Price");
					
			
					System.out.println("Growler Inventory:" + Inventory);
					
					System.out.println("Price Of Growler Deposit:" + Price);
					System.out.println();
					
					Current_Inventory_Crowlers.main(args);

				}
			}catch (Exception e) {
				System.out.println("There Was An Error Getting Data: ");
			}
}
}