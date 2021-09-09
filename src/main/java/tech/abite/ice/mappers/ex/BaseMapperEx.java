package tech.abite.ice.mappers.ex;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @author: zw.wen
 */
public interface BaseMapperEx<T> extends BaseMapper<T> {
    Integer insertBatchSomeColumn(Collection<T> entityList);
}
