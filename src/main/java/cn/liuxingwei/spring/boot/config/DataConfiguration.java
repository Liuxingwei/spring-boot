package cn.liuxingwei.spring.boot.config;

import cn.liuxingwei.spring.boot.orm.domain.UserDao;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "cn.liuxingwei.spring.boot.orm.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataConfiguration {

    @Value("${mysql.driver}")
    private String mysqlDriver;

    @Value("${mysql.url}")
    private String mysqlUrl;

    @Value("${mysql.username}")
    private String mysqlUsername;

    @Value("${mysql.password}")
    private String mysqlPassword;

    @Bean
    public PooledDataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(mysqlDriver);
        dataSource.setUrl(mysqlUrl);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());

        sqlSessionFactoryBean.setTypeAliasesPackage("cn.liuxingwei.spring.boot.orm.domain");

        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:cn/liuxingwei/spring/boot/orm/mapper/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        /** 以下设置只是使用java配置设置sqlSessionFactoryBean的属性的示例 **/
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(true);
//        configuration.setLazyLoadingEnabled(true);
//        configuration.setMultipleResultSetsEnabled(true);
//        configuration.setUseColumnLabel(true);
//        configuration.setUseGeneratedKeys(false);
//        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
//        configuration.setDefaultStatementTimeout(25000);
//        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
