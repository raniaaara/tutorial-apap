package apap.tutorial.haidokter.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "resep")
public class ResepModel implements Serializable {
    @Id
    @Column(name = "no_resep", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noResep;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_dokter", nullable = false)
    private String namaDokter;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_pasien", nullable = false)
    private String namaPasien;

    @NotNull
    @Size(max = 40)
    @Column(name = "catatan", nullable = false)
    private String catatan;

    @OneToMany(mappedBy = "resepModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ObatModel> listObat;

    public Long getNoResep() {
        return noResep;
    }

    public void setNoResep(Long noResep) {
        this.noResep = noResep;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public List<ObatModel> getListObat() {
        return listObat;
    }

    public void setListObat(List<ObatModel> listObat) {
        this.listObat = listObat;
    }
}