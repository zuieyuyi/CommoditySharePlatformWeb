package com.commodityshareplatform.web.commodity.controller;

import com.commodityshareplatform.web.commodity.bean.Commodity;
import com.commodityshareplatform.web.commodity.bean.CommodityExample;
import com.commodityshareplatform.web.commodity.server.ICommodityService;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("commodity")
public class CommodityController {
    private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);
    @Autowired
    ICommodityService commodityService;

//    /**
//     * 获取热租品列表
//     * @return
//     */
//    @RequestMapping(value = "hotCommodities",method = RequestMethod.GET)
//    @ResponseBody
//    public Result getHotCommodities(){
//
//    }

    /**
     * 获取全部商品(分页)
     */
    @RequestMapping(value = "commodities",method = RequestMethod.GET)
    @ResponseBody
    public Result<PageInfo> getCommodities(HttpServletRequest request
            , @RequestParam(value = "pn",defaultValue = "1")Integer pn , @RequestParam(value = "ps",defaultValue = "5") Integer ps){
        PageHelper.startPage(pn,ps);
        CommodityExample example = new CommodityExample();
        CommodityExample.Criteria criteria = example.createCriteria();

        String commodityTag = request.getParameter("commodityTag") == null?"":request.getParameter("commodityTag");
        String commodityStatus = request.getParameter("commodityStatus") == null?"":request.getParameter("commodityStatus");
        String year = request.getParameter("year") == null?"":request.getParameter("year");
        String month = request.getParameter("month") == null?"":request.getParameter("month");
        String userId = request.getParameter("userId") == null?"":request.getParameter("userId");
        String orderByAsc = request.getParameter("orderByAsc") == null?"":request.getParameter("orderByAsc");
        //搜索内容
        String search = request.getParameter("search") == null?"":request.getParameter("search").trim();


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
        if (!StringUtils.isEmpty(userId)){
            criteria.andCommodityUserIdEqualTo(Integer.parseInt(userId));
        }
        if (!StringUtils.isEmpty(orderByAsc)){
            example.setOrderByClause(orderByAsc + " asc");
        }
        //查询内容
        if (!StringUtils.isEmpty(search)){
            example.or().andCommodityNameLike(search);
            example.or().andCommodityTagLike(search);
            example.or().andCommodityQualityLike(search);
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
    public Result<Commodity> addCommodity(Commodity commodity,HttpServletRequest request){
        String contextPath = request.getServletContext().getRealPath("/uploadFile");
        logger.info("图片上传到的地址----"+contextPath);
        Date date = new Date();
        File imgPath = new File(contextPath + "/" + commodity.getCommodityUserId());
        logger.info("源文件地址----" + contextPath + "/" + commodity.getCommodityUserId());
        File[] files = imgPath.listFiles();
        if (files == null || files.length == 0){
            return ResultUtils.error(-1,"请上传图片");
        }
        //通过创建日期排序
        File img = files[files.length-1];

        File imgToDir = new File(imgPath.getPath() + "/" + date.getTime());//转移图片路径
        logger.info("转移图片路径----" + imgPath.getPath() + "/" + date.getTime());
        File img2 =  new File(imgToDir.getPath() + "/" + img.getName());

        //创建文件目录
        if (!imgToDir.exists()){
            imgToDir.mkdirs();
        }
        //**
        try {
            FileUtils.copyFile(img,img2);
            img.delete();
            logger.info("图片添加成功");
        } catch (IOException e) {
            return ResultUtils.error(-1,"图片添加失败");
        }

        commodity.setCommodityImgSrc("/uploadFile/" + commodity.getCommodityUserId() + "/" + date.getTime() + "/" + img2.getName());
        //**
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
    public Result<Commodity> saveCommodity(Commodity commodity,HttpServletRequest request){
        //获取商品图片路径
        //默认web地址
        String contextPath = request.getServletContext().getRealPath("");
        logger.info("默认web地址----"+contextPath);
        Commodity com = commodityService.selectCommodityById(commodity.getCommodityId());
        //图片与默认web地址的相对路径
        String commodityImgSrc = com.getCommodityImgSrc();
        logger.info("图片与默认web地址的相对路径----"+commodityImgSrc);
        //原图
        File oldImg = new File(contextPath + "/" + commodityImgSrc);
        logger.info("原图----" + contextPath + "/" + commodityImgSrc);
        //上传图片地址
        File imgPath = new File(contextPath + "/uploadFile/" + com.getCommodityUserId());
        logger.info("上传图片地址----" + contextPath + "/uploadFile/" + com.getCommodityUserId());
        File[] files = imgPath.listFiles();
        if (files == null){
            return ResultUtils.error(-1,"请上传文件");
        }else{
            //新图
            File newImg = files[files.length-1];;
            if(newImg.isFile()){
                //删除旧图片
                oldImg.delete();
                //转移新图
                File newImgTo = new File(oldImg.getParent(),newImg.getName());
                try {
                    FileUtils.copyFile(newImg,newImgTo);
                    commodity.setCommodityImgSrc(com.getCommodityImgSrc().replaceAll(oldImg.getName(),"") + newImg.getName());
                    newImg.delete();
                } catch (IOException e) {
                    return ResultUtils.error(-1,"图片添加失败");
                }
            }
        }

        if (commodity.getCommodityId() == null || commodity.getCommodityId() == 0){
            return ResultUtils.error(-1,"商品保存失败");
        }
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

    /**
     * 保存图片
     * @param file
     * @return
     */
    @RequestMapping(value = "imgUpload",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String contextPath = request.getServletContext().getRealPath("/uploadFile");
        //根据文件创建目录
        String userId = request.getParameter("userId") == null?"":request.getParameter("userId");
//        String commodityId = request.getParameter("commodityId") == null?"":request.getParameter("commodityId");
        File dir = null;
        if (!StringUtils.isEmpty(userId)){
            dir = new File(contextPath+"/"+userId);
            if (!dir.exists()){
                dir.mkdirs();
//                contextPath += "\\" + userId;
            }else {
                File[] files = dir.listFiles();
                for (File f: files){
                    if (f.isFile()){
                        f.delete();
                    }
                }
            }
        }
        logger.info("文件上传到----" + dir.getPath());

        String originalFilename = file.getOriginalFilename();
        // 生成文件新的名字
        String newFileName = UUID.randomUUID() + originalFilename;
        logger.info("文件名为----" + newFileName);
        // 封装上传文件位置的全路径
        File targetFile = new File(dir, newFileName);
        file.transferTo(targetFile);

        return ResultUtils.success();
    }
}
