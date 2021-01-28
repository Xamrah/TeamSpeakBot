package me.alov.simple_bot.service;

import lombok.RequiredArgsConstructor;
import me.alov.simple_bot.util.YoutubeUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {


    private final YoutubeUtils youtubeUtils;

    public void saveMusicFromYt(String videoUrl) {
//        var request = youtubeUtils.createRequest(videoUrl);
//        request.setDirectory(musicDir);

//        YoutubeDLResponse response = YoutubeDL.execute(request);
    }
}
