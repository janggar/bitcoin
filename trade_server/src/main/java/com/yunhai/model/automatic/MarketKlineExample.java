package com.yunhai.model.automatic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MarketKlineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketKlineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIsNull() {
            addCriterion("moneyType is null");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIsNotNull() {
            addCriterion("moneyType is not null");
            return (Criteria) this;
        }

        public Criteria andMoneytypeEqualTo(String value) {
            addCriterion("moneyType =", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotEqualTo(String value) {
            addCriterion("moneyType <>", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeGreaterThan(String value) {
            addCriterion("moneyType >", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyType >=", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLessThan(String value) {
            addCriterion("moneyType <", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLessThanOrEqualTo(String value) {
            addCriterion("moneyType <=", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLike(String value) {
            addCriterion("moneyType like", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotLike(String value) {
            addCriterion("moneyType not like", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIn(List<String> values) {
            addCriterion("moneyType in", values, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotIn(List<String> values) {
            addCriterion("moneyType not in", values, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeBetween(String value1, String value2) {
            addCriterion("moneyType between", value1, value2, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotBetween(String value1, String value2) {
            addCriterion("moneyType not between", value1, value2, "moneytype");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNull() {
            addCriterion("symbol is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNotNull() {
            addCriterion("symbol is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolEqualTo(String value) {
            addCriterion("symbol =", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotEqualTo(String value) {
            addCriterion("symbol <>", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThan(String value) {
            addCriterion("symbol >", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("symbol >=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThan(String value) {
            addCriterion("symbol <", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThanOrEqualTo(String value) {
            addCriterion("symbol <=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLike(String value) {
            addCriterion("symbol like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotLike(String value) {
            addCriterion("symbol not like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolIn(List<String> values) {
            addCriterion("symbol in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotIn(List<String> values) {
            addCriterion("symbol not in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolBetween(String value1, String value2) {
            addCriterion("symbol between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotBetween(String value1, String value2) {
            addCriterion("symbol not between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIsNull() {
            addCriterion("openPrice is null");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIsNotNull() {
            addCriterion("openPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOpenpriceEqualTo(BigDecimal value) {
            addCriterion("openPrice =", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotEqualTo(BigDecimal value) {
            addCriterion("openPrice <>", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceGreaterThan(BigDecimal value) {
            addCriterion("openPrice >", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("openPrice >=", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceLessThan(BigDecimal value) {
            addCriterion("openPrice <", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("openPrice <=", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIn(List<BigDecimal> values) {
            addCriterion("openPrice in", values, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotIn(List<BigDecimal> values) {
            addCriterion("openPrice not in", values, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("openPrice between", value1, value2, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("openPrice not between", value1, value2, "openprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceIsNull() {
            addCriterion("endPrice is null");
            return (Criteria) this;
        }

        public Criteria andEndpriceIsNotNull() {
            addCriterion("endPrice is not null");
            return (Criteria) this;
        }

        public Criteria andEndpriceEqualTo(BigDecimal value) {
            addCriterion("endPrice =", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceNotEqualTo(BigDecimal value) {
            addCriterion("endPrice <>", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceGreaterThan(BigDecimal value) {
            addCriterion("endPrice >", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("endPrice >=", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceLessThan(BigDecimal value) {
            addCriterion("endPrice <", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("endPrice <=", value, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceIn(List<BigDecimal> values) {
            addCriterion("endPrice in", values, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceNotIn(List<BigDecimal> values) {
            addCriterion("endPrice not in", values, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endPrice between", value1, value2, "endprice");
            return (Criteria) this;
        }

        public Criteria andEndpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endPrice not between", value1, value2, "endprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceIsNull() {
            addCriterion("highPrice is null");
            return (Criteria) this;
        }

        public Criteria andHighpriceIsNotNull() {
            addCriterion("highPrice is not null");
            return (Criteria) this;
        }

        public Criteria andHighpriceEqualTo(BigDecimal value) {
            addCriterion("highPrice =", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceNotEqualTo(BigDecimal value) {
            addCriterion("highPrice <>", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceGreaterThan(BigDecimal value) {
            addCriterion("highPrice >", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("highPrice >=", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceLessThan(BigDecimal value) {
            addCriterion("highPrice <", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("highPrice <=", value, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceIn(List<BigDecimal> values) {
            addCriterion("highPrice in", values, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceNotIn(List<BigDecimal> values) {
            addCriterion("highPrice not in", values, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("highPrice between", value1, value2, "highprice");
            return (Criteria) this;
        }

        public Criteria andHighpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("highPrice not between", value1, value2, "highprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceIsNull() {
            addCriterion("lowPrice is null");
            return (Criteria) this;
        }

        public Criteria andLowpriceIsNotNull() {
            addCriterion("lowPrice is not null");
            return (Criteria) this;
        }

        public Criteria andLowpriceEqualTo(BigDecimal value) {
            addCriterion("lowPrice =", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceNotEqualTo(BigDecimal value) {
            addCriterion("lowPrice <>", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceGreaterThan(BigDecimal value) {
            addCriterion("lowPrice >", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lowPrice >=", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceLessThan(BigDecimal value) {
            addCriterion("lowPrice <", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lowPrice <=", value, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceIn(List<BigDecimal> values) {
            addCriterion("lowPrice in", values, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceNotIn(List<BigDecimal> values) {
            addCriterion("lowPrice not in", values, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowPrice between", value1, value2, "lowprice");
            return (Criteria) this;
        }

        public Criteria andLowpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowPrice not between", value1, value2, "lowprice");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(BigDecimal value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(BigDecimal value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(BigDecimal value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(BigDecimal value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<BigDecimal> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<BigDecimal> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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