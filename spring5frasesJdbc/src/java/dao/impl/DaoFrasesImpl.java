package dao.impl;

import dao.DaoFrases;
import domain.Frases;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DaoFrasesImpl implements DaoFrases {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final StringBuilder sql;

    public DaoFrasesImpl() {
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> frasesQry() {
        List<Object[]> list = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("frases.idfrase,")
                .append("autores.autor,")
                .append("frases.frase ")
                .append("FROM frases ")
                .append("INNER JOIN autores ")
                .append("ON frases.idautor=autores.idautor ")
                .append("ORDER BY autores.autor");

        RowMapper<Object[]> mapper = (ResultSet rs, int rowNum) -> {
            Object[] reg = new Object[3];

            reg[0] = rs.getInt(1);
            reg[1] = rs.getString(2);
            reg[2] = rs.getString(3);

            return reg;
        };

        try {
            list = jdbcTemplate.query(sql.toString(), mapper);

        } catch (DataAccessException e) {
            
        }

        return list;
    }

    @Override
    public String frasesIns(Frases frases) {
        String message = null;
        sql.delete(0, sql.length())
                .append("INSERT INTO frases(")
                .append("idautor,")
                .append("frase ")
                .append(") VALUES(?,?)");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    frases.getIdautor(),
                    frases.getFrase());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String frasesDel(Integer[] id) {
        String message = null;
        sql.delete(0, sql.length())
                .append("DELETE FROM frases WHERE idfrase=?");

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
    public Frases frasesGet(Integer idfrase) {
        Frases frases = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idfrase,")
                .append("idautor,")
                .append("frase ")
                .append("FROM frases ")
                .append("WHERE idfrase=?");

        RowMapper<Frases> mapper = (ResultSet rs, int rowNum) -> {
            Frases f = new Frases();

            f.setIdfrase(rs.getInt(1));
            f.setIdautor(rs.getInt(2));
            f.setFrase(rs.getString(3));

            return f;
        };

        try {
            frases = (Frases) jdbcTemplate.queryForObject(
                    sql.toString(), mapper, idfrase);

        } catch (DataAccessException e) {
        }

        return frases;
    }

    @Override
    public String frasesUpd(Frases frases) {
        String message = null;
        sql.delete(0, sql.length())
                .append("UPDATE frases SET ")
                .append("idautor=?,")
                .append("frase=? ")
                .append("WHERE idfrase=?");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    frases.getIdautor(),
                    frases.getFrase(),
                    frases.getIdfrase());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

}
