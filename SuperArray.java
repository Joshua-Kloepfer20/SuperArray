public class SuperArray {
  private String[] data;
  private int size; //The current size

  public SuperArray() {
    data = new String[10];
    size = 0;
  }
  public SuperArray(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("initialCapacity " + initialCapacity + " cannot be negative");
    }
    data = new String[initialCapacity];
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean add(String element) {
    if (data.length > size) {
      data[size] = element;
    }
    else {
      resize();
      data[size] = element;
    }
    size += 1;

    return true;
  }
  public String get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Cant get index " + index);
    }
    return data[index];
  }
  public String set(int index, String element) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Cannot set index " + index + "to " + element);
    }
    String previous = data[index];
    data[index] = element;
    return previous;
  }
  private void resize() {
    double x = .5 * size;
    String[] data2 = new String[size * (int)x];
    for (int i = 0; i < size; i++) {
      data2[i] = data[i];
    }
    data = data2;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public void clear() {
    String[] data2 = new String[data.length];
    data = data2;
    size = 0;
  }
  public String toString() {
    if (size == 0) {
      return "[]";
    }
    String returnString = "[";
    for (int i = 0; i < size; i++) {
      returnString = returnString + data[i] + ", ";
    }
    returnString = returnString.substring(0, returnString.length() - 2) + "]";
    return returnString;
  }
  public boolean contains(String s) {
    for (int i = 0; i < size; i++) {
      if (data[i] == s) {
        return true;
      }
    }
    return false;
  }
  public void add(int index, String element) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Cannot add element " + element + "to index " + index);
    }
    if (data.length == size) {
      resize();
    }
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = element;
    size += 1;
  }
  public String remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Cannot remove index " + index);
    }
    String previous = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size -= 1;
    return previous;
  }
  public int indexOf(String s) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(s)) {
        return i;
      }
    }
    return -1;
  }
  public String[] toArray() {
    String[] data2 = new String[size];
    for (int i = 0; i < data2.length; i++) {
      data2[i] = data[i];
    }
    return data2;
  }
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
  public int lastIndexOf(String value) {
    for (int i = size - 1; i >= 0; i--) {
      if (data[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }
  public boolean equals(SuperArray other) {
    if (this.size() != other.size()) {
      return false;
    }
    for (int i = 0; i < other.size(); i++) {
      if (!this.get(i).equals(other.get(i))) {
        return false;
      }
    }
    return true;
  }
}
