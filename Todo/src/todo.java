import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class todo {

  public static void main(String[] args) throws IOException {

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

   /* if (args[0].equals("-a") && !args[1].isEmpty()) {
      todoList().add(args[1]);
    }*/

    if (args[0].equals("-a") && !args[1].isEmpty()) {
      writeFile(args[1]);
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

  //reads file
  public static List<String> todoList() {
    Path path = Paths.get("src/todo-list.txt");
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.out.println("File not found!");
    }
    return lines;
  }

  public static void writeFile(String arg){
    try{
      todoList();
      todoList().add(arg);
    }catch (Exception e){
      System.out.println("Something went wrong!");
    }
  }

}
