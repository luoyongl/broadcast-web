package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBroadcastTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBroadcastTempExample() {
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

        public Criteria andFBroadcastIdIsNull() {
            addCriterion("f_broadcast_id is null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdIsNotNull() {
            addCriterion("f_broadcast_id is not null");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdEqualTo(Integer value) {
            addCriterion("f_broadcast_id =", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotEqualTo(Integer value) {
            addCriterion("f_broadcast_id <>", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdGreaterThan(Integer value) {
            addCriterion("f_broadcast_id >", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_id >=", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdLessThan(Integer value) {
            addCriterion("f_broadcast_id <", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_broadcast_id <=", value, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdIn(List<Integer> values) {
            addCriterion("f_broadcast_id in", values, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotIn(List<Integer> values) {
            addCriterion("f_broadcast_id not in", values, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_id between", value1, value2, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFBroadcastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_broadcast_id not between", value1, value2, "fBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastIsNull() {
            addCriterion("f_timing_broadcast is null");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastIsNotNull() {
            addCriterion("f_timing_broadcast is not null");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastEqualTo(Boolean value) {
            addCriterion("f_timing_broadcast =", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastNotEqualTo(Boolean value) {
            addCriterion("f_timing_broadcast <>", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastGreaterThan(Boolean value) {
            addCriterion("f_timing_broadcast >", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_timing_broadcast >=", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastLessThan(Boolean value) {
            addCriterion("f_timing_broadcast <", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastLessThanOrEqualTo(Boolean value) {
            addCriterion("f_timing_broadcast <=", value, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastIn(List<Boolean> values) {
            addCriterion("f_timing_broadcast in", values, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastNotIn(List<Boolean> values) {
            addCriterion("f_timing_broadcast not in", values, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastBetween(Boolean value1, Boolean value2) {
            addCriterion("f_timing_broadcast between", value1, value2, "fTimingBroadcast");
            return (Criteria) this;
        }

        public Criteria andFTimingBroadcastNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_timing_broadcast not between", value1, value2, "fTimingBroadcast");
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