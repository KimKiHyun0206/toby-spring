package hellospring.tobyspring.config;


import hellospring.tobyspring.config.autoconfig.DispatcherServletConfig;
import hellospring.tobyspring.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Enable 이라는 이름을 가진 애노테이션은 구성 정보를 가진 클래스를 임포트한다
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfigImportSelector.class)
public @interface EnableMyAutoConfiguration {
}
