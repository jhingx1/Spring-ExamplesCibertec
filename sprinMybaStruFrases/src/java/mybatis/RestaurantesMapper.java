package mybatis;

import dto.Restaurantes;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RestaurantesMapper {

    @Select("SELECT restaurantes.idrestaurante,categorias.categoria,"
            + "restaurantes.restaurante,restaurantes.direccion,"
            + "distritos.distrito "
            + "FROM restaurantes INNER JOIN categorias "
            + "ON restaurantes.idcategoria=categorias.idcategoria "
            + "INNER JOIN distritos "
            + "ON restaurantes.iddistrito=distritos.iddistrito")
    List<Map<Object,Object>> restaurantesQry();

    @Insert("INSERT INTO restaurantes(idcategoria,restaurante,"
            + "direccion,iddistrito) "
            + "VALUES(#{idcategoria}, #{restaurante}, "
            + "#{direccion}, #{iddistrito})")
    public int restaurantesIns(Restaurantes restaurantes);

    @Delete("DELETE FROM restaurantes WHERE idrestaurante IN(${ids})")
    public int restaurantesDel(@Param("ids") String ids);

    @Select("SELECT idrestaurante,idcategoria,restaurante,direccion,iddistrito "
            + "FROM restaurantes idrestaurante WHERE idrestaurante=#{idrestaurante}")
    public Restaurantes restaurantesGet(@Param("idrestaurante") Integer idrestaurante);

    @Update("UPDATE restaurantes SET idcategoria=#{idcategoria},"
            + "restaurante=#{restaurante},direccion=#{direccion},"
            + "iddistrito=#{iddistrito} "
            + "WHERE idrestaurante=#{idrestaurante}")
    public int restaurantesUpd(Restaurantes restaurantes);
}
