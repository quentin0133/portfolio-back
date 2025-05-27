package fr.quentin.portfolio.portfolioback.core.generic;

/**
 * The type Generic mapper abstract.
 *
 * @param <E> the type parameter
 * @param <D> the type parameter
 * @param <P> the type parameter
 */
public abstract class GenericMapperAbstract<E, D, P> {
    /**
     * To dto d.
     *
     * @param entity the entity
     * @return the d
     */
    public abstract D toDto(E entity);

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    public abstract E toEntity(P dto);
}