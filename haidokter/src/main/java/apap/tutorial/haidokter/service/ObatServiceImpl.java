package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ObatServiceImpl implements ObatService{
    @Autowired
    ObatDb obatDb;

    @Override
    public void addObat(ObatModel obat) {
        obatDb.save(obat);
    }

    @Override
    public ObatModel getObatById(Long id){
        return obatDb.findById(id).get();
    }

    @Override
    public ObatModel changeObat(ObatModel obat){
//        ObatModel obatChanged = obatDb.findById(obat.getId()).get();
//        obatChanged.setBentuk(obat.getBentuk());
//        obatChanged.setKuantitas(obat.getKuantitas());
//        obatChanged.setNama(obat.getNama());
//        obatDb.save(obatChanged);
//        return obatChanged;
        obatDb.save(obat);
        return obat;
    }

    @Override
    public void deleteObat(ObatModel obat){
        obatDb.delete(obat);
    }
}
