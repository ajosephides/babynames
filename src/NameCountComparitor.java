import java.util.Comparator;

public class NameCountComparitor implements Comparator<Name> {
  public int compare(Name n1, Name n2) {
    if (n1.getCount() == n2.getCount()) return 0;
    else if (n1.getCount() < n2.getCount()) return 1;
    else return -1;
  }
}
