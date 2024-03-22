import controller.AuthorController;
import controller.BookController;
import entity.Author;
import entity.Book;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();

        while (true) {
            String[] options = {"Author", "Book", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    authorMenu(authorController);
                    break;
                case 1:
                    bookMenu(bookController);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Exiting program...");
                    return;
            }
        }
    }

    private static void authorMenu(AuthorController authorController) {
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Author Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                authorController.insertAuthor(new Author());
                break;
            case 1:
                authorController.updateAuthor(new Author());
                break;
            case 2:
                authorController.deleteAuthor(new Author());
                break;
            case 3:
                authorController.getAll();
                break;
            case 4:
                break;
        }
    }

    private static void bookMenu(BookController bookController) {
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Book Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                bookController.insertBook(new Book());
                break;
            case 1:
                bookController.updateBook(new Book());
                break;
            case 2:
                bookController.deleteBook(new Book());
                break;
            case 3:
                bookController.getAll();
                break;
            case 4:
                break;
        }
    }

    }
