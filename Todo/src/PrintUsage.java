import java.util.ArrayList;
import java.util.List;

public class PrintUsage {

  public static void main(String[] args) {
    List data = new ArrayList();
    data.add("Command line Todo application");
    data.add("==============================\n");
    data.add("\t-l\tLists all arguments");
    data.add("\t-a\tAdds a new task");
    data.add("\t-r\tRemoves a task");
    data.add("\t-c\tCompletes a task");
    printUsage(data);
  }

public static List<String> printUsage (List data){
  data.add("Command line Todo application");
  data.add("==============================\n");
  data.add("\t-l\tLists all arguments");
  data.add("\t-a\tAdds a new task");
  data.add("\t-r\tRemoves a task");
  data.add("\t-c\tCompletes a task");
  System.out.println(data);
  return data;
}

}
