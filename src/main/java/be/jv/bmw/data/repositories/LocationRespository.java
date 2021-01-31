package be.jv.bmw.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.location.Location;

@Repository
public interface LocationRespository extends JpaRepository<Location, Integer> {

	@Query("SELECT max(id) FROM Location")
	public List<Location> findLast();

	@Query("SELECT loc FROM Location loc where date = :datum")
	public List<Location> findByDate(@Param("datum") String datum);
	
//	@Query("SELECT bl FROM Location bl "+
//			"left join geocode bg "+
//			" where bl.date=:datum")
//			public List<Location> findByDate(@Param("datum") String datum);
}

