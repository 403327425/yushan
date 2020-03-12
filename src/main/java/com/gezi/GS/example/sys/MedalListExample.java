package com.gezi.GS.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedalListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedalListExample() {
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

        public Criteria andMadelIdIsNull() {
            addCriterion("madel_id is null");
            return (Criteria) this;
        }

        public Criteria andMadelIdIsNotNull() {
            addCriterion("madel_id is not null");
            return (Criteria) this;
        }

        public Criteria andMadelIdEqualTo(Integer value) {
            addCriterion("madel_id =", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdNotEqualTo(Integer value) {
            addCriterion("madel_id <>", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdGreaterThan(Integer value) {
            addCriterion("madel_id >", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("madel_id >=", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdLessThan(Integer value) {
            addCriterion("madel_id <", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdLessThanOrEqualTo(Integer value) {
            addCriterion("madel_id <=", value, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdIn(List<Integer> values) {
            addCriterion("madel_id in", values, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdNotIn(List<Integer> values) {
            addCriterion("madel_id not in", values, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdBetween(Integer value1, Integer value2) {
            addCriterion("madel_id between", value1, value2, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("madel_id not between", value1, value2, "madelId");
            return (Criteria) this;
        }

        public Criteria andMadelNameIsNull() {
            addCriterion("madel_name is null");
            return (Criteria) this;
        }

        public Criteria andMadelNameIsNotNull() {
            addCriterion("madel_name is not null");
            return (Criteria) this;
        }

        public Criteria andMadelNameEqualTo(String value) {
            addCriterion("madel_name =", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameNotEqualTo(String value) {
            addCriterion("madel_name <>", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameGreaterThan(String value) {
            addCriterion("madel_name >", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameGreaterThanOrEqualTo(String value) {
            addCriterion("madel_name >=", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameLessThan(String value) {
            addCriterion("madel_name <", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameLessThanOrEqualTo(String value) {
            addCriterion("madel_name <=", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameLike(String value) {
            addCriterion("madel_name like", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameNotLike(String value) {
            addCriterion("madel_name not like", value, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameIn(List<String> values) {
            addCriterion("madel_name in", values, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameNotIn(List<String> values) {
            addCriterion("madel_name not in", values, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameBetween(String value1, String value2) {
            addCriterion("madel_name between", value1, value2, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelNameNotBetween(String value1, String value2) {
            addCriterion("madel_name not between", value1, value2, "madelName");
            return (Criteria) this;
        }

        public Criteria andMadelTextIsNull() {
            addCriterion("madel_text is null");
            return (Criteria) this;
        }

        public Criteria andMadelTextIsNotNull() {
            addCriterion("madel_text is not null");
            return (Criteria) this;
        }

        public Criteria andMadelTextEqualTo(String value) {
            addCriterion("madel_text =", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextNotEqualTo(String value) {
            addCriterion("madel_text <>", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextGreaterThan(String value) {
            addCriterion("madel_text >", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextGreaterThanOrEqualTo(String value) {
            addCriterion("madel_text >=", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextLessThan(String value) {
            addCriterion("madel_text <", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextLessThanOrEqualTo(String value) {
            addCriterion("madel_text <=", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextLike(String value) {
            addCriterion("madel_text like", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextNotLike(String value) {
            addCriterion("madel_text not like", value, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextIn(List<String> values) {
            addCriterion("madel_text in", values, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextNotIn(List<String> values) {
            addCriterion("madel_text not in", values, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextBetween(String value1, String value2) {
            addCriterion("madel_text between", value1, value2, "madelText");
            return (Criteria) this;
        }

        public Criteria andMadelTextNotBetween(String value1, String value2) {
            addCriterion("madel_text not between", value1, value2, "madelText");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIsNull() {
            addCriterion("task_number is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIsNotNull() {
            addCriterion("task_number is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberEqualTo(Integer value) {
            addCriterion("task_number =", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotEqualTo(Integer value) {
            addCriterion("task_number <>", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberGreaterThan(Integer value) {
            addCriterion("task_number >", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_number >=", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberLessThan(Integer value) {
            addCriterion("task_number <", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberLessThanOrEqualTo(Integer value) {
            addCriterion("task_number <=", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIn(List<Integer> values) {
            addCriterion("task_number in", values, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotIn(List<Integer> values) {
            addCriterion("task_number not in", values, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBetween(Integer value1, Integer value2) {
            addCriterion("task_number between", value1, value2, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("task_number not between", value1, value2, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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