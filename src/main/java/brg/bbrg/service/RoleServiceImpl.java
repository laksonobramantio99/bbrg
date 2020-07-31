package brg.bbrg.service;

import brg.bbrg.model.RoleModel;
import brg.bbrg.repository.RoleDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDB roleDB;

    @Override
    public RoleModel getById(Integer id) {
        Optional<RoleModel> roleModel = roleDB.findById(id);
        if (roleModel.isPresent())
            return roleModel.get();
        else
            return null;
    }


}
