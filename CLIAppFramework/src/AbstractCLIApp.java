public abstract class AbstractCLIApp implements CLIApp {
    private final Menu menu;

    public AbstractCLIApp() {
        this.menu = new Menu(getAppName());
        setupMenu(menu);
    }

    @Override
    public void run() {
        System.out.println("=== Welcome to " + getAppName() + " ===");
        menu.show();
        System.out.println("Thank you for using " + getAppName() + "!");
    }

    protected abstract void setupMenu(Menu menu);
}
