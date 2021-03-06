package com.gezi.GS.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskTypeListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskTypeListExample() {
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

        public Criteria andTaskTypeIdIsNull() {
            addCriterion("task_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdIsNotNull() {
            addCriterion("task_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdEqualTo(Integer value) {
            addCriterion("task_type_id =", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdNotEqualTo(Integer value) {
            addCriterion("task_type_id <>", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdGreaterThan(Integer value) {
            addCriterion("task_type_id >", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type_id >=", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdLessThan(Integer value) {
            addCriterion("task_type_id <", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_type_id <=", value, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdIn(List<Integer> values) {
            addCriterion("task_type_id in", values, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdNotIn(List<Integer> values) {
            addCriterion("task_type_id not in", values, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("task_type_id between", value1, value2, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type_id not between", value1, value2, "taskTypeId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNull() {
            addCriterion("task_type_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNotNull() {
            addCriterion("task_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameEqualTo(String value) {
            addCriterion("task_type_name =", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotEqualTo(String value) {
            addCriterion("task_type_name <>", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThan(String value) {
            addCriterion("task_type_name >", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_type_name >=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThan(String value) {
            addCriterion("task_type_name <", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThanOrEqualTo(String value) {
            addCriterion("task_type_name <=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLike(String value) {
            addCriterion("task_type_name like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotLike(String value) {
            addCriterion("task_type_name not like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIn(List<String> values) {
            addCriterion("task_type_name in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotIn(List<String> values) {
            addCriterion("task_type_name not in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameBetween(String value1, String value2) {
            addCriterion("task_type_name between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotBetween(String value1, String value2) {
            addCriterion("task_type_name not between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsIsNull() {
            addCriterion("reserved_fields is null");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsIsNotNull() {
            addCriterion("reserved_fields is not null");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsEqualTo(String value) {
            addCriterion("reserved_fields =", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsNotEqualTo(String value) {
            addCriterion("reserved_fields <>", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsGreaterThan(String value) {
            addCriterion("reserved_fields >", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsGreaterThanOrEqualTo(String value) {
            addCriterion("reserved_fields >=", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsLessThan(String value) {
            addCriterion("reserved_fields <", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsLessThanOrEqualTo(String value) {
            addCriterion("reserved_fields <=", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsLike(String value) {
            addCriterion("reserved_fields like", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsNotLike(String value) {
            addCriterion("reserved_fields not like", value, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsIn(List<String> values) {
            addCriterion("reserved_fields in", values, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsNotIn(List<String> values) {
            addCriterion("reserved_fields not in", values, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsBetween(String value1, String value2) {
            addCriterion("reserved_fields between", value1, value2, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andReservedFieldsNotBetween(String value1, String value2) {
            addCriterion("reserved_fields not between", value1, value2, "reservedFields");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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