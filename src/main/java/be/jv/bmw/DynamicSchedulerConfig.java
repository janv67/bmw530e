package be.jv.bmw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class DynamicSchedulerConfig {
    @Bean
    public CustomDynamicSchedule getDinamicScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.initialize();
        return  new CustomDynamicSchedule(threadPoolTaskScheduler);
    }
}
