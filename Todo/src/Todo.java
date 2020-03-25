import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Todo {

  public static void main(String[] args) {

    int counter = 1;
    for (String arg : args) {
      System.out.println(counter + arg);
      counter++;
    }
    HashMap<String, String> printUsage = new HashMap<>();

    printUsage.put("-l","List all the tasks");
    printUsage.put("-a","Adds anew task");
    printUsage.put("-r","Removes a task");
    printUsage.put("-c","Completes a task");

    System.out.println(printUsage);


  /*List <String> data = new ArrayList<>();
    data.add("Command line Todo application\n");
    data.add("==============================\n");
    System.out.println();
    data.add("Command line arguments\n");
    data.add("\t-l\tLists all arguments\n");
    data.add("\t-a\tAdds a new task\n");
    data.add("\t-r\tRemoves a task\n");
    data.add("\t-c\tCompletes a task\n");
    System.out.println(data.toString());*/


  }

}
