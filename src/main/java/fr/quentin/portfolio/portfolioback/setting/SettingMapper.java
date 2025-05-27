package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingAdminDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingCommandDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPublicDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * The interface Setting mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SettingMapper extends GenericMapper<Setting, SettingPublicDto, SettingCommandDto> {
    /**
     * To admin dto setting admin dto.
     *
     * @param setting the setting
     * @return the setting admin dto
     */
    SettingAdminDto toAdminDto(Setting setting);
}
