package fr.quentin.portfolio.portfolioback.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Project repository.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /**
     * Exists by title boolean.
     *
     * @param title the title
     * @return the boolean
     */
    boolean existsByTitle(String title);

    /**
     * Find by title list.
     *
     * @param title the title
     * @return the list
     */
    List<Project> findByTitle(String title);

    /**
     * Exists by tags id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean existsByTags_Id(long id);
}
