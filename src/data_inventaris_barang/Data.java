
package data_inventaris_barang;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kevin
 */
public class Data {
    private SimpleStringProperty Kode, Nama, Kategori, Packaging, Harga;

    public Data(String Kode, String Nama, String Kategori, String Packaging, String Harga) {
        this.Kode = new SimpleStringProperty(Kode);
        this.Nama = new SimpleStringProperty(Nama);
         this.Kategori = new SimpleStringProperty(Kategori);
        this.Packaging = new SimpleStringProperty(Packaging);
        this.Harga = new SimpleStringProperty(Harga);
    }

    public String getKode() {
        return Kode.get();
    }

    public void setKode(String Kode) {
        this.Kode = new SimpleStringProperty(Kode);
    }

    public String getNama() {
        return Nama.get();
    }

    public void setNama(String Nama) {
        this.Nama = new SimpleStringProperty(Nama);
    }

    public String getKategori() {
        return Kategori.get();
    }

    public void setKategori(String Kategori) {
        this.Kategori = new SimpleStringProperty(Kategori);
    }

    public String getPackaging() {
        return Packaging.get();
    }

    public void setPackaging(String Packaging) {
        this.Packaging = new SimpleStringProperty(Packaging);
    }

    public String getHarga() {
        return Harga.get();
    }

    public void setHarga(String Harga) {
        this.Harga = new SimpleStringProperty(Harga);
    }
}
