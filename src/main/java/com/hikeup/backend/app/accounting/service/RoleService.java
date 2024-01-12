package com.hikeup.backend.app.accounting.service;

import com.hikeup.backend.app.accounting.model.mapper.RoleMapper;
import com.hikeup.backend.app.accounting.model.dto.RoleResponseDTO;
import com.hikeup.backend.app.accounting.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: hikeup-backend
 *
 * @author : sojer
 * @since : 11.01.2024
 **/
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository,
                       RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleResponseDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::map)
                .collect(Collectors.toList());
    }
}
