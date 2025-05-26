package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPostDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {
    private final SettingRepository repository;
    private final SettingMapper mapper;

    @Override
    public SettingDto findById(String id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
    }

    @Override
    public void save(SettingPostDto dto) {
        if (repository.existsById(dto.getKey()))
            throw new DuplicateKeyException("Setting id %s already exists".formatted(dto.getKey()));
        repository.saveAndFlush(mapper.toEntity(dto));
    }

    @Override
    public void update(SettingPostDto dto) {

        repository.saveAndFlush(mapper.toEntity(dto));
    }

    @Override
    public void checkProtection(String id, HttpServletRequest request) throws AuthenticationException {
        Setting setting = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
        if (setting.isProtected()) {
            String token = JwtUtils.getTokenFromRequest(request);
            if (token == null || JwtUtils.extractUsername(token) != null || !JwtUtils.isTokenExpired(token))
                throw new BadCredentialsException("This setting is protected, invalid token");
        }
    }

    @Override
    public void deleteByKey(String key) {
        if (!repository.existsById(key)) throw new ResourceNotFoundException("Setting", key);
        repository.deleteById(key);
    }

    @Override
    public List<SettingDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }
}
