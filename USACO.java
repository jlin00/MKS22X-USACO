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

    String[] firstline = lines.get(0).split(" ");
    int R = Integer.parseInt(firstline[0]);
    int C = Integer.parseInt(firstline[1]);
    int E = Integer.parseInt(firstline[2]);
    int N = Integer.parseInt(firstline[3]);

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
