package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.model.Libro;

@Component
public class LibroDao implements Dao<Libro>{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM libro", Integer.class);
    }

    @Override
    public Libro getOne(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM libro WHERE id=?",
            new BeanPropertyRowMapper<Libro>(Libro.class),
            id
        );
    }

    @Override
    public List<Libro> getData() {
        return jdbcTemplate.query("SELECT * FROM libro", new BeanPropertyRowMapper<Libro>(Libro.class));
    }

    @Override
    public boolean insert(Libro model) {
        int res =  jdbcTemplate.update(
            "INSERT INTO libro(titolo, anno, prezzo, autore_id) VALUE(?, ?, ?, ?) ",
            model.getTitolo(), model.getAnno(), model.getPrezzo(), model.getAutore_id()
        );
        return res>0;
    }

    @Override
    public boolean update(Long id, Libro model) {
        int res = jdbcTemplate.update(
            "UPDATE libro SET titolo=?, anno=?, prezzo=?, autore_id=? WHERE id=?",
            model.getTitolo(), model.getAnno(), model.getPrezzo(), model.getAutore_id(),
            id
        );
        return res > 0;
    }

    @Override
    public boolean delete(Long id) {
        int res = jdbcTemplate.update("DELETE FROM libro WHERE id=?", id);
        return res>0;
    }    
}
