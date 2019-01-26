package mybatis;

import dto.Categorias;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CategoriasMapper {

    @Select("SELECT idcategoria,categoria FROM categorias")
    List<Categorias> categoriasQry();

    @Insert("INSERT INTO categorias(categoria) VALUES(#{categoria})")
    public int categoriasIns(Categorias categorias);

    @Delete("DELETE FROM categorias WHERE idcategoria IN(${ids})")
    public int categoriasDel(@Param("ids") String ids);

    @Select("SELECT idcategoria,categoria "
            + "FROM categorias WHERE idcategoria=#{idcategoria}")
    public Categorias categoriasGet(@Param("idcategoria") Integer idcategoria);

    @Update("UPDATE categorias SET categoria=#{categoria} "
            + "WHERE idcategoria=#{idcategoria}")
    public int categoriasUpd(Categorias categorias);
}
