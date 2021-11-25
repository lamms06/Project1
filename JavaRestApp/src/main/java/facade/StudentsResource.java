package facade;

import domain.Student;
import service.StudentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("students")
@RequestScoped
public class StudentsResource {

    @Inject
    StudentService studentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
