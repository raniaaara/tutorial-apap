package apap.tutorial.haidokter.service;


import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;

public interface ResepService {
    // menambah resep
    void addResep(ResepModel resep);

    // mendapatkan semua data resep yang telah tersimpan
    List<ResepModel> getResepList();

    // mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(String noResep);
}
