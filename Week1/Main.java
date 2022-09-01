package Week1; 
import java.util.Scanner; 
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Main
{   




public static void main(String args[])   
{  
//get the data from the names.txt file
List<String> namesList = new ArrayList<>();
try {
    File myObj = new File("C:/Users/saber/Documents/IS 405 - Project Mgt/Week1/names.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        namesList.add(data);
    }
    myReader.close();
    } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
    }
    


// Randomizing list of names 
String arr[] = new String[namesList.size()];
namesList.toArray(arr);
List<String> list = Arrays.asList(arr);
Collections.shuffle(list);
list.toArray(arr);

//System.out.println(arr[0]);
//Get number of students
int numStudents = arr.length;

//Getting the number of groups from the user
Scanner reader = new Scanner(System.in);
System.out.println("Enter Number of Groups: ");
int totalGroups = reader.nextInt();
reader.close();

//Getting the group size
int groupSize = numStudents/totalGroups;
int remainder = numStudents - (groupSize * totalGroups);
//System.out.println(remainder);
   

String[][] NumArrays = new String[(totalGroups)][groupSize + 1];


int counter = 0;
for (int i = 0; i < totalGroups; i++){
    
    List<String> newList = new ArrayList<>();
    int x = 0;
    if (i < remainder){
        //System.out.println("catch");
        while (x < (groupSize + 1)){
            newList.add(arr[counter]);
            
            counter ++;
            x++;
        }
    }
    else{
        while (x < groupSize){
            newList.add(arr[counter]);
            
            counter ++;
            x++;
        }
    }
    //System.out.println(newList);
    newList.toArray(NumArrays[i]);  
}

int groupNum = 1;
for (String[] i : NumArrays){
    System.out.println("Group Number " + groupNum);
    for (int d = 0; d < i.length; d++){
        if (i[d] == null){
            
        }
        else{
            System.out.println(i[d]);
        }
        
    }
    groupNum ++;
}

}   
}  