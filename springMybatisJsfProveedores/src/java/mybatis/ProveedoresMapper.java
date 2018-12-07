package mybatis;

import dto.Proveedores;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProveedoresMapper {

    @Select("SELECT proveedores.idproveedor,clientes.nombrecliente,"
            + "proveedores.razonsocial,proveedores.direccion,"
            + "distritos.distrito,departamentos.departamento "
            + "FROM proveedores INNER JOIN clientes "
            + "ON proveedores.idcliente=clientes.idcliente "
            + "INNER JOIN distritos "
            + "ON proveedores.iddistrito=distritos.iddistrito "
            + "INNER JOIN departamentos "
            + "ON proveedores.iddepartamento=departamentos.iddepartamento")            
    List<Map<Object,Object>> proveedoresQry();

    @Insert("INSERT INTO proveedores(idcliente,razonsocial,"
            + "direccion,iddistrito,iddepartamento) "
            + "VALUES(#{idcliente}, #{razonsocial}, "
            + "#{direccion}, #{iddistrito}, #{iddepartamento})")
    public int proveedoresIns(Proveedores proveedores);

    @Delete("DELETE FROM proveedores WHERE idproveedor IN(${ids})")
    public int proveedoresDel(@Param("ids") String ids);

    @Select("SELECT idproveedor,idcliente,razonsocial,"
            + "direccion,iddistrito,iddepartamento "
            + "FROM proveedores idproveedor "
            + "WHERE idproveedor=#{idproveedor}")
    public Proveedores proveedoresGet(@Param("idproveedor") 
            Integer idproveedor);

    @Update("UPDATE proveedores SET idcliente=#{idcliente},"
            + "razonsocial=#{razonsocial},direccion=#{direccion},"
            + "iddistrito=#{iddistrito},iddepartamento=#{iddepartamento} "
            + "WHERE idproveedor=#{idproveedor}")
    public int proveedoresUpd(Proveedores proveedores);
}

