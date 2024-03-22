package controller;

import database.CRUD;
import entity.Author;
import model.AuthorModel;

import javax.swing.*;
import java.util.List;

public class AuthorController {
        AuthorModel objAuthorModel;

        public AuthorController() {
            this.objAuthorModel = new AuthorModel();
        }

        public void insertAuthor(Author author) {
            Author objAuthor = new Author();

            String name = JOptionPane.showInputDialog("Insert name: ");
            String nationality = JOptionPane.showInputDialog("Insert nationality: ");
            if (name != null && !name.isEmpty()) {
                objAuthor.setName(name);
                objAuthor.setNationality(nationality);

                objAuthor = (Author) this.objAuthorModel.insert(objAuthor);

                JOptionPane.showMessageDialog(null, objAuthor.toString());
                objAuthorModel.insert(objAuthor);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Name cannot be null or empty");
            }
        }

        public void updateAuthor(Author author) {
            List<Object> allAuthors = objAuthorModel.findAll();
            if (!allAuthors.isEmpty()) {
                String listAuthors = getAll(allAuthors);
                int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the author to update:\n" + listAuthors));
                Author objAuthor = (Author) objAuthorModel.findById(idUpdate);
                if (objAuthor == null){
                    JOptionPane.showMessageDialog(null, "Not found");
                } else {
                    String name = JOptionPane.showInputDialog(null,"New  name:",objAuthor.getName());
                    String clan = JOptionPane.showInputDialog(null,"New nationality:",objAuthor.getNationality());

                    objAuthor.setName(name);
                    objAuthor.setNationality(clan);
                    this.objAuthorModel.update(objAuthor);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No authors found.");
            }
        }

        public void deleteAuthor(Author author) {
            String listAuthorString = this.getAll(this.objAuthorModel.findAll());
            int confirm = 1;
            int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthorString + "Enter the ID of the author to delete"));
            Author objAuthor = (Author) this.objAuthorModel.findById(idDelete);
            if (objAuthor == null ){
                JOptionPane.showMessageDialog(null,"Author not found");
            } else {
                confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the author: \n" + objAuthor.toString());
                if (confirm == 0){
                    this.objAuthorModel.delete(objAuthor);
                }
            }
        }

        public void getAll(){
            List<Object> authors = this.objAuthorModel.findAll();
            if (!authors.isEmpty()) {
                String list = this.getAll(authors);
                JOptionPane.showMessageDialog(null, list);
            } else {
                JOptionPane.showMessageDialog(null, "No authors found.");
            }
        }

        public String getAll(List<Object> listObject){
            if (!listObject.isEmpty()) {
                String list = " List Authors \n";
                for (Object obj : listObject ){
                    Author objAuthor = (Author) obj;
                    list += objAuthor.toString()+ "\n";
                }
                return list;
            } else {
                return "No authors found.";
            }
        }

        public Author getAuthorById(int id) {
            return (Author) objAuthorModel.findById(id);
        }
}

