import java.io.File;

public class CdCommand implements ShellCommand {
    @Override
    public boolean execute(String[] args, MiniShell shell) {
        if (args.length < 2) {
            System.out.println("Usage: cd <directory>");
            return true;
        }

        File newDir = new File(shell.getCurrentDirectory(), args[1]);
        if (newDir.exists() && newDir.isDirectory()) {
            shell.setCurrentDirectory(newDir);
        } else {
            System.out.println("Directory not found: " + args[1]);
        }
        return true;
    }
}
