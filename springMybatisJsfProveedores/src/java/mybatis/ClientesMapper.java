package mybatis;

import dto.Clientes;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ClientesMapper {

    @Select("SELECT idcliente,nombrecliente,ruc FROM clientes")
    List<Clientes> clientesQry();

    @Insert("INSERT INTO clientes(nombrecliente,ruc) VALUES(#{nombrecliente},#{ruc})")
    public int clientesIns(Clientes clientes);

    @Delete("DELETE FROM clientes WHERE idcliente IN(${ids})")
    public int clientesDel(@Param("ids") String ids);

    @Select("SELECT idcliente,nombrecliente,ruc "
            + "FROM clientes WHERE idcliente=#{idcliente}")
    public Clientes clientesGet(
            @Param("idcliente") Integer idcliente);

    @Update("UPDATE clientes SET nombrecliente=#{nombrecliente},ruc=#{ruc} "
            + "WHERE idcliente=#{idcliente}")
    public int clientesUpd(Clientes clientes);
}


