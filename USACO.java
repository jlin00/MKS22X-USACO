import java.io.*;
import java.util.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
    File f = new File(filename); //reads in file
    Scanner info = new Scanner(f);

    String[] firstline = info.nextLine().split(" "); //split the first line and store values
    int R = Integer.parseInt(firstline[0]); //stores row
    int C = Integer.parseInt(firstline[1]); //stores col
    int E = Integer.parseInt(firstline[2]); //stores elevation

    int[][] land = new int[R][C]; //initialize array for land
    for (int i = 0; i < R; i++){
      String[] temp = info.nextLine().split(" ");
      for (int j = 0; j < C; j++){
        land[i][j] = Integer.parseInt(temp[j]); //add each number to array
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

    while (info.hasNextLine()){
      String[] temp = info.nextLine().split(" ");
      stomp(land, Integer.parseInt(temp[0]) - 1, Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[2])); //calls helper function to stomp land according to commands
    }

    return 0;
  }

  public static void stomp(int[][] land, int row, int col, int delta){

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
