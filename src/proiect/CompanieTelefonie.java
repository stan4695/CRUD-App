package proiect;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class CompanieTelefonie {
private final IntegerProperty idCompanieTelefonie;
private final StringProperty nume;
private final StringProperty adresaSediu;
private final StringProperty telefonContact;
private final StringProperty emailContact;
public CompanieTelefonie(Integer idCompanieTelefonie, String nume, String adresaSediu, String telefonContact, String emailContact) {
this.idCompanieTelefonie = new SimpleIntegerProperty(idCompanieTelefonie);
this.nume = new SimpleStringProperty(nume);
this.adresaSediu = new SimpleStringProperty(adresaSediu);
this.telefonContact = new SimpleStringProperty(telefonContact);
this.emailContact = new SimpleStringProperty(emailContact);
}
public Integer getIdCompanieTelefonie() {
return idCompanieTelefonie.get();
}
public String getNume() {
return nume.get();
}
public String getAdresaSediu() {
return adresaSediu.get();
}
public String getTelefonContact() {
return telefonContact.get();
}
public String getEmailContact() {
return emailContact.get();
}
public void setIdCompanieTelefonie(Integer valoare) {
	idCompanieTelefonie.set(valoare);
}
public void setNume(String valoare) {
	nume.set(valoare);
}
public void setAdresaSediu(String valoare) {
	adresaSediu.set(valoare);
}
public void setTelefonContact(String valoare) {
	telefonContact.set(valoare);
}
public void setEmailContact(String valoare) {
	emailContact.set(valoare);
}
public IntegerProperty idCompanieTelefonieProperty() {
return idCompanieTelefonie;
}
public StringProperty numeProperty() {
return nume;
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