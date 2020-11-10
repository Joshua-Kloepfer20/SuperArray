public class Demo{
  public static void removeDuplicates(SuperArray s) {
    for (int i = 0; i < s.size(); i++) {
      for (int j = i + 1; j < s.size(); j++) {
        if (s.get(i).equals(s.get(j))) {
          s.remove(j);
          j -= 1;
        }
      }
    }
  }
  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray overlap = new SuperArray();
    for (int i = 0; i < a.size(); i++) {
      if (b.contains(a.get(i))) {
        overlap.add(a.get(i));
      }
    }
    removeDuplicates(overlap);
    return overlap;
  }
  public static SuperArray zip(SuperArray a, SuperArray b) {
    SuperArray combine = new SuperArray();
    int largeSize = 0;
    if (a.size() > b.size()) {
      largeSize = a.size();
    }
    else {
      largeSize = b.size();
    }
    for (int i = 0; i < largeSize; i++) {
      if (i < a.size()) {
        combine.add(a.get(i));
      }
      if (i < b.size()) {
        combine.add(b.get(i));
      }
    }
    return combine;
  }
  public static void main(String[]args){
    SuperArray words = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    System.out.println(words);
    SuperArray.removeDuplicates(words);
    System.out.println(words);  }
}
