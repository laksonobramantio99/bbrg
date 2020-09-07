package brg.bbrg.service;

import brg.bbrg.model.StaticPageModel;
import brg.bbrg.repository.StaticPageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaticPageServiceImpl implements StaticPageService {

    @Autowired
    private StaticPageDB staticPageDB;

    @Override
    public List<StaticPageModel> getAll() {
        return staticPageDB.findAll();
    }

    @Override
    public StaticPageModel getByTitle(String title) {
        Optional<StaticPageModel> staticPageModel = staticPageDB.findByTitle(title);
        if (staticPageModel.isPresent())
            return staticPageModel.get();
        else
            return null;
    }

    @Override
    public StaticPageModel getById(Long id) {
        Optional<StaticPageModel> staticPageModel = staticPageDB.findById(id);
        if (staticPageModel.isPresent())
            return staticPageModel.get();
        else
            return null;
    }

    @Override
    public StaticPageModel savePage(StaticPageModel staticPageModel) {
        return staticPageDB.save(staticPageModel);
    }
}
