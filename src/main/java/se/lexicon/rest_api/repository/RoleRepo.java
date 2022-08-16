package se.lexicon.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.rest_api.model.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, Integer> {

    List<Role> findAll();

    Optional<Role> findByName(String name);

}
