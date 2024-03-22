import autors.controller.AutorController;
import books.controller.BookController;
import books.model.BookModel;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String optionAutors = "";
        String optionMenu = "";
        String optionBooks = "";

        do {
            optionMenu = JOptionPane.showInputDialog("""
                    1. Autors
                    2. Books
                    3. Exit
                    
                    Choose an option:
                    """);

            switch (optionMenu) {
                case "1":
                    optionAutors = JOptionPane.showInputDialog("""
                    1. List Autors
                    2. Insert Autors
                    3. Update Autors
                    4. Delete Autors
                    
                    
                    Choose an option:
                    """);

                    switch (optionAutors){
                        case "1":
                            AutorController.getAllAutors();
                            break;
                        case "2":
                            AutorController.createAutors();
                            break;
                        case "3":
                            AutorController.updateAutors();
                            break;
                        case "4":
                            AutorController.deleteAutor();
                            break;
                    }
                    break;
                case "2":
                    optionBooks = JOptionPane.showInputDialog("""
                            1. List Books
                            2. Insert Autors
                            3. Update Autors
                            4. Delete Autors
                            5. Exit
                            """);
                    switch (optionBooks){
                        case "1":
                            BookController.getAllBooks();
                            break;
                        case "2":
                            BookController.insertBook();
                            break;
                        case "3":
                            BookController.updateBook();
                            break;
                        case "4":
                            BookController.deleteBooks();
                            break;
                    }
                    break;
            }

        }while (!optionMenu.equals("3"));
    }
}