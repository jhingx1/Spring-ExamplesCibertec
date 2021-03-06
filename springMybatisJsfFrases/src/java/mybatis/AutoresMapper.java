package mybatis;

import dto.Autores;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AutoresMapper {

    @Select("SELECT idautor,autor FROM autores")
    List<Autores> autoresQry();

    @Insert("INSERT INTO autores(autor) VALUES(#{autor})")
    public int autoresIns(Autores autores);

    @Delete("DELETE FROM autores WHERE idautor IN(${ids})")
    public int autoresDel(@Param("ids") String ids);

    @Select("SELECT idautor,autor "
            + "FROM autores WHERE idautor=#{idautor}")
    public Autores autoresGet(
            @Param("idautor") Integer idautor);

    @Update("UPDATE autores SET autor=#{autor} "
            + "WHERE idautor=#{idautor}")
    public int autoresUpd(Autores autores);
}


