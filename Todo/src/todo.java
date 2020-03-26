import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class todo {

  public static void main(String[] args) throws IOException {

    try {
      if (args.length < 1) {
        printUsage();
      }
    } catch (ArrayIndexOutOfBoundsException e){
     // e.printStackTrace();
      System.out.println(" ");
    }

    if (args[0].equals("-l")) {
      int count = 1;
      for (String arg : todoList()) {
        System.out.println(count + " - " + arg);
        count++;
      }
    }

    if (args[0].equals("-l") && todoList().isEmpty()) {
      System.out.println("No todos for today! :)");
    }


    if (args[0].equals("-a") && args.length == 2) {
      writeFile(args[1]);
    }

    try {
      if (args[0].equals("-a") && args.length == 1) {
        System.out.println("Unable to add: no task provided");
      }
    } catch (Exception e) {
      System.out.println("Exception: Unable to add: no task provided");
    }


    if (args[0].equals("-r") && args.length == 2) {
      int argIndex = Integer.parseInt(args[1]);
      removeTask(argIndex);
    }

    if (args[0].equals("-r") && args.length == 1){
      System.out.println("Unable to remove: no index provided");
    }


  }

  //prints the usage
  public static void printUsage() {
    String list = "Command line Todo application\n";
    list = list.concat("=============================\n");
    list = list.concat(" \n");
    list = list.concat("\t-l\tLists all arguments\n");
    list = list.concat("\t-a\tAdds a new task\n");
    list = list.concat("\t-r\tRemoves a task\n");
    list = list.concat("\t-c\tCompletes a task\n");
    System.out.println(list);
  }

  //path of the file
  public static Path path() {
    Path path = Paths.get("src/todo-list.txt");
    return path;
  }

  //reads file
  public static List<String> todoList() {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path());
    } catch (IOException e) {
      System.out.println("File not found!");
    }
    return lines;
  }

  //write the file
  public static void writeFile(String arg) {
    try {
      List<String> word = todoList();
      todoList().add(arg);
      word.add(arg);
      Files.write(path(), word);
    } catch (IOException e) {
      System.out.println("Something went wrong!");
    }
  }

  public static void removeTask(int arg) {
    List<String> task = todoList();
    int count = 0;
    List <String> lines = todoList();
    for (String line: lines) {
      count ++;
    }
    if (arg <= count){
      task.remove(arg);
    }else{
      System.out.println("Unable to remove: index is out of bound");
    }
    try {
      Files.write(path(), task);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("couldn't remove");
    }
  }
}
