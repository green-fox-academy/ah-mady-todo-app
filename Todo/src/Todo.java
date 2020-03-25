import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Todo {

  public static void main(String[] args) {
    printUsage();
  }

  public static void printUsage(){
    String list = "Command line Todo application\n";
    list = list.concat("=============================\n");
    list = list.concat(" \n");
    list = list.concat("\t-l\tLists all arguments\n");
    list = list.concat("\t-a\tAdds a new task\n");
    list = list.concat("\t-r\tRemoves a task\n");
    list = list.concat("\t-c\tCompletes a task\n");
    System.out.println(list);
  }

}
