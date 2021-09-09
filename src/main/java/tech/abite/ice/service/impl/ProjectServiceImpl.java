package tech.abite.ice.service.impl;

import tech.abite.ice.entities.Project;
import tech.abite.ice.mappers.ProjectMapper;
import tech.abite.ice.service.IProjectService;
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
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
