package com.commodityshareplatform.web.commodity.controller;

import com.commodityshareplatform.web.commodity.bean.Commodity;
import com.commodityshareplatform.web.commodity.bean.CommodityExample;
import com.commodityshareplatform.web.commodity.server.ICommodityService;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("commodity")
public class CommodityController {
    private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);
    @Autowired
    ICommodityService commodityService;

    /**
     * 获取全部商品(分页)
     */
    @RequestMapping(value = "commodities",method = RequestMethod.GET)
    @ResponseBody
    public Result<PageInfo> getAllCommodities(HttpServletRequest request
            , @RequestParam(value = "pn",defaultValue = "1")Integer pn , @RequestParam(value = "ps",defaultValue = "5") Integer ps){
        PageHelper.startPage(pn,ps);
        CommodityExample example = new CommodityExample();
        CommodityExample.Criteria criteria = example.createCriteria();

        String commodityTag = request.getParameter("commodityTag") == null?"":request.getParameter("commodityTag");
        String commodityStatus = request.getParameter("commodityStatus") == null?"":request.getParameter("commodityStatus");
        String year = request.getParameter("year") == null?"":request.getParameter("year");
        String month = request.getParameter("month") == null?"":request.getParameter("month");

        //过滤条件
        if (!StringUtils.isEmpty(commodityTag)){
            criteria.andCommodityTagLike(commodityTag);
        }
        if(!StringUtils.isEmpty(commodityStatus)){
            criteria.andCommodityStatusEqualTo(Integer.parseInt(commodityStatus));
        }
        if(!StringUtils.isEmpty(year) || !StringUtils.isEmpty(month)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            Date date2 = null;
            try{
                if(!StringUtils.isEmpty(year) && !StringUtils.isEmpty(month)){
//                    if (month.length() == 1){
//                        month = "0" + month;
//                    }
                    date = sdf.parse(year+"-"+month+"-01");

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR,Integer.parseInt(year));
                    calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
                    int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                    date2 = sdf.parse(year+"-"+month+"-"+lastDay);
                }else if(StringUtils.isEmpty(month)){
                    date = sdf.parse(year+"-01-01");
                    date2 = sdf.parse(Integer.parseInt(year)+"-12-31");
                }
            }catch(Exception e){
                e.printStackTrace();
                logger.error(this.getClass().getName()+"---getAllCommodities---isError");
            }
            criteria.andCommodityCreateDateBetween(date,date2);
        }

        List<Commodity> commodities = commodityService.selectAllCommodities(example);
        PageInfo page = new PageInfo(commodities,ps);
        return ResultUtils.success(page);
    }

    /**
     * 通过id查商品
     */
    @RequestMapping(value = "commodity/{commodityId}",method = RequestMethod.GET)
    @ResponseBody
    public Result<Commodity> getCommodityById(@PathVariable("commodityId") Integer commodityId){
        Commodity commodity = commodityService.selectCommodityById(commodityId);
        return ResultUtils.success(commodity);
    }

    /**
     * 商品添加
     */
    @RequestMapping(value = "commodity",method = RequestMethod.POST)
    @ResponseBody
    public Result<Commodity> addCommodity(Commodity commodity){
        Integer result = commodityService.insertCommodity(commodity);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"商品添加失败");
        }
    }

    /**
     * 保存商品修改信息
     */
    @RequestMapping(value = "commodity",method = RequestMethod.PUT)
    @ResponseBody
    public Result<Commodity> saveCommodity(Commodity commodity){
        Integer result = commodityService.updateCommodity(commodity);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"商品保存失败");
        }
    }

    /**
     * 商品删除
     */
    @RequestMapping(value = "/commodity/{commodityId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Commodity> deleteCommodity(@PathVariable("commodityId") Integer commodityId){
        Integer result = commodityService.deleteCommodityById(commodityId);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"商品修改失败");
        }
    }

    /**
     * 保存商品标签
     */
    @RequestMapping(value = "/commodityTags/{commodityId}",method = RequestMethod.PUT)
    @ResponseBody
    public Result saveCommodityTags(@PathVariable("commodityId") Integer commodityId,@RequestParam("commodityTags") String commodityTags){
        Integer result = commodityService.saveCommodityTags(commodityId, commodityTags);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"商品修改失败");
        }
    }

    /**
     * 获取商品标签
     */
    @RequestMapping(value = "/commodityTags/{commodityId}",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getCommodityTags(@PathVariable("commodityId") Integer commodityId){
        String commodityTags = commodityService.getCommodityTags(commodityId);
        return ResultUtils.success(commodityTags);
    }

    /**
     * 更具主要标签获取该子标签
     */
    @RequestMapping(value = "/commodityTagsByMainTag",method = RequestMethod.GET)
    @ResponseBody
    public Result getCommodityTagsByMainTag(HttpServletRequest request){
        CommodityExample example = new CommodityExample();
        List<Commodity> commodities = commodityService.selectAllCommodities(example);
        Set<String> tagSet = new HashSet<>();

        String mainTag = request.getParameter("mainTag") == null?"":request.getParameter("mainTag");
        String tagSize = request.getParameter("tagSize") == null?"0":request.getParameter("tagSize");

        for (Commodity com:commodities){
            String commodityTag = com.getCommodityTag();
            if (!StringUtils.isEmpty(commodityTag)){
                String[] tags = commodityTag.split(",");
                if (tags[0].equals(mainTag) && tagSet.size() < Integer.parseInt(tagSize)){
                    for (int i = 1 ;i < tags.length; i++){
                        tagSet.add(tags[i]);
                    }
                }
            }
        }
        return ResultUtils.success(tagSet);
    }

}
