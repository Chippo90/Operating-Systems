import java.io.File;

public class LsCommand {
    public void run(MiniShell shell) {
        File[] files = shell.getCurrentDirectory().listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println((f.isDirectory() ? "[DIR] " : "      ") + f.getName());
            }
        }
    }
}
