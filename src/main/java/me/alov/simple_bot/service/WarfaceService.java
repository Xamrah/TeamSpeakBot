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

    @Autowired
    private RestTemplate restTemplate;

    public WarfaceClanDto checkClanRank(String clanName) {
            var responseEntity = restTemplate.exchange("http://api.warface.ru/rating/monthly?server=Альфа&clan=Лювенис", HttpMethod.GET, null, new ParameterizedTypeReference<List<WarfaceClanDto>>() {});
            var clan = responseEntity.getBody().stream()
                    .filter(dto -> dto.getName().equals(clanName))
                    .findFirst()
                    .get();
            return clan;
    }
}
