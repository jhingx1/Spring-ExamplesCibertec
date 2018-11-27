package model.dao.impl;

import dto.Tutoriales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import model.dao.DaoTutoriales;

public class DaoTutorialesImpl implements DaoTutoriales {

    private JdbcTemplate jdbcTemplate;
    //Esto significa que se esta injectando 
    //nota : tener en cuenta la configuracion.
    public void setDataSource(DataSource ds) {//application context que es la conexion.       
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    //public List<Tutoriales> tutorialesQry(String sql,Objecto o) { se puede pasar 
    //parametros para hacerlo mas estandar la consulta
    @Override
    public List<Tutoriales> tutorialesQry() {
        String sql = "SELECT "
                + "idtutorial,"
                + "titulo,"
                + "tipo,"
                + "precio "
                + "FROM tutoriales "
                + "ORDER BY titulo";

        RowMapper mapper = new RowMapper() {//Maperio de la tabla con cada dto
            @Override
            public Object mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                Tutoriales p = new Tutoriales();
                //Mapeando
                p.setIdtutorial(rs.getInt(1));
                p.setTitulo(rs.getString(2));
                p.setTipo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));

                return p;
            }
        };
        //obteniendo una lista de los tutoriales.
        List<Tutoriales> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public String tutorialesIns(Tutoriales tutoriales) {
        String result = null;
        String sql = "INSERT INTO tutoriales(titulo, tipo, precio) "
                + "VALUES(?, ?, ?)";

        int ctos = jdbcTemplate.update(sql,
                tutoriales.getTitulo(),
                tutoriales.getTipo(),
                tutoriales.getPrecio());

        if (ctos == 0) {
            result = "0 filas afectadas";
        }

        return result;
    }

    @Override
    public String tutorialesDel(List<Object[]> ids) {
        String result = null;
        String sql = "DELETE FROM tutoriales WHERE idtutorial=?";
        // ctos 0=no eliminado y 1 = eliminado
        //solo contabiliza los 1.
        //se va eliminando uno por uno
        int[] ctos = jdbcTemplate.batchUpdate(sql, ids);//ids es un entero(object)

        if (ctos.length != ids.size()) {
            result = "Algunas filas no retiradas";
        }

        return result;
    }

    @Override
    public Tutoriales tutorialesGet(Integer idtutorial) {
        String sql = "SELECT "
                + "idtutorial,"
                + "titulo,"
                + "tipo,"
                + "precio "
                + "FROM tutoriales "
                + "WHERE idtutorial=?";

        RowMapper mapper = new RowMapper() {
            @Override
            public Tutoriales mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                Tutoriales p = new Tutoriales();
                p.setIdtutorial(rs.getInt(1));
                p.setTitulo(rs.getString(2));
                p.setTipo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));

                return p;
            }
        };

        Tutoriales tutoriales = (Tutoriales) jdbcTemplate.queryForObject(
                sql, mapper, idtutorial);

        return tutoriales;
    }

    @Override
    public String tutorialesUpd(Tutoriales tutoriales) {
        String result = null;
        String sql = "UPDATE tutoriales SET "
                + "titulo=?,"
                + "tipo=?,"
                + "precio=? "
                + "WHERE idtutorial=?";

        int ctos = jdbcTemplate.update(sql,
                tutoriales.getTitulo(),
                tutoriales.getTipo(),
                tutoriales.getPrecio(),
                tutoriales.getIdtutorial());

        if (ctos == 0) {
            result = "0 filas afectadas";
        }

        return result;
    }
}
