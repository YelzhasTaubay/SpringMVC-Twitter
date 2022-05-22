package kz.bitlab.project.dao;

import kz.bitlab.project.entities.Roles;

import java.util.List;

public interface RoleDAO {

    Roles getRole(String role);

    List<Roles> getAllRoles();

}
