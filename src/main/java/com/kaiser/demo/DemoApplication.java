package com.kaiser.demo;

import com.kaiser.demo.config.ApplicationStartedListener;
import com.kaiser.demo.config.DruidDBConfig;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDBConfig.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.addListeners(new ApplicationStartedListener());
        application.run(args);
    }

}
