package hellospring.tobyspring.config.autoconfig;

import hellospring.tobyspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
