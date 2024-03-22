package books.controller;

import autors.entity.Autor;
import autors.model.AutorModel;
import books.entity.Book;
import books.model.BookModel;

import javax.swing.*;

public class BookController {

    public static void getAllBooks (){

        BookModel objBookModel = new BookModel();

        String listBooks = "List Books\n";

        for (Object book : objBookModel.findAll()){
            Book objBook = (Book) book;
            listBooks += objBook.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listBooks);
    }

    public static String getallBook(){

        BookModel objModel = new BookModel();

        String listBooks = "LIST BOOKS \n";

        for (Object book: objModel.findAll()){

            Book objBook = (Book) book;
            listBooks += objBook.toString()+"\n";
        }
     return listBooks;
    }

    public static String getAll(){

        AutorModel objAutorModel = new AutorModel();

        String listAutors = "AUTORS LIST\n";

        for (Object Autor:  objAutorModel.findAll()){

            autors.entity.Autor objAutor = (Autor) Autor;
            listAutors += objAutor.toString()+"\n";
        }
        return listAutors;
    }

    public static void insertBook (){

        BookModel objModel = new BookModel();

        String listAutors = getAll();

        String title = JOptionPane.showInputDialog("Insert the title by book");
        String year = JOptionPane.showInputDialog("Insert the year published (the format is 'year-month-day')");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Insert the price of book"));
        int idAutor =Integer.parseInt(JOptionPane.showInputDialog(listAutors+"\nInsert id of autor"));

        Book objBook = new Book();

        objBook.setTitle(title);
        objBook.setPrice(price);
        objBook.setYear_published(year);
        objBook.setIdAutor(idAutor);

        objBook = (Book) objModel.insert(objBook);

        JOptionPane.showMessageDialog(null,objBook.toString());



    }

    public static void deleteBooks(){

        String listBooks = getallBook();

        BookModel objModel = new BookModel();

        int isDelete = Integer.parseInt(JOptionPane.showInputDialog(listBooks+"\nInsert the id by delete\n"));

        Book objBook = objModel.findByID(isDelete);

        if (objBook == null){
            JOptionPane.showMessageDialog(null,"Book not fount");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the coder");
            if (confirm == 0){
                objModel.delete(objBook);
            }
        }

    }

    public static void updateBook(){

        BookModel objModelBook = new BookModel();

        String listBooks = getallBook();

        String listAutors = getAll();


        int isUpdate = Integer.parseInt(JOptionPane.showInputDialog(listBooks+"\nInsert the id by update\n"));

        Book objBooks = objModelBook.findByID(isUpdate);

        if (objBooks == null){
            JOptionPane.showMessageDialog(null,"The book no found");
        }else {
            String year = JOptionPane.showInputDialog("Insert the new year"+objBooks.getYear_published());
            String title = JOptionPane.showInputDialog("insert the new title"+objBooks.getTitle());
            double price = Double.parseDouble(JOptionPane.showInputDialog("Insert the new price"+objBooks.getPrice()));
            int idAutor = Integer.parseInt(JOptionPane.showInputDialog(listAutors+"Insert the id of autor"+objBooks.getIdAutor()));


            objBooks.setTitle(title);
            objBooks.setPrice(price);
            objBooks.setYear_published(year);
            objBooks.setIdAutor(idAutor);

            objModelBook.update(objBooks);
        }




    }

}
