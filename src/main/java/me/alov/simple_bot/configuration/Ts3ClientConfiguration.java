package me.alov.simple_bot.configuration;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class Ts3ClientConfiguration {


    @Bean
    @Qualifier("ts3Api")
    public TS3Api ts3Api() {
        final TS3Config config = new TS3Config();
        config.setHost("192.248.183.99");

        final TS3Query query = new TS3Query(config);
        query.connect();

        TS3Api api = query.getApi();
        api.login("serveradmin", "zhB7Wbh2");
        api.selectVirtualServerById(1);
        api.setNickname("LuvenisBot");
        api.sendChannelMessage("LuvenisBot is online!");
        api.registerAllEvents();
        return api;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
