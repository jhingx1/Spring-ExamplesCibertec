package dao.impl;

import dao.DaoDepartamentos;
import dto.Departamentos;
import java.util.List;
import mybatis.DepartamentosMapper;

public class DaoDepartamentosImpl implements DaoDepartamentos {

    private DepartamentosMapper departamentosMapper;

    public void setDepartamentosMapper(DepartamentosMapper departamentosMapper) {
        this.departamentosMapper = departamentosMapper;
    }

    @Override
    public List<Departamentos> departamentosCbo() {
        List<Departamentos> list = departamentosMapper.departamentosCbo();
        return list;
    }
}

