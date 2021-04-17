package com.commodityshareplatform.web.comment.server;

import com.commodityshareplatform.web.comment.bean.Comment;
import com.commodityshareplatform.web.comment.bean.CommentExample;

import java.util.List;

public interface ICommentServer {
    public List<Comment> selectList(CommentExample example);

    public Integer insertComment(Comment comment);
}
