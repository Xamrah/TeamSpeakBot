package me.alov.simple_bot;

import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.util.YoutubeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SimpleBotApplication implements CommandLineRunner {

    @Autowired
    private YoutubeUtils ytUtils;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        String s = ytUtils.downloadMusicFromYt("https://www.youtube.com/watch?v=p1r-loqlKhk");
//        log.info(s);
    }
}
