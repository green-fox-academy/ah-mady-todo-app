import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class todo {

  public static void main(String[] args) throws Exception {

    argumentHandler argument = new argumentHandler(args);

    argument.interpretArgs();

  }
}
