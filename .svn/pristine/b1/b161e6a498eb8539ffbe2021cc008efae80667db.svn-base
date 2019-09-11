package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BRollingSubtitlesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BRollingSubtitlesExample() {
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

        public Criteria andFTitleIsNull() {
            addCriterion("f_title is null");
            return (Criteria) this;
        }

        public Criteria andFTitleIsNotNull() {
            addCriterion("f_title is not null");
            return (Criteria) this;
        }

        public Criteria andFTitleEqualTo(String value) {
            addCriterion("f_title =", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleNotEqualTo(String value) {
            addCriterion("f_title <>", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleGreaterThan(String value) {
            addCriterion("f_title >", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleGreaterThanOrEqualTo(String value) {
            addCriterion("f_title >=", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleLessThan(String value) {
            addCriterion("f_title <", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleLessThanOrEqualTo(String value) {
            addCriterion("f_title <=", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleLike(String value) {
            addCriterion("f_title like", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleNotLike(String value) {
            addCriterion("f_title not like", value, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleIn(List<String> values) {
            addCriterion("f_title in", values, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleNotIn(List<String> values) {
            addCriterion("f_title not in", values, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleBetween(String value1, String value2) {
            addCriterion("f_title between", value1, value2, "fTitle");
            return (Criteria) this;
        }

        public Criteria andFTitleNotBetween(String value1, String value2) {
            addCriterion("f_title not between", value1, value2, "fTitle");
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

        public Criteria andFStartDateIsNull() {
            addCriterion("f_start_date is null");
            return (Criteria) this;
        }

        public Criteria andFStartDateIsNotNull() {
            addCriterion("f_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andFStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date =", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date <>", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_start_date >", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date >=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThan(Date value) {
            addCriterionForJDBCDate("f_start_date <", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_start_date <=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_start_date in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_start_date not in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_start_date between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_start_date not between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateIsNull() {
            addCriterion("f_end_date is null");
            return (Criteria) this;
        }

        public Criteria andFEndDateIsNotNull() {
            addCriterion("f_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andFEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date =", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date <>", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("f_end_date >", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date >=", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateLessThan(Date value) {
            addCriterionForJDBCDate("f_end_date <", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("f_end_date <=", value, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("f_end_date in", values, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("f_end_date not in", values, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_end_date between", value1, value2, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("f_end_date not between", value1, value2, "fEndDate");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIsNull() {
            addCriterion("f_start_time is null");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIsNotNull() {
            addCriterion("f_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andFStartTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time =", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time <>", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_start_time >", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time >=", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_start_time <", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_start_time <=", value, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_start_time in", values, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_start_time not in", values, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_start_time between", value1, value2, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_start_time not between", value1, value2, "fStartTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIsNull() {
            addCriterion("f_end_time is null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIsNotNull() {
            addCriterion("f_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andFEndTimeEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time =", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time <>", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("f_end_time >", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time >=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThan(Date value) {
            addCriterionForJDBCTime("f_end_time <", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("f_end_time <=", value, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeIn(List<Date> values) {
            addCriterionForJDBCTime("f_end_time in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("f_end_time not in", values, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_end_time between", value1, value2, "fEndTime");
            return (Criteria) this;
        }

        public Criteria andFEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("f_end_time not between", value1, value2, "fEndTime");
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