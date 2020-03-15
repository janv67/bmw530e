package be.jv.bmw.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTimer {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTimer.class);
	private int milliSeconds = 10000;

	public int getMilliSeconds() {
		return milliSeconds;
	}

	public void setMilliSeconds(int milliSeconds) {
		this.milliSeconds = milliSeconds;
	}

	public void incrementTimer() {
		milliSeconds = milliSeconds * 2;
		if (milliSeconds > 600000) {
			milliSeconds = 600000;
		}
		log.info("Incremented timer to " + milliSeconds);
	}

	public void decrementTimer() {
		milliSeconds = milliSeconds / 2;
		if (milliSeconds < 10000) {
			milliSeconds = 10000;
		}
		log.info("Decremented timer to " + milliSeconds);
	}

	public String getMilliSecondsAsString() {
		return String.valueOf(milliSeconds);
	}

}
