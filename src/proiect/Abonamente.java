package proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Abonamente {
	private final IntegerProperty idAbonament;
	private final IntegerProperty idAbonat;
	private final IntegerProperty idCompanieTelefonie;
	private final StringProperty nume;
	private final StringProperty prenume;
	private final StringProperty cnp;
	private final StringProperty adresa;
	private final StringProperty denumireCompanie;
	private final StringProperty adresaSediu;
	private final StringProperty telefonContact;
	private final StringProperty emailContact;
	
	public Abonamente(int idAbonament, int idAbonat, int idCompanieTelefonie,String nume, String prenume, String cnp, String adresa,String denumireCompanie, String adresaSediu, String telefonContact, String emailContact) {
		this.idAbonament = new SimpleIntegerProperty(idAbonament);
		this.idAbonat = new SimpleIntegerProperty(idAbonat);
		this.idCompanieTelefonie = new SimpleIntegerProperty(idCompanieTelefonie);
		this.nume = new SimpleStringProperty(nume);
		this.prenume = new SimpleStringProperty(prenume);
		this.cnp = new SimpleStringProperty(cnp);
		this.adresa = new SimpleStringProperty(adresa);
		this.denumireCompanie = new SimpleStringProperty(denumireCompanie);
		this.adresaSediu = new SimpleStringProperty(adresaSediu);
		this.telefonContact = new SimpleStringProperty(telefonContact);
		this.emailContact = new SimpleStringProperty(emailContact);
	}
	
	public Integer getIdAbonament() {
		return idAbonament.get();
	}
	
	
	public Integer getIdAbonat() {
		return idAbonat.get();
	}
	
	public Integer getIdCompanieTelefonie() {
		return idCompanieTelefonie.get();
	}

	public void setIdAbonament(Integer valoare) {
		idAbonament.set(valoare);
	}
	
	public void setIdAbonat(Integer valoare) {
		idAbonat.set(valoare);
	}

	public void setIdCompanieTelefonie(Integer valoare) {
		idCompanieTelefonie.set(valoare);
	}

	public IntegerProperty idAbonamentProperty() {
		return idAbonament;
	}
	
	public IntegerProperty idAbonatProperty() {
		return idAbonat;
	}
	public IntegerProperty idCompanieTelefonieProperty() {
		return idCompanieTelefonie;
	}
	public StringProperty numeProperty() {
		return nume;
	}
	public StringProperty prenumeProperty() {
		return prenume;
	}
	public StringProperty cnpProperty() {
		return cnp;
	}
	public StringProperty adresaProperty() {
		return adresa;
	}
	public StringProperty denumireCompanieProperty() {
		return denumireCompanie;
	}
	public StringProperty adresaSediuProperty() {
		return adresaSediu;
	}
	public StringProperty telefonContactProperty() {
		return telefonContact;
	}
	public StringProperty emailContactProperty() {
		return emailContact;
	}
}
