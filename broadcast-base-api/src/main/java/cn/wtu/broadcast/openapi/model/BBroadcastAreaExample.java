package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.List;

public class BBroadcastAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BBroadcastAreaExample() {
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

        public Criteria andFAssociationTypeIsNull() {
            addCriterion("f_association_type is null");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeIsNotNull() {
            addCriterion("f_association_type is not null");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeEqualTo(Byte value) {
            addCriterion("f_association_type =", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeNotEqualTo(Byte value) {
            addCriterion("f_association_type <>", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeGreaterThan(Byte value) {
            addCriterion("f_association_type >", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_association_type >=", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeLessThan(Byte value) {
            addCriterion("f_association_type <", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_association_type <=", value, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeIn(List<Byte> values) {
            addCriterion("f_association_type in", values, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeNotIn(List<Byte> values) {
            addCriterion("f_association_type not in", values, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_association_type between", value1, value2, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssociationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_association_type not between", value1, value2, "fAssociationType");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyIsNull() {
            addCriterion("f_assocaition_primary_key is null");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyIsNotNull() {
            addCriterion("f_assocaition_primary_key is not null");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyEqualTo(String value) {
            addCriterion("f_assocaition_primary_key =", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyNotEqualTo(String value) {
            addCriterion("f_assocaition_primary_key <>", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyGreaterThan(String value) {
            addCriterion("f_assocaition_primary_key >", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyGreaterThanOrEqualTo(String value) {
            addCriterion("f_assocaition_primary_key >=", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyLessThan(String value) {
            addCriterion("f_assocaition_primary_key <", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyLessThanOrEqualTo(String value) {
            addCriterion("f_assocaition_primary_key <=", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyLike(String value) {
            addCriterion("f_assocaition_primary_key like", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyNotLike(String value) {
            addCriterion("f_assocaition_primary_key not like", value, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyIn(List<String> values) {
            addCriterion("f_assocaition_primary_key in", values, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyNotIn(List<String> values) {
            addCriterion("f_assocaition_primary_key not in", values, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyBetween(String value1, String value2) {
            addCriterion("f_assocaition_primary_key between", value1, value2, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAssocaitionPrimaryKeyNotBetween(String value1, String value2) {
            addCriterion("f_assocaition_primary_key not between", value1, value2, "fAssocaitionPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFAreaIdIsNull() {
            addCriterion("f_area_id is null");
            return (Criteria) this;
        }

        public Criteria andFAreaIdIsNotNull() {
            addCriterion("f_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andFAreaIdEqualTo(Integer value) {
            addCriterion("f_area_id =", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdNotEqualTo(Integer value) {
            addCriterion("f_area_id <>", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdGreaterThan(Integer value) {
            addCriterion("f_area_id >", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_area_id >=", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdLessThan(Integer value) {
            addCriterion("f_area_id <", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_area_id <=", value, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdIn(List<Integer> values) {
            addCriterion("f_area_id in", values, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdNotIn(List<Integer> values) {
            addCriterion("f_area_id not in", values, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("f_area_id between", value1, value2, "fAreaId");
            return (Criteria) this;
        }

        public Criteria andFAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_area_id not between", value1, value2, "fAreaId");
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