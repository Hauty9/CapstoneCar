import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner;

public class Car_Fallback {

	
		public static void main(String[] args) throws IOException {
			
			
			Scanner sc = new Scanner(System.in);
			ArrayList<String> info = new ArrayList<String>();
			String model;
			String title;
			String features;
			String rating;
			
			
				System.out.println("******************************************************");
				System.out.println("*           What Would You Like To Do?               *");
				System.out.println("*                                                    *");
				System.out.println("*           Either                                   *");
				System.out.println("*                                                    *");
				System.out.println("*           Enter - Enter Car Info                   *");
				System.out.println("*                                                    *");
				System.out.println("*           Print - Print Car List                   *");
				System.out.println("*                                                    *");
				System.out.println("*           Sort - Save Car List To File Sorted      *");
				System.out.println("*                                                    *");
				System.out.println("*           Delete - Delete Car List                 *");
				System.out.println("******************************************************");
				

				String choice = sc.next();
				
				switch (choice){
				
				case "Enter":
					while (true) {
						System.out.println("Please Enter Car Model or q to Quit");
						model = sc.next();
						if (model.equals("q"))
							break;
						info.add(model);

						
						System.out.println("Please Enter Car Title");
						title = sc.next();
					    info.add(title);

						System.out.println("Please Enter Car Features");
						features = sc.next();
					   info.add(features);

						System.out.println("Please Enter Car Rating From 1-5 Star Scale");
						rating = sc.next();
						info.add(rating);
						
						//Writing Arraylist to file
						Path output = Paths.get("/Users/bhautman/Desktop/Rasmussen/Computer Science Bachelor Capstone 2:8:23-3:18:23/unsorted.txt");
						
						try {
						    Files.write(output, info);
						   
						} catch (Exception e) {
						    e.printStackTrace();
						}
					
					Car_Fallback.main(args);
						
					}
				
				case "Print":
					
				         System.out.println(info);
				        
					break;
					
				case "Sort":
					Save_To_File_Sorted.main(args);
					Car_Fallback.main(args);
					break;
					
				case "Delete":
					Delete.main(args);
					Car_Fallback.main(args);
					break;
				}
				sc.close();
	}

	}


