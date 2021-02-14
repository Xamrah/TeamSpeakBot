package me.alov.simple_bot.service;


import com.github.manevolent.ts3j.command.CommandException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Ts3Client {
    void changeServerBanner(String imageUrl);
    void renameChannel(int channelId, String channelName);
    Integer getOnlineMembers();
    void addListener();
}
