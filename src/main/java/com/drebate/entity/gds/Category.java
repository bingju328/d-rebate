package com.drebate.entity.gds;

import io.gd.generator.annotation.Field;
import io.gd.generator.annotation.Type;
import io.gd.generator.annotation.query.Query;
import io.gd.generator.annotation.query.QueryModel;
import io.gd.generator.annotation.view.View;
import io.gd.generator.annotation.view.ViewObject;
import io.gd.generator.api.query.Predicate;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "gds_category")
@Getter
@Setter
@QueryModel
@Type(label = "商品类别")
@ViewObject(groups = {},
        collectionViews = {
        },
        views = {
        }

)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    public static final String VO_SIMPLE = "CategorySimpleVo";
    public static final String VO_DETAIL = "CategoryDetailVo";

    @Id
    @Query({Predicate.IN})
    @Field(label = "id")
    @View(groups = {VO_SIMPLE, VO_DETAIL})
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String id;

    @Field(label = "头像")
    @View(name = "avatarThumbnail", type = String.class, groups = {VO_DETAIL, VO_SIMPLE})
    @Length(max = 250)
    private String avatar;

    @Query(Predicate.LK)
    @Field(label = "分类名称")
    @View(groups = {VO_SIMPLE, VO_DETAIL})
    private String catName;

    @Field(label = "排序")
    @NotNull
    private Integer ranking;

    @NotNull
    @Query(Predicate.EQ)
    @Field(label = "是否删除")
    private Boolean isDelete;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "创建时间")
    @View(groups = {VO_DETAIL})
    private Date registerTime;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "更新时间")
    @View(groups = {VO_DETAIL})
    private Date modifyTime;

    @NotNull
    @Version
    @Field(label = "乐观锁")
    private Integer version;

    @Query(Predicate.LK)
    @Field(label = "分类说明")
    @View(groups = {VO_DETAIL})
    private String remarks;

}
