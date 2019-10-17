package be.jv.bmw;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

public class CustomDynamicSchedule extends DynamicSchedule implements Trigger {

    private TaskScheduler taskScheduler;
    private ScheduledFuture<?> schedulerFuture;

    /**
     * milliseconds
     */
    private long delayInterval;

    public CustomDynamicSchedule(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }


    @Override
    public void increaseDelayInterval(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval += delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public void decreaseDelayInterval(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval += delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public void delay(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval = delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date lastTime = triggerContext.lastActualExecutionTime();
        return (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delayInterval);
    }
}