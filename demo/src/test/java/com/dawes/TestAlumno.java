package com.dawes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dawes.modelo.AlumnoVO;
import com.dawes.servicios.ServicioAlumnoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestAlumno {

	@Autowired
	ServicioAlumnoImpl sa;
	
	@BeforeClass
	public static void antes() {
		Persistence.generateSchema("jpa", null);
	}
	
	@Test
	public void test() {
		assertNotNull(sa);
	}

	@Test
	public void insertar() {
		sa.save(new AlumnoVO("alonso", LocalDate.now()));
		assertEquals(sa.findByNombre("alonso").getNombre(),"alonso" );
	}
}
