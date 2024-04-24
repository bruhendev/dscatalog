package com.bruno.dscatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dscatalog.dto.CategoryDTO;
import com.bruno.dscatalog.entities.Category;
import com.bruno.dscatalog.repositories.CategoryRepository;
import com.bruno.dscatalog.services.exceptions.EntityNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		List<CategoryDTO> listDto = list.stream().map(x -> new CategoryDTO(x)).toList();
		return listDto;
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity =  repository.save(entity);
		return new CategoryDTO(entity);
	}
}
