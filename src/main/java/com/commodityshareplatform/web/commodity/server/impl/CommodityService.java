package com.commodityshareplatform.web.commodity.server.impl;

import com.commodityshareplatform.web.commodity.bean.Commodity;
import com.commodityshareplatform.web.commodity.bean.CommodityExample;
import com.commodityshareplatform.web.commodity.dao.CommodityMapper;
import com.commodityshareplatform.web.commodity.server.ICommodityService;
import com.commodityshareplatform.web.enuminfo.CommodityStatusEnum;
import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.bean.UserExample;
import com.commodityshareplatform.web.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class CommodityService implements ICommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    UserMapper userMapper;

//    @Value("${commodity.imgSrc}")
//    private String ImgSrc;

    @Override
    public List<Commodity> selectAllCommodities(CommodityExample example) {
//        CommodityExample commodityExample = new CommodityExample();
//        CommodityExample.Criteria criteria = commodityExample.createCriteria();
//        criteria.andIsValidEqualTo(1);
//        List<Commodity> commodities = commodityMapper.selectByExample(null);
        List<Commodity> commodities = commodityMapper.selectAllCommodities(example);

        List<User> users = userMapper.selectByExample(null);

        for (Commodity commodity:commodities){
            //判断商品的状态
            if (commodity.getCommodityStatus() == CommodityStatusEnum.NOR_SELL.getStatusCode())
                commodity.setCommodityStatusMsg(CommodityStatusEnum.NOR_SELL.getStatus());
            else if (commodity.getCommodityStatus() == CommodityStatusEnum.SELL.getStatusCode())
                commodity.setCommodityStatusMsg(CommodityStatusEnum.SELL.getStatus());
            else if (commodity.getCommodityStatus() == CommodityStatusEnum.SELL_OUT.getStatusCode())
                commodity.setCommodityStatusMsg(CommodityStatusEnum.SELL_OUT.getStatus());

            if (commodity.getCommodityUserId() == null){
                commodity.setCommodityUserName("无用户");
                continue;
            }

//            if(commodity.getCommodityImgSrc() == null){
//                commodity.setCommodityImgSrc(ImgSrc);
//            }
            //获取用户名
            for (User user:users) {
                if (commodity.getCommodityUserId().equals(user.getUserId())) {
                    //判断用户是否有效
                    if (user.getIsValid() == 1){
                        commodity.setCommodityUserName(user.getUserName());
                    }else if (user.getIsValid() == 0){
                        commodity.setCommodityUserName("用户已失效");
                    }else {
                        commodity.setCommodityUserName("无用户");
                    }
                }
            }
        }

        return commodities;
    }

    @Override
    public Commodity selectCommodityById(Integer id) {
        //查询出商品信息
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdEqualTo(id);
//        criteria.andIsValidEqualTo(1);
        List<Commodity> commodities = commodityMapper.selectByExample(commodityExample);
        Commodity commodity = commodities.get(0);

        //判断商品的状态
        if (commodity.getCommodityStatus() == CommodityStatusEnum.NOR_SELL.getStatusCode())
            commodity.setCommodityStatusMsg(CommodityStatusEnum.NOR_SELL.getStatus());
        else if (commodity.getCommodityStatus() == CommodityStatusEnum.SELL.getStatusCode())
            commodity.setCommodityStatusMsg(CommodityStatusEnum.SELL.getStatus());
        else if (commodity.getCommodityStatus() == CommodityStatusEnum.SELL_OUT.getStatusCode())
            commodity.setCommodityStatusMsg(CommodityStatusEnum.SELL_OUT.getStatus());

        if (commodity.getCommodityUserId() != null){
            //通过商品属性找到对应的卖家
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUserIdEqualTo(commodity.getCommodityUserId());
            List<User> users = userMapper.selectByExample(userExample);
            User user = null;
            if (users.size() != 0){
                user = users.get(0);
                //赋值
                commodity.setCommodityUserName(user.getUserName());
            }else {
                commodity.setCommodityUserName("卖家账号已注销");
            }
        }

        return commodity;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 2,
            rollbackFor = {Exception.class})
    @Override
    public Integer deleteCommodityById(Integer id) {
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdEqualTo(id);
        Commodity commodity = selectCommodityById(id);
        commodity.setIsValid(0);
        int result = commodityMapper.updateByExample(commodity, commodityExample);
        return result;
    }

    @Override
    public Integer updateCommodity(Commodity commodity) {
        //需要先查出商品信息
//        Commodity commodity1 = selectCommodityById(commodity.getCommodityId());
//        commodity1.setCommodityName(commodity.getCommodityName());
//        commodity1.setCommodityStatus(commodity.getCommodityStatus());
//        commodity1.setCommodityNum(commodity.getCommodityNum());
//        commodity1.setCommodityUserId(commodity.getCommodityUserId());
//        commodity1.setCommodityQuality(commodity.getCommodityQuality());

        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdEqualTo(commodity.getCommodityId());

        int result = commodityMapper.updateByExampleSelective(commodity,commodityExample);
        return result;
    }

    @Override
    public Integer insertCommodity(Commodity commodity) {
        Date createDate = new Date();
        commodity.setCommodityCreateDate(createDate);
        commodity.setIsValid(1);
        //转运图片


        int result = commodityMapper.insertSelective(commodity);
        return result;
    }
    
    @Override
    public Integer deleteCommodityBatchById(List<Integer> ids) {
        Integer result = 0;
        for (Integer id:ids){
            result += deleteCommodityById(id);
        }
        return result;
    }

    @Override
    public Integer saveCommodityTags(Integer commodityId,String tags){
        Commodity commodity = selectCommodityById(commodityId);
        commodity.setCommodityTag(tags);

        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdEqualTo(commodity.getCommodityId());
        int result = commodityMapper.updateByExampleSelective(commodity, commodityExample);
        return result;
    }

    @Override
    public String getCommodityTags(Integer commodityId){
        Commodity commodity = selectCommodityById(commodityId);
        String commodityTags = commodity.getCommodityTag();
        return commodityTags;
    }
}
