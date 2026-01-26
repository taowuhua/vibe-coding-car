package com.car.base.biz.purchase.impl;

import com.car.base.biz.purchase.CarPurchaseDemandBiz;
import com.car.base.entity.purchase.CarPurchaseDemand;
import com.car.base.entity.purchase.CarPurchaseDemandDetail;
import com.car.base.entity.purchase.vo.CarPurchaseDemandVO;
import com.car.base.service.purchase.CarPurchaseDemandDetailService;
import com.car.base.service.purchase.CarPurchaseDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 求购信息 Biz 实现类
 * 负责业务逻辑处理
 * 
 * @author system
 * @date 2026-01-25
 */
@Service
public class CarPurchaseDemandBizImpl implements CarPurchaseDemandBiz {

    @Autowired
    private CarPurchaseDemandService carPurchaseDemandService;

    @Autowired
    private CarPurchaseDemandDetailService carPurchaseDemandDetailService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createDemand(CarPurchaseDemand demand, List<CarPurchaseDemandDetail> detailList) {
        // 业务逻辑：设置默认值
        if (demand.getStatus() == null) {
            demand.setStatus(1); // 默认启用
        }
        if (demand.getViewCount() == null) {
            demand.setViewCount(0);
        }
        if (demand.getCommentCount() == null) {
            demand.setCommentCount(0);
        }
        if (demand.getCreateDate() == null) {
            demand.setCreateDate(new Date());
        }

        // 保存求购信息
        boolean success = carPurchaseDemandService.save(demand);
        if (!success) {
            return false;
        }

        // 保存车型明细列表
        if (detailList != null && !detailList.isEmpty()) {
            for (CarPurchaseDemandDetail detail : detailList) {
                detail.setDemandId(demand.getTid());
                detail.setCreateUser(demand.getCreateUser());
                detail.setOperUser(demand.getOperUser());
            }
            carPurchaseDemandDetailService.batchSave(detailList);
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyDemand(CarPurchaseDemand demand, List<CarPurchaseDemandDetail> detailList) {
        // 业务逻辑：设置更新时间
        demand.setUpdateDate(new Date());

        // 更新求购信息
        boolean success = carPurchaseDemandService.update(demand);
        if (!success) {
            return false;
        }

        // 如果提供了新的明细列表，先删除旧的，再保存新的
        if (detailList != null) {
            carPurchaseDemandDetailService.deleteByDemandId(demand.getTid());
            if (!detailList.isEmpty()) {
                for (CarPurchaseDemandDetail detail : detailList) {
                    detail.setDemandId(demand.getTid());
                    detail.setCreateUser(demand.getOperUser());
                    detail.setOperUser(demand.getOperUser());
                }
                carPurchaseDemandDetailService.batchSave(detailList);
            }
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeDemand(Long tid) {
        // 逻辑删除求购信息
        return carPurchaseDemandService.delete(tid);
    }

    @Override
    public CarPurchaseDemandVO getDetail(Long tid) {
        // 查询基本信息
        CarPurchaseDemand demand = carPurchaseDemandService.getById(tid);
        if (demand == null) {
            return null;
        }

        // 构建 VO 对象
        CarPurchaseDemandVO vo = new CarPurchaseDemandVO();
        // 复制属性
        vo.setTid(demand.getTid());
        vo.setUserId(demand.getUserId());
        vo.setShopName(demand.getShopName());
        vo.setProvince(demand.getProvince());
        vo.setCity(demand.getCity());
        vo.setDescription(demand.getDescription());
        vo.setContactPhone(demand.getContactPhone());
        vo.setContactWechat(demand.getContactWechat());
        vo.setViewCount(demand.getViewCount());
        vo.setCommentCount(demand.getCommentCount());
        vo.setStatus(demand.getStatus());
        vo.setMemo(demand.getMemo());
        vo.setCreateUser(demand.getCreateUser());
        vo.setCreateDate(demand.getCreateDate());
        vo.setOperUser(demand.getOperUser());
        vo.setUpdateDate(demand.getUpdateDate());

        // 查询车型明细列表
        List<CarPurchaseDemandDetail> detailList = carPurchaseDemandDetailService.getByDemandId(tid);
        vo.setDetailList(detailList);

        // 生成相对时间文本
        vo.setCreateTimeText(formatRelativeTime(demand.getCreateDate()));

        return vo;
    }

    @Override
    public List<CarPurchaseDemandVO> queryList(CarPurchaseDemand query) {
        // 查询 VO 列表
        List<CarPurchaseDemandVO> voList = carPurchaseDemandService.getVoList(query);

        // 补充车型明细和相对时间
        for (CarPurchaseDemandVO vo : voList) {
            List<CarPurchaseDemandDetail> detailList = carPurchaseDemandDetailService.getByDemandId(vo.getTid());
            vo.setDetailList(detailList);
            vo.setCreateTimeText(formatRelativeTime(vo.getCreateDate()));
        }

        return voList;
    }

    @Override
    public List<CarPurchaseDemandVO> queryByUserId(Long userId) {
        // 查询用户的求购列表
        List<CarPurchaseDemand> demandList = carPurchaseDemandService.getByUserId(userId);
        List<CarPurchaseDemandVO> voList = new ArrayList<>();

        for (CarPurchaseDemand demand : demandList) {
            CarPurchaseDemandVO vo = getDetail(demand.getTid());
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }

    @Override
    public void addViewCount(Long tid) {
        // 增加浏览次数
        carPurchaseDemandService.incrementViewCount(tid);
    }

    /**
     * 格式化相对时间
     * 
     * @param date 日期
     * @return 相对时间文本（如：5分钟前）
     */
    private String formatRelativeTime(Date date) {
        if (date == null) {
            return "";
        }

        long diff = System.currentTimeMillis() - date.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (days > 30) {
            return (days / 30) + "个月前";
        } else if (days > 0) {
            return days + "天前";
        } else if (hours > 0) {
            return hours + "小时前";
        } else if (minutes > 0) {
            return minutes + "分钟前";
        } else {
            return "刚刚";
        }
    }
}
