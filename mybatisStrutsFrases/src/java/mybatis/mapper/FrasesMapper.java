package mybatis.mapper;

import dto.Frases;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FrasesMapper {

    @Select("SELECT idfrase,autor,frase "
            + "FROM frases INNER JOIN autores "
            + "ON frases.idautor=autores.idautor")
    public List<Map<Object,Object>> frasesQry();

    @Insert("INSERT INTO frases(idautor,frase) "
            + "VALUES(#{idautor},#{frase})")
    public int frasesIns(Frases frases);

    @Delete("DELETE FROM frases WHERE idfrase IN(${ids})")
    public int frasesDel(@Param("ids") String ids);

    @Select("SELECT idfrase,idautor,frase FROM frases "
            + "WHERE idfrase=#{idfrase}")
    public Frases frasesGet(@Param("idfrase") Integer idfrase);

    @Update("UPDATE frases SET "
            + "idautor=#{idautor},frase=#{frase} "
            + "WHERE idfrase=#{idfrase}")
    public int frasesUpd(Frases frases);
}

