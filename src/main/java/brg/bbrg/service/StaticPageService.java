package brg.bbrg.service;

import brg.bbrg.model.StaticPageModel;

import java.util.List;

public interface StaticPageService {
    List<StaticPageModel> getAll();
    StaticPageModel getByTitle(String title);
    StaticPageModel getById(Long id);
    StaticPageModel savePage(StaticPageModel staticPageModel);
}
