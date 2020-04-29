package org.silverlight.elasticsearch.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:22
 */
@Data
public class ProductDetail implements Serializable {

    private Long id;

    private Long cellphoneId;

    private String place;

    private Double weight;
}
