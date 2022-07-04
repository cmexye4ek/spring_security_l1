package ru.gb.spring_security_l1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_security_l1.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
