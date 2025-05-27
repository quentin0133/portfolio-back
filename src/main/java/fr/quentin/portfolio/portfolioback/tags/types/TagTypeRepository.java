package fr.quentin.portfolio.portfolioback.tags.types;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Tag type repository.
 */
public interface TagTypeRepository extends JpaRepository<TagType, Long> {
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
    List<TagType> findByName(String name);
}
