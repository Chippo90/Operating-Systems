import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MiniShell {
    private File currentDirectory;
    private Map<String, Object> commands;

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
            if (parts.length == 0 || parts[0].isEmpty()) continue;

            String cmd = parts[0];
            Object command = commands.get(cmd);

            if (command != null) {
                switch (cmd) {
                    case "cd":
                        ((CdCommand) command).run(parts, this);
                        break;
                    case "ls":
                        ((LsCommand) command).run(this);
                        break;
                    case "exit":
                        running = ((ExitCommand) command).run();
                        break;
                }
            } else {
                System.out.println("Unknown command: " + cmd);
            }
        }

        scanner.close();
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(File dir) {
        currentDirectory = dir;
    }

    public static void main(String[] args) {
        new MiniShell().run();
    }
}
