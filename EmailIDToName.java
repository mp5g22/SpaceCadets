import java.io.*;
import java.util.*;
import java.net.URL;

public class EmailIDToName {
  public static void main(String[] args) throws IOException {
    EmailIDToName reader = new EmailIDToName();
    reader.displayName();
  }

  public void displayName() throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an email ID:");
    String emailID = sc.nextLine();
    String webPage = "https://www.southampton.ac.uk/people/" + emailID;

    URL userURL = new URL(webPage);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(userURL.openStream()));

    for (int x = 0; x < 13; x++) {
      in.readLine();
    }
    String nameLine = in.readLine();
    in.close();

    boolean nameEnd = false;
    String name = "";
    for (int x = 35; nameEnd == false; x++){
      name = name + nameLine.charAt(x);
      if (nameLine.charAt(x+1) == '"'){
        nameEnd = true;
      }
    }
    System.out.println(name);

  }
}
