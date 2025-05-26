package fr.quentin.portfolio.portfolioback.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByTitle(String title);

    List<Project> findByTitle(String title);
}
