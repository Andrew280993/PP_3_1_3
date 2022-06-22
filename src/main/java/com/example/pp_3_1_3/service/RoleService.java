package com.example.pp_3_1_3.service;

import com.example.pp_3_1_3.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String role);
    List<Role> getAllRoles();
    void saveRole(Role role);
}