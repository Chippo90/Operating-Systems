import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MiniShell {
    private File currentDirectory;
    private Map<String, ShellCommand> commands;

    public MiniShell() {
        currentDirectory = new File(System.getProperty("user.dir"));
        commands = new HashMap<>();
        commands.put("cd", new CdCommand());
        commands.put("ls", new LsCommand());
        commands.put("exit", new ExitCommand());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print(currentDirectory.getAbsolutePath() + " $ ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");
            if (parts.length == 0) continue;

            ShellCommand command = commands.get(parts[0]);
            if (command != null) {
                running = command.execute(parts, this);
            } else {
                System.out.println("Unknown command: " + parts[0]);
            }
        }
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(File dir) {
        this.currentDirectory = dir;
    }

    public static void main(String[] args) {
        new MiniShell().run();
    }
}
