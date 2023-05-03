
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Save_To_File_Sorted {
 
    public static void main(String[] args) {
           
           String unsorted ="/Users/bhautman/Desktop/Rasmussen/Computer Science Bachelor Capstone 2:8:23-3:18:23/unsorted.txt";
           String sorted ="/Users/bhautman/Desktop/Rasmussen/Computer Science Bachelor Capstone 2:8:23-3:18:23/sorted.txt";

           
           try {
                  //1) Read file in String, and store each String in ArrayList
                  FileReader fr = new FileReader(unsorted);
                  BufferedReader br = new BufferedReader(fr);
                  
                  List<String> l=new ArrayList<String>();
                  String str;
                  
                  while((str = br.readLine()) != null){
                        l.add(str);
                  }
                  br.close();
                  
                  
                  
                  //2) Sort ArrayList
                  Collections.sort(l);
 
                  System.out.print("Display sorted list > ");
                  //Display sorted list
                  System.out.println(l);
                  
                  //3) Now, write sorted content in file
                  FileWriter fw = new FileWriter(sorted);
                  BufferedWriter bw = new BufferedWriter(fw);
                  for(String s: l){
                        bw.write(s);
                        bw.write("\n");
                  }
                  
                  bw.close();
                  System.out.println("\nSorted content has been written in file");
              	Car_Information.main(args);

                  
                  
           } catch (FileNotFoundException e) {
                  e.printStackTrace();
           } catch (IOException e) {
                  e.printStackTrace();
           }
           

    }

}