package be.jv.bmw.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.efficiency.Efficiency;

@Repository
public interface EfficiencyRespository extends JpaRepository<Efficiency, Integer> {

	 
    /**
     * Finds a person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
//  @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//   public List<Efficiency> find(@Param("lastName") String lastName);

	 @Query("SELECT max(id) FROM Efficiency")
	 public List<Efficiency> findLast();
   
}