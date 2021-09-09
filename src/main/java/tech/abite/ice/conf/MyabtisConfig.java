package tech.abite.ice.conf;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.abite.ice.sqlinjector.DefaultSqlInjectorEx;
import tech.abite.ice.utils.MyMetaObjectUtils;


@Configuration
@MapperScan(basePackages = {"tech.abite.ice.mappers"})
public class MyabtisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    @Bean
    public MyMetaObjectUtils createMyMetaObjectHandler(){
        return new MyMetaObjectUtils();
    }

    @Bean
    public DefaultSqlInjectorEx createInjector(){
        return new DefaultSqlInjectorEx();
    }
}
