package com.gezi.hdlw.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LwUserBelongsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LwUserBelongsExample() {
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

        public Criteria andUbkIdIsNull() {
            addCriterion("ubk_id is null");
            return (Criteria) this;
        }

        public Criteria andUbkIdIsNotNull() {
            addCriterion("ubk_id is not null");
            return (Criteria) this;
        }

        public Criteria andUbkIdEqualTo(Integer value) {
            addCriterion("ubk_id =", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdNotEqualTo(Integer value) {
            addCriterion("ubk_id <>", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdGreaterThan(Integer value) {
            addCriterion("ubk_id >", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ubk_id >=", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdLessThan(Integer value) {
            addCriterion("ubk_id <", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdLessThanOrEqualTo(Integer value) {
            addCriterion("ubk_id <=", value, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdIn(List<Integer> values) {
            addCriterion("ubk_id in", values, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdNotIn(List<Integer> values) {
            addCriterion("ubk_id not in", values, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdBetween(Integer value1, Integer value2) {
            addCriterion("ubk_id between", value1, value2, "ubkId");
            return (Criteria) this;
        }

        public Criteria andUbkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ubk_id not between", value1, value2, "ubkId");
            return (Criteria) this;
        }

        public Criteria andAkIdIsNull() {
            addCriterion("ak_id is null");
            return (Criteria) this;
        }

        public Criteria andAkIdIsNotNull() {
            addCriterion("ak_id is not null");
            return (Criteria) this;
        }

        public Criteria andAkIdEqualTo(Integer value) {
            addCriterion("ak_id =", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdNotEqualTo(Integer value) {
            addCriterion("ak_id <>", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdGreaterThan(Integer value) {
            addCriterion("ak_id >", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ak_id >=", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdLessThan(Integer value) {
            addCriterion("ak_id <", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdLessThanOrEqualTo(Integer value) {
            addCriterion("ak_id <=", value, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdIn(List<Integer> values) {
            addCriterion("ak_id in", values, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdNotIn(List<Integer> values) {
            addCriterion("ak_id not in", values, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdBetween(Integer value1, Integer value2) {
            addCriterion("ak_id between", value1, value2, "akId");
            return (Criteria) this;
        }

        public Criteria andAkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ak_id not between", value1, value2, "akId");
            return (Criteria) this;
        }

        public Criteria andFkIdIsNull() {
            addCriterion("fk_id is null");
            return (Criteria) this;
        }

        public Criteria andFkIdIsNotNull() {
            addCriterion("fk_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkIdEqualTo(String value) {
            addCriterion("fk_id =", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdNotEqualTo(String value) {
            addCriterion("fk_id <>", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdGreaterThan(String value) {
            addCriterion("fk_id >", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_id >=", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdLessThan(String value) {
            addCriterion("fk_id <", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdLessThanOrEqualTo(String value) {
            addCriterion("fk_id <=", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdLike(String value) {
            addCriterion("fk_id like", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdNotLike(String value) {
            addCriterion("fk_id not like", value, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdIn(List<String> values) {
            addCriterion("fk_id in", values, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdNotIn(List<String> values) {
            addCriterion("fk_id not in", values, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdBetween(String value1, String value2) {
            addCriterion("fk_id between", value1, value2, "fkId");
            return (Criteria) this;
        }

        public Criteria andFkIdNotBetween(String value1, String value2) {
            addCriterion("fk_id not between", value1, value2, "fkId");
            return (Criteria) this;
        }

        public Criteria andSkIdIsNull() {
            addCriterion("sk_id is null");
            return (Criteria) this;
        }

        public Criteria andSkIdIsNotNull() {
            addCriterion("sk_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkIdEqualTo(String value) {
            addCriterion("sk_id =", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdNotEqualTo(String value) {
            addCriterion("sk_id <>", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdGreaterThan(String value) {
            addCriterion("sk_id >", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdGreaterThanOrEqualTo(String value) {
            addCriterion("sk_id >=", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdLessThan(String value) {
            addCriterion("sk_id <", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdLessThanOrEqualTo(String value) {
            addCriterion("sk_id <=", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdLike(String value) {
            addCriterion("sk_id like", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdNotLike(String value) {
            addCriterion("sk_id not like", value, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdIn(List<String> values) {
            addCriterion("sk_id in", values, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdNotIn(List<String> values) {
            addCriterion("sk_id not in", values, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdBetween(String value1, String value2) {
            addCriterion("sk_id between", value1, value2, "skId");
            return (Criteria) this;
        }

        public Criteria andSkIdNotBetween(String value1, String value2) {
            addCriterion("sk_id not between", value1, value2, "skId");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeIsNull() {
            addCriterion("ub_creation_time is null");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeIsNotNull() {
            addCriterion("ub_creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeEqualTo(Date value) {
            addCriterion("ub_creation_time =", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeNotEqualTo(Date value) {
            addCriterion("ub_creation_time <>", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeGreaterThan(Date value) {
            addCriterion("ub_creation_time >", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ub_creation_time >=", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeLessThan(Date value) {
            addCriterion("ub_creation_time <", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("ub_creation_time <=", value, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeIn(List<Date> values) {
            addCriterion("ub_creation_time in", values, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeNotIn(List<Date> values) {
            addCriterion("ub_creation_time not in", values, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeBetween(Date value1, Date value2) {
            addCriterion("ub_creation_time between", value1, value2, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("ub_creation_time not between", value1, value2, "ubCreationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeIsNull() {
            addCriterion("ub_modification_time is null");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeIsNotNull() {
            addCriterion("ub_modification_time is not null");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeEqualTo(Date value) {
            addCriterion("ub_modification_time =", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeNotEqualTo(Date value) {
            addCriterion("ub_modification_time <>", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeGreaterThan(Date value) {
            addCriterion("ub_modification_time >", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ub_modification_time >=", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeLessThan(Date value) {
            addCriterion("ub_modification_time <", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("ub_modification_time <=", value, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeIn(List<Date> values) {
            addCriterion("ub_modification_time in", values, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeNotIn(List<Date> values) {
            addCriterion("ub_modification_time not in", values, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeBetween(Date value1, Date value2) {
            addCriterion("ub_modification_time between", value1, value2, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbModificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("ub_modification_time not between", value1, value2, "ubModificationTime");
            return (Criteria) this;
        }

        public Criteria andUbOperatorIsNull() {
            addCriterion("ub_operator is null");
            return (Criteria) this;
        }

        public Criteria andUbOperatorIsNotNull() {
            addCriterion("ub_operator is not null");
            return (Criteria) this;
        }

        public Criteria andUbOperatorEqualTo(Integer value) {
            addCriterion("ub_operator =", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorNotEqualTo(Integer value) {
            addCriterion("ub_operator <>", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorGreaterThan(Integer value) {
            addCriterion("ub_operator >", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("ub_operator >=", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorLessThan(Integer value) {
            addCriterion("ub_operator <", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("ub_operator <=", value, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorIn(List<Integer> values) {
            addCriterion("ub_operator in", values, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorNotIn(List<Integer> values) {
            addCriterion("ub_operator not in", values, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorBetween(Integer value1, Integer value2) {
            addCriterion("ub_operator between", value1, value2, "ubOperator");
            return (Criteria) this;
        }

        public Criteria andUbOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("ub_operator not between", value1, value2, "ubOperator");
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