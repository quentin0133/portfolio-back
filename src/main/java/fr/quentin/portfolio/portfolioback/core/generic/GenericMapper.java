package fr.quentin.portfolio.portfolioback.core.generic;

/**
 * The interface Generic mapper.
 *
 * @param <E> the type parameter
 * @param <D> the type parameter
 * @param <P> the type parameter
 */
public interface GenericMapper<E, D, P> {
    /**
     * To dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D toDto(E entity);

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E toEntity(P dto);
}