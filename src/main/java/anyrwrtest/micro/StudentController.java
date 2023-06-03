package anyrwrtest.micro;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import anyrwrtest.entities.Student;
import anyrwrtest.entities.Teacher;
import anyrwrtest.repos.StudentsRepository;
import anyrwrtest.repos.TeacherRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class StudentController {
	@Autowired
	private StudentsRepository studentsRepository;
	@Autowired
	private TeacherRepository teacherRepository;

	@Operation(summary = "Get Students")
	@RequestMapping(value = "/students method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE")
	public Page<Student> getStudents(@ParameterObject Pageable page) throws Exception {

		return studentsRepository.findAll(page);
	}

	@Operation(summary = "Get Students")
	@RequestMapping(value = "/filteredStudents method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE")
	public ResponseEntity<Page<Student>> getfilteredStudents(@ParameterObject Pageable page,
			@PathVariable FilterBy type, @RequestParam(required = true) String name,
			@RequestParam(required = false) String lastName) throws Exception {
		return ResponseEntity.ok(switch (type) {
		case teacher -> getfilteredByTeacher(page, name, lastName);
		case lecture -> getfilteredByClass(page, name);
		});

	}

	private Page<Student> getfilteredByTeacher(Pageable page, String fname, String lName) {
		Teacher teacher = teacherRepository.getteacher(fname, lName, page);
		return studentsRepository.getStudentsByTeacher(teacher, page);
	}

	private Page<Student> getfilteredByClass(Pageable page, String name) {
		return studentsRepository.getStudentsByclassName(name, page);
	}
}
