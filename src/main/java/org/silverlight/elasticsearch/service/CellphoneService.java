package org.silverlight.elasticsearch.service;

import org.silverlight.elasticsearch.model.CellPhone;
import org.silverlight.elasticsearch.model.CellPhoneSearchModel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:27
 */
public interface CellphoneService {


    void save(CellPhone cellPhone);

    CellPhone getById(Long id);

    List<CellPhone> getAll();

    List<CellPhone> getByBrandLike(String brand);

    void update(CellPhone cellPhone);

    void deleteById(Long id);

    Page<CellPhone> fullSearch(String keyword);

}
