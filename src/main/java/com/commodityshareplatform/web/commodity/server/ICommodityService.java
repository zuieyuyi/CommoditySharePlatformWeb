package com.commodityshareplatform.web.commodity.server;

import com.commodityshareplatform.web.commodity.bean.Commodity;

import java.util.List;

public interface ICommodityService {
    public List<Commodity> selectAllCommodities();

    public Commodity selectCommodityById(Integer id);

    public Integer deleteCommodityById(Integer id);

    public Integer updateCommodity(Commodity commodity);

    public Integer insertCommodity(Commodity commodity);

    public Integer deleteCommodityBatchById(List<Integer> ids);

    public Integer saveCommodityTags(Integer commodityId,String tags);

    public String getCommodityTags(Integer commodityId);
}
