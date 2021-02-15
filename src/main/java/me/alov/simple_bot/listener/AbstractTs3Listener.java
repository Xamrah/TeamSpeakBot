package me.alov.simple_bot.listener;


import com.github.theholywaffle.teamspeak3.api.event.*;

public abstract class AbstractTs3Listener implements TS3Listener {

    @Override
    public void onTextMessage(TextMessageEvent e) {

    }

    @Override
    public void onServerEdit(ServerEditedEvent e) {

    }

    @Override
    public void onChannelEdit(ChannelEditedEvent e) {

    }

    @Override
    public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent e) {

    }

    @Override
    public void onClientMoved(ClientMovedEvent e) {

    }

    @Override
    public void onChannelCreate(ChannelCreateEvent e) {

    }

    @Override
    public void onChannelDeleted(ChannelDeletedEvent e) {

    }

    @Override
    public void onChannelMoved(ChannelMovedEvent e) {

    }

    @Override
    public void onChannelPasswordChanged(ChannelPasswordChangedEvent e) {

    }

    @Override
    public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent e) {

    }
}
