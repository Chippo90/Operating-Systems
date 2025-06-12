public class ExitCommand implements ShellCommand {
    @Override
    public boolean execute(String[] args, MiniShell shell) {
        System.out.println("Exiting mini shell...");
        return false; // return false to stop the shell
    }
}
