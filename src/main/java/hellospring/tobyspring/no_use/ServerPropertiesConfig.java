package hellospring.tobyspring.no_use;

import hellospring.tobyspring.config.MyAutoConfiguration;
import hellospring.tobyspring.config.autoconfig.ServerProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    ServerProperties serverProperties(Environment env){
        /*
        ServerProperties serverProperties = new ServerProperties();
        serverProperties.setContextPath(env.getProperty("contextPath"));
        serverProperties.setPort(Integer.parseInt(env.getProperty("port")));
        return serverProperties;
        */

        return Binder.get(env).bind("", ServerProperties.class).get();   //getter, setter가 맞는 걸 자동으로 찾는다

    }
}
