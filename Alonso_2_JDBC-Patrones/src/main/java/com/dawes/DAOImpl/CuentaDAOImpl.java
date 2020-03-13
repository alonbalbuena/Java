package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.CuentaDAO;
import com.dawes.modelo.CuentaVO;

public class CuentaDAOImpl implements CuentaDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;

	public CuentaDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(CuentaVO cuenta) {
		try {
			//si en constructor no le ponemos un id haremos uso del autoincrementado
			ps = conexion.prepareStatement("INSERT INTO cuentas(numCuenta,saldo,fecha) VALUES (?,?,?)");
			
			if(cuenta.getIdCuenta() != 0) {
				//si le introducimos el id NO haremos uso del autoincrementado
				ps = conexion.prepareStatement("INSERT INTO cuentas(numCuenta,saldo,fecha,idCuentas) VALUES (?,?,?,?) ");			
				ps.setInt(4,cuenta.getIdCuenta());
			}
			
			ps.setString(1, cuenta.getNumCuenta());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setObject(3, cuenta.getFecha());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int eliminar(CuentaVO cuenta) {
		try {
			ps = conexion.prepareStatement("DELETE FROM cuentas WHERE numCuenta=?");
			ps.setString(1, cuenta.getNumCuenta());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int eliminar(int idCuenta) {
		//usamos el metodo eliminar con un objeto vacio, para no repetir codigo
		return eliminar(new CuentaVO(idCuenta, null, 0, null));
	}

	public int modificar(CuentaVO cuentaModificada) {
		try {
			//busco primero la cuenta que deseo modificar (para sacar el ID)
			//ya que al ser autoincrementado no lo tengo a mano
			CuentaVO cuentaAModificar = leerIgual(cuentaModificada.getNumCuenta());
			
			ps = conexion.prepareStatement("UPDATE cuentas SET numCuenta = ?, saldo = ?, fecha = ? WHERE idCuentas = ?");
			ps.setString(1, cuentaModificada.getNumCuenta());
			ps.setDouble(2, cuentaModificada.getSaldo());
			ps.setObject(3, cuentaModificada.getFecha());
			ps.setInt(4, cuentaAModificar.getIdCuenta());
			
			ps.executeUpdate();	
			return 1;
		} catch (SQLException e) {			
			e.printStackTrace();
			return 0;
		}
	}
	public CuentaVO leerIgual(String numCuenta) {
		CuentaVO cuenta = null;
		try {
			ps = conexion.prepareStatement("SELECT * FROM cuentas WHERE numCuenta = ?");
			ps.setString(1, numCuenta);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				//cuenta = new Cuentas(rs.getString(2), rs.getDouble(3), (LocalDate) rs.getObject(4));
				cuenta = new CuentaVO(rs.getString(2), rs.getDouble(3),  rs.getDate(4).toLocalDate());
			}
			return cuenta;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<CuentaVO> leerTodos() {
		Set<CuentaVO> cuentas = new HashSet<CuentaVO>();
		try {
			ps = conexion.prepareStatement("SELECT * FROM cuentas");
			rs = ps.executeQuery();
			while (rs.next()) {
				//no deja casting de object para localdate
				cuentas.add(new CuentaVO(rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate()));
			}
			return cuentas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public CuentaVO leerIgual(int idCuenta) {
		CuentaVO cuenta = null;
		try {
			ps = conexion.prepareStatement("SELECT * FROM cuentas WHERE idCuentas = ?");
			ps.setInt(1, idCuenta);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				//cuenta = new Cuentas(rs.getString(2), rs.getDouble(3), (LocalDate) rs.getObject(4));
				cuenta = new CuentaVO(rs.getInt(1),rs.getString(2), rs.getDouble(3),  rs.getDate(4).toLocalDate());
			}
			return cuenta;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
