package com.cci.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

import com.cci.models.User;

public interface UserRepository extends DomainRepository<User, Long> {
	@EntityGraph(attributePaths = {"tasks"})
	Optional<User> findById(long id);
}
