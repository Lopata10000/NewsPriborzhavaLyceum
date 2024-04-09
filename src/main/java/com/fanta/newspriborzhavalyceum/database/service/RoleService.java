package com.fanta.newspriborzhavalyceum.database.service;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanta.newspriborzhavalyceum.database.entity.Role;
import com.fanta.newspriborzhavalyceum.database.repository.RoleRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    public Role updateRole(Role role) {
        return roleRepository.findById(role.getId())
                .map(existingRole -> {
                    existingRole.setName(role.getName());
                    // Додаткові оновлення, якщо необхідно
                    return roleRepository.save(existingRole);
                })
                .orElseThrow(() -> new EntityNotFoundException("Role with id " + role.getId() + " not found"));
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}

