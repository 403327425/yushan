package com.gezi.hdlw.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LwDictionaryTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LwDictionaryTypeExample() {
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

        public Criteria andDtkIdIsNull() {
            addCriterion("dtk_id is null");
            return (Criteria) this;
        }

        public Criteria andDtkIdIsNotNull() {
            addCriterion("dtk_id is not null");
            return (Criteria) this;
        }

        public Criteria andDtkIdEqualTo(Integer value) {
            addCriterion("dtk_id =", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdNotEqualTo(Integer value) {
            addCriterion("dtk_id <>", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdGreaterThan(Integer value) {
            addCriterion("dtk_id >", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dtk_id >=", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdLessThan(Integer value) {
            addCriterion("dtk_id <", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdLessThanOrEqualTo(Integer value) {
            addCriterion("dtk_id <=", value, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdIn(List<Integer> values) {
            addCriterion("dtk_id in", values, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdNotIn(List<Integer> values) {
            addCriterion("dtk_id not in", values, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdBetween(Integer value1, Integer value2) {
            addCriterion("dtk_id between", value1, value2, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDtkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dtk_id not between", value1, value2, "dtkId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameIsNull() {
            addCriterion("dictionary_type_name is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameIsNotNull() {
            addCriterion("dictionary_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameEqualTo(String value) {
            addCriterion("dictionary_type_name =", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotEqualTo(String value) {
            addCriterion("dictionary_type_name <>", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameGreaterThan(String value) {
            addCriterion("dictionary_type_name >", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_type_name >=", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLessThan(String value) {
            addCriterion("dictionary_type_name <", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLessThanOrEqualTo(String value) {
            addCriterion("dictionary_type_name <=", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLike(String value) {
            addCriterion("dictionary_type_name like", value, "dictionaryTypeName");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDictionaryTypeNameLike_alias(String value) {
            addCriterion("dictionary_type1.dictionary_type_name like", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotLike(String value) {
            addCriterion("dictionary_type_name not like", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameIn(List<String> values) {
            addCriterion("dictionary_type_name in", values, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotIn(List<String> values) {
            addCriterion("dictionary_type_name not in", values, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameBetween(String value1, String value2) {
            addCriterion("dictionary_type_name between", value1, value2, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotBetween(String value1, String value2) {
            addCriterion("dictionary_type_name not between", value1, value2, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueIsNull() {
            addCriterion("dictionary_type_value is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueIsNotNull() {
            addCriterion("dictionary_type_value is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueEqualTo(String value) {
            addCriterion("dictionary_type_value =", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueNotEqualTo(String value) {
            addCriterion("dictionary_type_value <>", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueGreaterThan(String value) {
            addCriterion("dictionary_type_value >", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_type_value >=", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueLessThan(String value) {
            addCriterion("dictionary_type_value <", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueLessThanOrEqualTo(String value) {
            addCriterion("dictionary_type_value <=", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueLike(String value) {
            addCriterion("dictionary_type_value like", value, "dictionaryTypeValue");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDictionaryTypeValueLike_alias(String value) {
            addCriterion("dictionary_type1.dictionary_type_value like", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueNotLike(String value) {
            addCriterion("dictionary_type_value not like", value, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueIn(List<String> values) {
            addCriterion("dictionary_type_value in", values, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueNotIn(List<String> values) {
            addCriterion("dictionary_type_value not in", values, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueBetween(String value1, String value2) {
            addCriterion("dictionary_type_value between", value1, value2, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeValueNotBetween(String value1, String value2) {
            addCriterion("dictionary_type_value not between", value1, value2, "dictionaryTypeValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeIsNull() {
            addCriterion("dictionary_type_type is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeIsNotNull() {
            addCriterion("dictionary_type_type is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeEqualTo(String value) {
            addCriterion("dictionary_type_type =", value, "dictionaryTypeType");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDictionaryTypeTypeEqualTo_alias(String value) {
            addCriterion("dictionary_type1.dictionary_type_type =", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeNotEqualTo(String value) {
            addCriterion("dictionary_type_type <>", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeGreaterThan(String value) {
            addCriterion("dictionary_type_type >", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_type_type >=", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeLessThan(String value) {
            addCriterion("dictionary_type_type <", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeLessThanOrEqualTo(String value) {
            addCriterion("dictionary_type_type <=", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeLike(String value) {
            addCriterion("dictionary_type_type like", value, "dictionaryTypeType");
            return (Criteria) this;
        }
        
        public Criteria andDictionaryTypeTypeNotLike(String value) {
            addCriterion("dictionary_type_type not like", value, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeIn(List<String> values) {
            addCriterion("dictionary_type_type in", values, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeNotIn(List<String> values) {
            addCriterion("dictionary_type_type not in", values, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeBetween(String value1, String value2) {
            addCriterion("dictionary_type_type between", value1, value2, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeTypeNotBetween(String value1, String value2) {
            addCriterion("dictionary_type_type not between", value1, value2, "dictionaryTypeType");
            return (Criteria) this;
        }

        public Criteria andDtParentIdIsNull() {
            addCriterion("dt_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andDtParentIdIsNotNull() {
            addCriterion("dt_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andDtParentIdEqualTo(Integer value) {
            addCriterion("dt_parent_id =", value, "dtParentId");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDtParentIdEqualTo_alias(Integer value) {
            addCriterion("dictionary_type1.dt_parent_id =", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdNotEqualTo(Integer value) {
            addCriterion("dt_parent_id <>", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdGreaterThan(Integer value) {
            addCriterion("dt_parent_id >", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dt_parent_id >=", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdLessThan(Integer value) {
            addCriterion("dt_parent_id <", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("dt_parent_id <=", value, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdIn(List<Integer> values) {
            addCriterion("dt_parent_id in", values, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdNotIn(List<Integer> values) {
            addCriterion("dt_parent_id not in", values, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdBetween(Integer value1, Integer value2) {
            addCriterion("dt_parent_id between", value1, value2, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dt_parent_id not between", value1, value2, "dtParentId");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeIsNull() {
            addCriterion("dt_creation_time is null");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeIsNotNull() {
            addCriterion("dt_creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeEqualTo(Date value) {
            addCriterion("dt_creation_time =", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeNotEqualTo(Date value) {
            addCriterion("dt_creation_time <>", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeGreaterThan(Date value) {
            addCriterion("dt_creation_time >", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dt_creation_time >=", value, "dtCreationTime");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDtCreationTimeGreaterThanOrEqualTo_alias(Date value) {
            addCriterion("dictionary_type1.dt_creation_time >=", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeLessThan(Date value) {
            addCriterion("dt_creation_time <", value, "dtCreationTime");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDtCreationTimeLessThan_alias(Date value) {
            addCriterion("dictionary_type1.dt_creation_time <", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("dt_creation_time <=", value, "dtCreationTime");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDtCreationTimeLessThanOrEqualTo_alias(Date value) {
            addCriterion("dictionary_type1.dt_creation_time <=", value, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeIn(List<Date> values) {
            addCriterion("dt_creation_time in", values, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeNotIn(List<Date> values) {
            addCriterion("dt_creation_time not in", values, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeBetween(Date value1, Date value2) {
            addCriterion("dt_creation_time between", value1, value2, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("dt_creation_time not between", value1, value2, "dtCreationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeIsNull() {
            addCriterion("dt_modification_time is null");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeIsNotNull() {
            addCriterion("dt_modification_time is not null");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeEqualTo(Date value) {
            addCriterion("dt_modification_time =", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeNotEqualTo(Date value) {
            addCriterion("dt_modification_time <>", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeGreaterThan(Date value) {
            addCriterion("dt_modification_time >", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dt_modification_time >=", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeLessThan(Date value) {
            addCriterion("dt_modification_time <", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("dt_modification_time <=", value, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeIn(List<Date> values) {
            addCriterion("dt_modification_time in", values, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeNotIn(List<Date> values) {
            addCriterion("dt_modification_time not in", values, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeBetween(Date value1, Date value2) {
            addCriterion("dt_modification_time between", value1, value2, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtModificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("dt_modification_time not between", value1, value2, "dtModificationTime");
            return (Criteria) this;
        }

        public Criteria andDtOperatorIsNull() {
            addCriterion("dt_operator is null");
            return (Criteria) this;
        }

        public Criteria andDtOperatorIsNotNull() {
            addCriterion("dt_operator is not null");
            return (Criteria) this;
        }

        public Criteria andDtOperatorEqualTo(Integer value) {
            addCriterion("dt_operator =", value, "dtOperator");
            return (Criteria) this;
        }
        
        //别名条件
        public Criteria andDtOperatorEqualTo_alias(Integer value) {
            addCriterion("dictionary_type1.dt_operator =", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorNotEqualTo(Integer value) {
            addCriterion("dt_operator <>", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorGreaterThan(Integer value) {
            addCriterion("dt_operator >", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("dt_operator >=", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorLessThan(Integer value) {
            addCriterion("dt_operator <", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("dt_operator <=", value, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorIn(List<Integer> values) {
            addCriterion("dt_operator in", values, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorNotIn(List<Integer> values) {
            addCriterion("dt_operator not in", values, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorBetween(Integer value1, Integer value2) {
            addCriterion("dt_operator between", value1, value2, "dtOperator");
            return (Criteria) this;
        }

        public Criteria andDtOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("dt_operator not between", value1, value2, "dtOperator");
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