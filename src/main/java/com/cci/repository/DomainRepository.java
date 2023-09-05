package com.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.cci.models.AbstractDomain;

import jakarta.transaction.Transactional;
import java.util.Date;

/**
 * We restrict access to minimize accidental usage of the built-in delete methods instead of overriding them with
 * our own implementations. The assumption here is that sub-classes should not be able to hard delete entities.
 * This is still incomplete and does not cover all cases i.e. other batch deletes etc.
 */
@NoRepositoryBean
public interface DomainRepository<T extends AbstractDomain, ID extends Long> extends JpaRepository<T, ID> {

    @Override
    default void deleteById(ID id) {
        throw new UnsupportedOperationException("Use softDelete() instead.");
    }

    @Override
    default void delete(T entity) {
        throw new UnsupportedOperationException("Use softDelete() instead.");
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Use softDelete() instead.");
    }

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException("Use softDelete() instead.");
    }

    @Transactional
    @Modifying
    @Query("UPDATE #{#entityName} x SET x.deletedAt = :date WHERE x.id = :id")
    int softDelete(@Param("id") Long id, @Param("date") Date date);

    default int softDelete(AbstractDomain entity) {
        return softDelete(entity.getId(), new Date());
    }
}