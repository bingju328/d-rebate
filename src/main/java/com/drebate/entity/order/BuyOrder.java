package com.drebate.entity.order;

import io.gd.generator.annotation.Field;
import io.gd.generator.annotation.Type;
import io.gd.generator.annotation.query.Query;
import io.gd.generator.annotation.query.QueryModel;
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

import static io.gd.generator.api.query.Predicate.EQ;
import static io.gd.generator.api.query.Predicate.GT;

/**
 * @author bingju  2017/10/23
 */
@Entity
@Table(name = "buy_order")
@Getter
@Setter
@QueryModel
@Type(label = "")
@ViewObject(groups = {}, collectionViews = {
        }, views = {
        },
        associationViews ={
        }


)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyOrder implements Serializable {

    public static final String BUY_ORDER_DETAIL = "BuyOrderDetailVo";
    public static final String BUY_ORDER_LIST = "BuyOrderListVo";
    public static final String BILL_ORDER_ITEM = "BillOrderItemVo";

    @Type(label = "订单状态")
    public enum OrderStatus {
        created, payed,canceled,success
    }

    @Type(label = "订单支付退款类型")
    public enum OrderPayefundType{
        支付,部分退款,全部退款
    }

    @Id
    @Query({Predicate.IN, Predicate.EQ,Predicate.LK})
    @Field(label = "id")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String id;

    @Query(Predicate.EQ)
    @Field(label = "买家id")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    @NotBlank
    @Column(columnDefinition = "BigInt(20)")
    private String customId;

    @Query({EQ,Predicate.IN,Predicate.NEQ})
    @Field(label = "订单状态")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    @NotNull
    private OrderStatus orderStatus;

    @NotNull
    @Field(label = "商品合计价格")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal gdsPrice;

    @NotNull
    @Field(label = "合计价格")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal price;

    @Field(label = "应返利")
    @Query({GT})
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal shouldRebate;

    @Field(label = "可返利金额")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal divideableRebate;

    @NotNull
    @Field(label = "实际返利")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal realRebate;

    @Field(label = "淘客返利比")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private BigDecimal tkRate;

    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT,Predicate.EQ})
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    @Field(label = "完成时间")
    private Date completeTime;

    @NotNull
    @Query({Predicate.EQ})
    @Field(label = "是否删除")
    private Boolean isDelete;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @View(groups = {BUY_ORDER_DETAIL,BUY_ORDER_LIST})
    @Field(label = "创建时间")
    private Date registerTime;


    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @View(groups = {BUY_ORDER_DETAIL,BUY_ORDER_LIST})
    @Field(label = "支付完成时间")
    private Date payCompleteTime;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Query({Predicate.GTE, Predicate.LT})
    @View(groups = {BUY_ORDER_DETAIL,BUY_ORDER_LIST})
    @Field(label = "更新时间")
    private Date modifyTime;

    @NotNull
    @Version
    @Field(label = "乐观锁")
    private Integer version;

    @Query({Predicate.EQ, Predicate.IN})
    @Field(label = "支付订单还是退款单")
    @View(groups = {BUY_ORDER_DETAIL,BILL_ORDER_ITEM,BUY_ORDER_LIST})
    private OrderPayefundType orderPayefundType = OrderPayefundType.支付;

}
