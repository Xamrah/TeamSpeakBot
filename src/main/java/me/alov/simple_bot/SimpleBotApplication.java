package me.alov.simple_bot;

import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.service.Ts3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SimpleBotApplication implements CommandLineRunner {

    @Autowired
    private Ts3Client ts3QueryClient;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ts3QueryClient.renameChannel(58, "yaebusobak");
    }
}
