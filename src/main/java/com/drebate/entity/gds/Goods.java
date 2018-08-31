package com.drebate.entity.gds;

import com.drebate.model.enums.DRebateEnum;
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
import java.math.BigDecimal;
import java.util.Date;

import static io.gd.generator.api.query.Predicate.EQ;
import static io.gd.generator.api.query.Predicate.LK;

@Entity
@Table(name = "gds_goods")
@Getter
@Setter
@QueryModel
@Type(label = "商品")
@ViewObject(groups = {},
        collectionViews = {
        },
        views = {
        }

)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {

    public static final String VO_DETAIL = "GoodsDetailVo";
    public static final String VO_SIMPLE = "GoodsSimpleVo";
    public static final String VO_SHELF_GOODS_INIT = "ShelfGoodsInitVo";


    @Id
    @Query(Predicate.IN)
    @Field(label = "id")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String id;

    @Query(Predicate.LK)
    @Field(label = "商品名称")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private String title;

    @Field(label = "商品主图")
    @Length(max = 250)
    private String pictUrl;

    @Field(label = "商品地址")
    @Length(max = 250)
    private String itemUrl;

    @Field(label = "淘客地址")
    @Length(max = 250)
    private String clickUrl;

    @Field(label = "商品一口价格")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private BigDecimal reservePrice;

    @Field(label = "商品折扣价格")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private BigDecimal zkFinalPrice;

    @Query({EQ, LK})
    @Field(label = "渠道类型")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private DRebateEnum.GoodsChannel channel;

    @Query({EQ})
    @Field(label = "宝贝所在地")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    @NotBlank
    private String provcity;

    @Query(Predicate.LK)
    @Field(label = "卖家名称")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private String nick;

    @Query(Predicate.EQ)
    @Field(label = "卖家ID")
    @View(groups = {VO_SIMPLE})
    private String sellerId;

    @Query(Predicate.LK)
    @Field(label = "店铺名称")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private String shopTitle;

    @Field(label = "30天销量")
    @View
    private Long saleVolume;

    @Field(label = "收入比例 取值为20.00，表示比例20.00%")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private BigDecimal tkRate;

    @Field(label = "无线折扣价，即宝贝在无线上的实际售卖价格")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private BigDecimal zkFinalPriceWap;

    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "招商活动开始时间；如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00")
    private Date eventStartTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "招商活动结束时间；如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00")
    private Date eventEndTime;

    @Field(label = "宝贝类型：1 普通商品； 2 鹊桥高佣金商品；3 定向招商商品；4 营销计划商品")
    @View
    private Long type;

    @Field(label = "宝贝状态，0失效，1有效；注：失效可能是宝贝已经下线或者是被处罚不能在进行推广")
    @View
    private Long status;

    @Query(Predicate.EQ)
    @Field(label = "一级类目Id")
    @View(groups = {VO_SIMPLE})
    private String categoryId;

    @Query(Predicate.EQ)
    @Field(label = "选品库Id")
    @View(groups = {VO_SIMPLE})
    private String favoritesId;

    @Field(label = "商品优惠券推广链接")
    @Length(max = 250)
    private String couponClickUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "优惠券开始时间")
    private Date couponStartTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "优惠券结束时间")
    private Date couponEndTime;

    @Field(label = "优惠券面额（满16元减10元）")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_INIT})
    private String couponInfo;

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
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private Date modifyTime;

    @NotNull
    @Version
    @Field(label = "乐观锁")
    private Integer version;

    @Query({EQ,LK})
    @Field(label = "商品描述")
    @View(groups = {VO_DETAIL,VO_SIMPLE})
    private String describes;



}
