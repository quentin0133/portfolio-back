package fr.quentin.portfolio.portfolioback.auth;

import fr.quentin.portfolio.portfolioback.auth.dtos.LoginQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * The interface Auth mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthMapper {
    /**
     * To login response login query dto.
     *
     * @param security the security
     * @return the login query dto
     */
    @Mapping(target = "token", expression = "java(fr.quentin.portfolio.portfolioback.core.tools.JwtUtils.generateToken(security))")
    LoginQueryDto toLoginResponse(UserSecurity security);
}
