package edu.javainreal.SpringBootFirstApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Value("${DB_URL}")
    public String url;
    @Value("${DB_USER}")
    public String user;
    @Value("${DB_PSW}")
    public String psw;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(url);
        builder.username(user);
        builder.password(psw);
        System.out.println("New DataSource Configured");
        return builder.build();
    }

}
