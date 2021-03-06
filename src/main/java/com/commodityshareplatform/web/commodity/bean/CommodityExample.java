package com.commodityshareplatform.web.commodity.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommodityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public CommodityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCommodityIdIsNull() {
            addCriterion("COMMODITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("COMMODITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(Integer value) {
            addCriterion("COMMODITY_ID =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(Integer value) {
            addCriterion("COMMODITY_ID <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(Integer value) {
            addCriterion("COMMODITY_ID >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_ID >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(Integer value) {
            addCriterion("COMMODITY_ID <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_ID <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<Integer> values) {
            addCriterion("COMMODITY_ID in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<Integer> values) {
            addCriterion("COMMODITY_ID not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_ID between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_ID not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNull() {
            addCriterion("COMMODITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNotNull() {
            addCriterion("COMMODITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameEqualTo(String value) {
            addCriterion("COMMODITY_NAME =", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotEqualTo(String value) {
            addCriterion("COMMODITY_NAME <>", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThan(String value) {
            addCriterion("COMMODITY_NAME >", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITY_NAME >=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThan(String value) {
            addCriterion("COMMODITY_NAME <", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThanOrEqualTo(String value) {
            addCriterion("COMMODITY_NAME <=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLike(String value) {
            addCriterion("COMMODITY_NAME like", "%" + value + "%", "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotLike(String value) {
            addCriterion("COMMODITY_NAME not like", "%" + value + "%", "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIn(List<String> values) {
            addCriterion("COMMODITY_NAME in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotIn(List<String> values) {
            addCriterion("COMMODITY_NAME not in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameBetween(String value1, String value2) {
            addCriterion("COMMODITY_NAME between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotBetween(String value1, String value2) {
            addCriterion("COMMODITY_NAME not between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIsNull() {
            addCriterion("COMMODITY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIsNotNull() {
            addCriterion("COMMODITY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusEqualTo(Integer value) {
            addCriterion("COMMODITY_STATUS =", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotEqualTo(Integer value) {
            addCriterion("COMMODITY_STATUS <>", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusGreaterThan(Integer value) {
            addCriterion("COMMODITY_STATUS >", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_STATUS >=", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusLessThan(Integer value) {
            addCriterion("COMMODITY_STATUS <", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_STATUS <=", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIn(List<Integer> values) {
            addCriterion("COMMODITY_STATUS in", values, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotIn(List<Integer> values) {
            addCriterion("COMMODITY_STATUS not in", values, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_STATUS between", value1, value2, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_STATUS not between", value1, value2, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIsNull() {
            addCriterion("COMMODITY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIsNotNull() {
            addCriterion("COMMODITY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumEqualTo(Integer value) {
            addCriterion("COMMODITY_NUM =", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotEqualTo(Integer value) {
            addCriterion("COMMODITY_NUM <>", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumGreaterThan(Integer value) {
            addCriterion("COMMODITY_NUM >", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_NUM >=", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumLessThan(Integer value) {
            addCriterion("COMMODITY_NUM <", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumLessThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_NUM <=", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIn(List<Integer> values) {
            addCriterion("COMMODITY_NUM in", values, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotIn(List<Integer> values) {
            addCriterion("COMMODITY_NUM not in", values, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_NUM between", value1, value2, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_NUM not between", value1, value2, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdIsNull() {
            addCriterion("COMMODITY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdIsNotNull() {
            addCriterion("COMMODITY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdEqualTo(Integer value) {
            addCriterion("COMMODITY_USER_ID =", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdNotEqualTo(Integer value) {
            addCriterion("COMMODITY_USER_ID <>", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdGreaterThan(Integer value) {
            addCriterion("COMMODITY_USER_ID >", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_USER_ID >=", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdLessThan(Integer value) {
            addCriterion("COMMODITY_USER_ID <", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMMODITY_USER_ID <=", value, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdIn(List<Integer> values) {
            addCriterion("COMMODITY_USER_ID in", values, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdNotIn(List<Integer> values) {
            addCriterion("COMMODITY_USER_ID not in", values, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_USER_ID between", value1, value2, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMODITY_USER_ID not between", value1, value2, "commodityUserId");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcIsNull() {
            addCriterion("COMMODITY_IMG_SRC is null");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcIsNotNull() {
            addCriterion("COMMODITY_IMG_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcEqualTo(String value) {
            addCriterion("COMMODITY_IMG_SRC =", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcNotEqualTo(String value) {
            addCriterion("COMMODITY_IMG_SRC <>", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcGreaterThan(String value) {
            addCriterion("COMMODITY_IMG_SRC >", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITY_IMG_SRC >=", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcLessThan(String value) {
            addCriterion("COMMODITY_IMG_SRC <", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcLessThanOrEqualTo(String value) {
            addCriterion("COMMODITY_IMG_SRC <=", value, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcLike(String value) {
            addCriterion("COMMODITY_IMG_SRC like", "%" + value + "%", "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcNotLike(String value) {
            addCriterion("COMMODITY_IMG_SRC not like", "%" + value + "%", "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcIn(List<String> values) {
            addCriterion("COMMODITY_IMG_SRC in", values, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcNotIn(List<String> values) {
            addCriterion("COMMODITY_IMG_SRC not in", values, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcBetween(String value1, String value2) {
            addCriterion("COMMODITY_IMG_SRC between", value1, value2, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityImgSrcNotBetween(String value1, String value2) {
            addCriterion("COMMODITY_IMG_SRC not between", value1, value2, "commodityImgSrc");
            return (Criteria) this;
        }

        public Criteria andCommodityTagIsNull() {
            addCriterion("COMMODITY_TAG is null");
            return (Criteria) this;
        }

        public Criteria andCommodityTagIsNotNull() {
            addCriterion("COMMODITY_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityTagEqualTo(String value) {
            addCriterion("COMMODITY_TAG =", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagNotEqualTo(String value) {
            addCriterion("COMMODITY_TAG <>", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagGreaterThan(String value) {
            addCriterion("COMMODITY_TAG >", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITY_TAG >=", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagLessThan(String value) {
            addCriterion("COMMODITY_TAG <", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagLessThanOrEqualTo(String value) {
            addCriterion("COMMODITY_TAG <=", value, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagLike(String value) {
            addCriterion("COMMODITY_TAG like", "%" + value + "%", "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagNotLike(String value) {
            addCriterion("COMMODITY_TAG not like", "%" + value + "%", "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagIn(List<String> values) {
            addCriterion("COMMODITY_TAG in", values, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagNotIn(List<String> values) {
            addCriterion("COMMODITY_TAG not in", values, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagBetween(String value1, String value2) {
            addCriterion("COMMODITY_TAG between", value1, value2, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityTagNotBetween(String value1, String value2) {
            addCriterion("COMMODITY_TAG not between", value1, value2, "commodityTag");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityIsNull() {
            addCriterion("COMMODITY_QUALITY is null");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityIsNotNull() {
            addCriterion("COMMODITY_QUALITY is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityEqualTo(String value) {
            addCriterion("COMMODITY_QUALITY =", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityNotEqualTo(String value) {
            addCriterion("COMMODITY_QUALITY <>", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityGreaterThan(String value) {
            addCriterion("COMMODITY_QUALITY >", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityGreaterThanOrEqualTo(String value) {
            addCriterion("COMMODITY_QUALITY >=", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityLessThan(String value) {
            addCriterion("COMMODITY_QUALITY <", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityLessThanOrEqualTo(String value) {
            addCriterion("COMMODITY_QUALITY <=", value, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityLike(String value) {
            addCriterion("COMMODITY_QUALITY like", "%" + value + "%", "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityNotLike(String value) {
            addCriterion("COMMODITY_QUALITY not like", "%" + value + "%", "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityIn(List<String> values) {
            addCriterion("COMMODITY_QUALITY in", values, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityNotIn(List<String> values) {
            addCriterion("COMMODITY_QUALITY not in", values, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityBetween(String value1, String value2) {
            addCriterion("COMMODITY_QUALITY between", value1, value2, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityQualityNotBetween(String value1, String value2) {
            addCriterion("COMMODITY_QUALITY not between", value1, value2, "commodityQuality");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateIsNull() {
            addCriterion("COMMODITY_CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateIsNotNull() {
            addCriterion("COMMODITY_CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE =", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE <>", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE >", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE >=", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE <", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE <=", value, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE in", values, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE not in", values, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE between", value1, value2, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andCommodityCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMMODITY_CREATE_DATE not between", value1, value2, "commodityCreateDate");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("IS_VALID is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("IS_VALID is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Integer value) {
            addCriterion("IS_VALID =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Integer value) {
            addCriterion("IS_VALID <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Integer value) {
            addCriterion("IS_VALID >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_VALID >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Integer value) {
            addCriterion("IS_VALID <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Integer value) {
            addCriterion("IS_VALID <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Integer> values) {
            addCriterion("IS_VALID in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Integer> values) {
            addCriterion("IS_VALID not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Integer value1, Integer value2) {
            addCriterion("IS_VALID between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_VALID not between", value1, value2, "isValid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_commodity
     *
     * @mbg.generated do_not_delete_during_merge Fri Feb 12 16:54:45 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_commodity
     *
     * @mbg.generated Fri Feb 12 16:54:45 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}