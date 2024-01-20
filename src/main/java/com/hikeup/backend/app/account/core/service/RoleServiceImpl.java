package com.hikeup.backend.app.account.core.service;

import com.hikeup.backend.app.account.api.RoleService;
import com.hikeup.backend.app.account.core.model.mapper.RoleMapper;
import com.hikeup.backend.app.account.core.model.dto.RoleResponseDTO;
import com.hikeup.backend.app.account.core.repository.RoleRepository;
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
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository,
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
