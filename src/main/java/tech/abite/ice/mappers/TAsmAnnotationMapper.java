package tech.abite.ice.mappers;

import tech.abite.ice.model.TAsmAnnotation;

public interface TAsmAnnotationMapper {
    int deleteByPrimaryKey(Long asmAnnoId);

    int insert(TAsmAnnotation record);

    int insertSelective(TAsmAnnotation record);

    TAsmAnnotation selectByPrimaryKey(Long asmAnnoId);

    int updateByPrimaryKeySelective(TAsmAnnotation record);

    int updateByPrimaryKey(TAsmAnnotation record);
}