package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.Libro;

public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext contex = new AnnotationConfigApplicationContext(AppConfig.class);
        LibroDao lDao = contex.getBean(LibroDao.class);

        Libro l = lDao.getOne(1l);
        System.out.println(l.getTitolo());

        System.out.println("numero libri: "+lDao.count());

        List<Libro> all = lDao.getData();
        for (Libro libro : all) {
            System.out.println(libro.getId()+"   "+libro.getTitolo());
        }

        Libro newl = new Libro();
        newl.setTitolo("nuovolibro");
        newl.setAnno(2022);
        newl.setPrezzo(11f);
        newl.setAutore_id(1l);

        lDao.insert(newl);
        System.out.println("numero libri: " + lDao.count());

        lDao.delete(6l);
        System.out.println("numero libri: " + lDao.count());

    }
}

// final String connectionString = "jdbc:mysql://localhost:3306/java?user=root&password=root";

// try
// {
//     Class.forName("com.mysql.cj.jdbc.Driver");
//     Connection connection = DriverManager.getConnection(connectionString);
//     Statement statement = connection.createStatement();

//     String query = "SELECT * FROM libro l JOIN autore a ON l.autore_id=a.id";
//     ResultSet resultSet = statement.executeQuery(query);
//     while (resultSet.next()) {
//         System.out.print(resultSet.getLong("id") + " ");
//         System.out.print(resultSet.getString("titolo") + "  |  ");
//         System.out.print(resultSet.getString("nome") + " ");
//         System.out.print(resultSet.getString("cognome") + "   ");
//         System.out.println(" ");
//     }

// }catch(
// SQLException e)
// {
//             System.err.println(e.getMessage());
//         }
