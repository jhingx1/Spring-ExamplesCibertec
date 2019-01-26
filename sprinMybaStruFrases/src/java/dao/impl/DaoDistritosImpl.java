package dao.impl;

import dao.DaoDistritos;
import dto.Distritos;
import java.util.List;
import mybatis.DistritosMapper;

public class DaoDistritosImpl implements DaoDistritos {

    private DistritosMapper distritosMapper;

    public void setDistritosMapper(DistritosMapper distritosMapper) {
        this.distritosMapper = distritosMapper;
    }

    @Override
    public List<Distritos> distritosCbo() {
        List<Distritos> list = distritosMapper.distritosCbo();
        return list;
    }
}
