/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_inventaris_barang;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> list1 = FXCollections.observableArrayList("Makanan","Minuman","Snack");
    ObservableList<String> list2 = FXCollections.observableArrayList("Kardus","Plastik","Box");

    @FXML
    private JFXTextField Kode;
    @FXML
    private JFXComboBox<String> Kategori;
    @FXML
    private TextField Harga;
    @FXML
    private TextField Nama;
    @FXML
    private JFXComboBox<String> Packaging;
    @FXML
    private JFXButton Simpan;
    @FXML
    private JFXButton Hapus;
    @FXML
    private JFXButton Bersih;
    @FXML
    private JFXButton Keluar;
    @FXML
    private TableView<Data> tabel1;
    @FXML
    private TableColumn<Data, String> col_kode;
    @FXML
    private TableColumn<Data, String> col_name;
    @FXML
    private TableColumn<Data, String> col_kat;
    @FXML
    private TableColumn<Data, String> col_pack;
     @FXML
    private TableColumn<Data, String> col_harga;
     
    public void changeKodeCellEvent(CellEditEvent edditedCell){
          Data dataSelected = tabel1.getSelectionModel().getSelectedItem();
          dataSelected.setKode(edditedCell.getNewValue().toString());
    }
    public void changeNamaCellEvent(CellEditEvent edditedCell){
          Data dataSelected = tabel1.getSelectionModel().getSelectedItem();
          dataSelected.setKode(edditedCell.getNewValue().toString());
    }
    public void changeKategoriCellEvent(CellEditEvent edditedCell){
          Data dataSelected = tabel1.getSelectionModel().getSelectedItem();
          dataSelected.setKode(edditedCell.getNewValue().toString());
    }
    public void changePackagingCellEvent(CellEditEvent edditedCell){
          Data dataSelected = tabel1.getSelectionModel().getSelectedItem();
          dataSelected.setKode(edditedCell.getNewValue().toString());
    }
    public void changeHargaCellEvent(CellEditEvent edditedCell){
          Data dataSelected = tabel1.getSelectionModel().getSelectedItem();
          dataSelected.setKode(edditedCell.getNewValue().toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Kategori.setValue("Makanan");
         Kategori.setItems(list1);
         
         Packaging.setValue("Kardus");
         Packaging.setItems(list2);
         
         //setup column
         col_kode.setCellValueFactory(new PropertyValueFactory<Data, String>("Kode"));
         col_name.setCellValueFactory(new PropertyValueFactory<Data, String>("Nama"));
         col_kat.setCellValueFactory(new PropertyValueFactory<Data, String>("Kategori"));
         col_pack.setCellValueFactory(new PropertyValueFactory<Data, String>("Packaging"));
         col_harga.setCellValueFactory(new PropertyValueFactory<Data, String>("Harga"));
         
        //dummy data 
         tabel1.setItems(getPeople());
        //update data in column 
         tabel1.setEditable(true);
         col_kode.setCellFactory(TextFieldTableCell.forTableColumn());
         col_name.setCellFactory(TextFieldTableCell.forTableColumn());
         col_kat.setCellFactory(TextFieldTableCell.forTableColumn());
         col_pack.setCellFactory(TextFieldTableCell.forTableColumn());
         col_harga.setCellFactory(TextFieldTableCell.forTableColumn());
         
         //select multiple row
         tabel1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    //array dummy data
    public ObservableList<Data> getPeople() {
        ObservableList<Data> people = FXCollections.observableArrayList();
        people.add(new Data("100", "Cheetos","Makanan","Plastik","5000"));
        people.add(new Data("101", "Better","Makanan","Plastik","1000"));
        
        return people;
    }
    
   
    @FXML
    private void simpan(ActionEvent event) {
        Data newData = new Data (Kode.getText(),Nama.getText(),Kategori.getValue(),Packaging.getValue(),Harga.getText());
        //get data from list
        tabel1.getItems().add(newData);
}
    @FXML
    private void hapus(ActionEvent event) {
        ObservableList<Data> selectedRows, allPeople;
        allPeople = tabel1.getItems();
        
        //gives us the selected rows
        selectedRows = tabel1.getSelectionModel().getSelectedItems();
        
        //remove object
        for (Data person: selectedRows)
        {
            allPeople.remove(person);
        }
    }

    @FXML
    private void bersih(ActionEvent event) {
        Kode.setText("");
        Nama.setText("");
        Kategori.setValue("");
        Packaging.setValue("");
        Harga.setText("");
    }

    @FXML
    void keluar(ActionEvent event) {
        System.exit(0);
    }
}         
    


