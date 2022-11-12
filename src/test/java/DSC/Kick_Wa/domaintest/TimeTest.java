package DSC.Kick_Wa.domaintest;

import net.bytebuddy.asm.Advice;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeTest {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime endT = LocalDateTime.of(2022,11,12,16,59);
        Duration duration = Duration.between(start,endT);
        long seconds = duration.getSeconds();
        long minute = seconds/60;
        System.out.println("minute = " + minute);
    }
}
