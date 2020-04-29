package org.silverlight.elasticsearch.repository;

import org.silverlight.elasticsearch.model.CellPhone;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:25
 */
public interface CellPhoneRepository extends ElasticsearchRepository<CellPhone,Long> {

    List<CellPhone> findCellPhonesByBrandLike(String brand);
}
