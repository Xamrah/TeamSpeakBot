package me.alov.simple_bot.service;

import lombok.extern.slf4j.Slf4j;
import me.alov.simple_bot.model.WarfaceClanDto;
import me.alov.simple_bot.model.WarfaceClanLeague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Slf4j
@Service
public class WarfaceService {

    private final Integer CHANNEL_ID_LEAGUE = 62;
    private String CHANNEL_NAME_LEAGUE = "[cspacer0] Лига: ";

    private final Integer CHANNEL_ID_PLACE = 64;
    private String CHANNEL_NAME_PLACE = "[cspacer0] Место: ";

    private final Integer CHANNEL_ID_POINTS = 63;
    private String CHANNEL_NAME_POINTS = "[cspacer0] Очки: ";

    private final Integer CHANNEL_ID_MEMBERS = 65;
    private String CHANNEL_NAME_MEMBERS = "[cspacer0] Участников: ";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Ts3Client ts3QueryClient;

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public WarfaceClanDto checkClanRank() {
            ResponseEntity<List<WarfaceClanDto>> responseEntity = restTemplate.exchange("http://api.warface.ru/rating/monthly?server=Альфа&clan=Лювенис", HttpMethod.GET, null, new ParameterizedTypeReference<List<WarfaceClanDto>>() {});
            List<WarfaceClanDto> data = responseEntity.getBody();
            WarfaceClanDto luvenis = data.stream().filter(c -> c.getName().equals("Лювенис")).findFirst().get();
            Integer leagueId = luvenis.getLeague();
            WarfaceClanLeague league = WarfaceClanLeague.findById(leagueId);
            try {
                ts3QueryClient.renameChannel(CHANNEL_ID_LEAGUE, CHANNEL_NAME_LEAGUE + league.getName());
            } catch (Exception E) {
                log.warn("This channel name already in use: {}", CHANNEL_NAME_LEAGUE + league.getName());
            }
            try {
                ts3QueryClient.renameChannel(CHANNEL_ID_PLACE, CHANNEL_NAME_PLACE + luvenis.getPlace());
            } catch (Exception E) {
                log.warn("This channel name already in use: {}", CHANNEL_NAME_PLACE + luvenis.getPlace());
            }
            try {
                ts3QueryClient.renameChannel(CHANNEL_ID_POINTS, CHANNEL_NAME_POINTS + luvenis.getPoints());
            } catch (Exception E) {
                log.warn("This channel name already in use: {}", CHANNEL_NAME_POINTS + luvenis.getPoints());
            }
            try {
                ts3QueryClient.renameChannel(CHANNEL_ID_MEMBERS, CHANNEL_NAME_MEMBERS + luvenis.getMembers());
            } catch (Exception E) {
                log.warn("This channel name already in use: {}", CHANNEL_NAME_MEMBERS + luvenis.getMembers());
            }
            return luvenis;
    }
}
