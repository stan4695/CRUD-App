package proiect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	String error;
	Connection con;
	// Conectarea la baza de date
	public DBOperations() {
	}
	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abonamentedb?useSSL=false", "root", "enter_databasepassword");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()
	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `abonamentedb`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	// end vedeTabel()
	public ResultSet vedeAbonament() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select a.nume, a.prenume , a.cnp, a.adresa, b.nume denumireCompanie , b.adresaSediu, b.telefonContact, b.emailContact, c.idAbonament, c.idAbonat idAbonat_rep, c.idCompanieTelefonie idCompanieTelefonie_rep from abonati a, companie_telefonie b, abonamente c where a.idAbonat = c.idAbonat and b.idCompanieTelefonie = c.idCompanieTelefonie;");
					Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY*/);
					rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;}
	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()
	public void adaugaAbonat(String nume, String prenume, String cnp, String adresa) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `abonamentedb`.`abonati`(nume, prenume, cnp, adresa) values('" + nume + "', '" + prenume +
					"', '" + cnp + "', '" + adresa + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	// end adaugaClient()
	public void adaugaCompanieTelefonie(String denumire, String adresaSediu, String telefonContact, String emailContact) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `abonamentedb`.`companie_telefonie`(nume, adresaSediu, telefonContact, emailContact) values('" + denumire + "', '" + adresaSediu + "', '" + telefonContact + "', '" + emailContact + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaAbonament(int idAbonat, int idCompanieTelefonie)
			throws SQLException, Exception {
		if (con != null) {
			try {
				//creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into abonamente(idAbonat, idCompanieTelefonie) values('"+ idAbonat + "'  , '" + idCompanieTelefonie + "');");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} 
	public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		if (con != null) {
			try {
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()
	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()
	

	public ResultSet intoarceLinie(String tabela, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			//Executa interogarea
			String queryString = ("SELECT * FROM " + tabela + " where idAbonat=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); // sql exception
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // end of intoarceLinie()

	public ResultSet intoarceLinieDupaId(String tabela, String denumireId, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			//Executa interogarea
			String queryString = ("SELECT * FROM " + tabela + " where " + denumireId + "=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); // sql exception
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // end of intoarceLinieDupaId()

	public ResultSet intoarceRepartizareId(int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			//Executa interogarea
			String queryString = ("SELECT a.nume , a.prenume, a.cnp, a.adresa, b.nume denumireCompanie, b.adresaSediu, b.telefonContact, b.emailContact, c.idAbonament, c.idCompanieTelefonie idCompanieTelefonie_rep, c.idAbonat idAbonat_rep FROM abonati a, companie_telefonie b, abonamente c WHERE a.idAbonat = c.idAbonat AND b.idCompanieTelefonie = c.idCompanieTelefonie and idAbonament = '" +ID + "';");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); // sql exception
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // end of intoarceLinieDupaId()
}
