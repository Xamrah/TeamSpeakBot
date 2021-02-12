package me.alov.simple_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarfaceClanDto {

    @JsonProperty("clan")
    private String name;

    @JsonProperty("rank")
    private Integer place;

    @JsonProperty
    private Integer points;

    @JsonProperty
    private Integer league;

    @JsonProperty
    private Byte    members;






}
