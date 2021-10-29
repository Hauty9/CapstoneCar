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
		System.out.println("What Inventory Item Would You Like To Update?");
		System.out.println();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("1 - Growlers");
		System.out.println("2 - Crowlers");
		System.out.println("3 - Glassware");
		System.out.println("4 - Log Out Of Inventory System");
		
		pChoice=sc.nextInt();

		
		
		}catch(InputMismatchException e) {
			   
			   LOGGER.log(Level.WARNING, "Input Mismatched, A Letter Was Entered Instead Of A Number", e);
			  }
		
		//Switch Statement to Choose add or delete Inventory
		switch(pChoice) {
		
		case 1:
			System.out.println("Would You Like To Add - 1 Or Delete - 2 Growler Inventory?");
			Growlers.main(args);
			break;
			
		case 2:
			System.out.println("Would You Like To Add - 1 Or Delete - 2 Crowler Inventory?");
			Crowlers.main(args);
			break;
			
		case 3:
			System.out.println("Would You Like To Add - 1 Or Delete - 2 Glassware Inventory?");
			Pint_Glasses.main(args);
			break;
		
		case 4:
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
		FileHandler fh = new FileHandler("/Users/bhautman/eclipse-workspace/Advanced Java Course Project - Farm To Bar Inventory/Logging.log", true);
		
		//formatter
		XMLFormatter formatter = new XMLFormatter();
		fh.setFormatter(formatter);
		
		//Custom filter
		MyCustomLoggingFilter filter = new MyCustomLoggingFilter();
		fh.setFilter(filter);
		
		LOGGER.addHandler(fh);
	}

}

