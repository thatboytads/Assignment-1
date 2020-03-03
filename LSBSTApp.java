import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
 
public class LSBSTApp
{   //TextF[] Arrayobj= new TextF[2976];
    private BinarySearchTree<TextF> bst;
    int opCount= 0;
    public LSBSTApp(){
      bst = new BinarySearchTree<TextF>();
      }
    public static void main( String [] args )
    {  
           
       if (args.length==3)
          (new LSBSTApp ()).printAreas (args[0], args[1], args[2]);
       else{
           LSBSTApp m=new LSBSTApp();
           m.printAllAreas();}

    }
  
    public void insertTree(TextF other){
      bst.insert(other);
      }
    
        public void TextFile()
    { 
     // LSBSTApp LSBT= new LSBSTApp();
      
    try{
        File file= new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner sc= new Scanner(file);
        
       
        int icount= 0; 
        while(sc.hasNextLine()){
          TextF other= new TextF(sc.nextLine());
         //System.out.println(other.toString());
                bst.insert(other);
                
                icount= icount+1;
               
                }
                sc.close();
       }catch (FileNotFoundException e){
       e.printStackTrace();
       
       }}
       
    public void printAreas (String stage2, String day2, String time2) 
    {
   TextFile();
   
      
    System.out.println("Areas: " + Arrays.toString((bst.find(new TextF(stage2,day2,time2)).getData()).getAreas()));
    //}
    
    }

    
    public void printAllAreas () 
    {
     TextFile();
     
    bst.inOrder();
 
     
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



   

