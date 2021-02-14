package me.alov.simple_bot.listener;

import com.github.manevolent.ts3j.event.ClientJoinEvent;
import com.github.manevolent.ts3j.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import lombok.Getter;
import me.alov.simple_bot.service.Ts3ApiWrapper;
import me.alov.simple_bot.service.Ts3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OnlineMemberListener extends AbstractTs3Listener implements TS3Listener {

    @Getter
    private static Integer onlineMembers;

    @Autowired
    private Ts3ApiWrapper ts3ApiWrapper;

    @Autowired
    private Ts3Service ts3Service;

    @PostConstruct
    public void initOnlineMembers(){
        onlineMembers = ts3ApiWrapper.getOnlineMembers() - 1;
    }

    @Override
    public void onClientJoin(ClientJoinEvent e) {
        onlineMembers++;
        ts3Service.updateTs3Members();
    }

    @Override
    public void onClientLeave(ClientLeaveEvent e) {
        onlineMembers--;
        ts3Service.updateTs3Members();
    }

}
