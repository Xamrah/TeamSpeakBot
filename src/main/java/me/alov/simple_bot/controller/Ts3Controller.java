package me.alov.simple_bot.controller;

import me.alov.simple_bot.model.WarfaceClanDto;
import me.alov.simple_bot.service.WarfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ts3")
public class Ts3Controller {

    @Autowired
    private WarfaceService warfaceService;

    @GetMapping("/update")
    private ResponseEntity<WarfaceClanDto> data(){

        WarfaceClanDto clanData = warfaceService.checkClanRank();
        return ResponseEntity.ok(clanData);

    }

}
