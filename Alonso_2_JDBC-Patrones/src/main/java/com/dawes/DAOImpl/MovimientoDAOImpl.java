package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.MovimientoDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.util.MySqlDAOFactory;

public class MovimientoDAOImpl implements MovimientoDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MovimientoDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(MovimientoVO movimiento) {
		try {
			//si en constructor no le ponemos un id haremos uso del autoincrementado
			ps = conexion.prepareStatement("INSERT INTO movimientos(fecha,tipo,importe,idCuentas) VALUES (?,?,?,?)");
			
			if(movimiento.getIdMovimiento() != 0) {
				//si le introducimos el id NO haremos uso del autoincrementado
				ps = conexion.prepareStatement("INSERT INTO movimientos(fecha,tipo,importe,idCuentas,idMovimientos) VALUES (?,?,?,?,?)");
				ps.setInt(5,movimiento.getIdMovimiento());
			}
			
			ps.setObject(1, movimiento.getFecha());
			ps.setString(2, movimiento.getTipo());
			ps.setDouble(3, movimiento.getImporte());
			ps.setInt(4, movimiento.getCuenta().getIdCuenta());
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int eliminar(MovimientoVO movimiento) {
		try {
			ps = conexion.prepareStatement("DELETE FROM movimientos WHERE idMovimientos = ?");
			ps.setInt(1,movimiento.getIdMovimiento());
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminar(int idMovimiento) {
		//usamos el metodo eliminar con un objeto vacio, para no repetir codigo
		return eliminar(new MovimientoVO(idMovimiento,null, null, 0, null));
	}

	public int modificar(MovimientoVO movimientoModificado) {
		try {
			//busco primero la movimiento que deseo modificar (para sacar el ID)
			MovimientoVO movimientoAModificar = leerIgual(movimientoModificado.getIdMovimiento());
			
			ps = conexion.prepareStatement("UPDATE movimientos SET fecha = ?, tipo = ?, importe = ? WHERE idMovimientos = ?");
			ps.setObject(1, movimientoModificado.getFecha());
			ps.setString(2, movimientoModificado.getTipo());
			ps.setDouble(3, movimientoModificado.getImporte());
			
			ps.setInt(4, movimientoAModificar.getIdMovimiento());
			
			ps.executeUpdate();	
			return 1;
		} catch (SQLException e) {			
			e.printStackTrace();
			return 0;
		}
	}

	public MovimientoVO leerIgual(int idMovimiento) {
		MovimientoVO movimiento = null;
		try {
			ps = conexion.prepareStatement("SELECT * FROM movimientos WHERE idMovimientos = ?");
			ps.setInt(1, idMovimiento);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				movimiento = new MovimientoVO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getString(3),rs.getDouble(4),(CuentaVO) rs.getObject(5));
			}
			return movimiento;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<MovimientoVO> leerTodos() {
		Set<MovimientoVO> movimientos = new HashSet<MovimientoVO>();
		try {
			ps = conexion.prepareStatement("SELECT * FROM movimientos");
			rs = ps.executeQuery();
			while (rs.next()) {
				MovimientoVO movimiento = new MovimientoVO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getString(3),rs.getDouble(4), null);

				//1creamos una conexion con la BBDD
				MySqlDAOFactory dao = MySqlDAOFactory.getDAO();
				//2buscamos la cuenta a la que enlaza
				//3Le asignamos esa cuenta al movimiento
				movimiento.setCuenta(dao.getCuentasRepositorioJDBC().leerIgual(rs.getInt(5)));
				
				movimientos.add(movimiento);
			}
			return movimientos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
