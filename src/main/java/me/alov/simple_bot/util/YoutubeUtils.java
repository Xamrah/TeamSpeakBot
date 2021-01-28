package me.alov.simple_bot.util;

import com.sapher.youtubedl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class YoutubeUtils {

    @Value("{$ts3.client.music-dir}")
    private static String musicDir;

    public String downloadMusicFromYt(String videoUrl) throws YoutubeDLException {
        var request = createRequest(videoUrl);
        YoutubeDLResponse response = YoutubeDL.execute(request, (progress, etaInSeconds) -> log.info("Progress: {}%, ETA: {}s", progress, etaInSeconds));
        return response.getOut();
    }

    private static YoutubeDLRequest createRequest(String videoUrl) {
        YoutubeDLRequest request = new YoutubeDLRequest(videoUrl, musicDir);
        request.setOption("ignore-errors");
        request.setOption("output", "%(title)s-%(id)s.%(ext)s");
        request.setOption("retries", 10);
        request.setOption("extract-audio");
        request.setOption("audio-format", "opus");

        return request;
    }
}
