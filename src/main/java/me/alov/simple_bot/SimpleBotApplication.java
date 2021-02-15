package me.alov.simple_bot;

import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.listener.OnlineMemberListener;
import me.alov.simple_bot.service.Ts3ApiWrapper;
import me.alov.simple_bot.service.Ts3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SimpleBotApplication implements CommandLineRunner {

    @Autowired
    private OnlineMemberListener onlineMemberListener;
    @Autowired
    private Ts3ApiWrapper ts3Api;
    @Autowired
    private Ts3Service ts3Service;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBotApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ts3Service.updateTs3Members();
    }
}
