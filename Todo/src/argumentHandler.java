public class argumentHandler {
  private String[] arguments;

  FileHandler fileHandle = new FileHandler();
  PrintHandler printUsage = new PrintHandler();

  public argumentHandler(String [] args){
    this.arguments = args;
  }

  public void interpretArgs (){
    if (this.arguments.length == 0){
      printUsage.printUsage();
      System.exit(0);
    }
    switch (this.arguments[0]) {
      case "-l":
        list();
        break;
      case "-a":
        add();
        break;
      case "-r":
        remove();
        break;
      case "-c":
        check();
        break;
      default:
        System.out.println("Unsupported arguments");
        break;
    }
  }

  private void check() {
    fileHandle.readFile();
    fileHandle.checkTask(Integer.parseInt(arguments[1]));
  }

  private void remove() {
    fileHandle.readFile();
      if (arguments.length == 2){
        try {
          int argIndex = Integer.parseInt(arguments[1]);
          fileHandle.removeTask(argIndex);
        } catch (NumberFormatException e){
          System.out.println("Unable to remove: index is not a number");
        }
      } else if(arguments.length == 1){
        System.out.println("Unable to remove: no index provided");
      }
  }

  private void add() {
    fileHandle.readFile();
    if (this.arguments.length == 2) {
      fileHandle.writeFile(this.arguments[1]);
    }

    try {
      if (this.arguments.length == 1) {
        System.out.println("Unable to add: no task provided");
      }
    } catch (Exception e) {
      System.out.println("Exception: Unable to add: no task provided");
    }
  }

  private void list() {
    fileHandle.readFile();
    if (!fileHandle.getList().isEmpty()) {
      int count = 1;
      for (String arg : fileHandle.getList()) {
        System.out.println(count + " - " + arg);
        count++;
      }
    }
    if (fileHandle.getList().isEmpty()) {
      System.out.println("No todos for today! :)");
    }
  }
}
