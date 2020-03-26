import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

  private List <String> list;

  public List<String> getList() {
    return list;
  }

  public FileHandler() {
    this.list = new ArrayList<>();
  }

  //path of the file
  public Path path() {
    Path path = Paths.get("src/todo-list.txt");
    return path;
  }

  //reads file
  public void readFile() {
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path());
      this.list = lines;
    } catch (IOException e) {
      System.out.println("File not found!");
    }
  }

  //write the file
  public void writeFile(String arg) {
    try {
      List<String> word = this.list;
      //todoList().add(arg);
      word.add(arg);
      Files.write(path(), word);
    } catch (IOException e) {
      System.out.println("Something went wrong!");
    }
  }

  public void removeTask(int arg) {
    int count = 0;
    List<String> lines = this.list;
    for (String line : lines) {
      count++;
    }
    try {
      if (arg <= count) {
        lines.remove(arg);
      } else {
        System.out.println("Unable to remove: index is out of bound");
      }
      Files.write(path(), lines);
    } catch (NumberFormatException e) {
      System.out.println("Exception : Unable to remove: index is not a number");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("couldn't remove");
    }
  }

  public void checkTask(int index){
    System.out.println(this.list.get(index-1));
  }
}
