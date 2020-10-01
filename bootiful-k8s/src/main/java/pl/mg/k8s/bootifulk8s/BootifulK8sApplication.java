package pl.mg.k8s.bootifulk8s;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootifulK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootifulK8sApplication.class, args);
    }


    @Bean
//    @ConditionalOnCloudPlatform(CloudPlatform.KUBERNETES)
    InitializingBean initializingBean() {
        return () -> System.out.println("hello K8S from " + BootifulK8sApplication.class.getName());
    }
}
