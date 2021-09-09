package tech.abite.ice.mappers;

import tech.abite.ice.model.TProject;

public interface TProjectMapper {
    int deleteByPrimaryKey(Long projectId);

    int insert(TProject record);

    int insertSelective(TProject record);

    TProject selectByPrimaryKey(Long projectId);

    int updateByPrimaryKeySelective(TProject record);

    int updateByPrimaryKey(TProject record);
}