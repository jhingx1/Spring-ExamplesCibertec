package model.dao.impl;

import dto.Alumnos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import model.dao.DaoAlumnos;

public class DaoAlumnosImpl implements DaoAlumnos {

    private JdbcTemplate jdbcTemplate;
    //Esto significa que se esta injectando 
    //nota : tener en cuenta la configuracion.
    public void setDataSource(DataSource ds) {//application context que es la conexion.       
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    //public List<Alumnos> alumnosQry(String sql,Objecto o) { se puede pasar 
    //parametros para hacerlo mas estandar la consulta
    @Override
    public List<Alumnos> alumnosQry() {
        String sql = "SELECT "
                + "idalumno,"
                + "nombre,"
                + "correo,"
                + "telefono "
                + "FROM alumnos "
                + "ORDER BY nombre";

        RowMapper mapper = new RowMapper() {//Maperio de la tabla con cada dto
            @Override
            public Object mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                Alumnos p = new Alumnos();
                //Mapeando
                p.setIdalumno(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));

                return p;
            }
        };
        //obteniendo una lista de los alumnos.
        List<Alumnos> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public String alumnosIns(Alumnos alumnos) {
        String result = null;
        String sql = "INSERT INTO alumnos(nombre, correo, telefono) "
                + "VALUES(?, ?, ?)";

        int ctos = jdbcTemplate.update(sql,
                alumnos.getNombre(),
                alumnos.getCorreo(),
                alumnos.getTelefono());

        if (ctos == 0) {
            result = "0 filas afectadas";
        }

        return result;
    }

    @Override
    public String alumnosDel(List<Object[]> ids) {
        String result = null;
        String sql = "DELETE FROM alumnos WHERE idalumno=?";
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
    public Alumnos alumnosGet(Integer idalumno) {
        String sql = "SELECT "
                + "idalumno,"
                + "nombre,"
                + "correo,"
                + "telefono "
                + "FROM alumnos "
                + "WHERE idalumno=?";

        RowMapper mapper = new RowMapper() {
            @Override
            public Alumnos mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                Alumnos p = new Alumnos();
                p.setIdalumno(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                
                return p;
            }
        };

        Alumnos alumnos = (Alumnos) jdbcTemplate.queryForObject(
                sql, mapper, idalumno);

        return alumnos;
    }

    @Override
    public String alumnosUpd(Alumnos alumnos) {
        String result = null;
        String sql = "UPDATE alumnos SET "
                + "nombre=?,"
                + "correo=?,"
                + "telefono=? "
                + "WHERE idalumno=?";

        int ctos = jdbcTemplate.update(sql,
                alumnos.getNombre(),
                alumnos.getCorreo(),
                alumnos.getTelefono(),
                alumnos.getIdalumno());

        if (ctos == 0) {
            result = "0 filas afectadas";
        }

        return result;
    }
}
