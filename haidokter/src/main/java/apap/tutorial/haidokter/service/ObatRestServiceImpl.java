package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
//import apap.tutorial.haidokter.rest.ResepDetail;
import apap.tutorial.haidokter.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ObatRestServiceImpl implements ObatRestService{
    private final WebClient webClient;

    @Autowired
    private ObatDb obatDb;

    @Override
    public ObatModel createObat(ObatModel obat) {
        return obatDb.save(obat);
    }

    @Override
    public List<ObatModel> retrieveListObat() {
        return obatDb.findAll();
    }

    @Override
    public ObatModel getObatById(Long id){
        Optional<ObatModel> obat = obatDb.findById(id);
        if (obat.isPresent()){
            return obat.get();
        } else {
            throw new NoSuchElementException();
        }
    }


    @Override
    public ObatModel changeObat(Long id, ObatModel obatUpdate) {
        ObatModel obat = getObatById(id);
        obat.setNama(obatUpdate.getNama());
        obat.setKuantitas(obatUpdate.getKuantitas());
        obat.setBentuk(obatUpdate.getBentuk());
        return obatDb.save(obat);
    }


    @Override
    public void deleteObat(Long id) {
        ObatModel obat = getObatById(id);
        obatDb.delete(obat);
    }

    public ObatRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.resepUrl).build();
    }
}