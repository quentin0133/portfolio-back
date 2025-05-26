package fr.quentin.portfolio.portfolioback.tags;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByName(String name);
}
