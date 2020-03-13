 package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.dao.PostDAO;
import com.dawes.modelo.PostVO;
import com.dawes.servicios.PostServicios;
@Service
public class PostServiciosImpl implements PostServicios {

	@Autowired
	PostDAO pd;

	@Override
	public <S extends PostVO> S save(S entity) {
		return pd.save(entity);
	}

	@Override
	public Optional<PostVO> findById(Integer id) {
		return pd.findById(id);
	}

	@Override
	public Iterable<PostVO> findAll() {
		return pd.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		pd.deleteById(id);
	}

	@Override
	public void delete(PostVO entity) {
		pd.delete(entity);
	}

	@Override
	public void deleteAll() {
		pd.deleteAll();
	}

	@Override
	public PostVO findByTitle(String title) {
		return pd.findByTitle(title);
	}
	
	
}
