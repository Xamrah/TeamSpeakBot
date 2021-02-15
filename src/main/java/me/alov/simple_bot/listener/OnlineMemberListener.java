package me.alov.simple_bot.listener;


import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import me.alov.simple_bot.service.Ts3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnlineMemberListener extends AbstractTs3Listener {

    @Autowired
    private Ts3Service ts3Service;

    @Override
    public void onClientJoin(ClientJoinEvent e) {
        ts3Service.updateTs3Members();
    }

    @Override
    public void onClientLeave(ClientLeaveEvent e) {
        ts3Service.updateTs3Members();
    }
}
