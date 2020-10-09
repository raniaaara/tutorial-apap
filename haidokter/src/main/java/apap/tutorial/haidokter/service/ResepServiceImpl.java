package apap.tutorial.haidokter.service;


import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResepServiceImpl implements ResepService{
    @Autowired
    ResepDb resepDb;

    public ResepServiceImpl() {
        super();
    }

    @Override
    public void addResep(ResepModel resep) {
        resepDb.save(resep);

    }

    @Override
    public List<ResepModel> getResepList() {
        return resepDb.findAll();
    }

    @Override
    public ResepModel getResepByNomorResep(Long noResep) {
        return resepDb.findByNoResep(noResep).get();
    }

    @Override
    public ResepModel updateResep(ResepModel resep) {
        resepDb.save(resep);
        return resep;
    }

    @Override
    public void deleteResep(ResepModel resep) {
        resepDb.delete(resep);
    }

    @Override
    public List<ResepModel> getSortedResepList() {
        return resepDb.findAll(Sort.by(Sort.Direction.DESC,"noResep"));
    }
}