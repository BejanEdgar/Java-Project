import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingListApp {
        private ArrayList<ShoppingItem> shoppingList;

        public ShoppingListApp() {
            shoppingList = new ArrayList<>();
        }

        public void addItem(String itemName) {
            shoppingList.add(new ShoppingItem(itemName));
            System.out.println(itemName + " a fost adăugat în lista de cumpărături.");
        }

        public void removeItem(String itemName) {
            boolean found = false;
            for (ShoppingItem item : shoppingList) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    shoppingList.remove(item);
                    System.out.println(itemName + " a fost eliminat din lista de cumpărături.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Articolul " + itemName + " nu a fost găsit în lista de cumpărături.");
            }
        }

        public void markItemAsPurchased(String itemName) {
            boolean found = false;
            for (ShoppingItem item : shoppingList) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    item.setPurchased(true);
                    System.out.println(itemName + " a fost marcat ca achiziționat.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Articolul " + itemName + " nu a fost găsit în lista de cumpărături.");
            }
        }

        public void displayList() {
            System.out.println("\nLista de cumpărături:");
            for (ShoppingItem item : shoppingList) {
                System.out.println(item);
            }
            System.out.println();
        }

        public static void main(String[] args) {
            ShoppingListApp app = new ShoppingListApp();
            Scanner scanner = new Scanner(System.in);
            String command;

            System.out.println("Bine ați venit la aplicația Lista de Cumpărături!");
            System.out.println("Comenzi disponibile: adauga, elimina, marcheaza, afiseaza, iesire");

            do {
                System.out.print("Introduceți comanda: ");
                command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "adauga":
                        System.out.print("Introduceți numele articolului: ");
                        String itemToAdd = scanner.nextLine();
                        app.addItem(itemToAdd);
                        break;
                    case "elimina":
                        System.out.print("Introduceți numele articolului de eliminat: ");
                        String itemToRemove = scanner.nextLine();
                        app.removeItem(itemToRemove);
                        break;
                    case "marcheaza":
                        System.out.print("Introduceți numele articolului de marcat: ");
                        String itemToMark = scanner.nextLine();
                        app.markItemAsPurchased(itemToMark);
                        break;
                    case "afiseaza":
                        app.displayList();
                        break;
                    case "iesire":
                        System.out.println("Ieșire din aplicație. La revedere!");
                        break;
                    default:
                        System.out.println("Comandă invalidă. Încercați din nou.");
                        break;
                }
            } while (!command.equals("iesire"));

            scanner.close();
        }
    }

