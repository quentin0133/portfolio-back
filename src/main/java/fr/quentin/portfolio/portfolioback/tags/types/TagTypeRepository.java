package fr.quentin.portfolio.portfolioback.tags.types;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagTypeRepository extends JpaRepository<TagType, Long> {
    boolean existsByName(String name);

    List<TagType> findByName(String name);
}
