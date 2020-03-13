package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.dao.UsuarioDAO;
import com.dawes.modelo.UsuarioVO;

//para que Spring sepa que hay que inyectarle el entitymanager
//(igual que como haciamos nosotros)
@Service
public class ServicioUsuarioImpl {
	
	//1- queremos que se autoinstancie el dao
		@Autowired
		UsuarioDAO ar;

	//2- genereamos los metodos delegados	
		
		//generamos el creado por nosotros en el DAO
		public UsuarioVO findByNombre(String nombre) {
			return ar.findByNombre(nombre);
		}

		//y los que estan por defecto en Spring
		public <S extends UsuarioVO> S save(S entity) {
			return ar.save(entity);
		}

		public Optional<UsuarioVO> findById(Integer id) {
			return ar.findById(id);
		}

		public void delete(UsuarioVO entity) {
			ar.delete(entity);
		}
	
		
		
}
