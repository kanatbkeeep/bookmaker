package com.example.bookmaker.repository;

import com.example.bookmaker.entity.Privilege;
import com.example.bookmaker.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
