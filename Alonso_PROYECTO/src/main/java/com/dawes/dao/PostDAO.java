package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.PostVO;

//a la interfaz CRUDREPOSITORY le pasamos la clase que vamos a usar y el tipo del id 
@Repository
public interface PostDAO extends CrudRepository<PostVO, Integer> {
	PostVO findByTitle(String title);
}
