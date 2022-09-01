package Week1; 
import java.util.Scanner; 
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Main
{   




public static void main(String args[])   
{  
//get the data from the names.txt file and storing it in a list
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
    


// Randomizing list of names, then converting it into an array
String arr[] = new String[namesList.size()];
Collections.shuffle(namesList);
namesList.toArray(arr);


//Get number of students
int numStudents = arr.length;

//Getting the number of groups from the user
Scanner reader = new Scanner(System.in);
System.out.println("Enter Number of Groups: ");
int totalGroups = reader.nextInt();
reader.close();

//Getting the group size
int groupSize = numStudents/totalGroups;

//Gets the remainder, so that all students are assigned into groups
int remainder = numStudents - (groupSize * totalGroups);
   
//Creating an array of arrays for the different groups
String[][] NumArrays = new String[(totalGroups)][groupSize + 1];

//This for loop creates a list for each group, and then converts that list into an array and adds it the array of groups. 
int counter = 0;
for (int i = 0; i < totalGroups; i++){
    
    List<String> newList = new ArrayList<>();
    int x = 0;
    // If there are extra kids left over, I use the remainder to make sure that everyone is assigned to a group. 
    // This leads to some groups occasionally having an extra person
    if (i < remainder){
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
    newList.toArray(NumArrays[i]);  
}

// Print out the different groups
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
    System.out.println("");
}

}   
}  