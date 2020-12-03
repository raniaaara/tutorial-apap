package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.RoleModel;
import apap.tutorial.haidokter.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDb roleDB;

    @Override
    public List<RoleModel> findAll() {
        return roleDB.findAll();
    }
}
