package fr.quentin.portfolio.portfolioback.setting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SettingRepository extends JpaRepository<Setting, String> {
    List<Setting> findByValue(String value);
}
