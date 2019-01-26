package mybatis;

import dto.Distritos;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DistritosMapper {

    @Select("SELECT iddistrito,distrito FROM distritos")
    List<Distritos> distritosCbo();

    @Select("SELECT iddistrito,distrito "
            + "FROM distritos WHERE iddistrito=#{iddistrito}")
    public Distritos categoriasGet(
            @Param("iddistrito") Integer iddistrito);
}
