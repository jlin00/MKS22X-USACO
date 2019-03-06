import java.io.*;
import java.util.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    File f = new File(filename); //reads in file
    Scanner info = new Scanner(f);
    List<String> lines = new ArrayList<String>();

    while (info.hasNextLine()){ //adds lines from file into Arraylist
      lines.add(info.nextLine());
    }

    String[] firstline = lines.get(0).split(" "); //split the first line and store values
    int R = Integer.parseInt(firstline[0]);
    int C = Integer.parseInt(firstline[1]);
    int E = Integer.parseInt(firstline[2]);
    int N = Integer.parseInt(firstline[3]);

    int[][] land = new int[R][C];
    String[] temp; //temporary storage for line
    for (int i = 1; i <= R; i++){
      temp = lines.get(i).split(" "); //split the line
      for (int j = 0; j < C; j++){
        land[i-1][j] = Integer.parseInt(temp[j]); //add each number to array 
      }
    }

    //print out land array for debugging purposes
    /*
    String output = "";
    for (int r = 0; r < R; r++){
      for (int c = 0; c < C; c++){
        output += land[r][c] + " ";
      }
      output += "\n";
    }
    System.out.println(output);
    */

    return 0;
  }

  public static int silver(String filename){
    return 0;
  }

  public static void main(String[] args) {
    try{
      System.out.println(bronze("makelake.1.in"));
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
  }

}
