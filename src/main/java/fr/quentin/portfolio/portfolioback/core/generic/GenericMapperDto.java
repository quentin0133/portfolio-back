package fr.quentin.portfolio.portfolioback.core.generic;

public interface GenericMapperDto<E, D, P> {
    D toDto(E entity);
    E toEntity(P dto);
}