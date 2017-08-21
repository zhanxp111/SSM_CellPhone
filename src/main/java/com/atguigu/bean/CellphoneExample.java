package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class CellphoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CellphoneExample() {
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

        public Criteria andPhoneIdIsNull() {
            addCriterion("phone_id is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIdIsNotNull() {
            addCriterion("phone_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneIdEqualTo(Integer value) {
            addCriterion("phone_id =", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdNotEqualTo(Integer value) {
            addCriterion("phone_id <>", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdGreaterThan(Integer value) {
            addCriterion("phone_id >", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_id >=", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdLessThan(Integer value) {
            addCriterion("phone_id <", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdLessThanOrEqualTo(Integer value) {
            addCriterion("phone_id <=", value, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdIn(List<Integer> values) {
            addCriterion("phone_id in", values, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdNotIn(List<Integer> values) {
            addCriterion("phone_id not in", values, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdBetween(Integer value1, Integer value2) {
            addCriterion("phone_id between", value1, value2, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneIdNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_id not between", value1, value2, "phoneId");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIsNull() {
            addCriterion("phone_name is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIsNotNull() {
            addCriterion("phone_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNameEqualTo(String value) {
            addCriterion("phone_name =", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotEqualTo(String value) {
            addCriterion("phone_name <>", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameGreaterThan(String value) {
            addCriterion("phone_name >", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameGreaterThanOrEqualTo(String value) {
            addCriterion("phone_name >=", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLessThan(String value) {
            addCriterion("phone_name <", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLessThanOrEqualTo(String value) {
            addCriterion("phone_name <=", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLike(String value) {
            addCriterion("phone_name like", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotLike(String value) {
            addCriterion("phone_name not like", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIn(List<String> values) {
            addCriterion("phone_name in", values, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotIn(List<String> values) {
            addCriterion("phone_name not in", values, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameBetween(String value1, String value2) {
            addCriterion("phone_name between", value1, value2, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotBetween(String value1, String value2) {
            addCriterion("phone_name not between", value1, value2, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhonePriceIsNull() {
            addCriterion("phone_price is null");
            return (Criteria) this;
        }

        public Criteria andPhonePriceIsNotNull() {
            addCriterion("phone_price is not null");
            return (Criteria) this;
        }

        public Criteria andPhonePriceEqualTo(Double value) {
            addCriterion("phone_price =", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceNotEqualTo(Double value) {
            addCriterion("phone_price <>", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceGreaterThan(Double value) {
            addCriterion("phone_price >", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("phone_price >=", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceLessThan(Double value) {
            addCriterion("phone_price <", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceLessThanOrEqualTo(Double value) {
            addCriterion("phone_price <=", value, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceIn(List<Double> values) {
            addCriterion("phone_price in", values, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceNotIn(List<Double> values) {
            addCriterion("phone_price not in", values, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceBetween(Double value1, Double value2) {
            addCriterion("phone_price between", value1, value2, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhonePriceNotBetween(Double value1, Double value2) {
            addCriterion("phone_price not between", value1, value2, "phonePrice");
            return (Criteria) this;
        }

        public Criteria andPhoneColorIsNull() {
            addCriterion("phone_color is null");
            return (Criteria) this;
        }

        public Criteria andPhoneColorIsNotNull() {
            addCriterion("phone_color is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneColorEqualTo(String value) {
            addCriterion("phone_color =", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorNotEqualTo(String value) {
            addCriterion("phone_color <>", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorGreaterThan(String value) {
            addCriterion("phone_color >", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorGreaterThanOrEqualTo(String value) {
            addCriterion("phone_color >=", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorLessThan(String value) {
            addCriterion("phone_color <", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorLessThanOrEqualTo(String value) {
            addCriterion("phone_color <=", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorLike(String value) {
            addCriterion("phone_color like", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorNotLike(String value) {
            addCriterion("phone_color not like", value, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorIn(List<String> values) {
            addCriterion("phone_color in", values, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorNotIn(List<String> values) {
            addCriterion("phone_color not in", values, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorBetween(String value1, String value2) {
            addCriterion("phone_color between", value1, value2, "phoneColor");
            return (Criteria) this;
        }

        public Criteria andPhoneColorNotBetween(String value1, String value2) {
            addCriterion("phone_color not between", value1, value2, "phoneColor");
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