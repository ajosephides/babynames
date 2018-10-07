import java.io.IOException;
import java.util.ArrayList;

public class Name {

  private String name;
  private String gender;
  private int count;
  private int popularity;

  Name() {}

  Name(String name, String gender, int count) {
    this.name = name;
    this.gender = gender;
    this.count = count;
    popularity = 0;
  }

  public String getName() {
    return name;
  }

  public int getPopularity() {
    return popularity;
  }

  public int getCount() {
    return count;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public Name findNameMatch(UserInput userInput) throws IOException {

    FileParser file = new FileParser();
    ArrayList<Name> babyNameList = new ArrayList<>();
    babyNameList = file.getBabyNameList(userInput.getYOB(), userInput);

    Name givenName =
        babyNameList
            .stream()
            .filter(name -> userInput.getUsername().equals(name.name))
            .findAny()
            .get();
    return givenName;
  }

  public Name findNameByPopularity(UserInput userInput, Name givenName) throws IOException {

    FileParser file = new FileParser();
    ArrayList<Name> babyNameList = new ArrayList<>();
    babyNameList = file.getBabyNameList(userInput.getSecondYOB(), userInput);

    Name babyName =
        babyNameList
            .stream()
            .filter(name -> name.popularity == givenName.popularity)
            .findAny()
            .get();
    return babyName;
  }
}
