package com.gezi.hdlw.example.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LwActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LwActivityExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIsNull() {
            addCriterion("activity_describe is null");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIsNotNull() {
            addCriterion("activity_describe is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeEqualTo(String value) {
            addCriterion("activity_describe =", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotEqualTo(String value) {
            addCriterion("activity_describe <>", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeGreaterThan(String value) {
            addCriterion("activity_describe >", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_describe >=", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLessThan(String value) {
            addCriterion("activity_describe <", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLessThanOrEqualTo(String value) {
            addCriterion("activity_describe <=", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeLike(String value) {
            addCriterion("activity_describe like", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotLike(String value) {
            addCriterion("activity_describe not like", value, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeIn(List<String> values) {
            addCriterion("activity_describe in", values, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotIn(List<String> values) {
            addCriterion("activity_describe not in", values, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeBetween(String value1, String value2) {
            addCriterion("activity_describe between", value1, value2, "activityDescribe");
            return (Criteria) this;
        }

        public Criteria andActivityDescribeNotBetween(String value1, String value2) {
            addCriterion("activity_describe not between", value1, value2, "activityDescribe");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNull() {
            addCriterion("start_time2 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNotNull() {
            addCriterion("start_time2 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime2EqualTo(Date value) {
            addCriterion("start_time2 =", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotEqualTo(Date value) {
            addCriterion("start_time2 <>", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThan(Date value) {
            addCriterion("start_time2 >", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("start_time2 >=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThan(Date value) {
            addCriterion("start_time2 <", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThanOrEqualTo(Date value) {
            addCriterion("start_time2 <=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2In(List<Date> values) {
            addCriterion("start_time2 in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotIn(List<Date> values) {
            addCriterion("start_time2 not in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2Between(Date value1, Date value2) {
            addCriterion("start_time2 between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotBetween(Date value1, Date value2) {
            addCriterion("start_time2 not between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2IsNull() {
            addCriterion("end_time2 is null");
            return (Criteria) this;
        }

        public Criteria andEndTime2IsNotNull() {
            addCriterion("end_time2 is not null");
            return (Criteria) this;
        }

        public Criteria andEndTime2EqualTo(Date value) {
            addCriterion("end_time2 =", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotEqualTo(Date value) {
            addCriterion("end_time2 <>", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2GreaterThan(Date value) {
            addCriterion("end_time2 >", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("end_time2 >=", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2LessThan(Date value) {
            addCriterion("end_time2 <", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2LessThanOrEqualTo(Date value) {
            addCriterion("end_time2 <=", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2In(List<Date> values) {
            addCriterion("end_time2 in", values, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotIn(List<Date> values) {
            addCriterion("end_time2 not in", values, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2Between(Date value1, Date value2) {
            addCriterion("end_time2 between", value1, value2, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotBetween(Date value1, Date value2) {
            addCriterion("end_time2 not between", value1, value2, "endTime2");
            return (Criteria) this;
        }

        public Criteria andVisitCountIsNull() {
            addCriterion("visit_count is null");
            return (Criteria) this;
        }

        public Criteria andVisitCountIsNotNull() {
            addCriterion("visit_count is not null");
            return (Criteria) this;
        }

        public Criteria andVisitCountEqualTo(Long value) {
            addCriterion("visit_count =", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountNotEqualTo(Long value) {
            addCriterion("visit_count <>", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountGreaterThan(Long value) {
            addCriterion("visit_count >", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountGreaterThanOrEqualTo(Long value) {
            addCriterion("visit_count >=", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountLessThan(Long value) {
            addCriterion("visit_count <", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountLessThanOrEqualTo(Long value) {
            addCriterion("visit_count <=", value, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountIn(List<Long> values) {
            addCriterion("visit_count in", values, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountNotIn(List<Long> values) {
            addCriterion("visit_count not in", values, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountBetween(Long value1, Long value2) {
            addCriterion("visit_count between", value1, value2, "visitCount");
            return (Criteria) this;
        }

        public Criteria andVisitCountNotBetween(Long value1, Long value2) {
            addCriterion("visit_count not between", value1, value2, "visitCount");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andSortModeIsNull() {
            addCriterion("sort_mode is null");
            return (Criteria) this;
        }

        public Criteria andSortModeIsNotNull() {
            addCriterion("sort_mode is not null");
            return (Criteria) this;
        }

        public Criteria andSortModeEqualTo(Integer value) {
            addCriterion("sort_mode =", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeNotEqualTo(Integer value) {
            addCriterion("sort_mode <>", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeGreaterThan(Integer value) {
            addCriterion("sort_mode >", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_mode >=", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeLessThan(Integer value) {
            addCriterion("sort_mode <", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeLessThanOrEqualTo(Integer value) {
            addCriterion("sort_mode <=", value, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeIn(List<Integer> values) {
            addCriterion("sort_mode in", values, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeNotIn(List<Integer> values) {
            addCriterion("sort_mode not in", values, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeBetween(Integer value1, Integer value2) {
            addCriterion("sort_mode between", value1, value2, "sortMode");
            return (Criteria) this;
        }

        public Criteria andSortModeNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_mode not between", value1, value2, "sortMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeIsNull() {
            addCriterion("vote_mode is null");
            return (Criteria) this;
        }

        public Criteria andVoteModeIsNotNull() {
            addCriterion("vote_mode is not null");
            return (Criteria) this;
        }

        public Criteria andVoteModeEqualTo(Integer value) {
            addCriterion("vote_mode =", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeNotEqualTo(Integer value) {
            addCriterion("vote_mode <>", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeGreaterThan(Integer value) {
            addCriterion("vote_mode >", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_mode >=", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeLessThan(Integer value) {
            addCriterion("vote_mode <", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeLessThanOrEqualTo(Integer value) {
            addCriterion("vote_mode <=", value, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeIn(List<Integer> values) {
            addCriterion("vote_mode in", values, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeNotIn(List<Integer> values) {
            addCriterion("vote_mode not in", values, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeBetween(Integer value1, Integer value2) {
            addCriterion("vote_mode between", value1, value2, "voteMode");
            return (Criteria) this;
        }

        public Criteria andVoteModeNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_mode not between", value1, value2, "voteMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeIsNull() {
            addCriterion("limit_mode is null");
            return (Criteria) this;
        }

        public Criteria andLimitModeIsNotNull() {
            addCriterion("limit_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLimitModeEqualTo(Integer value) {
            addCriterion("limit_mode =", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeNotEqualTo(Integer value) {
            addCriterion("limit_mode <>", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeGreaterThan(Integer value) {
            addCriterion("limit_mode >", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_mode >=", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeLessThan(Integer value) {
            addCriterion("limit_mode <", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeLessThanOrEqualTo(Integer value) {
            addCriterion("limit_mode <=", value, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeIn(List<Integer> values) {
            addCriterion("limit_mode in", values, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeNotIn(List<Integer> values) {
            addCriterion("limit_mode not in", values, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeBetween(Integer value1, Integer value2) {
            addCriterion("limit_mode between", value1, value2, "limitMode");
            return (Criteria) this;
        }

        public Criteria andLimitModeNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_mode not between", value1, value2, "limitMode");
            return (Criteria) this;
        }

        public Criteria andResultModeIsNull() {
            addCriterion("result_mode is null");
            return (Criteria) this;
        }

        public Criteria andResultModeIsNotNull() {
            addCriterion("result_mode is not null");
            return (Criteria) this;
        }

        public Criteria andResultModeEqualTo(Integer value) {
            addCriterion("result_mode =", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeNotEqualTo(Integer value) {
            addCriterion("result_mode <>", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeGreaterThan(Integer value) {
            addCriterion("result_mode >", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_mode >=", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeLessThan(Integer value) {
            addCriterion("result_mode <", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeLessThanOrEqualTo(Integer value) {
            addCriterion("result_mode <=", value, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeIn(List<Integer> values) {
            addCriterion("result_mode in", values, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeNotIn(List<Integer> values) {
            addCriterion("result_mode not in", values, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeBetween(Integer value1, Integer value2) {
            addCriterion("result_mode between", value1, value2, "resultMode");
            return (Criteria) this;
        }

        public Criteria andResultModeNotBetween(Integer value1, Integer value2) {
            addCriterion("result_mode not between", value1, value2, "resultMode");
            return (Criteria) this;
        }

        public Criteria andShowModeIsNull() {
            addCriterion("show_mode is null");
            return (Criteria) this;
        }

        public Criteria andShowModeIsNotNull() {
            addCriterion("show_mode is not null");
            return (Criteria) this;
        }

        public Criteria andShowModeEqualTo(Integer value) {
            addCriterion("show_mode =", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeNotEqualTo(Integer value) {
            addCriterion("show_mode <>", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeGreaterThan(Integer value) {
            addCriterion("show_mode >", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_mode >=", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeLessThan(Integer value) {
            addCriterion("show_mode <", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeLessThanOrEqualTo(Integer value) {
            addCriterion("show_mode <=", value, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeIn(List<Integer> values) {
            addCriterion("show_mode in", values, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeNotIn(List<Integer> values) {
            addCriterion("show_mode not in", values, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeBetween(Integer value1, Integer value2) {
            addCriterion("show_mode between", value1, value2, "showMode");
            return (Criteria) this;
        }

        public Criteria andShowModeNotBetween(Integer value1, Integer value2) {
            addCriterion("show_mode not between", value1, value2, "showMode");
            return (Criteria) this;
        }

        public Criteria andLimitNumberIsNull() {
            addCriterion("limit_number is null");
            return (Criteria) this;
        }

        public Criteria andLimitNumberIsNotNull() {
            addCriterion("limit_number is not null");
            return (Criteria) this;
        }

        public Criteria andLimitNumberEqualTo(Integer value) {
            addCriterion("limit_number =", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotEqualTo(Integer value) {
            addCriterion("limit_number <>", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberGreaterThan(Integer value) {
            addCriterion("limit_number >", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_number >=", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberLessThan(Integer value) {
            addCriterion("limit_number <", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("limit_number <=", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberIn(List<Integer> values) {
            addCriterion("limit_number in", values, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotIn(List<Integer> values) {
            addCriterion("limit_number not in", values, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberBetween(Integer value1, Integer value2) {
            addCriterion("limit_number between", value1, value2, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_number not between", value1, value2, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andVoteMode2IsNull() {
            addCriterion("vote_mode2 is null");
            return (Criteria) this;
        }

        public Criteria andVoteMode2IsNotNull() {
            addCriterion("vote_mode2 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteMode2EqualTo(Integer value) {
            addCriterion("vote_mode2 =", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2NotEqualTo(Integer value) {
            addCriterion("vote_mode2 <>", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2GreaterThan(Integer value) {
            addCriterion("vote_mode2 >", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2GreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_mode2 >=", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2LessThan(Integer value) {
            addCriterion("vote_mode2 <", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2LessThanOrEqualTo(Integer value) {
            addCriterion("vote_mode2 <=", value, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2In(List<Integer> values) {
            addCriterion("vote_mode2 in", values, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2NotIn(List<Integer> values) {
            addCriterion("vote_mode2 not in", values, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2Between(Integer value1, Integer value2) {
            addCriterion("vote_mode2 between", value1, value2, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andVoteMode2NotBetween(Integer value1, Integer value2) {
            addCriterion("vote_mode2 not between", value1, value2, "voteMode2");
            return (Criteria) this;
        }

        public Criteria andCandidateCountIsNull() {
            addCriterion("candidate_count is null");
            return (Criteria) this;
        }

        public Criteria andCandidateCountIsNotNull() {
            addCriterion("candidate_count is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateCountEqualTo(Integer value) {
            addCriterion("candidate_count =", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountNotEqualTo(Integer value) {
            addCriterion("candidate_count <>", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountGreaterThan(Integer value) {
            addCriterion("candidate_count >", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("candidate_count >=", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountLessThan(Integer value) {
            addCriterion("candidate_count <", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountLessThanOrEqualTo(Integer value) {
            addCriterion("candidate_count <=", value, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountIn(List<Integer> values) {
            addCriterion("candidate_count in", values, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountNotIn(List<Integer> values) {
            addCriterion("candidate_count not in", values, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountBetween(Integer value1, Integer value2) {
            addCriterion("candidate_count between", value1, value2, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andCandidateCountNotBetween(Integer value1, Integer value2) {
            addCriterion("candidate_count not between", value1, value2, "candidateCount");
            return (Criteria) this;
        }

        public Criteria andNowStateIsNull() {
            addCriterion("now_state is null");
            return (Criteria) this;
        }

        public Criteria andNowStateIsNotNull() {
            addCriterion("now_state is not null");
            return (Criteria) this;
        }

        public Criteria andNowStateEqualTo(Integer value) {
            addCriterion("now_state =", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateNotEqualTo(Integer value) {
            addCriterion("now_state <>", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateGreaterThan(Integer value) {
            addCriterion("now_state >", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_state >=", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateLessThan(Integer value) {
            addCriterion("now_state <", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateLessThanOrEqualTo(Integer value) {
            addCriterion("now_state <=", value, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateIn(List<Integer> values) {
            addCriterion("now_state in", values, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateNotIn(List<Integer> values) {
            addCriterion("now_state not in", values, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateBetween(Integer value1, Integer value2) {
            addCriterion("now_state between", value1, value2, "nowState");
            return (Criteria) this;
        }

        public Criteria andNowStateNotBetween(Integer value1, Integer value2) {
            addCriterion("now_state not between", value1, value2, "nowState");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNull() {
            addCriterion("prefix is null");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("prefix is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("prefix =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("prefix <>", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("prefix >", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("prefix >=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("prefix <", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("prefix <=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLike(String value) {
            addCriterion("prefix like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("prefix not like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixIn(List<String> values) {
            addCriterion("prefix in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotIn(List<String> values) {
            addCriterion("prefix not in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("prefix between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("prefix not between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
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