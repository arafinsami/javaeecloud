package com.javaee.config;

import com.javaee.dao.CountryDAO;
import com.javaee.dao.CountryDAOImpl;
import com.javaee.service.CountryService;
import com.javaee.service.CountryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.javaee")
public class SpringConfig {

    @Bean
    public CountryDAO countryDAO() {
        return new CountryDAOImpl();
    }

    @Bean
    public CountryService countryService() {
        return new CountryServiceImpl(countryDAO());
    }
}
