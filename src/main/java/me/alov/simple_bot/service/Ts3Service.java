package me.alov.simple_bot.service;

import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import lombok.RequiredArgsConstructor;
import me.alov.simple_bot.model.WarfaceClanDto;
import me.alov.simple_bot.model.WarfaceClanLeague;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class Ts3Service {

    private final Ts3ApiWrapper ts3Api;
    private final Set<TS3Listener> listeners;

    //TODO: move to global properties-map
    private final Integer CHANNEL_ID_LEAGUE = 62;
    private String CHANNEL_NAME_LEAGUE = "[cspacer0] Лига: ";
    private final Integer CHANNEL_ID_PLACE = 64;
    private String CHANNEL_NAME_PLACE = "[cspacer0] Место: ";
    private final Integer CHANNEL_ID_POINTS = 63;
    private String CHANNEL_NAME_POINTS = "[cspacer0] Очки: ";
    private final Integer CHANNEL_ID_MEMBERS = 65;
    private String CHANNEL_NAME_MEMBERS = "[cspacer0] Участников: ";
    private final Integer CHANNEL_ID_ONLINE = 50;
    private String CHANNEL_NAME_ONLINE = "[cspacer8252]  Онлайн : ";

    public void updateServerByWarfaceData(WarfaceClanDto clan) {
        var league = WarfaceClanLeague.findById(clan.getLeague());

        ts3Api.renameChannel(CHANNEL_ID_PLACE, CHANNEL_NAME_PLACE + clan.getPlace());
        ts3Api.renameChannel(CHANNEL_ID_POINTS, CHANNEL_NAME_POINTS + clan.getPoints());
        ts3Api.renameChannel(CHANNEL_ID_MEMBERS, CHANNEL_NAME_MEMBERS + clan.getMembers());

    }

    public void updateTs3Members() {
        ts3Api.renameChannel(CHANNEL_ID_ONLINE, CHANNEL_NAME_ONLINE + getOnlineClientsCount());
    }

    public Integer getOnlineClientsCount() {
        return ts3Api.getOnlineMembers();
    }

    @PostConstruct
    public void init() {
        listeners.forEach(ts3Api::addListener);
    }
}
