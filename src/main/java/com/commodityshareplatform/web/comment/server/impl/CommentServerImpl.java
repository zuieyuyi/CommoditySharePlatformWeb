package com.commodityshareplatform.web.comment.server.impl;

import com.commodityshareplatform.web.comment.bean.Comment;
import com.commodityshareplatform.web.comment.bean.CommentExample;
import com.commodityshareplatform.web.comment.dao.CommentMapper;
import com.commodityshareplatform.web.comment.server.ICommentServer;
import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.server.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServerImpl implements ICommentServer {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserService userService;

    @Override
    public List<Comment> selectList(CommentExample example) {
        List<Comment> comments = commentMapper.selectByExample(example);
        for (Comment comment:comments){
            //查出发布用户信息
            Integer commentUserId = comment.getCommentUserId();
            User user = userService.selectUserById(commentUserId);
            comment.setCommentUserName(user.getUserName());
        }
        return comments;
    }

    @Override
    public Integer insertComment(Comment comment) {
        Date date = new Date();
        comment.setCommentCreateTime(date);
        int result = commentMapper.insert(comment);
        return result;
    }
}
