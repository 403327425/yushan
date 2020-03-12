package com.gezi.hdlw.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudyDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudyDataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSdTypeIsNull() {
            addCriterion("sd_type is null");
            return (Criteria) this;
        }

        public Criteria andSdTypeIsNotNull() {
            addCriterion("sd_type is not null");
            return (Criteria) this;
        }

        public Criteria andSdTypeEqualTo(String value) {
            addCriterion("sd_type =", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeNotEqualTo(String value) {
            addCriterion("sd_type <>", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeGreaterThan(String value) {
            addCriterion("sd_type >", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sd_type >=", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeLessThan(String value) {
            addCriterion("sd_type <", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeLessThanOrEqualTo(String value) {
            addCriterion("sd_type <=", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeLike(String value) {
            addCriterion("sd_type like", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeNotLike(String value) {
            addCriterion("sd_type not like", value, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeIn(List<String> values) {
            addCriterion("sd_type in", values, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeNotIn(List<String> values) {
            addCriterion("sd_type not in", values, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeBetween(String value1, String value2) {
            addCriterion("sd_type between", value1, value2, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdTypeNotBetween(String value1, String value2) {
            addCriterion("sd_type not between", value1, value2, "sdType");
            return (Criteria) this;
        }

        public Criteria andSdNameIsNull() {
            addCriterion("sd_name is null");
            return (Criteria) this;
        }

        public Criteria andSdNameIsNotNull() {
            addCriterion("sd_name is not null");
            return (Criteria) this;
        }

        public Criteria andSdNameEqualTo(String value) {
            addCriterion("sd_name =", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameNotEqualTo(String value) {
            addCriterion("sd_name <>", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameGreaterThan(String value) {
            addCriterion("sd_name >", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameGreaterThanOrEqualTo(String value) {
            addCriterion("sd_name >=", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameLessThan(String value) {
            addCriterion("sd_name <", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameLessThanOrEqualTo(String value) {
            addCriterion("sd_name <=", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameLike(String value) {
            addCriterion("sd_name like", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameNotLike(String value) {
            addCriterion("sd_name not like", value, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameIn(List<String> values) {
            addCriterion("sd_name in", values, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameNotIn(List<String> values) {
            addCriterion("sd_name not in", values, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameBetween(String value1, String value2) {
            addCriterion("sd_name between", value1, value2, "sdName");
            return (Criteria) this;
        }

        public Criteria andSdNameNotBetween(String value1, String value2) {
            addCriterion("sd_name not between", value1, value2, "sdName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andSdPictureIsNull() {
            addCriterion("sd_picture is null");
            return (Criteria) this;
        }

        public Criteria andSdPictureIsNotNull() {
            addCriterion("sd_picture is not null");
            return (Criteria) this;
        }

        public Criteria andSdPictureEqualTo(String value) {
            addCriterion("sd_picture =", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureNotEqualTo(String value) {
            addCriterion("sd_picture <>", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureGreaterThan(String value) {
            addCriterion("sd_picture >", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureGreaterThanOrEqualTo(String value) {
            addCriterion("sd_picture >=", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureLessThan(String value) {
            addCriterion("sd_picture <", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureLessThanOrEqualTo(String value) {
            addCriterion("sd_picture <=", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureLike(String value) {
            addCriterion("sd_picture like", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureNotLike(String value) {
            addCriterion("sd_picture not like", value, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureIn(List<String> values) {
            addCriterion("sd_picture in", values, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureNotIn(List<String> values) {
            addCriterion("sd_picture not in", values, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureBetween(String value1, String value2) {
            addCriterion("sd_picture between", value1, value2, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdPictureNotBetween(String value1, String value2) {
            addCriterion("sd_picture not between", value1, value2, "sdPicture");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksIsNull() {
            addCriterion("sd_hyperlinks is null");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksIsNotNull() {
            addCriterion("sd_hyperlinks is not null");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksEqualTo(String value) {
            addCriterion("sd_hyperlinks =", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksNotEqualTo(String value) {
            addCriterion("sd_hyperlinks <>", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksGreaterThan(String value) {
            addCriterion("sd_hyperlinks >", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksGreaterThanOrEqualTo(String value) {
            addCriterion("sd_hyperlinks >=", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksLessThan(String value) {
            addCriterion("sd_hyperlinks <", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksLessThanOrEqualTo(String value) {
            addCriterion("sd_hyperlinks <=", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksLike(String value) {
            addCriterion("sd_hyperlinks like", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksNotLike(String value) {
            addCriterion("sd_hyperlinks not like", value, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksIn(List<String> values) {
            addCriterion("sd_hyperlinks in", values, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksNotIn(List<String> values) {
            addCriterion("sd_hyperlinks not in", values, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksBetween(String value1, String value2) {
            addCriterion("sd_hyperlinks between", value1, value2, "sdHyperlinks");
            return (Criteria) this;
        }

        public Criteria andSdHyperlinksNotBetween(String value1, String value2) {
            addCriterion("sd_hyperlinks not between", value1, value2, "sdHyperlinks");
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