package dao.impl;

import domain.Autores;
import java.util.List;
import dao.DaoAutores;
import java.sql.ResultSet;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DaoAutoresImpl implements DaoAutores{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final StringBuilder sql;

    public DaoAutoresImpl() {
        this.sql = new StringBuilder();
    }

    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idautor,")
                .append("autor ")
                .append("FROM autores");

        RowMapper<Autores> mapper = (ResultSet rs, int rowNum) -> {
            Autores a = new Autores();

            a.setIdautor(rs.getInt(1));
            a.setAutor(rs.getString(2));

            return a;
        };

        try {
            list = jdbcTemplate.query(sql.toString(), mapper);
        } catch (DataAccessException e) {
        }

        return list;
    }

    @Override
    public String autoresIns(Autores autores) {
        String message = null;
        sql.delete(0, sql.length())
                .append("INSERT INTO autores(")
                .append("autor")
                .append(") VALUES(?)");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    autores.getAutor());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = "este autor ya está registrado";
        }

        return message;
    }

    @Override
    public String autoresDel(Integer[] id) {
        String message = null;
        sql.delete(0, sql.length())
                .append("DELETE FROM autores WHERE idautor=?");

        List<Object[]> parameters = new LinkedList<>();
        for (Integer x : id) {
            parameters.add(new Object[]{x});
        }

        try {
            int[] ctos = jdbcTemplate.batchUpdate(sql.toString(), parameters);

            for (int i = 0; i < ctos.length; i++) {
                if (ctos[i] == 0) {
                    message = "Alguna(s) fila(s) no afectada(s).";
                    break;
                }
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Autores autoresGet(Integer idautor) {
        Autores autores = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idautor,")
                .append("autor ")
                .append("FROM autores ")
                .append("WHERE idautor=?");

        RowMapper<Autores> mapper = (ResultSet rs, int rowNum) -> {
            Autores a = new Autores();

            a.setIdautor(rs.getInt(1));
            a.setAutor(rs.getString(2));

            return a;
        };

        try {
            autores = (Autores) jdbcTemplate.queryForObject(
                    sql.toString(), mapper, idautor);

        } catch (DataAccessException e) {
        }

        return autores;
    }

    @Override
    public String autoresUpd(Autores autores) {
        String message = null;
        sql.delete(0, sql.length())
                .append("UPDATE autores SET ")
                .append("autor=? ")
                .append("WHERE idautor=?");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    autores.getAutor(),
                    autores.getIdautor());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public List<Object[]> autoresCbo() {
        List<Object[]> list = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idautor,")
                .append("autor ")
                .append("FROM autores");

        RowMapper<Object[]> mapper = (ResultSet rs, int rowNum) -> {
            Object[] reg = new Object[2];

            reg[0] = rs.getInt(1);
            reg[1] = rs.getString(2);

            return reg;
        };

        try {
            list = jdbcTemplate.query(sql.toString(), mapper);
        } catch (DataAccessException e) {
        }

        return list;
    }
    
}
