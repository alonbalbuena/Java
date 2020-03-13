package proyectoexamen;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.ServicioImpl.ServicioFincasImpl;
import com.dawes.ServicioImpl.ServicioFincasTratamientoImpl;
import com.dawes.ServicioImpl.ServicioTratamientoImpl;
import com.dawes.modelos.FincasTratamientoVO;
import com.dawes.modelos.FincasVO;
import com.dawes.modelos.TratamientoVO;

public class TestConexion {
	
	private static ServicioFincasImpl servicioFinca;
	private static ServicioTratamientoImpl servicioTratamiento;
	private static ServicioFincasTratamientoImpl ServicioRelacion;

	@BeforeClass
	public static void antes() {
		servicioFinca = new ServicioFincasImpl();
		
		servicioTratamiento = new ServicioTratamientoImpl();
		
		ServicioRelacion = new ServicioFincasTratamientoImpl();
	}
	
	@Test
	public void t1insertar() {
		assertEquals(1, servicioFinca.insertar(new FincasVO("siero", new ArrayList<FincasTratamientoVO>())));
	}
	@Test
	public void t2borrar() {
		assertEquals(1, servicioFinca.borrar(new FincasVO("siero", new ArrayList<FincasTratamientoVO>())));
	}
	
	
	@Test
	public void t3insertarTratamiento() {
		assertEquals(1, servicioTratamiento.insertar(new TratamientoVO("matatopos","altaaaa",new ArrayList<FincasTratamientoVO>())));
	}
	
	@Test
	public void t4insertarRelacion() {
		FincasVO finca = new FincasVO(78,"siero", new ArrayList<FincasTratamientoVO>());
		TratamientoVO tratamiento = new TratamientoVO(78,"matatopos","altaaaa",new ArrayList<FincasTratamientoVO>());
		
		FincasTratamientoVO relacion = new FincasTratamientoVO(LocalDate.now(), finca, tratamiento);
		assertEquals(1, ServicioRelacion.insertar(relacion));
	}
}
