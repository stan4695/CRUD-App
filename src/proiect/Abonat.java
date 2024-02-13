package proiect;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Abonat {
private final IntegerProperty idAbonat;
private final StringProperty nume;
private final StringProperty prenume;
private final StringProperty cnp;
private final StringProperty adresa;
public Abonat(Integer idAbonat, String nume, String prenume, String cnp, String adresa) {
this.idAbonat = new SimpleIntegerProperty(idAbonat);
this.nume = new SimpleStringProperty(nume);
this.prenume = new SimpleStringProperty(prenume);
this.cnp = new SimpleStringProperty(cnp);
this.adresa = new SimpleStringProperty(adresa);
}
public Integer getIdAbonat() {
return idAbonat.get();
}
public String getNume() {
return nume.get();
}
public String getPrenume() {
return prenume.get();
}
public String getCnp() {
return cnp.get();
}
public String getAdresa() {
return adresa.get();
}
public void setIdAbonat(Integer valoare) {
idAbonat.set(valoare);
}
public void setNume(String valoare) {
nume.set(valoare);
}
public void setPrenume(String valoare) {
prenume.set(valoare);
}
public void setCnp(String valoare) {
cnp.set(valoare);
}
public void setAdresa(String valoare) {
adresa.set(valoare);
}
public IntegerProperty idAbonatProperty() {
return idAbonat;
}
public StringProperty NumeProperty() {
return nume;
}
public StringProperty PrenumeProperty() {
return prenume;
}
public StringProperty CnpProperty() {
return cnp;
}
public StringProperty adresaProperty() {
return adresa;
}
}
