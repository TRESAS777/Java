package controller;



import entity.Author;
import entity.Book;
import model.AuthorModel;
import model.BookModel;

import javax.swing.*;
import java.util.List;

public class BookController{

    BookModel objBookModel;

    public BookController() {
        this.objBookModel = new BookModel();
    }

    public void insertBook(Book author) {
        Book objBook = new Book();

        String title = JOptionPane.showInputDialog("Insert title: ");
        int yearPublication = Integer.parseInt(JOptionPane.showInputDialog("Insert year of the publication: "));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Insert price: "));
        int idAuthor = Integer.parseInt(JOptionPane.showInputDialog("Insert author: "));

        objBook.setTitle(title);
        objBook.setYearPublication(yearPublication);
        objBook.setPrice(price);
        objBook.setIdAuthor(idAuthor);

        objBook = (Book) this.objBookModel.insert(objBook);

        JOptionPane.showMessageDialog(null, objBook.toString());
    }

    public void updateBook (Book book) {
        List<Object> allBooks = objBookModel.findAll();
        if (!allBooks.isEmpty()) {
            String listBooks = getAll(allBooks);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the book to update:\n" + listBooks));
            Book objBookToUpdate = (Book) objBookModel.findById(idUpdate);
            if (objBookToUpdate == null){
                JOptionPane.showMessageDialog(null, "Not found");
            } else {
                // Mostrar la lista de autores para seleccionar el ID del autor
                List<Object> allAuthors = new AuthorModel().findAll();
                if (!allAuthors.isEmpty()) {
                    String authorList = "Available Authors:\n";
                    for (Object author : allAuthors) {
                        Author objAuthor = (Author) author;
                        authorList += objAuthor.getId() + ": " + objAuthor.getName() + "\n";
                    }
                    int idAuthor = Integer.parseInt(JOptionPane.showInputDialog("Select the ID of the author from the following list:\n" + authorList));

                    String title = JOptionPane.showInputDialog(null,"New title:", objBookToUpdate.getTitle());
                    int yearPublication = Integer.parseInt(JOptionPane.showInputDialog(null,"New year of publication:", objBookToUpdate.getYearPublication()));
                    double price = Double.parseDouble(JOptionPane.showInputDialog(null,"New price:", objBookToUpdate.getPrice()));

                    objBookToUpdate.setTitle(title);
                    objBookToUpdate.setYearPublication(yearPublication);
                    objBookToUpdate.setPrice(price);
                    objBookToUpdate.setIdAuthor(idAuthor);

                    this.objBookModel.update(objBookToUpdate);
                } else {
                    JOptionPane.showMessageDialog(null, "No authors found.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No books found.");
        }
    }

    public void deleteBook(Book book) {
        String listBookString = this.getAll(this.objBookModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listBookString + "Enter the ID of the book to delete"));
        Book objBook = (Book) this.objBookModel.findById(idDelete);
        if (objBook == null ){
            JOptionPane.showMessageDialog(null,"Book not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the book: \n" + objBook.toString());
            if (confirm == 0){
                this.objBookModel.delete(objBook);
            }
        }
    }

    public void getAll(){
        String list = this.getAll(this.objBookModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " List Books \n";
        for (Object obj : listObject ){
            Book objBook = (Book) obj;
            list += objBook.toString()+ "\n";
        }
        return list;
    }

    public Book getBookById(int id) {
        return (Book) objBookModel.findById(id);
    }

}
