package mybatis;

import dto.Autos;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface AutosMapper {
     @Select("SELECT idauto,modelo,precioxdia,alquilado FROM autos")
    List<Autos> autosQry();

    @Insert("INSERT INTO autos(modelo,precioxdia,alquilado) "
            + "VALUES(#{modelo},#{precioxdia},#{alquilado})")
    public int autosIns(Autos autos);

    @Delete("DELETE FROM autos WHERE idauto IN(${ids})")
    public int autosDel(@Param("ids") String ids);

    @Select("SELECT idauto,modelo,precioxdia,alquilado "
            + "FROM autos WHERE idauto=#{idauto}")
    public Autos autosGet(
            @Param("idauto") Integer idauto);

    @Update("UPDATE autos SET modelo=#{modelo},"
            + "precioxdia=#{precioxdia},"
            + "alquilado=#{alquilado} "
            + "WHERE idauto=#{idauto}")
    public int autosUpd(Autos autos);
}