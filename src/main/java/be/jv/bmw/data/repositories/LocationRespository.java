package be.jv.bmw.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.location.Location;

@Repository
public interface LocationRespository extends JpaRepository<Location, Integer> {


	 @Query("SELECT max(id) FROM Location")
	 public List<Location> findLast();
	
}