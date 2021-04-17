package com.commodityshareplatform.web.comment.controller;

import com.commodityshareplatform.web.comment.bean.Comment;
import com.commodityshareplatform.web.comment.bean.CommentExample;
import com.commodityshareplatform.web.comment.server.ICommentServer;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    ICommentServer commentServer;

    /**
     * 获取评论列表
     * @return
     */
    @RequestMapping(value = "comments",method = RequestMethod.POST)
    @ResponseBody
    public Result getCommentList(HttpServletRequest request){
        String commodityId = request.getParameter("commodityId") == null?"":request.getParameter("commodityId");

        //查询条件
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andCommentCommodityIdEqualTo(Integer.parseInt(commodityId));

        List<Comment> rs = commentServer.selectList(example);
        return ResultUtils.success(rs);
    }

    /**
     * 添加评论信息
     */
    @RequestMapping(value = "comment",method = RequestMethod.POST)
    @ResponseBody
    public Result<Comment> addCommodity(Comment comment){
        Integer result = commentServer.insertComment(comment);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"评论添加失败");
        }
    }
}
