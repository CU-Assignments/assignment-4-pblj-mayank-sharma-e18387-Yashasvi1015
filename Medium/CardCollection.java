import java.util.ArrayList;
import java.util.Scanner;

class Card {
    String symbol;
    String rank;

    Card(String symbol, String rank) {
        this.symbol = symbol;
        this.rank = rank;
    }
}

public class CardCollection {
    private static ArrayList<Card> cards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    searchBySymbol();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Symbol (Hearts, Diamonds, etc.): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Rank (Ace, 2, King, etc.): ");
        String rank = scanner.nextLine();
        cards.add(new Card(symbol, rank));
        System.out.println("Card added successfully!");
    }

    private static void searchBySymbol() {
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();
        for (Card card : cards) {
            if (card.symbol.equals(symbol)) {
                System.out.println("Symbol: " + card.symbol + ", Rank: " + card.rank);
            }
        }
    }

    private static void displayAllCards() {
        for (Card card : cards) {
            System.out.println("Symbol: " + card.symbol + ", Rank: " + card.rank);
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting program...");
        System.exit(0); // Terminates the program
    }
}
