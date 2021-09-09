package tech.abite.ice;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

public class MyBatisPlusGenerator {


    /**
     * 项目路径  修改为你项目的实际绝对路径
     *
     */
    private static String canonicalPath = "";


    /**
     * 基本包名
     */
    private static String basePackage = "tech.abite.aot";

    /**
     * 作者
     */
    private static String authorName = "john";


    private static String[] tables = {};
    /**
     * table前缀
     */
    private static  String[] prefix = {"t_"};

    /**
     * 数据库类型
     */
    private static DbType dbType = DbType.MYSQL;

    /**
     * 数据库配置四要素
     */
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/ice?useUnicode=true&characterEncoding=utf-8";
    private static String username = "root";
    private static String password = "qwe123";


    public static void main(String[] args) {
        GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
                .fileOverride().openDir(false).enableSwagger()
                .outputDir("builds")
                .author(authorName).dateType(DateType.TIME_PACK).commentDate("yyyy-MM-dd")
                .build();
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("tech.abite")
                .moduleName("ice")
                .mapper("mappers")
                .entity("entities")
                .xml("mappers.xml")
                .build();

        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()
                .addTablePrefix("t_") // 生成类的时候会去掉
//                .addInclude(tables)
                .addExclude("flyway_schema_history")
                .entityBuilder()// 实体配置构建者
                .enableLombok()// 开启lombok模型
                .versionColumnName("version") //乐观锁数据库表字段
                .naming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
                .addTableFills(new Column("created_time", FieldFill.INSERT))	//基于数据库字段填充
                .addTableFills(new Property("updated_time", FieldFill.INSERT_UPDATE))	//基于模型属性填充
                .controllerBuilder() //控制器属性配置构建
                .enableRestStyle()
                .build();
        new AutoGenerator(new DataSourceConfig.Builder(url, username, password).build())
                .global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig).execute();
    }
}