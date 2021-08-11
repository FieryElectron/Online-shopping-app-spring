package org.javadev.app.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// @Slf4j
@Component
public class Scheduler {
    // private final MessagingController messagingController;

    // Scheduler(GreetingController greetingService) {
    //     this.MessagingController = MessagingController;
    // }

    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    public void schedulingTask() {
        // System.out.println("Scheduler.schedulingTask()");
        // MessagingController.message();
    }
}
