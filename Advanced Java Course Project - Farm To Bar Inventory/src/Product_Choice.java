import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
public class Product_Choice  {
	
	
	private static final Logger LOGGER = Logger.getLogger(Product_Choice.class.getName());
	
	
	public static void productChoice(String[] args) throws java.io.IOException, InterruptedException, SQLException {
		
		configureLogger();
		
		//Logger messages for logging
		LOGGER.config(" This is a log message that won't get logged to a file due to my MyCustomLoggingFilter");
		LOGGER.info("Product Choice Has Started");
		
		int pChoice=0;
		Scanner sc = new Scanner(System.in);
		
		
		
		try {	
			
		//Product Selection
			
		
		System.out.println("*************Please Select Area To Edit***************");
		System.out.println("*               1 - Growlers                         *");
		System.out.println("*               2 - Crowlers                         *");
		System.out.println("*               3 - Pint Glasses                     *");
		System.out.println("*               4 - Add or Delete New Product        *");
		System.out.println("*               5 - Show Current Inventory           *");
		System.out.println("*               6 - Log Out Of Inventory System      *");
		System.out.println("******************************************************");	

		pChoice=sc.nextInt();

		
		
		}catch(InputMismatchException e) {
			   
			   LOGGER.log(Level.WARNING, "Input Mismatched, A Letter Was Entered Instead Of A Number", e);
			  }
		
		//Switch Statement to Choose add or delete Inventory
		switch(pChoice) {
		
		case 1:
			System.out.println("******************************************************");	
			System.out.println("*                Would You Like To:                  *");
			System.out.println("*                   1 - ADD                          *");
			System.out.println("*                   2 - Delete                       *");
			System.out.println("*                   3 - Change Price                 *");
			System.out.println("*                 From The Growlers                  *");
			System.out.println("******************************************************");	

			Growlers.main(args);
			break;
			
		case 2:
			System.out.println("******************************************************");	
			System.out.println("*                Would You Like To:                  *");
			System.out.println("*                   1 - ADD                          *");
			System.out.println("*                   2 - Delete                       *");
			System.out.println("*                   3 - Change Price                 *");
			System.out.println("*                 From The Crowlers                  *");
			System.out.println("******************************************************");
			Crowlers.main(args);
			break;
			
		case 3:
			System.out.println("******************************************************");	
			System.out.println("*                Would You Like To:                  *");
			System.out.println("*                   1 - ADD                          *");
			System.out.println("*                   2 - Delete                       *");
			System.out.println("*                   3 - Change Price                 *");
			System.out.println("*                 From The Pint Glasses              *");
			System.out.println("******************************************************");
			Pint_Glasses.main(args);
			break;
		
		case 4:
			
			System.out.println("******************************************************");	
			System.out.println("*                Would You Like To:                  *");
			System.out.println("*                   1 - ADD                          *");
			System.out.println("*                   2 - Delete                       *");
			System.out.println("*                  New Products                      *");
			System.out.println("******************************************************");
			TimeUnit.SECONDS.sleep(1);
			Add_Delete_Product.main(args);
			break;
			
		case 5:
			System.out.println("Updated Product List: ");
			TimeUnit.SECONDS.sleep(1);
			All_Products.main(args);
			break;
			
		case 6:
			System.out.println("You Have Been Logged Out");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			Main.main(args);
			break;
			
			
		}
		sc.close();
		
		LOGGER.info("Product Choice Has Ended");
		}	
	public static void configureLogger() throws IOException {
		//location for log
		FileHandler fh = new FileHandler("/Users/bhautman/Desktop/Advanced Java Course Project - Farm To Bar Inventory/Logging.log", true);
		
		//formatter
		XMLFormatter formatter = new XMLFormatter();
		fh.setFormatter(formatter);
		
		//Custom filter
		MyCustomLoggingFilter filter = new MyCustomLoggingFilter();
		fh.setFilter(filter);
		
		LOGGER.addHandler(fh);
	}

}

