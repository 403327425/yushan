package com.gezi.hdlw.example.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LwEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LwEmployeeExample() {
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

        public Criteria andEkIdIsNull() {
            addCriterion("ek_id is null");
            return (Criteria) this;
        }

        public Criteria andEkIdIsNotNull() {
            addCriterion("ek_id is not null");
            return (Criteria) this;
        }

        public Criteria andEkIdEqualTo(Integer value) {
            addCriterion("ek_id =", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdNotEqualTo(Integer value) {
            addCriterion("ek_id <>", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdGreaterThan(Integer value) {
            addCriterion("ek_id >", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ek_id >=", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdLessThan(Integer value) {
            addCriterion("ek_id <", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdLessThanOrEqualTo(Integer value) {
            addCriterion("ek_id <=", value, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdIn(List<Integer> values) {
            addCriterion("ek_id in", values, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdNotIn(List<Integer> values) {
            addCriterion("ek_id not in", values, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdBetween(Integer value1, Integer value2) {
            addCriterion("ek_id between", value1, value2, "ekId");
            return (Criteria) this;
        }

        public Criteria andEkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ek_id not between", value1, value2, "ekId");
            return (Criteria) this;
        }

        public Criteria andPostIsNull() {
            addCriterion("post is null");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("post is not null");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(Integer value) {
            addCriterion("post =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(Integer value) {
            addCriterion("post <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(Integer value) {
            addCriterion("post >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(Integer value) {
            addCriterion("post >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(Integer value) {
            addCriterion("post <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(Integer value) {
            addCriterion("post <=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostIn(List<Integer> values) {
            addCriterion("post in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<Integer> values) {
            addCriterion("post not in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(Integer value1, Integer value2) {
            addCriterion("post between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(Integer value1, Integer value2) {
            addCriterion("post not between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andEContactWayIsNull() {
            addCriterion("e_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andEContactWayIsNotNull() {
            addCriterion("e_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andEContactWayEqualTo(String value) {
            addCriterion("e_contact_way =", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayNotEqualTo(String value) {
            addCriterion("e_contact_way <>", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayGreaterThan(String value) {
            addCriterion("e_contact_way >", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("e_contact_way >=", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayLessThan(String value) {
            addCriterion("e_contact_way <", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayLessThanOrEqualTo(String value) {
            addCriterion("e_contact_way <=", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayLike(String value) {
            addCriterion("e_contact_way like", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayNotLike(String value) {
            addCriterion("e_contact_way not like", value, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayIn(List<String> values) {
            addCriterion("e_contact_way in", values, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayNotIn(List<String> values) {
            addCriterion("e_contact_way not in", values, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayBetween(String value1, String value2) {
            addCriterion("e_contact_way between", value1, value2, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEContactWayNotBetween(String value1, String value2) {
            addCriterion("e_contact_way not between", value1, value2, "eContactWay");
            return (Criteria) this;
        }

        public Criteria andEStatusIsNull() {
            addCriterion("e_status is null");
            return (Criteria) this;
        }

        public Criteria andEStatusIsNotNull() {
            addCriterion("e_status is not null");
            return (Criteria) this;
        }

        public Criteria andEStatusEqualTo(Integer value) {
            addCriterion("e_status =", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusNotEqualTo(Integer value) {
            addCriterion("e_status <>", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusGreaterThan(Integer value) {
            addCriterion("e_status >", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_status >=", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusLessThan(Integer value) {
            addCriterion("e_status <", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusLessThanOrEqualTo(Integer value) {
            addCriterion("e_status <=", value, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusIn(List<Integer> values) {
            addCriterion("e_status in", values, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusNotIn(List<Integer> values) {
            addCriterion("e_status not in", values, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusBetween(Integer value1, Integer value2) {
            addCriterion("e_status between", value1, value2, "eStatus");
            return (Criteria) this;
        }

        public Criteria andEStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("e_status not between", value1, value2, "eStatus");
            return (Criteria) this;
        }

        public Criteria andECreationTimeIsNull() {
            addCriterion("e_creation_time is null");
            return (Criteria) this;
        }

        public Criteria andECreationTimeIsNotNull() {
            addCriterion("e_creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andECreationTimeEqualTo(Date value) {
            addCriterion("e_creation_time =", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeNotEqualTo(Date value) {
            addCriterion("e_creation_time <>", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeGreaterThan(Date value) {
            addCriterion("e_creation_time >", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_creation_time >=", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeLessThan(Date value) {
            addCriterion("e_creation_time <", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("e_creation_time <=", value, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeIn(List<Date> values) {
            addCriterion("e_creation_time in", values, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeNotIn(List<Date> values) {
            addCriterion("e_creation_time not in", values, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeBetween(Date value1, Date value2) {
            addCriterion("e_creation_time between", value1, value2, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andECreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("e_creation_time not between", value1, value2, "eCreationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeIsNull() {
            addCriterion("e_modification_time is null");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeIsNotNull() {
            addCriterion("e_modification_time is not null");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeEqualTo(Date value) {
            addCriterion("e_modification_time =", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeNotEqualTo(Date value) {
            addCriterion("e_modification_time <>", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeGreaterThan(Date value) {
            addCriterion("e_modification_time >", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_modification_time >=", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeLessThan(Date value) {
            addCriterion("e_modification_time <", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("e_modification_time <=", value, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeIn(List<Date> values) {
            addCriterion("e_modification_time in", values, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeNotIn(List<Date> values) {
            addCriterion("e_modification_time not in", values, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeBetween(Date value1, Date value2) {
            addCriterion("e_modification_time between", value1, value2, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEModificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("e_modification_time not between", value1, value2, "eModificationTime");
            return (Criteria) this;
        }

        public Criteria andEOperatorIsNull() {
            addCriterion("e_operator is null");
            return (Criteria) this;
        }

        public Criteria andEOperatorIsNotNull() {
            addCriterion("e_operator is not null");
            return (Criteria) this;
        }

        public Criteria andEOperatorEqualTo(Integer value) {
            addCriterion("e_operator =", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorNotEqualTo(Integer value) {
            addCriterion("e_operator <>", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorGreaterThan(Integer value) {
            addCriterion("e_operator >", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_operator >=", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorLessThan(Integer value) {
            addCriterion("e_operator <", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("e_operator <=", value, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorIn(List<Integer> values) {
            addCriterion("e_operator in", values, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorNotIn(List<Integer> values) {
            addCriterion("e_operator not in", values, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorBetween(Integer value1, Integer value2) {
            addCriterion("e_operator between", value1, value2, "eOperator");
            return (Criteria) this;
        }

        public Criteria andEOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("e_operator not between", value1, value2, "eOperator");
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