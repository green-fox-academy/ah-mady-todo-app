public class Todo {

  public static void main(String[] args) {

    int counter = 1;
    for (String arg:args) {
      System.out.println(counter + arg);
      counter++;
    }
  }
}
