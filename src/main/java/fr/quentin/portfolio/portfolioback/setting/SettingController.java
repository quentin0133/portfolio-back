package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.setting.dtos.SettingDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPostDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {
    private final SettingService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SettingDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SettingDto> getValueById(@PathVariable String id, HttpServletRequest request)
        throws AuthenticationException
    {
        service.checkProtection(id, request);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody SettingPostDto settingDto) {
        service.save(settingDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody SettingPostDto settingDto) {
        service.update(settingDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteByKey(id);
        return ResponseEntity.noContent().build();
    }
}
