package adagun.webservices.rest.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long>
{
    List<Project> findByUsername(String username);
}
