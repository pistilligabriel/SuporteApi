package br.com.api_suporte.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	public static String formatLocalDateTime(LocalDateTime dateTime) {
        // Criando o formatador para o padrão dd/MM/yyyy HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        // Formatando o LocalDateTime para String
        return dateTime.format(formatter);
    }

}
