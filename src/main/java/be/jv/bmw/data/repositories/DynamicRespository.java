package be.jv.bmw.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.jv.bmw.data.dynamic.Dynamic;

@Repository
public interface DynamicRespository extends JpaRepository<Dynamic, Integer> {

	/**
	 * Finds a person by using the last name as a search criteria.
	 * 
	 * @param lastName
	 * @return A list of persons whose last name is an exact match with the given
	 *         last name. If no persons is found, this method returns an empty list.
	 */
//  @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//   public List<Efficiency> find(@Param("lastName") String lastName);

	@Query("SELECT max(id) FROM Dynamic")
	public List<Dynamic> findLast();

//	@Query("SELECT dyn FROM Dynamic dyn join Attributesmap where Attributesmap.updateTime_converted_date = :datum")
//	@Query("SELECT dyn, am FROM Dynamic dyn inner join dyn.attributesMapObject am where am.updateTime_converted_date = :datum")
	@Query("SELECT dyn FROM Dynamic dyn, AttributesMap am where dyn.attributesMapObject = am.id and am.updateTime_converted_date = :datum")
	public List<Dynamic> findByDate(@Param("datum") String datum);

}