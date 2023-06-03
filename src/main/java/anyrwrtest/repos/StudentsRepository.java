package anyrwrtest.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import anyrwrtest.entities.Student;
import anyrwrtest.entities.Teacher;

@RepositoryRestResource(exported = false)
public interface StudentsRepository extends CrudPagingAndSortingRepository<Student, Long> {
	
	@Query(value ="select e from Student e ")
	Page<Student> getAll(@Param("page") Pageable page);
	
	@Query(value ="select e from Student e where e.class.name= :#{#name}")
	Page<Student> getStudentsByclassName(@Param("name") String name,@Param("page") Pageable page);
	
	Page<Student> findByClassClassName(@Param("name") String name,@Param("page") Pageable page);
	
	@Query("SELECT s FROM Student s WHERE EXISTS (SELECT 1 FROM s.class ci WHERE"
			+ "						ci.classId = teacher.class.classId")
			Page<Student> getStudentsByTeacher(@Param("teacher") Teacher teacher, @Param("page") Pageable page);
	}