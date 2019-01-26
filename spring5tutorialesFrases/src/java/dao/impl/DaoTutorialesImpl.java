package dao.impl;

import dao.DaoTutoriales;
import dto.Tutoriales;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DaoTutorialesImpl implements DaoTutoriales {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final StringBuilder sql;

    public DaoTutorialesImpl() {
        this.sql = new StringBuilder();
    }

    @Override
    public List<Tutoriales> tutorialesQry() {
        List<Tutoriales> list = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idtutorial,")
                .append("titulo,")
                .append("tipo,")
                .append("precio ")
                .append("FROM tutoriales");

        RowMapper<Tutoriales> mapper = (ResultSet rs, int rowNum) -> {
            Tutoriales t = new Tutoriales();

            t.setIdtutorial(rs.getInt(1));
            t.setTitulo(rs.getString(2));
            t.setTipo(rs.getString(3));
            t.setPrecio(rs.getDouble(4));

            return t;
        };

        try {
            list = jdbcTemplate.query(sql.toString(), mapper);
        } catch (DataAccessException e) {
        }

        return list;
    }

    @Override
    public String tutorialesIns(Tutoriales tutoriales) {
        String message = null;
        sql.delete(0, sql.length())
                .append("INSERT INTO tutoriales(")
                .append("titulo,")
                .append("tipo,")
                .append("precio")
                .append(") VALUES(?,?,?)");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    tutoriales.getTitulo(),
                    tutoriales.getTipo(),
                    tutoriales.getPrecio());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String tutorialesDel(Integer[] id) {
        String message = null;
        sql.delete(0, sql.length())
                .append("DELETE FROM tutoriales WHERE idtutorial=?");

        List<Object[]> parameters = new ArrayList<>();
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
    public Tutoriales tutorialesGet(Integer idtutorial) {
        Tutoriales tutoriales = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idtutorial,")
                .append("titulo,")
                .append("tipo,")
                .append("precio ")
                .append("FROM tutoriales ")
                .append("WHERE idtutorial=?");

        RowMapper<Tutoriales> mapper = (ResultSet rs, int rowNum) -> {
            Tutoriales t = new Tutoriales();

            t.setIdtutorial(rs.getInt(1));
            t.setTitulo(rs.getString(2));
            t.setTipo(rs.getString(3));
            t.setPrecio(rs.getDouble(4));

            return t;
        };

        try {
            tutoriales = (Tutoriales) jdbcTemplate.queryForObject(
                    sql.toString(), mapper, idtutorial);

        } catch (DataAccessException e) {
        }

        return tutoriales;
    }

    @Override
    public String tutorialesUpd(Tutoriales tutoriales) {
        String message = null;
        sql.delete(0, sql.length())
                .append("UPDATE tutoriales SET ")
                .append("titulo=?,")
                .append("tipo=?,")
                .append("precio=? ")
                .append("WHERE idtutorial=?");

        try {
            int ctos = jdbcTemplate.update(sql.toString(),
                    tutoriales.getTitulo(),
                    tutoriales.getTipo(),
                    tutoriales.getPrecio(),
                    tutoriales.getIdtutorial());

            if (ctos == 0) {
                message = "0 filas afectadas";
            }
        } catch (DataAccessException e) {
            message = e.getMessage();
        }

        return message;
    }

}
