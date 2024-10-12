package br.com.api_suporte.config;

import java.util.TimeZone;

public class TimeZoneConfig {
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
