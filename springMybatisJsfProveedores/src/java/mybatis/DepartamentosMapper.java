package mybatis;

import dto.Departamentos;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DepartamentosMapper {

    @Select("SELECT iddepartamento,departamento FROM departamentos")
    List<Departamentos> departamentosCbo();

    @Select("SELECT iddepartamento,departamento "
            + "FROM departamentos WHERE iddepartamento=#{iddepartamento}")
    public Departamentos categoriasGet(
            @Param("iddepartamento") Integer iddepartamento);
}

