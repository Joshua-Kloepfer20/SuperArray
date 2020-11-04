public class SuperArray {
  private String[] data;
  private int size; //The current size

  public SuperArray() {
    data = new String[10];
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
    return data[index];
  }
  public String set(int index, String element) {
    String previous = data[index];
    data[index] = element;
    return previous;
  }
  private void resize() {
    String[] data2 = new String[size + 1];
    for (int i = 0; i < size; i++) {
      data2[i] = data[i];
    }
    data = data2;
  }
}
