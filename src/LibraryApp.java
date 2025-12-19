import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    printAllBooks();
                    break;
                case "2":
                    addNewBook();
                    break;
                case "3":
                    searchBooksByTitle();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    deleteBookById();
                    break;
                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    private void addNewBook() {
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            Book newBook = new Book(title, author, year);
            books.add(newBook);
            System.out.println("Book added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for year.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooksByTitle() {
        System.out.print("Enter title part to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }

    private void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(id);
            if (book != null) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                    System.out.println("You borrowed the book: " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed.");
                }
            } else {
                System.out.println("Book not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }
    }

    private void returnBook() {
        System.out.print("Enter book ID to return: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(id);
            if (book != null && !book.isAvailable()) {
                book.markAsReturned();
                System.out.println("Book returned successfully.");
            } else if (book != null && book.isAvailable()) {
                System.out.println("This book is already in the library.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }
    }

    private void deleteBookById() {
        System.out.print("Enter book ID to delete: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book bookToRemove = findBookById(id);
            if (bookToRemove != null) {
                books.remove(bookToRemove);
                System.out.println("Book deleted.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        new LibraryApp().run();
    }
}