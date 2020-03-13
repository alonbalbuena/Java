package com.dawes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioUsuarioImpl;

@SpringBootTest
class ProyectoBocetoSpringApplicationTests {
	
	@Autowired
	ServicioUsuarioImpl sa;
	
	@BeforeAll
	public static void antes() {
		Persistence.generateSchema("jpa", null);
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test() {
		assertNotNull(sa);
	}

	@Test
	public void insertar() {
		sa.save(new UsuarioVO("alonso", "alonso@alonso", "pass", LocalDate.now(), "tipo 1", "src/ruta/foto.jpg"));
		assertEquals(sa.findByNombre("alonso").getUsuarioNombre(),"alonso");
	}
}
