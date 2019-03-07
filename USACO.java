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

    return calcWater(land, E) * 72 * 72; //returns depth of water times area of square
  }

  public static void stomp(int[][] land, int row, int col, int delta){
    int max = land[row][col];
    for (int i = 0; i < 3; i++){ //loops through 3 by 3 area
      for (int j = 0; j < 3; j++){
        if (land[row + i][col + j] > max) max = land[row + i][col + j]; //find max of the stomping area
      }
    }
    max -= delta; //adjusts elevation according to command

    for (int i = 0; i < 3; i++){ //loops through 3 by 3 area
      for (int j = 0; j < 3; j++){
        if (land[row + i][col + j] > max) land[row + i][col + j] = max; //stomps down land
      }
    }
  }

  public static int calcWater(int[][] land, int elevation){
    int output = 0;
    for (int i = 0; i < land.length; i++){ //loops through entire array
      for (int j = 0; j < land[0].length; j++){
        if (land[i][j] > elevation) land[i][j] = 0; //if higher than water level, no water is present
        else {
          land[i][j] = elevation - land[i][j]; //if lower than water level, calculate depth
          output += land[i][j]; //add to output
        }
      }
    }
    return output;
  }

  //auxiliary function used to return output of bronze
  public static int bronze_output(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner info = new Scanner(f);
    return Integer.parseInt(info.nextLine());
  }

  public static int silver(String filename) throws FileNotFoundException{
    File f = new File(filename); //reads in file
    Scanner info = new Scanner(f);

    String[] firstline = info.nextLine().split(" "); //splits first line
    int R = Integer.parseInt(firstline[0]); //records row
    int C = Integer.parseInt(firstline[1]); //records col
    int T = Integer.parseInt(firstline[2]); //records time in seconds

    int[][] land = new int[R][C]; //initializes new array
    for (int i = 0; i < R; i++){ //loops through array
      String temp = info.nextLine(); //reads in next line
      for (int j = 0; j < C; j++){
        if (temp.charAt(j) == '*') land[i][j] = -1; //adds in information from file into array
        //trees are denoted by -1
      }
    }

    String[] lastline = info.nextLine().split(" "); //splits lastline
    int R1 = Integer.parseInt(lastline[0]); //records R1
    int C1 = Integer.parseInt(lastline[1]); //records C1
    int R2 = Integer.parseInt(lastline[2]); //records R2
    int C2 = Integer.parseInt(lastline[3]); //records C2

    fillboard(land, T, R1 - 1, C1 - 1);

    //print statement or debugging purposes
    String output = "";
    for (int r = 0; r < R; r++){
      for (int c = 0; c < C; c++){
        if (land[r][c] == -1) output += "* ";
        else output += land[r][c] + " ";
      }
      output += "\n";
    }
    System.out.println(output);

    return land[R2 - 1][C2 - 1];
  }

  //helper function used to calculate the number of ways each square can be reached given a certain number of moves
  public static void fillboard(int[][] land, int T, int R1, int C1){
    land[R1][C1]++;
    if (T > 0){
      land[R1][C1] = 0; //spot you are at changes to 0
      if (!outOfBounds(land, R1 + 1, C1)) fillboard(land, T - 1, R1 + 1, C1); //check for valid move to the right
      if (!outOfBounds(land, R1 - 1, C1)) fillboard(land, T - 1, R1 - 1, C1); //check for valid move to the left
      if (!outOfBounds(land, R1, C1 + 1)) fillboard(land, T - 1, R1, C1 + 1); //check for valid move up
      if (!outOfBounds(land, R1, C1 - 1)) fillboard(land, T - 1, R1, C1 - 1); //check for valid move down
    }
  }

  public static boolean outOfBounds(int[][] land, int row, int col){
    return row < 0 || row >= land.length || col < 0 || col >= land[0].length || land[row][col] == -1; //check if out of bounds of if tree present
  }

  //auxiliary function used to return output of silver
  public static int silver_output(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner info = new Scanner(f);
    return Integer.parseInt(info.nextLine());
  }

  public static void main(String[] args) {
    try{
      System.out.println("----------Bronze-----------");
      for (int i = 1; i < 6; i++){
        int input = bronze("makelake." + i + ".in");
        //System.out.println(input);
        int output = bronze_output("makelake." + i + ".out");
        if (input == output) System.out.println("Test " + i + ": PASSED");
        else System.out.println("Test " + i + ": FAILED");
      }
      System.out.println();
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }

    try{
      System.out.println("----------Silver-----------");
      for (int i = 1; i < 6; i++){
        int input = silver("ctravel." + i + ".in");
        //System.out.println(input);
        int output = silver_output("ctravel." + i + ".out");
        //System.out.println(output);
        if (input == output) System.out.println("Test " + i + ": PASSED");
        else System.out.println("Test " + i + ": FAILED");
      }
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
  }

}
