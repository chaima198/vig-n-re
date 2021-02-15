/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vige;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Chaima
 */
public class Vige {

    static String directory = System.getProperty("user.home");
  static String filename ="FileCr.texte";
  static String filename1 ="FileDec.texte";
  static String  absolutePath = directory + File.separator + filename;
  static String  absolutePath1 = directory + File.separator + filename1;
 
  static char alphabet [][] =
  {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},
   {'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a'},
   {'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b'},
   {'d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'},
   {'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d'},
   {'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e'},
   {'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f'},
   {'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g'},
   {'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h'},
   {'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i'},
   {'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j'},
   {'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k'},
   {'m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l'},
   {'n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'},
   {'o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n'},
   {'p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'},
   {'q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'},
   {'r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q'},
   {'s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r'},
   {'t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'},
   {'u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t'},
   {'v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'},
   {'w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v'},
   {'x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w'},
   {'y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x'},
   {'5','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'}
           
};
static char[][] matrix = new char[1000][1000];
static String r;
static String k;
static String lineEn="";
static String lineDec="";
static String ref;
static String ref1;
static Scanner sc = new Scanner(System.in);
static  String cryptedTxt;
static  String decryptedTxt;
//la creation de fichier qui contient le message 
public static String WriteFile(){
    Scanner s = new Scanner(System.in);
    String line = "";
    
try {
      FileWriter myWriter = new FileWriter("C:\\Users\\Chaima\\filename1.txt");
      System.out.println("entrez votre texte");
       line = s.nextLine();
      myWriter.write(line);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    
       
     
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
      return null;
    
}
//lecture et cryptage du message 
public static String ReadAndCrypt(){
  int c=0;
      
    try {
      File myObj = new File("C:\\Users\\Chaima\\filename1.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ref= data.toLowerCase();
                System.out.println("entre le clé k");
                  k = sc.nextLine();
                System.out.println("votre message est:"+data);
                
                
                for(int i=0; i<ref.length(); i++){
            if (ref.charAt(i)!= ' '){
                
        matrix[0][i]=ref.charAt(i);
        if (c==0){
            
        matrix[1][i]=k.charAt(i%k.length());
        }else{
            matrix[1][i]=k.charAt((i-c+k.length())%k.length());
        }
        
       
    }else{
                 matrix[0][i]=' ';
         matrix[1][i]=' ';
        c+=1;
         
            }
            
            System.out.println(matrix[0][i]+"  "+matrix[1][i]); 
        }
         for(int k=0; k<matrix.length; k++){
        for(int i=0; i<alphabet.length; i++){
             for(int r=0;r<alphabet.length; r++){
                
               if(matrix[0][k]==alphabet[0][i]&&matrix[1][k]==alphabet[r][0])  {
                    if(matrix[1][k]!=' '){
                   lineEn=lineEn+alphabet[r][i];
                    }else{
                       lineEn=lineEn+" "; 
                    }
               }              

                }
                
    }
     
         }
              
                System.out.println(lineEn);
            } }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
  
      return lineEn;
     
}
//creation de fichier qui contient le message crypté
 public static String CreatCFile(){
    
     cryptedTxt=lineEn;
     
    try(BufferedWriter bufferedWriter = new BufferedWriter(new
FileWriter(absolutePath))) {
String fileContent = cryptedTxt;
bufferedWriter.write(fileContent);
} catch (IOException e) {
// Exception handling
}
      return null;
          
      }
 //lecture et decryptage du message 
 public static String ReadAndDerypt(){
 int test;
    int c=0;
      
    try {
      File myObj = new File("C:\\Users\\Chaima\\FileCr.texte");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ref1= data.toLowerCase();
                System.out.println("entre le clé k");
                  k = sc.nextLine();
                System.out.println("votre message est:"+ref1);
                
                
                for(int i=0; i<ref1.length(); i++){
           
                
        matrix[0][i]=ref1.charAt(i);
         
        if (c==0){
            
        matrix[1][i]=k.charAt(i%k.length());
        }else{
            matrix[1][i]=k.charAt((i-c+k.length())%k.length());
        }
        
       
   
            System.out.println(matrix[0][i]+"  "+matrix[1][i]); 
        }
         for(int k=0; k<matrix.length; k++){
        for(int i=0; i<alphabet.length; i++){
             for(int r=0;r<alphabet.length; r++){
                
               if(matrix[0][k]==alphabet[r][i]&&matrix[1][k]==alphabet[r][0])  {
                    if(matrix[1][k]!=' '){
                   lineDec=lineDec+alphabet[0][i];
                    }else{
                       lineDec=lineDec+" "; 
                    }
               }              

                }
                
    }
     
         }
              
                System.out.println(lineDec);
            } }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
      return lineDec;
          
      }public static String CreatDECFile(){
    
     decryptedTxt=lineDec;
     
    try(BufferedWriter bufferedWriter = new BufferedWriter(new
FileWriter(absolutePath1))) {
String fileContent = decryptedTxt;
bufferedWriter.write(fileContent);
} catch (IOException e) {
// Exception handling
}
      return null;
          
      }
 
    public static void main(String[] args) {
        WriteFile();
      ReadAndCrypt();
        CreatCFile();
        ReadAndDerypt();
        CreatDECFile();
    }
    
}
