package fr.quentin.portfolio.portfolioback.tags;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Tag repository.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<Tag> findByName(String name);

    /**
     * Exists by tag type id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean existsByTagType_Id(long id);
}
