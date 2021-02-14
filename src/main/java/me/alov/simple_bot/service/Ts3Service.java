package me.alov.simple_bot.service;

import lombok.RequiredArgsConstructor;
import me.alov.simple_bot.model.WarfaceClanDto;
import me.alov.simple_bot.model.WarfaceClanLeague;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Ts3Service {

    private final Ts3ApiWrapper ts3Api;

    //TODO: move to global properties-map
    private final Integer CHANNEL_ID_LEAGUE = 62;
    private String CHANNEL_NAME_LEAGUE = "[cspacer0] Лига: ";
    private final Integer CHANNEL_ID_PLACE = 64;
    private String CHANNEL_NAME_PLACE = "[cspacer0] Место: ";
    private final Integer CHANNEL_ID_POINTS = 63;
    private String CHANNEL_NAME_POINTS = "[cspacer0] Очки: ";
    private final Integer CHANNEL_ID_MEMBERS = 65;
    private String CHANNEL_NAME_MEMBERS = "[cspacer0] Участников: ";

    public void updateServerByWarfaceData(WarfaceClanDto clan) {
        var league = WarfaceClanLeague.findById(clan.getLeague());

        ts3Api.renameChannel(CHANNEL_ID_LEAGUE, CHANNEL_NAME_LEAGUE + league.getName());
        ts3Api.renameChannel(CHANNEL_ID_PLACE, CHANNEL_NAME_PLACE + clan.getPlace());
        ts3Api.renameChannel(CHANNEL_ID_POINTS, CHANNEL_NAME_POINTS + clan.getPoints());
        ts3Api.renameChannel(CHANNEL_ID_MEMBERS, CHANNEL_NAME_MEMBERS + clan.getMembers());

    }
}
