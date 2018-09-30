package com.drebate.model.enums;


/**
 * Created by bingju on 2018/3/28.
 */
public class DRebateEnum {

    public enum GoodsChannel {
        淘宝,天猫,京东,拼多多
    }
    //性别
    public enum Gender {
        男, 女
    }


//    public static SettleStatus itemOfSettleStatus(int value)  {
//        for (SettleStatus item : AgencyEnum.SettleStatus.values()) {
//            if (value == item.ordinal()) {
//                return item;
//            }
//        }
//        throw new RuntimeException("未定义状态");
//    }

//	public static AgencySettle.SettleType itemOfSettleType(int value)  {
//		for (AgencySettle.SettleType item : AgencySettle.SettleType.values()) {
//			if (value == item.ordinal()) {
//				return item;
//			}
//		}
//		throw new RuntimeException("未定义状态");
//	}
}
