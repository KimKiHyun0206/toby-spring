package hellospring.tobyspring.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false)    //기본값 = true
/*
@MyAutoConfiguration 애노테이션을 붙여서 imports 파일을 통해서 동적으로 로딩되는 Configuration 들은 기존에 우리가 사용했던 것처럼
그냥 Configuration Annotation 이 적용되는 것이 아니라 ProxyBeanMethods 를 false  바꾼 Configuration 이 적용된다
*/
//리펙토링을 할 때는 시스템이 변경되지는 않았는지 점검하는 것이 꼭 필요하다
public @interface MyAutoConfiguration {

}
