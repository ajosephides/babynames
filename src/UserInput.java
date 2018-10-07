import java.awt.*;
import java.util.Scanner;

public class UserInput {

  private String username;
  private String yOB;
  private String secondYOB;
  private String gender;

  UserInput() {

    username = "";
    yOB = "";
    secondYOB = "";
    gender = "";
  }

  public String getUsername() {

    return username;
  }

  public String getGender() {
    return gender;
  }

  public String getYOB() {
    return yOB;
  }

  public String getSecondYOB() {

    return secondYOB;
  }

  public void setUserInput() {

    Scanner userInput = new Scanner(System.in);

    System.out.println("Please enter your first name:");
    this.username = userInput.nextLine();

    System.out.println("Please enter your gender. M or F:");
    this.gender = userInput.nextLine();

    System.out.println("Please enter your year of birth:");
    this.yOB = userInput.nextLine();

    System.out.println("Please enter the year you are interested in:");
    this.secondYOB = userInput.nextLine();
  }
}
