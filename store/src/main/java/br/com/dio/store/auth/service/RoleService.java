package br.com.dio.store.auth.service;

import java.util.List;

import br.com.dio.store.auth.entity.Role;
import br.com.dio.store.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public Role save(Role Role) {
		return repository.save(Role);
	}

	public Role findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Role> findAll() {
		return repository.findAll();
	}
}
