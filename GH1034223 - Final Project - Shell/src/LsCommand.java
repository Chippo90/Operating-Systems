import java.io.File;

public class LsCommand implements ShellCommand {
    @Override
    public boolean execute(String[] args, MiniShell shell) {
        File[] files = shell.getCurrentDirectory().listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println((f.isDirectory() ? "[DIR] " : "      ") + f.getName());
            }
        }
        return true;
    }
}
