package com.example.multipledatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 扫描 Mapper 接口并容器管理
 * @author Administrator
 */
@Configuration
@MapperScan(basePackages = FirstDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class FirstDatasourceConfig {


    /**
     * 精确到 master 目录，以便跟其他数据源隔离
     */
    static final String PACKAGE = "com.example.multipledatasource.mapper.first";
        static final String MAPPER_LOCATION = "classpath:mapper/first/*.xml";

        @Value("${first.datasource.url}")
        private String url;

        @Value("${first.datasource.username}")
        private String username;

        @Value("${first.datasource.password}")
        private String password;

        @Value("${first.datasource.driverClassName}")
        private String driverClass;

        @Bean(name = "masterDataSource")
        @Primary
        public DataSource masterDataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }

        @Bean(name = "masterTransactionManager")
        @Primary
        public DataSourceTransactionManager masterTransactionManager() {
            return new DataSourceTransactionManager(masterDataSource());
        }

        @Bean(name = "masterSqlSessionFactory")
        @Primary
        public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
                throws Exception {
            final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(masterDataSource);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(FirstDatasourceConfig.MAPPER_LOCATION));
            return sessionFactory.getObject();
        }
    }
