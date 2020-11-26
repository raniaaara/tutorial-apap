package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
//import apap.tutorial.haidokter.rest.ResepDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ObatRestService {
    ObatModel createObat(ObatModel obat);

    List<ObatModel> retrieveListObat();

    ObatModel getObatById(Long id);
//
    ObatModel changeObat(Long id, ObatModel obatUpdate);
//
    void deleteObat(Long id);

}
