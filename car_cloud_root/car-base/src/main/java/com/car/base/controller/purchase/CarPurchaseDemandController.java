package com.car.base.controller.purchase;

import com.car.base.biz.purchase.CarPurchaseDemandBiz;
import com.car.base.common.Result;
import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.CarPurchaseDemandDetail;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 求购信息控制器
 * 负责返回前端接口
 * 返回结构: {"code":"", "success":"", "data":{}, "message":""}
 * 
 * @author system
 * @date 2026-01-25
 */
@RestController
@RequestMapping("/api/car-base/api/purchase/demand")
public class CarPurchaseDemandController {

    @Autowired
    private CarPurchaseDemandBiz carPurchaseDemandBiz;

    /**
     * 发布求购信息
     * 
     * @param params 请求参数，包含 demand 和 detailList
     * @return 结果
     */
    @PostMapping("/add")
    @SuppressWarnings("unchecked")
    public Result<Boolean> add(@RequestBody Map<String, Object> params) {
        try {
            // 解析求购信息
            CarPurchaseDemand demand = parseDemand(params);

            // 解析车型明细列表
            List<CarPurchaseDemandDetail> detailList = parseDetailList(params);

            // 创建求购信息
            boolean success = carPurchaseDemandBiz.createDemand(demand, detailList);
            return success ? Result.success(true, "发布成功") : Result.error("发布失败");
        } catch (Exception e) {
            return Result.error("发布失败：" + e.getMessage());
        }
    }

    /**
     * 更新求购信息
     * 
     * @param params 请求参数
     * @return 结果
     */
    @PostMapping("/update")
    @SuppressWarnings("unchecked")
    public Result<Boolean> update(@RequestBody Map<String, Object> params) {
        try {
            // 解析求购信息
            CarPurchaseDemand demand = parseDemand(params);
            if (demand.getTid() == null) {
                return Result.error("缺少求购信息ID");
            }

            // 解析车型明细列表
            List<CarPurchaseDemandDetail> detailList = parseDetailList(params);

            // 更新求购信息
            boolean success = carPurchaseDemandBiz.modifyDemand(demand, detailList);
            return success ? Result.success(true, "更新成功") : Result.error("更新失败");
        } catch (Exception e) {
            return Result.error("更新失败：" + e.getMessage());
        }
    }

    /**
     * 删除求购信息
     * 
     * @param params 请求参数，包含 tid
     * @return 结果
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody Map<String, Object> params) {
        Object tidObj = params.get("tid");
        if (tidObj == null) {
            return Result.error("缺少求购信息ID");
        }
        Long tid = Long.valueOf(tidObj.toString());
        boolean success = carPurchaseDemandBiz.removeDemand(tid);
        return success ? Result.success(true, "删除成功") : Result.error("删除失败");
    }

    /**
     * 获取求购列表
     * 
     * @param query 查询条件
     * @return 列表
     */
    @PostMapping("/list")
    public Result<List<CarPurchaseDemandVO>> list(@RequestBody(required = false) CarPurchaseDemand query) {
        if (query == null) {
            query = new CarPurchaseDemand();
        }
        List<CarPurchaseDemandVO> list = carPurchaseDemandBiz.queryList(query);
        return Result.success(list);
    }

    /**
     * 获取求购详情
     * 
     * @param tid 序号
     * @return 详情
     */
    @GetMapping("/detail")
    public Result<CarPurchaseDemandVO> detail(@RequestParam Long tid) {
        // 增加浏览次数
        carPurchaseDemandBiz.addViewCount(tid);
        // 获取详情
        CarPurchaseDemandVO detail = carPurchaseDemandBiz.getDetail(tid);
        if (detail == null) {
            return Result.error("求购信息不存在");
        }
        return Result.success(detail);
    }

    /**
     * 获取我的求购列表
     * 
     * @param userId 用户ID
     * @return 列表
     */
    @PostMapping("/my")
    public Result<List<CarPurchaseDemandVO>> myDemands(@RequestBody Map<String, Object> params) {
        Object userIdObj = params.get("userId");
        if (userIdObj == null) {
            return Result.error("缺少用户ID");
        }
        Long userId = Long.valueOf(userIdObj.toString());
        List<CarPurchaseDemandVO> list = carPurchaseDemandBiz.queryByUserId(userId);
        return Result.success(list);
    }

    /**
     * 解析求购信息
     */
    @SuppressWarnings("unchecked")
    private CarPurchaseDemand parseDemand(Map<String, Object> params) {
        CarPurchaseDemand demand = new CarPurchaseDemand();

        // 获取 demand 对象（如果存在）
        Object demandObj = params.get("demand");
        Map<String, Object> demandMap = demandObj != null ? (Map<String, Object>) demandObj : params;

        // 解析字段
        if (demandMap.get("tid") != null) {
            demand.setTid(Long.valueOf(demandMap.get("tid").toString()));
        }
        if (demandMap.get("userId") != null) {
            demand.setUserId(Long.valueOf(demandMap.get("userId").toString()));
        }
        if (demandMap.get("shopName") != null) {
            demand.setShopName(demandMap.get("shopName").toString());
        }
        if (demandMap.get("province") != null) {
            demand.setProvince(demandMap.get("province").toString());
        }
        if (demandMap.get("city") != null) {
            demand.setCity(demandMap.get("city").toString());
        }
        if (demandMap.get("description") != null) {
            demand.setDescription(demandMap.get("description").toString());
        }
        if (demandMap.get("contactPhone") != null) {
            demand.setContactPhone(demandMap.get("contactPhone").toString());
        }
        if (demandMap.get("contactWechat") != null) {
            demand.setContactWechat(demandMap.get("contactWechat").toString());
        }
        if (demandMap.get("memo") != null) {
            demand.setMemo(demandMap.get("memo").toString());
        }
        if (demandMap.get("createUser") != null) {
            demand.setCreateUser(demandMap.get("createUser").toString());
        }
        if (demandMap.get("operUser") != null) {
            demand.setOperUser(demandMap.get("operUser").toString());
        }

        return demand;
    }

    /**
     * 解析车型明细列表
     */
    @SuppressWarnings("unchecked")
    private List<CarPurchaseDemandDetail> parseDetailList(Map<String, Object> params) {
        List<Map<String, Object>> detailMapList = (List<Map<String, Object>>) params.get("detailList");
        if (detailMapList == null || detailMapList.isEmpty()) {
            return null;
        }

        java.util.ArrayList<CarPurchaseDemandDetail> detailList = new java.util.ArrayList<>();
        for (Map<String, Object> detailMap : detailMapList) {
            CarPurchaseDemandDetail detail = new CarPurchaseDemandDetail();
            if (detailMap.get("brand") != null) {
                detail.setBrand(detailMap.get("brand").toString());
            }
            if (detailMap.get("model") != null) {
                detail.setModel(detailMap.get("model").toString());
            }
            if (detailMap.get("yearStart") != null) {
                detail.setYearStart(Integer.valueOf(detailMap.get("yearStart").toString()));
            }
            if (detailMap.get("yearEnd") != null) {
                detail.setYearEnd(Integer.valueOf(detailMap.get("yearEnd").toString()));
            }
            if (detailMap.get("memo") != null) {
                detail.setMemo(detailMap.get("memo").toString());
            }
            detailList.add(detail);
        }

        return detailList;
    }
}
