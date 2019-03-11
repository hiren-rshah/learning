package com.self.learning.cntr;

import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@RestController
public class DateTimeCntr {

    @RequestMapping(value = {"/currentTime", "/currentTime/{timeZone}"}, method = {RequestMethod.GET})
    public String getTime(@PathVariable(value = "timeZone", required = false) Optional<String> timeZoneStr) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("timeZoneStr : " + timeZoneStr);
        System.out.println("Optional.of(timeZoneStr).orElse(null)) : " + Optional.of(timeZoneStr).orElse(null));
        if ("PST".equals(timeZoneStr.isPresent() ? timeZoneStr.get() : null)) {
            return convertTime("Europe/Paris");
        } else if ("EST".equals(timeZoneStr.isPresent() ? timeZoneStr.get() : null)) {
            return convertTime("America/New_York");
        } else {
            return convertTime("Asia/Kolkata");
        }
    }

    private String convertTime(String zone) {
        return ZonedDateTime.now(ZoneId.of(zone)).format(DateTimeFormatter.ofPattern("dd MMM yyyy hh"));
    }
}
