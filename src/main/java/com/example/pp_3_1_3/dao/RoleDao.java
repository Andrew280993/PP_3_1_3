package com.example.pp_3_1_3.dao;

import com.example.pp_3_1_3.model.Role;

import java.util.List;

public interface RoleDao {
    Role findByName(String role);
    List<Role> getAllRoles();
    void saveRole(Role role);
}
