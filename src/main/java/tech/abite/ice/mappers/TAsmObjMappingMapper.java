package tech.abite.ice.mappers;

import tech.abite.ice.model.TAsmObjMapping;

public interface TAsmObjMappingMapper {
    int deleteByPrimaryKey(Long tAsmObjMappingId);

    int insert(TAsmObjMapping record);

    int insertSelective(TAsmObjMapping record);

    TAsmObjMapping selectByPrimaryKey(Long tAsmObjMappingId);

    int updateByPrimaryKeySelective(TAsmObjMapping record);

    int updateByPrimaryKey(TAsmObjMapping record);
}