package be.jv.bmw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerBean implements ApplicationListener {

	@Autowired
	Environment environment;

	private static final Logger log = LoggerFactory.getLogger(ApplicationListenerBean.class);

	@Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
    		String port = environment.getProperty("server.port");
    		String datasource = environment.getProperty("spring.datasource.url");
    		
    		log.info("---------------------------------------------------------------");
    		log.info("Op deze poort kan je connecteren!    "+port);
    		log.info("Datasource waarnaar wordt geschreven "+datasource);
        }
    }
}