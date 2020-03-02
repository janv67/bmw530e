package be.jv.bmw.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.geocode.BMWGeocodes;

@Repository
public interface GeocodeRepository extends JpaRepository<BMWGeocodes, Integer> {

    @Query("SELECT geonumber FROM BMWGeocodes where longitude = :longitude and latitude = :latitude") 
    Optional<String> findGeocodeInfoByLongLat(@Param("latitude") String latitude,@Param("longitude") String longitude);

}