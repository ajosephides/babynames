import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.jws.soap.SOAPBinding;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FileParser {

  private String pathname;
  private int popularityRank;

  FileParser() {
    pathname = "";
    popularityRank = 1;
  }

  public ArrayList<Name> getBabyNameList(String yob, UserInput user) throws IOException {

    ArrayList<Name> babyNameList = new ArrayList<>();
    findFile(yob);
    CSVParser fileContents = readFile();

    babyNameList = createBabyList(fileContents, user);
    return babyNameList;
  }

  private void findFile(String yob) {

    File directory = new File("./names/");
    File[] matches =
        directory.listFiles((dir1, name) -> name.contains(yob) && name.endsWith(".txt"));
    for (File file : matches) {
      pathname = file.getPath();
    }
  }

  private CSVParser readFile() throws IOException {

    Reader reader = Files.newBufferedReader(Paths.get(pathname));

    CSVParser babyNames =
        new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Gender", "Count"));
    return babyNames;
  }

  private ArrayList<Name> createBabyList(CSVParser fileContents, UserInput userInput)
      throws IOException {

    ArrayList<Name> babyNameList = new ArrayList<>();

    babyNameList =
        (ArrayList<Name>)
            fileContents
                .getRecords()
                .stream()
                .filter(line -> line.get("Gender").equalsIgnoreCase(userInput.getGender()))
                .map(
                    line ->
                        new Name(
                            line.get("Name"),
                            line.get("Gender"),
                            Integer.parseInt(line.get("Count"))))
                .sorted(new NameCountComparitor())
                .map(this::setPopularity)
                .collect(Collectors.toList());
    return babyNameList;
  }

  private Name setPopularity(Name babyName) {
    babyName.setPopularity(popularityRank);
    popularityRank++;
    return babyName;
  }
}
