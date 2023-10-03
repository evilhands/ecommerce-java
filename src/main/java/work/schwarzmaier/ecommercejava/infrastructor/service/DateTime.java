package work.schwarzmaier.ecommercejava.infrastructor.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTime {

    private static final LocalDateTime now = LocalDateTime.now();
    private static final ZoneOffset utc = ZoneOffset.UTC;
    public static Instant UTCplusMin(long min){
        return now.plusMinutes(min).toInstant(utc);
    }
}
