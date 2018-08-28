package com.drebate.entity;


import io.gd.generator.annotation.Field;
import io.gd.generator.annotation.Type;
import io.gd.generator.annotation.query.Query;
import io.gd.generator.annotation.query.QueryModel;
import io.gd.generator.annotation.view.AssociationView;
import io.gd.generator.annotation.view.CollectionView;
import io.gd.generator.annotation.view.View;
import io.gd.generator.annotation.view.ViewObject;
import io.gd.generator.api.query.Predicate;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static com.drebate.entity.Firm.VO_DETAIL;
import static com.drebate.entity.Firm.VO_ID_NAME;
import static com.drebate.entity.Firm.VO_SHELF_GOODS_DETAIL;
import static com.drebate.entity.Firm.VO_SIMPLE;

import static io.gd.generator.api.query.Predicate.*;

@Entity
@Table(name = "frm_firm")
@Getter
@Setter
@QueryModel
@Type(label = "企业")
@ViewObject(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL, VO_ID_NAME},
        collectionViews = {

            @CollectionView(name = "region", elementType = String.class, groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL}),

        },
        views = {
            @View(name = "shelfNum", type = String.class, groups = {VO_SHELF_GOODS_DETAIL}),
            @View(name = "shelfId", type = String.class, groups = {VO_SIMPLE},field = @Field(label = "货架ID酒店物业专用")),
            @View(name = "firmCutRatio", type = BigDecimal.class, groups = {VO_SIMPLE}),
            @View(name = "openFlag", type = Boolean.class, groups = {VO_DETAIL}),
            @View(name = "warningDictQuantity",type = Integer.class,groups = {VO_SIMPLE}),
            @View(name = "propertyQrCodeUrl",type = String.class,groups = {VO_SIMPLE},field = @Field(label = "物业商品展示页二维码链接")),
            @View(name = "createUserName",type = String.class,groups = {VO_SIMPLE,VO_DETAIL},field = @Field(label = "企业创建人")),

        },
        associationViews = {

        }


)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Firm implements Serializable {

    public static final String VO_DETAIL = "FirmDetailVo";
    public static final String VO_SIMPLE = "FirmSimpleVo";
    public static final String VO_SHELF_GOODS_DETAIL = "FirmShelfGoodsDetailVo";
    public static final String VO_ID_NAME = "FirmIdNameVo";


    @Type(label = "企业类型")
    public enum FirmType {
        企业, 配货点, 酒店, 物业
    }

    @Type(label = "酒店星级")
    public enum HotelClass {
        一星酒店, 二星酒店, 三星酒店, 四星酒店, 五星酒店
    }

    @Id
    @Query(IN)
    @Field(label = "id")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL, VO_ID_NAME})
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String id;

    @Query({EQ, IN})
    @Field(label = "企业类型")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    @NotNull
    private FirmType firmType;

    @Query({EQ})
    @Field(label = "酒店星级")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private HotelClass hotelClass;

    @Query({EQ,LK})
    @Field(label = "酒店描述")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private String describes;

    @Query({EQ})
    @Field(label = "公司logo")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private String logoUrl;

    @Query({EQ,LK})
    @Field(label = "酒店服务描述")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private String serverDescribes;

    @Query(EQ)
    @Field(label = "酒店分润比例")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private BigDecimal benefitRatio;

    @Query(EQ)
    @Field(label = "三方商户抽成比例")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private BigDecimal merchantCutRatio;

    @Query(EQ)
    @Field(label = "员工优惠比例")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private BigDecimal staffRatio;

    @Query(Predicate.EQ)
    @Field(label = "是否进行让利(内部员工)")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private Boolean isStaffBenefit;

    @Field(label = "酒店的二维码链接")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private String qrCodeUrl;

    @Field(label = "酒店的二维码链接")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private String qrCodeAccessUrl;

    @NotNull
    @Query(Predicate.LK)
    @Field(label = "企业名称")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL, VO_ID_NAME})
    private String name;

    @NotNull
    @Query(Predicate.EQ)
    @Field(label = "企业编号")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String firmNo;

    @Query(Predicate.LK)
    @Field(label = "企业联系人")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String contactName;

    @Field(label = "企业联系方式")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String contactPhone;

    @NotNull
    @Field(label = "企业地址")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String address;

    @NotNull
    @Query(Predicate.EQ)
    @Field(label = "是否删除")
    private Boolean isDelete;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "创建时间")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private Date registerTime;

    @Temporal(TemporalType.TIME)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "酒店营业开始时间")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private Date bussinessTimeBegin;


    @Temporal(TemporalType.TIME)
    @Query({Predicate.GTE, Predicate.LT})
    @Field(label = "酒店营业结束时间")
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private Date bussinessTimeEnd;

    @NotNull
    @Query(EQ)
    @Field(label = "累计总积分")
    @View(groups = {VO_DETAIL})
    private BigDecimal totalMoney;

    @NotNull
    @Query(EQ)
    @Field(label = "已税换积分")
    @View(groups = {VO_DETAIL})
    private BigDecimal convertedMoney;

    @NotNull
    @Query(EQ)
    @Field(label = "可兑换积分")
    @View(groups = {VO_DETAIL, VO_SIMPLE})
    private BigDecimal ableConvertMoney;



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

    /**
     * 企业类型为企业时必须要有对应的配送点
     */
    @Field(label = "企业配送点")
    @Query(Predicate.EQ)
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String deliverFirmId;

    @Field(label = "创建当前企业所在的企业(parent)")
    @Query(Predicate.EQ)
    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    @NotBlank
    private String pFirmId;

    @Field(label = "省")
    @Query({EQ})
    private Integer provinceId;

    @Field(label = "市")
    @Query({EQ})
    private Integer cityId;

    @Field(label = "区县")
    @Query({EQ})
    private Integer districtId;

    @Field(label = "省市区县,逗号分隔")
//    @View(groups = {VO_DETAIL, VO_SIMPLE, VO_SHELF_GOODS_DETAIL})
    private String region;

    @Field(label = "创建用户ID")
    @Query(Predicate.EQ)
    @View(groups = {VO_DETAIL,VO_SIMPLE})
    @Column(columnDefinition = "BigInt(20)")
    private String createUserId;

}
