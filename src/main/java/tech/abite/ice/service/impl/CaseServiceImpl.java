package tech.abite.ice.service.impl;

import tech.abite.ice.entities.Case;
import tech.abite.ice.mappers.CaseMapper;
import tech.abite.ice.service.ICaseService;
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
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements ICaseService {

}
