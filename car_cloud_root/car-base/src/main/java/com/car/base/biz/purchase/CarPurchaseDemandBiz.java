package com.car.base.biz.purchase;

import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.CarPurchaseDemandDetail;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;

import java.util.List;

/**
 * 求购信息 Biz 接口
 * 负责业务逻辑处理
 * 
 * @author system
 * @date 2026-01-25
 */
public interface CarPurchaseDemandBiz {

    /**
     * 创建求购信息（含车型明细）
     * 
     * @param demand     求购信息
     * @param detailList 车型明细列表
     * @return 是否成功
     */
    boolean createDemand(CarPurchaseDemand demand, List<CarPurchaseDemandDetail> detailList);

    /**
     * 更新求购信息
     * 
     * @param demand     求购信息
     * @param detailList 车型明细列表（将替换原有明细）
     * @return 是否成功
     */
    boolean modifyDemand(CarPurchaseDemand demand, List<CarPurchaseDemandDetail> detailList);

    /**
     * 删除求购信息（逻辑删除）
     * 
     * @param tid 主键ID
     * @return 是否成功
     */
    boolean removeDemand(Long tid);

    /**
     * 获取求购详情（含车型明细）
     * 
     * @param tid 主键ID
     * @return VO 对象
     */
    CarPurchaseDemandVO getDetail(Long tid);

    /**
     * 查询求购列表
     * 
     * @param query 查询条件
     * @return VO 列表
     */
    List<CarPurchaseDemandVO> queryList(CarPurchaseDemand query);

    /**
     * 查询用户的求购列表
     * 
     * @param userId 用户ID
     * @return VO 列表
     */
    List<CarPurchaseDemandVO> queryByUserId(Long userId);

    /**
     * 增加浏览次数
     * 
     * @param tid 主键ID
     */
    void addViewCount(Long tid);
}
