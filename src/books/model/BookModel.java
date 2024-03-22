package books.model;

import books.entity.Book;
import database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookModel {

    public List<Object> findAll(){

        Connection objConnection = ConfigDB.openConection();

        List<Object> listBooks = new ArrayList<>();

        try{

            String sql = "SELECT * FROM books;";

            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objprepare.executeQuery();

            while (objResult.next()){
                Book objBook = new Book();

                objBook.setTitle(objResult.getString("title"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setId(objResult.getInt("id"));
                objBook.setYear_published(objResult.getString("year_published"));
                objBook.setIdAutor(objResult.getInt("fk_idAutor"));

                listBooks.add(objBook);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }

        return listBooks;
    }


    public Object insert(Object obj){

        Connection objConnection = ConfigDB.openConection();

        Book objBook = (Book) obj;

        try{

            String sql = "INSERT INTO books (title,year_published,price,fk_idAutor) VALUES (?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objBook.getTitle());
            objPrepare.setString(2,objBook.getYear_published());
            objPrepare.setDouble(3,objBook.getPrice());
            objPrepare.setInt(4,objBook.getIdAutor());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objBook.setId(objResult.getInt(1));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }

        return objBook;
    }

    public boolean delete(Object obj){

        Connection objConnection = ConfigDB.openConection();

        Book objBook = (Book) obj;



        try{

            String sql = "DELETE FROM books WHERE id =?;";

            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            objPrepared.setInt(1,objBook.getId());

            int totalRowsAfected = objPrepared.executeUpdate();

            if (totalRowsAfected > 0){
                JOptionPane.showMessageDialog(null,"The update was successful");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        }finally {
            ConfigDB.closeConnection();
        }

        return true;
    }

    public Book findByID(int id){

        Connection objConnection = ConfigDB.openConection();

        Book objBooks = new Book();

        try{

            String slq = "SELECT * FROM books WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(slq);

            objPrepare.setInt(1,id);

            ResultSet objResult = objPrepare.executeQuery();

            if (objResult.next()){

                objBooks.setId(objResult.getInt("id"));
                objBooks.setTitle(objResult.getString("title"));
                objBooks.setPrice(objResult.getDouble("price"));
                objBooks.setYear_published(objResult.getString("year_published"));
                objBooks.setIdAutor(objResult.getInt("fk_idAutor"));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return objBooks;
    }

    public boolean update(Object obj){

        Connection objConnection = ConfigDB.openConection();

        Book objBook = (Book) obj;

        try{

            String sql = "UPDATE books SET title =?, price=?,year_published=? WHERE id =?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objBook.getTitle());
            objPrepare.setDouble(2,objBook.getPrice());
            objPrepare.setString(3,objBook.getYear_published());
            objPrepare.setInt(4,objBook.getId());

            int totalRowsAfected = objPrepare.executeUpdate();

            if (totalRowsAfected > 0){
                JOptionPane.showMessageDialog(null,"The update was successful");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        }

        return true;
    }

}
