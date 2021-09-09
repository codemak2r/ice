package tech.abite.ice.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author: zw.wen
 */
@Slf4j
public class MyMetaObjectUtils implements MetaObjectHandler {
    //insert操作时要填充的字段
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        //根据属性名字设置要填充的值
        this.setFieldValByName("createdTime", LocalDateTime.now(),metaObject);
    }

    //update操作时要填充的字段
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        this.setFieldValByName("updatedTime",LocalDateTime.now(),metaObject);
    }
}
