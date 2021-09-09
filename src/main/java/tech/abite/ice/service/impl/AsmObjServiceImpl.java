package tech.abite.ice.service.impl;

import tech.abite.ice.entities.AsmObj;
import tech.abite.ice.mappers.AsmObjMapper;
import tech.abite.ice.service.IAsmObjService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author john
 * @since 2021-09-09
 */
@Service
public class AsmObjServiceImpl extends ServiceImpl<AsmObjMapper, AsmObj> implements IAsmObjService {
    public void parse(){

    }
}
