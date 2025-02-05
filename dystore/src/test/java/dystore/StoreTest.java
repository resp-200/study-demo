package dystore;

import com.doudian.open.api.shop_batchCreateStore.ShopBatchCreateStoreRequest;
import com.doudian.open.api.shop_batchCreateStore.ShopBatchCreateStoreResponse;
import com.doudian.open.api.shop_batchCreateStore.param.ShopBatchCreateStoreParam;
import com.doudian.open.api.shop_batchCreateStore.param.StoreListItem;
import com.doudian.open.api.shop_delStore.ShopDelStoreRequest;
import com.doudian.open.api.shop_delStore.ShopDelStoreResponse;
import com.doudian.open.api.shop_delStore.param.ShopDelStoreParam;
import com.doudian.open.api.shop_editStore.ShopEditStoreRequest;
import com.doudian.open.api.shop_editStore.ShopEditStoreResponse;
import com.doudian.open.api.shop_editStore.param.OpenTime;
import com.doudian.open.api.shop_editStore.param.ShopEditStoreParam;
import com.doudian.open.api.shop_getStoreDetail.ShopGetStoreDetailRequest;
import com.doudian.open.api.shop_getStoreDetail.param.ShopGetStoreDetailParam;
import com.doudian.open.api.shop_getStoreList.ShopGetStoreListRequest;
import com.doudian.open.api.shop_getStoreList.ShopGetStoreListResponse;
import com.doudian.open.api.shop_getStoreList.param.ShopGetStoreListParam;
import com.doudian.open.api.shop_storeSuspend.ShopStoreSuspendRequest;
import com.doudian.open.api.shop_storeSuspend.ShopStoreSuspendResponse;
import com.doudian.open.api.shop_storeSuspend.param.ShopStoreSuspendParam;
import com.doudian.open.api.warehouse_bindFencesByStore.WarehouseBindFencesByStoreRequest;
import com.doudian.open.api.warehouse_bindFencesByStore.WarehouseBindFencesByStoreResponse;
import com.doudian.open.api.warehouse_bindFencesByStore.param.WarehouseBindFencesByStoreParam;
import com.doudian.open.api.warehouse_createFence.WarehouseCreateFenceRequest;
import com.doudian.open.api.warehouse_createFence.WarehouseCreateFenceResponse;
import com.doudian.open.api.warehouse_createFence.param.Center;
import com.doudian.open.api.warehouse_createFence.param.Circular;
import com.doudian.open.api.warehouse_createFence.param.FenceInfo;
import com.doudian.open.api.warehouse_createFence.param.WarehouseCreateFenceParam;
import com.doudian.open.api.warehouse_getFences.WarehouseGetFencesRequest;
import com.doudian.open.api.warehouse_getFences.WarehouseGetFencesResponse;
import com.doudian.open.api.warehouse_getWarehouseByStore.WarehouseGetWarehouseByStoreRequest;
import com.doudian.open.api.warehouse_getWarehouseByStore.WarehouseGetWarehouseByStoreResponse;
import com.doudian.open.api.warehouse_getWarehouseByStore.param.WarehouseGetWarehouseByStoreParam;
import com.doudian.open.api.warehouse_setFence.WarehouseSetFenceRequest;
import com.doudian.open.api.warehouse_setFence.WarehouseSetFenceResponse;
import com.doudian.open.api.warehouse_setFence.param.WarehouseSetFenceParam;
import com.doudian.open.api.warehouse_unbindFencesByStore.WarehouseUnbindFencesByStoreRequest;
import com.doudian.open.api.warehouse_unbindFencesByStore.WarehouseUnbindFencesByStoreResponse;
import com.doudian.open.api.warehouse_unbindFencesByStore.param.WarehouseUnbindFencesByStoreParam;
import com.doudian.open.core.AccessToken;
import com.doudian.open.utils.JsonUtil;
import com.google.common.collect.Lists;
import com.study_demo.TokenConfig;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2024/12/23 16:25
 */
public class StoreTest {
    private static final Long storeId = 153406001L;
    private static final AccessToken accessToken = TokenConfig.getAccessToken(storeId);

    @Test
    public void getToken(){
        System.out.println(JsonUtil.toJson(accessToken));
    }
    @Test
    public void getFences(){
        WarehouseGetFencesRequest warehouseGetFencesRequest = new WarehouseGetFencesRequest();
        WarehouseGetFencesResponse warehouseGetFencesResponse = warehouseGetFencesRequest.execute(accessToken);
        System.out.println(JsonUtil.toJson(warehouseGetFencesResponse));
    }

    @Test
    public void createFence(){
        WarehouseCreateFenceRequest request = new WarehouseCreateFenceRequest();
        WarehouseCreateFenceParam param = request.getParam();
        FenceInfo fenceInfo = new FenceInfo();
        fenceInfo.setOutFenceId("1");
        fenceInfo.setShape(1);
        Circular circular = new Circular();
        // 半径
        circular.setRadius(1000d);
        Center center = new Center();
        center.setLatitude(40.045839);
        center.setLongitude(116.358197);
        circular.setCenter(center);
        fenceInfo.setCircular(circular);
        param.setFenceInfo(fenceInfo);
        WarehouseCreateFenceResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
        /*
{"data":{"fence_id":"1734943295"},"log_id":"2024122316413533F8130FA725971A51E5","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void updateFence(){
        WarehouseSetFenceRequest request = new WarehouseSetFenceRequest();
        WarehouseSetFenceParam param = request.getParam();
        com.doudian.open.api.warehouse_setFence.param.FenceInfo fenceInfo = new com.doudian.open.api.warehouse_setFence.param.FenceInfo();
        fenceInfo.setOutFenceId("1");
        fenceInfo.setShape(1);
        com.doudian.open.api.warehouse_setFence.param.Circular circular = new com.doudian.open.api.warehouse_setFence.param.Circular();
        // 半径
        circular.setRadius(1000.0);
        com.doudian.open.api.warehouse_setFence.param.Center center = new com.doudian.open.api.warehouse_setFence.param.Center();
        center.setLatitude(23.119977);
        center.setLongitude(113.324511);
        circular.setCenter(center);
        fenceInfo.setCircular(circular);
        param.setFenceInfo(fenceInfo);
        WarehouseSetFenceResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
        /*
{"data":{"fence_id":"1734943295"},"log_id":"2024122316413533F8130FA725971A51E5","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void bindStoreAndFence(){
        WarehouseBindFencesByStoreRequest request = new WarehouseBindFencesByStoreRequest();
        WarehouseBindFencesByStoreParam param = request.getParam();
        param.setStoreId(storeId);
        param.setAddOutFenceIds(Lists.newArrayList("1"));
        WarehouseBindFencesByStoreResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
    }

    @Test
    public void unbindStoreAndFence(){
        WarehouseUnbindFencesByStoreRequest request = new WarehouseUnbindFencesByStoreRequest();
        WarehouseUnbindFencesByStoreParam param = request.getParam();
        param.setStoreId(storeId);
        param.setRemoveOutFenceIds(Lists.newArrayList( "155321500_1732672894"));
        WarehouseUnbindFencesByStoreResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
        /*
        {"log_id":"202412231703293DFAE5A1456AD33C468A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }


    @Test
    public void getFenceByStore(){
        WarehouseGetWarehouseByStoreRequest request = new WarehouseGetWarehouseByStoreRequest();
        WarehouseGetWarehouseByStoreParam param = request.getParam();
        param.setStoreIds(Collections.singletonList(storeId));
        WarehouseGetWarehouseByStoreResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void storeSuspend(){
        ShopStoreSuspendRequest request = new ShopStoreSuspendRequest();
        ShopStoreSuspendParam param = request.getParam();
        param.setStoreId(7342775907016376586L);
        param.setReason("测试暂停");
        ShopStoreSuspendResponse response = request.execute(accessToken);
        System.out.println(JsonUtil.toJson(response));
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void getStoreList(){
        ShopGetStoreListRequest request = new ShopGetStoreListRequest();
        ShopGetStoreListParam param = request.getParam();
        param.setPage(0L);
        param.setPageSize(10L);
        param.setStoreCodeList(Collections.singletonList("3962068290"));
        ShopGetStoreListResponse response = request.execute(accessToken);
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void batchCreateStore(){
        ShopBatchCreateStoreRequest request = new ShopBatchCreateStoreRequest();
        ShopBatchCreateStoreParam param = request.getParam();
        StoreListItem storeListItem = new StoreListItem();
        storeListItem.setRowId(1L);
        storeListItem.setName("望京测试门店2");
        storeListItem.setStoreCode("1655836221420603392");
        /*非必填*/
        storeListItem.setLongitude("116.356137");
        storeListItem.setLatitude("40.045697");
        storeListItem.setProvince("北京市");
        storeListItem.setCity("北京市");
        storeListItem.setDistrict("东城区");
        storeListItem.setAddress("东升科技园测试测试测试不需要联系");
        com.doudian.open.api.shop_batchCreateStore.param.OpenTime openTime = new com.doudian.open.api.shop_batchCreateStore.param.OpenTime();
        HashMap<Long, String> map = new HashMap<>();
        map.put(1L, "10:00-24:00");
        map.put(2L, "10:00-24:00");
        map.put(3L, "10:00-24:00");
        map.put(4L, "10:00-24:00");
        map.put(5L, "10:00-24:00");
        map.put(6L, "10:00-24:00");
        map.put(7L, "10:00-24:00");
        openTime.setDayMap(map);
        storeListItem.setOpenTime(openTime);
        param.setStoreList(Collections.singletonList(storeListItem));
        ShopBatchCreateStoreResponse response = request.execute(accessToken);
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void storeDetail(){
        ShopGetStoreDetailRequest request = new ShopGetStoreDetailRequest();
        ShopGetStoreDetailParam param = request.getParam();
//        param.setStoreId(203740622L);
        param.setStoreId(203748659L);
        param.setIsNeedChargeInfo(true);
        param.setIsNeedPoiAuditInfo(true);
        param.setIsNeedRelShopUser(true);
        request.execute(accessToken);
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void editStore() {
        ShopEditStoreRequest request = new ShopEditStoreRequest();
        ShopEditStoreParam param = request.getParam();
        param.setStoreId(203751244L);
        OpenTime openTime = new OpenTime();
        HashMap<Long, String> map = new HashMap<>();
        map.put(1L, "10:00-19:00");
        map.put(2L, "10:00-19:00");
        map.put(3L, "10:00-19:00");
        map.put(4L, "10:00-19:00");
        map.put(5L, "10:00-19:00");
        map.put(6L, "10:00-19:00");
        map.put(7L, "10:00-19:00");
        openTime.setDayMap(map);
        param.setOpenTime(openTime);
        ShopEditStoreResponse response = request.execute(accessToken);
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }

    @Test
    public void delStore() {
        ShopDelStoreRequest request = new ShopDelStoreRequest();
        ShopDelStoreParam param = request.getParam();
        param.setStoreId(203740622L);
        ShopDelStoreResponse response = request.execute(accessToken);
        /* 202053460L
{"data":{},"log_id":"202412231646298440319E1E4FDB35001A","code":"10000","msg":"success","sub_code":"","sub_msg":""}
        * */
    }
}
