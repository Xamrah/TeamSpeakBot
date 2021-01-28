package me.alov.simple_bot.configuration;

import com.github.manevolent.ts3j.identity.LocalIdentity;
import com.github.manevolent.ts3j.protocol.socket.client.LocalTeamspeakClientSocket;
import lombok.SneakyThrows;
import me.alov.simple_bot.listener.SimpleListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;

@Configuration
public class Ts3ClientConfiguration {

//    @SneakyThrows
//    @Bean
//    public LocalTeamspeakClientSocket ts3client() throws GeneralSecurityException {
//        LocalTeamspeakClientSocket client = new LocalTeamspeakClientSocket();
//
//        // Set up client
//        client.setIdentity(LocalIdentity.generateNew(7));
//        client.addListener(new SimpleListener());
//        client.setNickname("PewPewBot");
//
//        client.connect(
//                new InetSocketAddress(
//                        InetAddress.getByName("192.248.183.99"),
//                        9987
//                ),
//                "",
//                10000L
//        );
//
//        return client;
//
//    }
}
