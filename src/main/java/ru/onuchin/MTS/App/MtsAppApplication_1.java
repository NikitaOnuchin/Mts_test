package ru.onuchin.MTS.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MtsAppApplication_1 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MtsAppApplication_1.class, args);
        MtsGenerated mtsApp = context.getBean(MtsGenerated.class);
        mtsApp.generate();
    }
}
