package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.setting.dtos.SettingDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPostDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public interface SettingService {
    SettingDto findById(String id);

    void save(SettingPostDto dto);

    void update(SettingPostDto dto);

    void checkProtection(String id, HttpServletRequest request) throws AuthenticationException;

    void deleteByKey(String id);

    List<SettingDto> findAll();
}
