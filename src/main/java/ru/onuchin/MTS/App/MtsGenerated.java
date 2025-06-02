package ru.onuchin.MTS.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ru.onuchin.MTS.App.service.ReadingsService;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class MtsGenerated {
    private static final Logger logger = Logger.getLogger(MtsGenerated.class.getName());

    private ReadingsService readingsService;

    @Autowired
    public void setReadingsService(ReadingsService readingsService) {
        this.readingsService = readingsService;
    }

    public MtsGenerated() {

    }

    public void generate() {
        Random rand = new Random();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                int randomValue = rand.nextInt(101);
                readingsService.saveReadings(randomValue);
                logger.info("Добавлено число: " + randomValue);
            } catch (Exception e) {
                logger.log(java.util.logging.Level.SEVERE,
                        "Ошибка при вставке данных в таблицу readings");                }

        };

        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
    }

    @SpringBootApplication
    public static class FirstRestAppApplication {

        public static void main(String[] args) {
            SpringApplication.run(FirstRestAppApplication.class, args);
        }

    }
}
