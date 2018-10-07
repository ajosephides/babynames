import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    UserInput user = new UserInput();
    Name firstName = new Name();
    Name secondName = new Name();

    user.setUserInput();

    firstName = firstName.findNameMatch(user);
    secondName = secondName.findNameByPopularity(user, firstName);

    System.out.println(firstName.getName() + " " + firstName.getPopularity());
    System.out.println(secondName.getName() + " " + secondName.getPopularity());

    System.out.println(
        "In the year you were born you name, "
            + user.getUsername()
            + " was the "
            + firstName.findNameMatch(user).getPopularity()
            + " most popular name");
    System.out.println(
        "If you were born in your chosen second year you would be called " + secondName.getName());
  }
}
