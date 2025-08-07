import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String title;
    private final List<MenuOption> options = new ArrayList<>();

    public Menu(String title) {
        this.title = title;
    }

    public void addOption(String label, Runnable action) {
        options.add(new MenuOption(label, action));
    }

    public void show() {
        while (true) {
            System.out.println("\n==== " + title + " ====");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getLabel());
            }
            System.out.println("0. Exit");

            int choice = InputHandler.getInt("Select: ");

            if (choice == 0) break;

            if (choice > 0 && choice <= options.size()) {
                options.get(choice - 1).getAction().run();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
