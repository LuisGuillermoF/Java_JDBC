package autors.controller;

import autors.entity.Autor;
import autors.model.AutorModel;

import javax.swing.*;

public class AutorController {

    public static void getAllAutors(){

        AutorModel objAutorModel = new AutorModel();

         String listAutors = "AUTORS LIST\n";

         for (Object Autor:  objAutorModel.findAll()){

             Autor objAutor = (Autor) Autor;
             listAutors += objAutor.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listAutors);
    }

    public static String getAll(){

        AutorModel objAutorModel = new AutorModel();

        String listAutors = "AUTORS LIST\n";

        for (Object Autor:  objAutorModel.findAll()){

            Autor objAutor = (Autor) Autor;
            listAutors += objAutor.toString()+"\n";
        }
        return listAutors;
    }

    public static void createAutors(){

        AutorModel objAutorModel = new AutorModel();

        String name = JOptionPane.showInputDialog("Insert name");
        String nationality = JOptionPane.showInputDialog("Insert nation");

        Autor objAutor = new Autor();

        objAutor.setName(name);
        objAutor.setNationality(nationality);

        objAutor = (Autor) objAutorModel.insert(objAutor);

        JOptionPane.showMessageDialog(null,objAutor.toString());

    }

    public static void deleteAutor(){

        AutorModel objAutorModel = new AutorModel();

        String listAutors = getAll();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAutors+"\n Insert id  the autor to delete\n"));

        Autor objAutor = objAutorModel.findById(idDelete);


        if (objAutor == null){
            JOptionPane.showMessageDialog(null, "Autor not found");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the coder ?\n" + objAutor.toString());
            if (confirm == 0) {
                objAutorModel.delete(objAutor);
        }
    }
}

    public static void updateAutors(){

        AutorModel objAutorModel = new AutorModel();

        String listAutor = getAll();

        int update = Integer.parseInt(JOptionPane.showInputDialog(listAutor+"\nInsert the id for edit\n"));

        Autor objAutor = objAutorModel.findById(update);

        if (objAutor == null){
            JOptionPane.showMessageDialog(null,"The autor no found");
        }else {
            System.out.println(objAutor.toString());
            String name = JOptionPane.showInputDialog(null,"insert the new name",objAutor.getName());
            String nationality = JOptionPane.showInputDialog(null,"Insert the new nationality",objAutor.getNationality());

            objAutor.setName(name);
            objAutor.setNationality(nationality);
            objAutorModel.update(objAutor);
        }
    }
}
