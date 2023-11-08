package hellospring.tobyspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);

        List<String> autoConfigs = new ArrayList<>();
        candidates.forEach(autoConfigs::add);

        return autoConfigs.toArray(new String[0]);  //List -> Array

        //return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

        /*return new String[]{
                "hellospring.tobyspring.config.autoconfig.DispatcherServletConfig",
                "hellospring.tobyspring.config.autoconfig.TomcatWebServerConfig"
        };*/
    }
}
