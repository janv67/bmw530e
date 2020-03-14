package be.jv.bmw.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.geocode.BMWGeocodes;

@Repository
public interface GeocodeRepository extends JpaRepository<BMWGeocodes, Integer> {

	@Query("SELECT max(id) FROM BMWGeocodes")
	public List<BMWGeocodes> findLast();

	@Query("SELECT bmw FROM BMWGeocodes bmw where longitude = :longitude and latitude = :latitude")
	List<BMWGeocodes> findGeocodeInfoByLongLat(@Param("latitude") String latitude,
			@Param("longitude") String longitude);

}