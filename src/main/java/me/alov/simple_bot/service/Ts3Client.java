package me.alov.simple_bot.service;


import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;

public interface Ts3Client {
    void changeServerBanner(String imageUrl);
    void renameChannel(int channelId, String channelName);
    Integer getOnlineMembers();
    void addListener(TS3Listener ... listeners);
}
