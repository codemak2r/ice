package tech.abite.ice.mappers;

import tech.abite.ice.model.TAsmField;

public interface TAsmFieldMapper {
    int deleteByPrimaryKey(Long asmFieldId);

    int insert(TAsmField record);

    int insertSelective(TAsmField record);

    TAsmField selectByPrimaryKey(Long asmFieldId);

    int updateByPrimaryKeySelective(TAsmField record);

    int updateByPrimaryKey(TAsmField record);
}