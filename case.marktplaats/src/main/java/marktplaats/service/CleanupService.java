package marktplaats.service;

import marktplaats.dao.WinkelwagenDao;

import javax.inject.Inject;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class CleanupService {

    @Inject
    WinkelwagenDao winkelwagenDao;
    public void startTimer(){
        Timer timer = new Timer();
        TimerTask hourlyTask = new TimerTask(){
            @Override
            public void run(){
                winkelwagenDao.validateWinkelwagens();
            }
        };
        timer.schedule(hourlyTask, 0l, Duration.ofMinutes(30l).toMillis());
    }

}
