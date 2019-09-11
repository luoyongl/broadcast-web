package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BPictureAdsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPictureAdsExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFImageNameIsNull() {
            addCriterion("f_image_name is null");
            return (Criteria) this;
        }

        public Criteria andFImageNameIsNotNull() {
            addCriterion("f_image_name is not null");
            return (Criteria) this;
        }

        public Criteria andFImageNameEqualTo(String value) {
            addCriterion("f_image_name =", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameNotEqualTo(String value) {
            addCriterion("f_image_name <>", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameGreaterThan(String value) {
            addCriterion("f_image_name >", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_image_name >=", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameLessThan(String value) {
            addCriterion("f_image_name <", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameLessThanOrEqualTo(String value) {
            addCriterion("f_image_name <=", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameLike(String value) {
            addCriterion("f_image_name like", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameNotLike(String value) {
            addCriterion("f_image_name not like", value, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameIn(List<String> values) {
            addCriterion("f_image_name in", values, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameNotIn(List<String> values) {
            addCriterion("f_image_name not in", values, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameBetween(String value1, String value2) {
            addCriterion("f_image_name between", value1, value2, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFImageNameNotBetween(String value1, String value2) {
            addCriterion("f_image_name not between", value1, value2, "fImageName");
            return (Criteria) this;
        }

        public Criteria andFAddressIsNull() {
            addCriterion("f_address is null");
            return (Criteria) this;
        }

        public Criteria andFAddressIsNotNull() {
            addCriterion("f_address is not null");
            return (Criteria) this;
        }

        public Criteria andFAddressEqualTo(String value) {
            addCriterion("f_address =", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressNotEqualTo(String value) {
            addCriterion("f_address <>", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressGreaterThan(String value) {
            addCriterion("f_address >", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_address >=", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressLessThan(String value) {
            addCriterion("f_address <", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressLessThanOrEqualTo(String value) {
            addCriterion("f_address <=", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressLike(String value) {
            addCriterion("f_address like", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressNotLike(String value) {
            addCriterion("f_address not like", value, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressIn(List<String> values) {
            addCriterion("f_address in", values, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressNotIn(List<String> values) {
            addCriterion("f_address not in", values, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressBetween(String value1, String value2) {
            addCriterion("f_address between", value1, value2, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFAddressNotBetween(String value1, String value2) {
            addCriterion("f_address not between", value1, value2, "fAddress");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesIsNull() {
            addCriterion("f_send_all_dates is null");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesIsNotNull() {
            addCriterion("f_send_all_dates is not null");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesEqualTo(Boolean value) {
            addCriterion("f_send_all_dates =", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesNotEqualTo(Boolean value) {
            addCriterion("f_send_all_dates <>", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesGreaterThan(Boolean value) {
            addCriterion("f_send_all_dates >", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_send_all_dates >=", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesLessThan(Boolean value) {
            addCriterion("f_send_all_dates <", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesLessThanOrEqualTo(Boolean value) {
            addCriterion("f_send_all_dates <=", value, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesIn(List<Boolean> values) {
            addCriterion("f_send_all_dates in", values, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesNotIn(List<Boolean> values) {
            addCriterion("f_send_all_dates not in", values, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesBetween(Boolean value1, Boolean value2) {
            addCriterion("f_send_all_dates between", value1, value2, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendAllDatesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_send_all_dates not between", value1, value2, "fSendAllDates");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateIsNull() {
            addCriterion("f_send_start_date is null");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateIsNotNull() {
            addCriterion("f_send_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_start_date =", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_start_date <>", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_send_start_date >", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_start_date >=", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateLessThan(Date value) {
            addCriterionForJDBCDate("f_send_start_date <", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_start_date <=", value, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_send_start_date in", values, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_send_start_date not in", values, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_send_start_date between", value1, value2, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_send_start_date not between", value1, value2, "fSendStartDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateIsNull() {
            addCriterion("f_send_end_date is null");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateIsNotNull() {
            addCriterion("f_send_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_end_date =", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_end_date <>", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_send_end_date >", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_end_date >=", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateLessThan(Date value) {
            addCriterionForJDBCDate("f_send_end_date <", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_send_end_date <=", value, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_send_end_date in", values, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_send_end_date not in", values, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_send_end_date between", value1, value2, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_send_end_date not between", value1, value2, "fSendEndDate");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesIsNull() {
            addCriterion("f_send_all_times is null");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesIsNotNull() {
            addCriterion("f_send_all_times is not null");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesEqualTo(Boolean value) {
            addCriterion("f_send_all_times =", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesNotEqualTo(Boolean value) {
            addCriterion("f_send_all_times <>", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesGreaterThan(Boolean value) {
            addCriterion("f_send_all_times >", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_send_all_times >=", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesLessThan(Boolean value) {
            addCriterion("f_send_all_times <", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesLessThanOrEqualTo(Boolean value) {
            addCriterion("f_send_all_times <=", value, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesIn(List<Boolean> values) {
            addCriterion("f_send_all_times in", values, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesNotIn(List<Boolean> values) {
            addCriterion("f_send_all_times not in", values, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesBetween(Boolean value1, Boolean value2) {
            addCriterion("f_send_all_times between", value1, value2, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendAllTimesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_send_all_times not between", value1, value2, "fSendAllTimes");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeIsNull() {
            addCriterion("f_send_start_time is null");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeIsNotNull() {
            addCriterion("f_send_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_start_time =", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_start_time <>", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_send_start_time >", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_start_time >=", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_send_start_time <", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_start_time <=", value, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_send_start_time in", values, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_send_start_time not in", values, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_send_start_time between", value1, value2, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_send_start_time not between", value1, value2, "fSendStartTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeIsNull() {
            addCriterion("f_send_end_time is null");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeIsNotNull() {
            addCriterion("f_send_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_end_time =", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_end_time <>", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_send_end_time >", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_end_time >=", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_send_end_time <", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_send_end_time <=", value, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_send_end_time in", values, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_send_end_time not in", values, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_send_end_time between", value1, value2, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFSendEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_send_end_time not between", value1, value2, "fSendEndTime");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNull() {
            addCriterion("f_broadcast_area is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIsNotNull() {
            addCriterion("f_broadcast_area is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaEqualTo(String value) {
            addCriterion("f_broadcast_area =", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotEqualTo(String value) {
            addCriterion("f_broadcast_area <>", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThan(String value) {
            addCriterion("f_broadcast_area >", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaGreaterThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area >=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThan(String value) {
            addCriterion("f_broadcast_area <", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLessThanOrEqualTo(String value) {
            addCriterion("f_broadcast_area <=", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaLike(String value) {
            addCriterion("f_broadcast_area like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotLike(String value) {
            addCriterion("f_broadcast_area not like", value, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaIn(List<String> values) {
            addCriterion("f_broadcast_area in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotIn(List<String> values) {
            addCriterion("f_broadcast_area not in", values, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaBetween(String value1, String value2) {
            addCriterion("f_broadcast_area between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFBroadcastAreaNotBetween(String value1, String value2) {
            addCriterion("f_broadcast_area not between", value1, value2, "fBroadcastArea");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalIsNull() {
            addCriterion("f_roll_interval is null");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalIsNotNull() {
            addCriterion("f_roll_interval is not null");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalEqualTo(Integer value) {
            addCriterion("f_roll_interval =", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalNotEqualTo(Integer value) {
            addCriterion("f_roll_interval <>", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalGreaterThan(Integer value) {
            addCriterion("f_roll_interval >", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_roll_interval >=", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalLessThan(Integer value) {
            addCriterion("f_roll_interval <", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("f_roll_interval <=", value, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalIn(List<Integer> values) {
            addCriterion("f_roll_interval in", values, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalNotIn(List<Integer> values) {
            addCriterion("f_roll_interval not in", values, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalBetween(Integer value1, Integer value2) {
            addCriterion("f_roll_interval between", value1, value2, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRollIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("f_roll_interval not between", value1, value2, "fRollInterval");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNull() {
            addCriterion("f_remark is null");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNotNull() {
            addCriterion("f_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFRemarkEqualTo(String value) {
            addCriterion("f_remark =", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotEqualTo(String value) {
            addCriterion("f_remark <>", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThan(String value) {
            addCriterion("f_remark >", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_remark >=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThan(String value) {
            addCriterion("f_remark <", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThanOrEqualTo(String value) {
            addCriterion("f_remark <=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLike(String value) {
            addCriterion("f_remark like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotLike(String value) {
            addCriterion("f_remark not like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkIn(List<String> values) {
            addCriterion("f_remark in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotIn(List<String> values) {
            addCriterion("f_remark not in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkBetween(String value1, String value2) {
            addCriterion("f_remark between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotBetween(String value1, String value2) {
            addCriterion("f_remark not between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFSortIsNull() {
            addCriterion("f_sort is null");
            return (Criteria) this;
        }

        public Criteria andFSortIsNotNull() {
            addCriterion("f_sort is not null");
            return (Criteria) this;
        }

        public Criteria andFSortEqualTo(Byte value) {
            addCriterion("f_sort =", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotEqualTo(Byte value) {
            addCriterion("f_sort <>", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortGreaterThan(Byte value) {
            addCriterion("f_sort >", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_sort >=", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortLessThan(Byte value) {
            addCriterion("f_sort <", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortLessThanOrEqualTo(Byte value) {
            addCriterion("f_sort <=", value, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortIn(List<Byte> values) {
            addCriterion("f_sort in", values, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotIn(List<Byte> values) {
            addCriterion("f_sort not in", values, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortBetween(Byte value1, Byte value2) {
            addCriterion("f_sort between", value1, value2, "fSort");
            return (Criteria) this;
        }

        public Criteria andFSortNotBetween(Byte value1, Byte value2) {
            addCriterion("f_sort not between", value1, value2, "fSort");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("f_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("f_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("f_create_time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("f_create_time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("f_create_time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_create_time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("f_create_time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_create_time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("f_create_time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("f_create_time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("f_create_time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_create_time not between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNull() {
            addCriterion("f_creator_id is null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIsNotNull() {
            addCriterion("f_creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdEqualTo(Integer value) {
            addCriterion("f_creator_id =", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotEqualTo(Integer value) {
            addCriterion("f_creator_id <>", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThan(Integer value) {
            addCriterion("f_creator_id >", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id >=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThan(Integer value) {
            addCriterion("f_creator_id <", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_creator_id <=", value, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdIn(List<Integer> values) {
            addCriterion("f_creator_id in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotIn(List<Integer> values) {
            addCriterion("f_creator_id not in", values, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_creator_id not between", value1, value2, "fCreatorId");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNull() {
            addCriterion("f_update_time is null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIsNotNull() {
            addCriterion("f_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeEqualTo(Date value) {
            addCriterion("f_update_time =", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotEqualTo(Date value) {
            addCriterion("f_update_time <>", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThan(Date value) {
            addCriterion("f_update_time >", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_update_time >=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThan(Date value) {
            addCriterion("f_update_time <", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_update_time <=", value, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeIn(List<Date> values) {
            addCriterion("f_update_time in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotIn(List<Date> values) {
            addCriterion("f_update_time not in", values, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("f_update_time between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_update_time not between", value1, value2, "fUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNull() {
            addCriterion("f_operator_id is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIsNotNull() {
            addCriterion("f_operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdEqualTo(Integer value) {
            addCriterion("f_operator_id =", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotEqualTo(Integer value) {
            addCriterion("f_operator_id <>", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThan(Integer value) {
            addCriterion("f_operator_id >", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id >=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThan(Integer value) {
            addCriterion("f_operator_id <", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator_id <=", value, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdIn(List<Integer> values) {
            addCriterion("f_operator_id in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotIn(List<Integer> values) {
            addCriterion("f_operator_id not in", values, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator_id not between", value1, value2, "fOperatorId");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNull() {
            addCriterion("f_delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIsNotNull() {
            addCriterion("f_delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagEqualTo(Boolean value) {
            addCriterion("f_delete_flag =", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("f_delete_flag <>", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThan(Boolean value) {
            addCriterion("f_delete_flag >", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag >=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThan(Boolean value) {
            addCriterion("f_delete_flag <", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("f_delete_flag <=", value, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagIn(List<Boolean> values) {
            addCriterion("f_delete_flag in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("f_delete_flag not in", values, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag between", value1, value2, "fDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andFDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_delete_flag not between", value1, value2, "fDeleteFlag");
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