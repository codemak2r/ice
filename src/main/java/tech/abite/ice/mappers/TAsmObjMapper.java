package tech.abite.ice.mappers;

import tech.abite.ice.model.TAsmObj;

public interface TAsmObjMapper {
    int deleteByPrimaryKey(Long asmObjId);

    int insert(TAsmObj record);

    int insertSelective(TAsmObj record);

    TAsmObj selectByPrimaryKey(Long asmObjId);

    int updateByPrimaryKeySelective(TAsmObj record);

    int updateByPrimaryKey(TAsmObj record);
}