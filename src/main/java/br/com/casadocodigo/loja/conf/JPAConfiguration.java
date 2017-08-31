package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean factoryBean;
        factoryBean = new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/casadocodigo");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        factoryBean.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(properties);

        factoryBean.setPackagesToScan("br.com.casadocodigo.loja.model");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}
