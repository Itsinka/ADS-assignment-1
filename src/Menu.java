import controllers.BookController;
import entities.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final BookController controller;
    private final Scanner sc;

    public Menu(BookController controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void go(){
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get a book by id");
            System.out.println("2. Get a book by name and year");
            System.out.println("3. Create a book");
            System.out.println("4. Update a book");
            System.out.println("5. Delete a book");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = sc.nextInt();
                if (option == 1) {
                    getBookMenu();
                } else if (option == 2) {
                    getBookByNameAndYearMenu();
                } else if (option == 3) {
                    createBookMenu();
                } else if (option == 4) {
                    updateBookMenu();
                } else if (option == 5) {
                    deleteBookMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                sc.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getBookMenu() {
        System.out.println("Input the ID of the book (1, 2,3 or another number):");
        int id = sc.nextInt();
        controller.getBook(id);
    }

    public void getBookByNameAndYearMenu() {
        System.out.println("Input the book name:");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.println("Input the book year:");
        int year = sc.nextInt();
        controller.getBookByNameAndYear(bookName, year);
    }

    public void createBookMenu() {
        System.out.println("Input the book name:");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.println("Input the book author:");
        String author = sc.next();
        System.out.println("Input the book year:");
        int year = sc.nextInt();
        controller.createBook(bookName, author, year);
    }
    public void updateBookMenu() {
        System.out.println("Input the book id:");
        int id = sc.nextInt();
        System.out.println("Input the book year:");
        int year = sc.nextInt();
        controller.updateBook(id, year);
    }
    public void deleteBookMenu() {
        System.out.println("Input the book id:");
        int id = sc.nextInt();
        controller.deleteBook(id);
    }
}
