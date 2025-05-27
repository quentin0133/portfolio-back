package fr.quentin.portfolio.portfolioback.setting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Setting repository.
 */
public interface SettingRepository extends JpaRepository<Setting, String> {
    /**
     * Find by value list.
     *
     * @param value the value
     * @return the list
     */
    List<Setting> findByValue(String value);
}
