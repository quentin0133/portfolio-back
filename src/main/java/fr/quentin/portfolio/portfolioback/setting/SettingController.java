package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.core.validations.groups.OnCreate;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingAdminDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingCommandDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPublicDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Setting controller.
 */
@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {
    private final SettingService service;

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SettingAdminDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Gets value by id.
     *
     * @param id      the id
     * @param request the request
     * @return the value by id
     * @throws AuthenticationException the authentication exception
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SettingPublicDto> getValueById(@PathVariable String id, HttpServletRequest request)
        throws AuthenticationException
    {
        service.checkProtection(id, request);
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Save response entity.
     *
     * @param settingDto the setting dto
     * @return the response entity
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SettingAdminDto> save(@Validated(OnCreate.class) @RequestBody SettingCommandDto settingDto) {
        return ResponseEntity.ok(service.save(settingDto));
    }

    /**
     * Update response entity.
     *
     * @param settingDto the setting dto
     * @return the response entity
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SettingAdminDto> update(@Validated(OnUpdate.class) @RequestBody SettingCommandDto settingDto) {
        return ResponseEntity.ok(service.update(settingDto));
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteByKey(id);
        return ResponseEntity.noContent().build();
    }
}
