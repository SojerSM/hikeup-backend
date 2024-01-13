package com.hikeup.backend.app.accounting.core.controller;

import com.hikeup.backend.app.accounting.api.RoleService;
import com.hikeup.backend.app.accounting.core.model.dto.RoleResponseDTO;
import com.hikeup.backend.app.accounting.core.service.RoleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
@RestController
@RequestMapping("/hikeup/api/v1/existingRoles")
public class ExistingRolesController {

    private final RoleService roleService;

    public ExistingRolesController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleResponseDTO> findAll() {
        return roleService.findAll();
    }
}
