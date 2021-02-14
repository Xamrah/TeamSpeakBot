package me.alov.simple_bot.service;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.VirtualServerProperty;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.exception.TS3CommandFailedException;
import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.listener.OnlineMemberListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.github.theholywaffle.teamspeak3.api.ChannelProperty.CHANNEL_NAME;
import static com.github.theholywaffle.teamspeak3.api.VirtualServerProperty.VIRTUALSERVER_HOSTBANNER_GFX_URL;

@Slf4j
@Component
public class Ts3ApiWrapper implements Ts3Client {

    @Autowired
    private TS3Api ts3Api;

    @Autowired
    private OnlineMemberListener onlineMemberListener;


    @Override
    public void changeServerBanner(String imageUrl) {
        HashMap<VirtualServerProperty, String> props = new HashMap<>();
        props.put(VIRTUALSERVER_HOSTBANNER_GFX_URL, imageUrl);

        try {
            log.info("Changing HostBanner");
            ts3Api.editServer(props);
        } catch (TS3CommandFailedException e) {
            log.warn(e.getError().getMessage());
        }
    }

    @Override
    public void renameChannel(int channelId, String channelName) {
        log.info("Renaming channed with id {} to {}", channelId, channelName);
        try {
            ts3Api.editChannel(channelId, CHANNEL_NAME, channelName);
        } catch (TS3CommandFailedException e) {
            log.warn(e.getError().getMessage());
        }
    }

    @Override
    public void addListener() {
        ts3Api.addTS3Listeners((TS3Listener) onlineMemberListener);
    }

    @Override
    public Integer getOnlineMembers() {
        return ts3Api.getClients().size();
    }
}
