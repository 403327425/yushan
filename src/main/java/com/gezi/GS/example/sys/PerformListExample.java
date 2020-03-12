package com.gezi.GS.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerformListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerformListExample() {
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

        public Criteria andPerformIdIsNull() {
            addCriterion("perform_id is null");
            return (Criteria) this;
        }

        public Criteria andPerformIdIsNotNull() {
            addCriterion("perform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPerformIdEqualTo(Long value) {
            addCriterion("perform_id =", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotEqualTo(Long value) {
            addCriterion("perform_id <>", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdGreaterThan(Long value) {
            addCriterion("perform_id >", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdGreaterThanOrEqualTo(Long value) {
            addCriterion("perform_id >=", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdLessThan(Long value) {
            addCriterion("perform_id <", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdLessThanOrEqualTo(Long value) {
            addCriterion("perform_id <=", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdIn(List<Long> values) {
            addCriterion("perform_id in", values, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotIn(List<Long> values) {
            addCriterion("perform_id not in", values, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdBetween(Long value1, Long value2) {
            addCriterion("perform_id between", value1, value2, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotBetween(Long value1, Long value2) {
            addCriterion("perform_id not between", value1, value2, "performId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
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

        public Criteria andFinishNumberIsNull() {
            addCriterion("finish_number is null");
            return (Criteria) this;
        }

        public Criteria andFinishNumberIsNotNull() {
            addCriterion("finish_number is not null");
            return (Criteria) this;
        }

        public Criteria andFinishNumberEqualTo(Integer value) {
            addCriterion("finish_number =", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotEqualTo(Integer value) {
            addCriterion("finish_number <>", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberGreaterThan(Integer value) {
            addCriterion("finish_number >", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("finish_number >=", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberLessThan(Integer value) {
            addCriterion("finish_number <", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberLessThanOrEqualTo(Integer value) {
            addCriterion("finish_number <=", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberIn(List<Integer> values) {
            addCriterion("finish_number in", values, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotIn(List<Integer> values) {
            addCriterion("finish_number not in", values, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberBetween(Integer value1, Integer value2) {
            addCriterion("finish_number between", value1, value2, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("finish_number not between", value1, value2, "finishNumber");
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