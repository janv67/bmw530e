package be.jv.bmw.batch;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jv.bmw.BmwApplication;
import be.jv.bmw.data.location.Location;
import be.jv.bmw.data.repositories.LocationRespository;

public class LoadGeoCodesInLocations {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(BmwApplication.class);
		LocationRespository locrepo=(LocationRespository)ctx.getBean("LocationRespository");
		List <Location> locations = locrepo.findAll();


	}

}
