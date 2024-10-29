package com.robayet.inndirector.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public String getCurrentDataAndTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}
