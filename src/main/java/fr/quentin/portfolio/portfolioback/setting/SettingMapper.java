package fr.quentin.portfolio.portfolioback.setting;

import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingDto;
import fr.quentin.portfolio.portfolioback.setting.dtos.SettingPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SettingMapper extends GenericMapper<Setting, SettingDto, SettingPostDto> {
}
