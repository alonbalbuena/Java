package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.PostCategoriaVO;
@Repository

public interface PostCategoryDAO extends CrudRepository<PostCategoriaVO, Integer> {

}
