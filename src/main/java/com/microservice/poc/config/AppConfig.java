package com.microservice.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class AppConfig {

    @Value("${resttemplate.timeout}")
    private int restTemplateTimeout;  //timeout in milliseconds

    @Value("${resttemplate.connection.timeout}")
    private int restTemplateConnectionTimeout; //connection timeout in milliseconds


    // @Bean
    //public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder(5);
    //}


    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(restTemplateTimeout);
        factory.setConnectTimeout(restTemplateConnectionTimeout);
        return factory;
    }

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }



}
