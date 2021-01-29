package me.alov.simple_bot.configuration;

import com.github.manevolent.ts3j.identity.LocalIdentity;
import com.github.manevolent.ts3j.protocol.socket.client.LocalTeamspeakClientSocket;
import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import lombok.SneakyThrows;
import me.alov.simple_bot.listener.SimpleListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;

@Configuration
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
        api.setNickname("PutPutBot_1");
        api.sendChannelMessage("PutPutBot is online!");
        return api;
    }

}
