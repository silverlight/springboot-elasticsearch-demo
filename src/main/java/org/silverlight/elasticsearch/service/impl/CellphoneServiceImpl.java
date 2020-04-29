package org.silverlight.elasticsearch.service.impl;

import org.elasticsearch.index.query.QueryBuilders;
import org.silverlight.elasticsearch.model.CellPhone;
import org.silverlight.elasticsearch.repository.CellPhoneRepository;
import org.silverlight.elasticsearch.service.CellphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:27
 */
@Service
public class CellphoneServiceImpl implements CellphoneService {

    @Autowired
    private CellPhoneRepository cellPhoneRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void save(CellPhone cellPhone) {
        cellPhoneRepository.save(cellPhone);
    }

    @Override
    public CellPhone getById(Long id) {
        return cellPhoneRepository.findById(id).get();
    }

    @Override
    public List<CellPhone> getAll() {
        ArrayList<CellPhone> cellPhones = new ArrayList<>();
        cellPhoneRepository.findAll().forEach(cellPhones::add);
        return cellPhones;
    }

    @Override
    public List<CellPhone> getByBrandLike(String brand) {
        return new ArrayList<>(cellPhoneRepository.findCellPhonesByBrandLike(brand));
    }

    @Override
    public void update(CellPhone cellPhone) {
        cellPhoneRepository.save(cellPhone);
    }

    @Override
    public void deleteById(Long id) {
        cellPhoneRepository.deleteById(id);
    }

    @Override
    public Page<CellPhone> fullSearch(String keyword) {

        Pageable pageable = PageRequest.of(0, 10);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        SearchQuery searchQuery = nativeSearchQueryBuilder
            .withQuery(QueryBuilders.queryStringQuery(keyword))
            .withPageable(pageable)
            .build();
        return elasticsearchRestTemplate.queryForPage(searchQuery, CellPhone.class);
    }
}
