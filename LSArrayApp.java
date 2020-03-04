import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

 
public class LSArrayApp
{   LSA[] Arrayobj= new LSA[2976];
    int opCount= 0;
    public static void main( String [] args )
    {  
           
       if (args.length==3)
          (new LSArrayApp ()).printAreas (args[0], args[1], args[2]);
       else
           (new LSArrayApp ()).printAllAreas ();

    }

    
        public void TextFile()
    { 
    try{
        File file= new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner sc= new Scanner(file);
        
       
        int icount= 0; 
        while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] info= line.split(" ");
                String data= info[0];
                String[] data2= data.split("_");
                String stage1 = data2[0];
                String day1 = data2[1];
                String time1= data2[2];
                int num1= line.indexOf(" ");
                String areas1= line.substring(num1);
                LSA  j = new LSA(stage1,day1,time1,areas1);
                Arrayobj[icount]= j;
               // System.out.println(j.toString());
                // Arrayobj[icount].stage= stage1;
                // Arrayobj[icount].day= day1;
                // Arrayobj[icount].time= time1;
                icount= icount+1;
                }
                sc.close();
       }catch (FileNotFoundException e){
       e.printStackTrace();
       
       }}

    public void printAreas (String stage2, String day2, String time2) 
    {
    TextFile();
    
      
    for (LSA textF : Arrayobj) {
        
        opCount++;
       
            
                  
        if ( textF.stage.equals(stage2) && (textF.day.equals(day2)) && (textF.time.equals(time2)) ) {
         
      
         
         System.out.println(stage2 +" "+ day2+" "+ time2+" "+textF.areas);
         CreateText();
         WriteText();
         break;

        }
       
        }
    }

    
    public void printAllAreas () 
    {
     TextFile();
     
     
     //TextF ts= new TextF();
    
     for (LSA textF : Arrayobj) {
        
         System.out.println(textF.stage +" "+ textF.day+" "+ textF.time+" "+textF.areas);
        }
     
    } 
    public void CreateText(){
        try{ 
            File file = new File("./counter update.txt");
  
            //Create the file
            if (file.createNewFile())
            {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
             
            
                }
                catch(IOException e) {
                    e.printStackTrace();
                  }
        }
        public void WriteText(){
            try{
                File file = new File("./counter update.txt");
      
                
                 
                //Write Content
                FileWriter writer = new FileWriter(file);
                writer.write(Integer.toString(opCount));
                writer.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                      }
            }
    
    
} 



   

