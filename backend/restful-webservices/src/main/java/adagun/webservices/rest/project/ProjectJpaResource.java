package adagun.webservices.rest.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectJpaResource
{

    //private ProjectHardcodedService projectService;
    @Autowired
    private ProjectJpaRepository jpaRepository;

    // get all projects
    @GetMapping("/jpa/users/{username}/projects")
    public List<Project> getAllProjects(@PathVariable String username)
    {
        return jpaRepository.findByUsername(username);
    }
    // get project
    @GetMapping("/jpa/users/{username}/projects/{id}")
    public Project getProject(@PathVariable String username, @PathVariable long id)
    {
        return jpaRepository.findById(id).get();
    }

    // edit project
    @PutMapping("/jpa/users/{username}/projects/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable String username, @PathVariable long id, @RequestBody Project project)
    {
        Project updatedProject = jpaRepository.save(project);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    // add project
    @PostMapping("/jpa/users/{username}/projects")
    public ResponseEntity<Void> createProject(
            @PathVariable String username, @RequestBody Project project)
    {
        project.setUsername(username);
        Project createdProject = jpaRepository.save(project);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdProject.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //delete
    @DeleteMapping("/jpa/users/{username}/projects/{id}")
    public ResponseEntity<Void> deleteProject(
            @PathVariable String username, @PathVariable long id)
    {
        jpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
