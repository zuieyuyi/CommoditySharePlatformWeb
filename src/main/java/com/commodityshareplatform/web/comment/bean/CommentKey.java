package com.commodityshareplatform.web.comment.bean;

public class CommentKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.COMMENT_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    private Integer commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.COMMENT_USER_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    private Integer commentUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.COMMENT_COMMODITY_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    private Integer commentCommodityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.COMMENT_ID
     *
     * @return the value of t_comment.COMMENT_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.COMMENT_ID
     *
     * @param commentId the value for t_comment.COMMENT_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.COMMENT_USER_ID
     *
     * @return the value of t_comment.COMMENT_USER_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public Integer getCommentUserId() {
        return commentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.COMMENT_USER_ID
     *
     * @param commentUserId the value for t_comment.COMMENT_USER_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.COMMENT_COMMODITY_ID
     *
     * @return the value of t_comment.COMMENT_COMMODITY_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public Integer getCommentCommodityId() {
        return commentCommodityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.COMMENT_COMMODITY_ID
     *
     * @param commentCommodityId the value for t_comment.COMMENT_COMMODITY_ID
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void setCommentCommodityId(Integer commentCommodityId) {
        this.commentCommodityId = commentCommodityId;
    }
}