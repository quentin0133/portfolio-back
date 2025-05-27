package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingAdminDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingCommandDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPublicDto;
import fr.quentin.portfolio.portfolioback.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Setting service.
 */
@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {
    private final SettingRepository repository;
    private final SettingMapper mapper;

    private final UserService userService;

    @Override
    public SettingPublicDto findById(String id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
    }

    @Override
    public SettingAdminDto save(SettingCommandDto dto) {
        if (repository.existsById(dto.getKey()))
            throw new DuplicateKeyException("Setting id %s already exists".formatted(dto.getKey()));
        return mapper.toAdminDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public SettingAdminDto update(SettingCommandDto dto) {
        return mapper.toAdminDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public void checkProtection(String id, HttpServletRequest request) throws AuthenticationException {
        Setting setting = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
        if (setting.isProtected()) {
            String token = JwtUtils.getTokenFromRequest(request);
            // Throw 404 so we hide that this setting exists
            if (JwtUtils.validateToken(token, userService.getUserDetailsFromToken(token)))
                throw new ResourceNotFoundException("Setting", id);
        }
    }

    @Override
    public void deleteByKey(String key) {
        if (!repository.existsById(key)) throw new ResourceNotFoundException("Setting", key);
        repository.deleteById(key);
    }

    @Override
    public List<SettingAdminDto> findAll() {
        return repository.findAll().stream().map(mapper::toAdminDto).toList();
    }
}
