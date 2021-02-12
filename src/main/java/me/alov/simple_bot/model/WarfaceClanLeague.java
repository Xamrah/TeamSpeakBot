package me.alov.simple_bot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WarfaceClanLeague {

    Elite(1,"Элита"),
    Platinum(2,"Платина"),
    Gold(3,"Золото"),
    Silver(4,"Серебро"),
    Bronze(5,"Бронза");

    private Integer id;
    private String name;

    public static WarfaceClanLeague findById(Integer id){
        for(WarfaceClanLeague v : values()){
            if(v.getId().equals(id)){
                return v;
            }
        }
        return null;
    }
}
