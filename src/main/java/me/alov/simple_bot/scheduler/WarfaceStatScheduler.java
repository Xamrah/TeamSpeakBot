package me.alov.simple_bot.scheduler;

import lombok.RequiredArgsConstructor;
import me.alov.simple_bot.service.Ts3Service;
import me.alov.simple_bot.service.WarfaceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarfaceStatScheduler {

    private final WarfaceService warfaceService;
    private final Ts3Service ts3Service;


    private final String CLAN_NAME = "Лювенис";

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void checkClanStats() {
        var clanDto= warfaceService.checkClanRank(CLAN_NAME);
        ts3Service.updateServerByWarfaceData(clanDto);
    }

}
