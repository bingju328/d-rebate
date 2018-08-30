package com.drebate;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatEyeApplicationTests {

	@Test
	public void contextLoads() {
		DefaultTaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23338490", "c6393c570bf2254118511b2800fee2fc");
		TimeGetRequest request = new TimeGetRequest();
		TimeGetResponse response = null;
		try {
			response = client.execute(request);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		if (response.isSuccess()) {
			System.out.println(response.getBody());
		}
	}
	/**
	 * taobao.tbk.item.get
	 * 淘宝客商品查询
	 */
	@Test
	public void getGoodsList() {
		TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23338490", "c6393c570bf2254118511b2800fee2fc");
		TbkItemGetRequest req = new TbkItemGetRequest();
//		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,tk_rate");
		req.setFields("num_iid,title,tk_rate");
		req.setQ("女装");
//		req.setCat("16,18");
//		req.setItemloc("杭州");
		req.setSort("tk_rate_des");
//		req.setIsTmall(false);
//		req.setIsOverseas(false);
		req.setStartPrice(100L);
		req.setEndPrice(10L);
		req.setStartTkRate(1L);
		req.setEndTkRate(1000L);
//		req.setPlatform(1L);
		req.setPageNo(123L);
		req.setPageSize(100L);
		TbkItemGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}

	/**
	 *
	 */
	@Test
	public void getDirectList() {
		TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23338490", "c6393c570bf2254118511b2800fee2fc");
		TbkUatmEventGetRequest req = new TbkUatmEventGetRequest();
		req.setPageNo(1L);
		req.setPageSize(20L);
		req.setFields("event_id,event_title,start_time,end_time");
		TbkUatmEventGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}

	/**
	 *枚举出淘宝客在淘宝联盟超级搜索，特色频道中，创建的选品库列表
	 * 18492553
	 */
	@Test
	public void getDirectGoodList() {
		TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23338490", "c6393c570bf2254118511b2800fee2fc");
		TbkUatmFavoritesGetRequest req = new TbkUatmFavoritesGetRequest();
		req.setPageNo(1L);
		req.setPageSize(20L);
		req.setFields("favorites_title,favorites_id,type");
		req.setType(1L);
		TbkUatmFavoritesGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}

	/**
	 *指定选品库id，获取该选品库的宝贝信息
	 * 18492553
	 * mm_29600904_4474024_14768975
	 * mm_29600904_4474024_14768975:1535622729_120_521362265&pvid=12_123.113.252.71_3100_1535622716923
	 */
	@Test
	public void getGoodListByXPKId() {
		TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23338490", "c6393c570bf2254118511b2800fee2fc");
		TbkUatmFavoritesItemGetRequest req = new TbkUatmFavoritesItemGetRequest();
//		req.setPlatform(1L);
//		req.setPageSize(20L);
		req.setAdzoneId(14768975L);
		req.setUnid("3456");
		req.setFavoritesId(18492553L);
//		req.setPageNo(2L);
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
		TbkUatmFavoritesItemGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}

}
