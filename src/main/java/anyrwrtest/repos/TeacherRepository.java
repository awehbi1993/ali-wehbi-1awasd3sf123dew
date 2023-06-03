package anyrwrtest.repos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import anyrwrtest.entities.Teacher;



@RepositoryRestResource(exported = false)
public interface TeacherRepository extends CrudPagingAndSortingRepository<Teacher, Long> {
	@Query(value ="select t from Teacher t where t.firstname= :#{#name} AND t.lastname= :#{#lastName}")
	Teacher getteacher(@Param("name") String name, @Param("lastName") String lastName , @Param("page") Pageable page);
}
