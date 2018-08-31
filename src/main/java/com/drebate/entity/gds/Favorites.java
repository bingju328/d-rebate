package com.drebate.entity.gds;

import io.gd.generator.annotation.Field;
import io.gd.generator.annotation.Type;
import io.gd.generator.annotation.query.Query;
import io.gd.generator.annotation.query.QueryModel;
import io.gd.generator.annotation.view.ViewObject;
import io.gd.generator.api.query.Predicate;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "gds_favorites")
@Getter
@Setter
@QueryModel
@Type(label = "商品选品库")
@ViewObject(groups = {},
        collectionViews = {
        },
        views = {
        }

)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favorites implements Serializable {

    @Id
    @Query({Predicate.IN})
    @Field(label = "id")
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String favoritesId;

    @Query(Predicate.LK)
    @Field(label = "选品库标题")
    private String favoritesTitle;

    @Field(label = "选品库类型")
    @NotNull
    private Long type;

    @NotNull
    @Query(Predicate.EQ)
    @Field(label = "是否删除")
    private Boolean isDelete;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "创建时间")
    private Date registerTime;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "更新时间")
    private Date modifyTime;

    @NotNull
    @Version
    @Field(label = "乐观锁")
    private Integer version;

}
