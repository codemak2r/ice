package tech.abite.ice.mappers;

import tech.abite.ice.model.TAsmMethod;

public interface TAsmMethodMapper {
    int deleteByPrimaryKey(Long asmMethodId);

    int insert(TAsmMethod record);

    int insertSelective(TAsmMethod record);

    TAsmMethod selectByPrimaryKey(Long asmMethodId);

    int updateByPrimaryKeySelective(TAsmMethod record);

    int updateByPrimaryKey(TAsmMethod record);
}