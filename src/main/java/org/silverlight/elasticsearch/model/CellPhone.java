package org.silverlight.elasticsearch.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by silverlight on 2020/4/26.
 *
 * @author silverlight
 * @date 2020/4/26 18:17
 */
@Data
@Accessors(chain = true)
@Document(indexName = "springboot_elasticsearch_demo")
public class CellPhone implements Serializable {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    private String brand;

    private String name;

    private String description;

    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseDate;

    private ProductDetail productDetail;

}
