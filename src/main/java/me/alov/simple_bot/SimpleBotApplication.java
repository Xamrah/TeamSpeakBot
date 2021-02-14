package me.alov.simple_bot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.service.Ts3ApiWrapper;
import me.alov.simple_bot.service.Ts3Client;
import me.alov.simple_bot.service.WarfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SimpleBotApplication implements CommandLineRunner {

    @Autowired
    private Ts3Client ts3QueryClient;

    @Autowired
    private WarfaceService warfaceService;

    @Autowired
    private Ts3ApiWrapper ts3ApiWrapper;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBotApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ts3ApiWrapper.addListener();
    }
}
