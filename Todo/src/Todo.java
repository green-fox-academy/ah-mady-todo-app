import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {

  public static void main(String[] args) throws IOException {

    if (args[0].equals("-l")){
      int count = 1;
      for (String arg: todoList()) {
        System.out.println(count + " - " + arg);
        count++;
      }
    }
  }

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

  public static List<String> todoList(){
    Path path = Paths.get("src/todo-list.txt");
    List<String> lines = new ArrayList<>();
    try{
      lines = Files.readAllLines(path);
      for (String line: lines) {
        System.out.println(line);
      }
    }catch (IOException e){
      System.out.println("File not found!");
    }
    return lines;
  }

}
