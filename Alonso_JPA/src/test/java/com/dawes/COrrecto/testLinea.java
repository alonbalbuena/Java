package com.dawes.COrrecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dawes.util.MySQLFactory;

class testLinea {

	@BeforeAll
	static void setUpBeforeClass(){
		MySQLFactory.getDAO();
	}

	@Test
	void testInsertar() {
		fail("Not yet implemented");
	}

}
