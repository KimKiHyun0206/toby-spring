package hellospring.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

    @Test
    void configuration() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyConfig.class);
        applicationContext.refresh();

        Bean1 bean1 = applicationContext.getBean(Bean1.class);
        Bean2 bean2 = applicationContext.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common); //두개가 동일하다고 나옴
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        //프록시 패턴을 사용하는 경우 동일하게 나온다
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);

        /*
         * Configuration Class에 ProxyBeanMethod 라는 게 Default 값으로
         * True로 들어있다는 것은 처음에 Spring Container가 시작할 때 이런 Proxy
         * 클래스들을 생성하고 Configuration Annotation이 붙은 BeanObject를 사용하는 것이다
         * 그래서 여러번의 FactoryMethod를 호출해서 오브젝트를 생성해도 한 개의 오브젝트만 사용되는 것이다
         * */
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();
            return common;
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        protected final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        protected final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }

    //Bean1  <--의존-- Common
    //Bean2  <--의존-- Common
    //이때 Common은 같은 오브젝트여야한다
}