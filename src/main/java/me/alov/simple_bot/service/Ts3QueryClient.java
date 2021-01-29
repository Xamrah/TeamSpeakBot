package me.alov.simple_bot.service;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

import static com.github.theholywaffle.teamspeak3.api.ChannelProperty.CHANNEL_NAME;

@Slf4j
@Component
public class Ts3QueryClient implements Ts3Client {

    @Autowired
    private TS3Api ts3Api;

    @Override
    public void changeServerBanner(String imageUrl) {

    }

    @Override
    public void renameChannel(int channelId, String channelName) {
        HashMap<ChannelProperty, String> props = new HashMap<>();
        props.put(CHANNEL_NAME, channelName);

        log.info("Renaming channed with id {} to {}", channelId, channelName);
        ts3Api.editChannel(channelId, props);
    }
}
