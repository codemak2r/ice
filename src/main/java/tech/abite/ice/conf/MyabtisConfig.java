package tech.abite.ice.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = {"tech.abite.ice.mappers"})
public class MyabtisConfig {

}
