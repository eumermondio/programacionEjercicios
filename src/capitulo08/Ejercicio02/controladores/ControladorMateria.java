package capitulo08.Ejercicio02.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import capitulo08.Ejercicio02.ConnectionManager;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.vista.GestionCurso;

public class ControladorMateria extends ControladorGeneral {
	/**
	 * 
	 */
	public static Materia findPrimerMateria() {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from materia order by id limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	/**
	 * 
	 */
	public static Materia findSiguienteMateria(int idAnterior) {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from materia where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

//	/**
//	 * 
//	 */
//	public static int borrarMateria(int id) {
//		int rowAffected = 0;
//		Curso c = new Curso();
//		try {
//			Connection con = ConnectionManager.getConexion();
//			Statement s = con.createStatement();
//
//			ResultSet rs = s.executeQuery("select id from curso order by id limit 1");
//			// Menor id
//			if (rs.next()) {
//				if (id == rs.getInt(1)) {
//					ResultSet rs3 = s.executeQuery("select * from curso where id > " + id + " order by id asc limit 1");
//					if (rs3.next()) {
//						c.setId(rs3.getInt(1));
//						c.setDescripcion(rs3.getString(2));
//						GestionCurso.getInstance().mostrarCurso(c);
//					}
//				}
//			} else {
//				c.setId(0);
//				c.setDescripcion("0");
//				GestionCurso.getInstance().mostrarCurso(c);
//			}
//			ResultSet rs2 = s.executeQuery("select id from curso order by id desc limit 1");
//			// Mayor id
//			if (rs2.next()) {
//				if (id == rs2.getInt(1)) {
//					ResultSet rs4 = s
//							.executeQuery("select * from curso where id < " + id + " order by id desc limit 1");
//					if (rs4.next()) {
//						c.setId(rs4.getInt(1));
//						c.setDescripcion(rs4.getString(2));
//						GestionCurso.getInstance().mostrarCurso(c);
//					}
//				}
//			} else {
//				c.setId(0);
//				c.setDescripcion("0");
//				GestionCurso.getInstance().mostrarCurso(c);
//			}
//			rowAffected = s.executeUpdate("delete from curso where id = " + id + ";");
//			return rowAffected;
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
//					"Gestion de cursos", 0);
//		}
//		return rowAffected;
//	}
//
//	/**
//	 * 
//	 */
//	public static int actualizarMateria(Curso c) {
//		int rowAffected = 0;
//		int idMax = 0;
//		try {
//			Connection con = ConnectionManager.getConexion();
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("select max(id) from curso;");
//			if (rs.next()) {
//				idMax = (rs.getInt(1) + 1);
//			}
//			// si entra en este if quiere decir k voy a insertar
//			if (c.getId() == 0) {
//				rowAffected = s
//						.executeUpdate("insert into curso values(" + idMax + "," + "'" + c.getDescripcion() + "');");
//			} else {
//				// si entra en este else quiere decir k voy a actualizar
//				rowAffected = s.executeUpdate("update curso set descripcion = " + "'" + c.getDescripcion() + "'" + ";");
//			}
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null,
//					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(), "Gestion de cursos",
//					0);
//		}
//		return rowAffected;
//	}

	/**
	* 
	*/
	public static Materia findAnteriorMateria(int idSiguiente) {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from materia where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

	/**
	 * 
	 */
	public static Materia findUltimoMateria() {
		Materia m = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from materia order by id desc limit 1");
			if (rs.next()) {
				m = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("acronimo"),
						rs.getInt("curso_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

}
