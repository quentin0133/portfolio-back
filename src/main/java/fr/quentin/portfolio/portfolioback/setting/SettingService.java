package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.setting.dtos.SettingAdminDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingCommandDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPublicDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

/**
 * The interface Setting service.
 */
public interface SettingService {
    /**
     * Find by id setting public dto.
     *
     * @param id the id
     * @return the setting public dto
     */
    SettingPublicDto findById(String id);

    /**
     * Save setting admin dto.
     *
     * @param dto the dto
     * @return the setting admin dto
     */
    SettingAdminDto save(SettingCommandDto dto);

    /**
     * Update setting admin dto.
     *
     * @param dto the dto
     * @return the setting admin dto
     */
    SettingAdminDto update(SettingCommandDto dto);

    /**
     * Check protection.
     *
     * @param id      the id
     * @param request the request
     * @throws AuthenticationException the authentication exception
     */
    void checkProtection(String id, HttpServletRequest request) throws AuthenticationException;

    /**
     * Delete by key.
     *
     * @param id the id
     */
    void deleteByKey(String id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<SettingAdminDto> findAll();
}
