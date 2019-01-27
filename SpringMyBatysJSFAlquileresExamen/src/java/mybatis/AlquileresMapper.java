package mybatis;

import dto.Alquileres;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AlquileresMapper {

    @Select("SELECT alquileres.idalquiler,autos.modelo,"
            + "alquileres.alquiler_ini,alquileres.alquiler_fin,"
            + "alquileres.cliente,alquileres.dni "
            + "FROM alquileres INNER JOIN autos "
            + "ON alquileres.idauto=autos.idauto ")
    List<Map<Object, Object>> alquileresQry();

    @Insert("INSERT INTO alquileres(idauto,alquiler_ini,alquiler_fin,cliente,dni) "
            + "VALUES(#{idauto},#{alquiler_ini},#{alquiler_fin},#{cliente}, "
            + "#{dni})")
    public int alquileresIns(Alquileres alquileres);

    @Delete("DELETE FROM alquileres WHERE idalquiler IN(${ids})")
    public int alquileresDel(@Param("ids") String ids);

    @Select("SELECT idalquiler,idauto,alquiler_ini,alquiler_fin,cliente,dni "
            + "FROM alquileres idalquiler "
            + "WHERE idalquiler=#{idalquiler} ")
    public Alquileres alquileresGet(@Param("idalquiler") Integer idalquiler);

    @Update("UPDATE alquileres SET idauto=#{idauto},"
            + "alquiler_ini=#{alquiler_ini},alquiler_fin=#{alquiler_fin},"
            + "cliente=#{cliente},dni=#{dni} "
            + "WHERE idalquiler=#{idalquiler}")
    public int alquileresUpd(Alquileres alquileres);
}
