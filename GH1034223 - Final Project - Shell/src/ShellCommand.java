public interface ShellCommand {
    boolean execute(String[] args, MiniShell shell);
}
