package org.silverlight.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Guang.Yang on 2020/4/28.
 *
 * @author Guang.Yang
 * @date 2020/4/28 22:06
 */
@Data
@Accessors(chain = true)
@Document(indexName = "springboot_elasticsearch_demo")
public class CellPhoneSearchModel {

    @Id
    private String id;

    private String brand;

    private String name;

    private String description;

    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseDate;

    private ProductDetail productDetail;
}
