package proiect;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ProiectController implements Initializable {
@FXML
private TableView<Abonat> tabela_Abonati;
@FXML
private Tab tab_Abonati;
@FXML
private Button buton_IncarcareAbonati;
@FXML
private TableColumn<Abonat, Integer> atribut_idAbonat;
@FXML
private TableColumn<Abonat, String> atribut_NumeA;
@FXML
private TableColumn<Abonat, String> atribut_PrenumeA;
@FXML
private TableColumn<Abonat, String> atribut_CNPA;
@FXML
private TableColumn<Abonat, String> atribut_AdresaA;
@FXML
private TextField inputNumeA;
@FXML
private TextField inputPrenumeA;
@FXML
private TextField inputCnpA;
@FXML
private TextField inputAdresaA;
@FXML
private TextField inputNumeAm;
@FXML
private TextField inputPrenumeAm;
@FXML
private TextField inputCnpAm;
@FXML
private TextField inputAdresaAm;
@FXML
private TableView<CompanieTelefonie> tabela_CompaniiTelefonie;
@FXML
private Tab tab_CompaniiTelefonie;
@FXML
private Button buton_IncarcareCompaniiTelefonie;
@FXML
private TableColumn<CompanieTelefonie, Integer> atribut_idCompanieTelefonieC;
@FXML
private TableColumn<CompanieTelefonie, String> atribut_numeC;
@FXML
private TableColumn<CompanieTelefonie, String> atribut_adresaSediuC;
@FXML
private TableColumn<CompanieTelefonie, String> atribut_telefonContactC;
@FXML
private TableColumn<CompanieTelefonie, String> atribut_emailContactC;
@FXML
private TextField inputDenumireC;
@FXML
private TextField inputAdresaSediuC;
@FXML
private TextField inputTelefonContactC;
@FXML
private TextField inputEmailContactC;
@FXML
private TextField inputDenumireCm;
@FXML
private TextField inputAdresaSediuCm;
@FXML
private TextField inputTelefonContactCm;
@FXML
private TextField inputEmailContactCm;
@FXML
private TableView<Abonamente> tabela_Abonamente;
@FXML
private Tab tab_Abonamente;
@FXML
private Button buton_IncarcareAbonamente;
@FXML
private TableColumn<Abonamente, Integer> atribut_idAbonament;
@FXML
private TableColumn<Abonamente, Integer> atribut_idAbonatAbonamente;
@FXML
private TableColumn<Abonamente, Integer> atribut_idCompanieTelefonieAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_NumeAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_PrenumeAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_CnpAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_AdresaAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_DenumireCompanieAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_AdresaSediuAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_TelefonContactAbonamente;
@FXML
private TableColumn<Abonamente, String> atribut_emailContactAbonamente;
@FXML
private ComboBox combobox_abonati;
@FXML
private ComboBox combobox_companiiTelefonie;
@FXML
private ComboBox combobox_abonatim;
@FXML
private ComboBox combobox_companiiTelefoniem;
public static int x;
private ObservableList<Abonat> dateAbonati;
private ObservableList<CompanieTelefonie> dateCompaniiTelefonie;
private ObservableList<Abonamente> dateAbonamente;
private DBOperations jb;
@Override
public void initialize(URL url, ResourceBundle rb) {
	jb = new DBOperations();
	if (combobox_abonati != null) {
		ObservableList<Integer> dateIdAbonati = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("abonati");
			while (rs.next()) {
				dateIdAbonati.add(rs.getInt("idAbonat"));
			}
			jb.disconnect();
			combobox_abonati.setItems(dateIdAbonati);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_abonatim != null) {
		ObservableList<Integer> dateIdAbonati = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("abonati");
			while (rs.next()) {
				dateIdAbonati.add(rs.getInt("idAbonat"));
			}
			jb.disconnect();
			combobox_abonatim.setItems(dateIdAbonati);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_companiiTelefonie != null) {
		ObservableList<Integer> dateIdCompanii = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("companie_telefonie");
			while (rs.next()) {
				dateIdCompanii.add(rs.getInt("idCompanieTelefonie"));
			}
			jb.disconnect();
			combobox_companiiTelefonie.setItems(dateIdCompanii);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	if (combobox_companiiTelefoniem != null) {
		ObservableList<Integer> dateIdCompanii = FXCollections.observableArrayList();
		try {
			jb.connect();
			ResultSet rs = jb.vedeTabel("companie_telefonie");
			while (rs.next()) {
				dateIdCompanii.add(rs.getInt("idCompanieTelefonie"));
			}
			jb.disconnect();
			combobox_companiiTelefoniem.setItems(dateIdCompanii);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
@FXML
private void incarcaAbonati(ActionEvent event) throws SQLException, Exception {
jb.connect();
dateAbonati = FXCollections.observableArrayList();
ResultSet rs = jb.vedeTabel("abonati");
while (rs.next()) {
dateAbonati.add(new Abonat(rs.getInt("idAbonat"), rs.getString("nume"), rs.getString("prenume"), rs.getString("cnp"), rs.getString("adresa")));
}
atribut_idAbonat.setCellValueFactory(new PropertyValueFactory<>("idAbonat"));
atribut_NumeA.setCellValueFactory(new PropertyValueFactory<>("nume"));
atribut_PrenumeA.setCellValueFactory(new PropertyValueFactory<>("prenume"));
atribut_CNPA.setCellValueFactory(new PropertyValueFactory<>("cnp"));
atribut_AdresaA.setCellValueFactory(new PropertyValueFactory<>("adresa"));
tabela_Abonati.setItems(null);
tabela_Abonati.setItems(dateAbonati);
jb.disconnect();
}
@FXML
private void startAdaugaAbonat() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaAbonat.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaAbonat() throws SQLException, Exception {
	String nume = inputNumeA.getText();
	String prenume = inputPrenumeA.getText();
	String CNP = inputCnpA.getText();
	String adresa = inputAdresaA.getText();
	
	jb.connect();
	jb.adaugaAbonat(nume, prenume , CNP , adresa);
	jb.disconnect();
}

@FXML
private void incarcaCompaniiTelefonie(ActionEvent event) throws SQLException, Exception {
jb.connect();
dateCompaniiTelefonie = FXCollections.observableArrayList();
ResultSet rs = jb.vedeTabel("companie_telefonie");
while (rs.next()) {
dateCompaniiTelefonie.add(new CompanieTelefonie(rs.getInt("idCompanieTelefonie"), rs.getString("nume"), rs.getString("adresaSediu"), rs.getString("telefonContact"), rs.getString("emailContact")));
}
atribut_idCompanieTelefonieC.setCellValueFactory(new PropertyValueFactory<>("idCompanieTelefonie"));
atribut_numeC.setCellValueFactory(new PropertyValueFactory<>("nume"));
atribut_adresaSediuC.setCellValueFactory(new PropertyValueFactory<>("adresaSediu"));
atribut_telefonContactC.setCellValueFactory(new PropertyValueFactory<>("telefonContact"));
atribut_emailContactC.setCellValueFactory(new PropertyValueFactory<>("emailContact"));
tabela_CompaniiTelefonie.setItems(null);
tabela_CompaniiTelefonie.setItems(dateCompaniiTelefonie);
jb.disconnect();
}

@FXML
private void startAdaugaCompanieTelefonie() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaCompanieTelefonie.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaCompanieTelefonie() throws SQLException, Exception {
	String denumire = inputDenumireC.getText();
	String adresaSediu = inputAdresaSediuC.getText();
	String telefonContact = inputTelefonContactC.getText();
	String emailContact = inputEmailContactC.getText();
	
	jb.connect();
	jb.adaugaCompanieTelefonie(denumire, adresaSediu, telefonContact, emailContact);
	jb.disconnect();
}

@FXML
private void incarcaAbonamente(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	dateAbonamente = FXCollections.observableArrayList();
	ResultSet rs = jb.vedeAbonament();
	while (rs.next()) {
		dateAbonamente.add(new Abonamente(rs.getInt("idAbonament"), rs.getInt("idAbonat_rep"), rs.getInt("idCompanieTelefonie_rep"), rs.getString("nume") ,rs.getString("prenume"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("denumireCompanie"),rs.getString("adresaSediu"),rs.getString("telefonContact"), rs.getString("emailContact")));
	}
	
	atribut_idAbonament.setCellValueFactory(new PropertyValueFactory<>("idAbonament"));
	atribut_idAbonatAbonamente.setCellValueFactory(new PropertyValueFactory<>("idAbonat"));
	atribut_idCompanieTelefonieAbonamente.setCellValueFactory(new PropertyValueFactory<>("idCompanieTelefonie"));
	atribut_NumeAbonamente.setCellValueFactory(new PropertyValueFactory<>("nume"));
	atribut_PrenumeAbonamente.setCellValueFactory(new PropertyValueFactory<>("prenume"));
	atribut_CnpAbonamente.setCellValueFactory(new PropertyValueFactory<>("cnp"));
	atribut_AdresaAbonamente.setCellValueFactory(new PropertyValueFactory<>("adresa"));
	atribut_DenumireCompanieAbonamente.setCellValueFactory(new PropertyValueFactory<>("denumireCompanie"));
	atribut_AdresaSediuAbonamente.setCellValueFactory(new PropertyValueFactory<>("adresaSediu"));
	atribut_TelefonContactAbonamente.setCellValueFactory(new PropertyValueFactory<>("telefonContact"));
	atribut_emailContactAbonamente.setCellValueFactory(new PropertyValueFactory<>("emailContact"));
	tabela_Abonamente.setItems(null);
	tabela_Abonamente.setItems(dateAbonamente);
	
	jb.disconnect();
}

@FXML
private void startAdaugaAbonament() throws IOException {
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaAbonament.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

@FXML
private void adaugaAbonament() throws SQLException, Exception {
	Integer idAbonat = (Integer) combobox_abonati.getValue();
	Integer idCompanieTelefonie = (Integer) combobox_companiiTelefonie.getValue();
	
	jb.connect();
	jb.adaugaAbonament(idAbonat, idCompanieTelefonie);
	jb.disconnect();
}
@FXML
private void stergeAbonat(ActionEvent event) throws SQLException, Exception {
jb.connect();
Abonat abonat = tabela_Abonati.getSelectionModel().getSelectedItem();
if (abonat != null) {
jb.stergeTabela("abonati", "idAbonat",abonat.getIdAbonat());
} else {
System.out.println("Nu s-a putut face stergerea abonatului!");
}
incarcaAbonati(event);
jb.disconnect();
}
@FXML
private void startModificaAbonat() throws IOException {
	Abonat abonat = tabela_Abonati.getSelectionModel().getSelectedItem();
	
	if(abonat!=null)
	{
		x=abonat.getIdAbonat();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaAbonat.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea abonatului!");
	}
}
@FXML
private void modificaAbonat(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {inputNumeAm.getText(), inputPrenumeAm.getText(), inputCnpAm.getText(), inputAdresaAm.getText()};
		String[] campuri = {"nume", "prenume","cnp", "adresa"};
		jb.modificaTabela("abonati", "idAbonat",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}

@FXML
private void stergeCompanieTelefonie(ActionEvent event) throws SQLException, Exception {
jb.connect();
CompanieTelefonie companie = tabela_CompaniiTelefonie.getSelectionModel().getSelectedItem();
if (companie != null) {
jb.stergeTabela("companie_telefonie", "idCompanieTelefonie",companie.getIdCompanieTelefonie());
} else {
System.out.println("Nu s-a putut face stergerea companiei de telefonie!");
}
incarcaCompaniiTelefonie(event);
jb.disconnect();
}
@FXML
private void startModificaCompanieTelefonie() throws IOException {
	CompanieTelefonie companie = tabela_CompaniiTelefonie.getSelectionModel().getSelectedItem();
	
	if(companie!=null)
	{
		x=companie.getIdCompanieTelefonie();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaCompanieTelefonie.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea companiei de telefonie!");
	}
}
@FXML
private void modificaCompanieTelefonie(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {inputDenumireCm.getText(), inputAdresaSediuCm.getText(), inputTelefonContactCm.getText(), inputEmailContactCm.getText()};
		String[] campuri = {"nume", "adresaSediu", "telefonContact", "emailContact"};
		jb.modificaTabela("companie_telefonie", "idCompanieTelefonie",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}
@FXML
private void stergeAbonament(ActionEvent event) throws SQLException, Exception {
jb.connect();
Abonamente abonamente = tabela_Abonamente.getSelectionModel().getSelectedItem();
if (abonamente != null) {
jb.stergeTabela("abonamente", "idAbonament",abonamente.getIdAbonament());
} else {
System.out.println("Nu s-a putut face stergerea abonamentului!");
}
incarcaAbonamente(event);
jb.disconnect();
}
@FXML
private void startModificaAbonament() throws IOException {
	Abonamente abonamente = tabela_Abonamente.getSelectionModel().getSelectedItem();
	
	if(abonamente!=null)
	{
		x=abonamente.getIdAbonament();
	Stage stage = new Stage();
	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaAbonament.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}else {
	System.out.println("Nu s-a putut face modificarea abonamentului!");
	}
}
@FXML
private void modificaAbonament(ActionEvent event) throws SQLException, Exception {
	try {
		
		jb.connect();
		String[] valori = {String.valueOf(combobox_abonatim.getValue()),String.valueOf(combobox_companiiTelefoniem.getValue())}; 
		String[] campuri = {"idAbonat", "idCompanieTelefonie"};
		jb.modificaTabela("abonamente", "idAbonament",x ,campuri, valori);
		jb.disconnect();
		} catch(Exception e) {
		System.out.println("Error!");
		return;
		}
		jb.disconnect();
		}
}