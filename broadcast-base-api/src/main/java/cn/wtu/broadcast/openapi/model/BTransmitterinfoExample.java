package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.List;

public class BTransmitterinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BTransmitterinfoExample() {
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

        public Criteria andFTransmitterIdIsNull() {
            addCriterion("f_transmitter_id is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdIsNotNull() {
            addCriterion("f_transmitter_id is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdEqualTo(String value) {
            addCriterion("f_transmitter_id =", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdNotEqualTo(String value) {
            addCriterion("f_transmitter_id <>", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdGreaterThan(String value) {
            addCriterion("f_transmitter_id >", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_id >=", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdLessThan(String value) {
            addCriterion("f_transmitter_id <", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_id <=", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdLike(String value) {
            addCriterion("f_transmitter_id like", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdNotLike(String value) {
            addCriterion("f_transmitter_id not like", value, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdIn(List<String> values) {
            addCriterion("f_transmitter_id in", values, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdNotIn(List<String> values) {
            addCriterion("f_transmitter_id not in", values, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdBetween(String value1, String value2) {
            addCriterion("f_transmitter_id between", value1, value2, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterIdNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_id not between", value1, value2, "fTransmitterId");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameIsNull() {
            addCriterion("f_transmitter_name is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameIsNotNull() {
            addCriterion("f_transmitter_name is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameEqualTo(String value) {
            addCriterion("f_transmitter_name =", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameNotEqualTo(String value) {
            addCriterion("f_transmitter_name <>", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameGreaterThan(String value) {
            addCriterion("f_transmitter_name >", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_name >=", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameLessThan(String value) {
            addCriterion("f_transmitter_name <", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_name <=", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameLike(String value) {
            addCriterion("f_transmitter_name like", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameNotLike(String value) {
            addCriterion("f_transmitter_name not like", value, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameIn(List<String> values) {
            addCriterion("f_transmitter_name in", values, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameNotIn(List<String> values) {
            addCriterion("f_transmitter_name not in", values, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameBetween(String value1, String value2) {
            addCriterion("f_transmitter_name between", value1, value2, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFTransmitterNameNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_name not between", value1, value2, "fTransmitterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameIsNull() {
            addCriterion("f_adapter_name is null");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameIsNotNull() {
            addCriterion("f_adapter_name is not null");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameEqualTo(String value) {
            addCriterion("f_adapter_name =", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameNotEqualTo(String value) {
            addCriterion("f_adapter_name <>", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameGreaterThan(String value) {
            addCriterion("f_adapter_name >", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_adapter_name >=", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameLessThan(String value) {
            addCriterion("f_adapter_name <", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameLessThanOrEqualTo(String value) {
            addCriterion("f_adapter_name <=", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameLike(String value) {
            addCriterion("f_adapter_name like", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameNotLike(String value) {
            addCriterion("f_adapter_name not like", value, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameIn(List<String> values) {
            addCriterion("f_adapter_name in", values, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameNotIn(List<String> values) {
            addCriterion("f_adapter_name not in", values, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameBetween(String value1, String value2) {
            addCriterion("f_adapter_name between", value1, value2, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFAdapterNameNotBetween(String value1, String value2) {
            addCriterion("f_adapter_name not between", value1, value2, "fAdapterName");
            return (Criteria) this;
        }

        public Criteria andFRegionIsNull() {
            addCriterion("f_region is null");
            return (Criteria) this;
        }

        public Criteria andFRegionIsNotNull() {
            addCriterion("f_region is not null");
            return (Criteria) this;
        }

        public Criteria andFRegionEqualTo(String value) {
            addCriterion("f_region =", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionNotEqualTo(String value) {
            addCriterion("f_region <>", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionGreaterThan(String value) {
            addCriterion("f_region >", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionGreaterThanOrEqualTo(String value) {
            addCriterion("f_region >=", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionLessThan(String value) {
            addCriterion("f_region <", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionLessThanOrEqualTo(String value) {
            addCriterion("f_region <=", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionLike(String value) {
            addCriterion("f_region like", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionNotLike(String value) {
            addCriterion("f_region not like", value, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionIn(List<String> values) {
            addCriterion("f_region in", values, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionNotIn(List<String> values) {
            addCriterion("f_region not in", values, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionBetween(String value1, String value2) {
            addCriterion("f_region between", value1, value2, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFRegionNotBetween(String value1, String value2) {
            addCriterion("f_region not between", value1, value2, "fRegion");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaIsNull() {
            addCriterion("f_install_area is null");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaIsNotNull() {
            addCriterion("f_install_area is not null");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaEqualTo(String value) {
            addCriterion("f_install_area =", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaNotEqualTo(String value) {
            addCriterion("f_install_area <>", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaGreaterThan(String value) {
            addCriterion("f_install_area >", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaGreaterThanOrEqualTo(String value) {
            addCriterion("f_install_area >=", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaLessThan(String value) {
            addCriterion("f_install_area <", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaLessThanOrEqualTo(String value) {
            addCriterion("f_install_area <=", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaLike(String value) {
            addCriterion("f_install_area like", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaNotLike(String value) {
            addCriterion("f_install_area not like", value, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaIn(List<String> values) {
            addCriterion("f_install_area in", values, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaNotIn(List<String> values) {
            addCriterion("f_install_area not in", values, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaBetween(String value1, String value2) {
            addCriterion("f_install_area between", value1, value2, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFInstallAreaNotBetween(String value1, String value2) {
            addCriterion("f_install_area not between", value1, value2, "fInstallArea");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIsNull() {
            addCriterion("f_physical_code is null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIsNotNull() {
            addCriterion("f_physical_code is not null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeEqualTo(String value) {
            addCriterion("f_physical_code =", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotEqualTo(String value) {
            addCriterion("f_physical_code <>", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeGreaterThan(String value) {
            addCriterion("f_physical_code >", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_physical_code >=", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLessThan(String value) {
            addCriterion("f_physical_code <", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLessThanOrEqualTo(String value) {
            addCriterion("f_physical_code <=", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeLike(String value) {
            addCriterion("f_physical_code like", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotLike(String value) {
            addCriterion("f_physical_code not like", value, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeIn(List<String> values) {
            addCriterion("f_physical_code in", values, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotIn(List<String> values) {
            addCriterion("f_physical_code not in", values, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeBetween(String value1, String value2) {
            addCriterion("f_physical_code between", value1, value2, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFPhysicalCodeNotBetween(String value1, String value2) {
            addCriterion("f_physical_code not between", value1, value2, "fPhysicalCode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeIsNull() {
            addCriterion("f_resourcecode is null");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeIsNotNull() {
            addCriterion("f_resourcecode is not null");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeEqualTo(String value) {
            addCriterion("f_resourcecode =", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeNotEqualTo(String value) {
            addCriterion("f_resourcecode <>", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeGreaterThan(String value) {
            addCriterion("f_resourcecode >", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_resourcecode >=", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeLessThan(String value) {
            addCriterion("f_resourcecode <", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeLessThanOrEqualTo(String value) {
            addCriterion("f_resourcecode <=", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeLike(String value) {
            addCriterion("f_resourcecode like", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeNotLike(String value) {
            addCriterion("f_resourcecode not like", value, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeIn(List<String> values) {
            addCriterion("f_resourcecode in", values, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeNotIn(List<String> values) {
            addCriterion("f_resourcecode not in", values, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeBetween(String value1, String value2) {
            addCriterion("f_resourcecode between", value1, value2, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFResourcecodeNotBetween(String value1, String value2) {
            addCriterion("f_resourcecode not between", value1, value2, "fResourcecode");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateIsNull() {
            addCriterion("f_transmitter_state is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateIsNotNull() {
            addCriterion("f_transmitter_state is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateEqualTo(Integer value) {
            addCriterion("f_transmitter_state =", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateNotEqualTo(Integer value) {
            addCriterion("f_transmitter_state <>", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateGreaterThan(Integer value) {
            addCriterion("f_transmitter_state >", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_transmitter_state >=", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateLessThan(Integer value) {
            addCriterion("f_transmitter_state <", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateLessThanOrEqualTo(Integer value) {
            addCriterion("f_transmitter_state <=", value, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateIn(List<Integer> values) {
            addCriterion("f_transmitter_state in", values, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateNotIn(List<Integer> values) {
            addCriterion("f_transmitter_state not in", values, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateBetween(Integer value1, Integer value2) {
            addCriterion("f_transmitter_state between", value1, value2, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterStateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_transmitter_state not between", value1, value2, "fTransmitterState");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmIsNull() {
            addCriterion("f_transmitter_output_fm is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmIsNotNull() {
            addCriterion("f_transmitter_output_fm is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmEqualTo(String value) {
            addCriterion("f_transmitter_output_fm =", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmNotEqualTo(String value) {
            addCriterion("f_transmitter_output_fm <>", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmGreaterThan(String value) {
            addCriterion("f_transmitter_output_fm >", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_output_fm >=", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmLessThan(String value) {
            addCriterion("f_transmitter_output_fm <", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_output_fm <=", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmLike(String value) {
            addCriterion("f_transmitter_output_fm like", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmNotLike(String value) {
            addCriterion("f_transmitter_output_fm not like", value, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmIn(List<String> values) {
            addCriterion("f_transmitter_output_fm in", values, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmNotIn(List<String> values) {
            addCriterion("f_transmitter_output_fm not in", values, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmBetween(String value1, String value2) {
            addCriterion("f_transmitter_output_fm between", value1, value2, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFTransmitterOutputFmNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_output_fm not between", value1, value2, "fTransmitterOutputFm");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerIsNull() {
            addCriterion("f_output_power is null");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerIsNotNull() {
            addCriterion("f_output_power is not null");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerEqualTo(String value) {
            addCriterion("f_output_power =", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerNotEqualTo(String value) {
            addCriterion("f_output_power <>", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerGreaterThan(String value) {
            addCriterion("f_output_power >", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerGreaterThanOrEqualTo(String value) {
            addCriterion("f_output_power >=", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerLessThan(String value) {
            addCriterion("f_output_power <", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerLessThanOrEqualTo(String value) {
            addCriterion("f_output_power <=", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerLike(String value) {
            addCriterion("f_output_power like", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerNotLike(String value) {
            addCriterion("f_output_power not like", value, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerIn(List<String> values) {
            addCriterion("f_output_power in", values, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerNotIn(List<String> values) {
            addCriterion("f_output_power not in", values, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerBetween(String value1, String value2) {
            addCriterion("f_output_power between", value1, value2, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFOutputPowerNotBetween(String value1, String value2) {
            addCriterion("f_output_power not between", value1, value2, "fOutputPower");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureIsNull() {
            addCriterion("f_equipment_temperature is null");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureIsNotNull() {
            addCriterion("f_equipment_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureEqualTo(String value) {
            addCriterion("f_equipment_temperature =", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureNotEqualTo(String value) {
            addCriterion("f_equipment_temperature <>", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureGreaterThan(String value) {
            addCriterion("f_equipment_temperature >", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("f_equipment_temperature >=", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureLessThan(String value) {
            addCriterion("f_equipment_temperature <", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureLessThanOrEqualTo(String value) {
            addCriterion("f_equipment_temperature <=", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureLike(String value) {
            addCriterion("f_equipment_temperature like", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureNotLike(String value) {
            addCriterion("f_equipment_temperature not like", value, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureIn(List<String> values) {
            addCriterion("f_equipment_temperature in", values, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureNotIn(List<String> values) {
            addCriterion("f_equipment_temperature not in", values, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureBetween(String value1, String value2) {
            addCriterion("f_equipment_temperature between", value1, value2, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFEquipmentTemperatureNotBetween(String value1, String value2) {
            addCriterion("f_equipment_temperature not between", value1, value2, "fEquipmentTemperature");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageIsNull() {
            addCriterion("f_transmitter_voltage is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageIsNotNull() {
            addCriterion("f_transmitter_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageEqualTo(String value) {
            addCriterion("f_transmitter_voltage =", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageNotEqualTo(String value) {
            addCriterion("f_transmitter_voltage <>", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageGreaterThan(String value) {
            addCriterion("f_transmitter_voltage >", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_voltage >=", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageLessThan(String value) {
            addCriterion("f_transmitter_voltage <", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_voltage <=", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageLike(String value) {
            addCriterion("f_transmitter_voltage like", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageNotLike(String value) {
            addCriterion("f_transmitter_voltage not like", value, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageIn(List<String> values) {
            addCriterion("f_transmitter_voltage in", values, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageNotIn(List<String> values) {
            addCriterion("f_transmitter_voltage not in", values, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageBetween(String value1, String value2) {
            addCriterion("f_transmitter_voltage between", value1, value2, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterVoltageNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_voltage not between", value1, value2, "fTransmitterVoltage");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentIsNull() {
            addCriterion("f_transmitter_current is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentIsNotNull() {
            addCriterion("f_transmitter_current is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentEqualTo(String value) {
            addCriterion("f_transmitter_current =", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentNotEqualTo(String value) {
            addCriterion("f_transmitter_current <>", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentGreaterThan(String value) {
            addCriterion("f_transmitter_current >", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_current >=", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentLessThan(String value) {
            addCriterion("f_transmitter_current <", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_current <=", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentLike(String value) {
            addCriterion("f_transmitter_current like", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentNotLike(String value) {
            addCriterion("f_transmitter_current not like", value, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentIn(List<String> values) {
            addCriterion("f_transmitter_current in", values, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentNotIn(List<String> values) {
            addCriterion("f_transmitter_current not in", values, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentBetween(String value1, String value2) {
            addCriterion("f_transmitter_current between", value1, value2, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterCurrentNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_current not between", value1, value2, "fTransmitterCurrent");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerIsNull() {
            addCriterion("f_transmitter_reflection_power is null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerIsNotNull() {
            addCriterion("f_transmitter_reflection_power is not null");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerEqualTo(String value) {
            addCriterion("f_transmitter_reflection_power =", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerNotEqualTo(String value) {
            addCriterion("f_transmitter_reflection_power <>", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerGreaterThan(String value) {
            addCriterion("f_transmitter_reflection_power >", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerGreaterThanOrEqualTo(String value) {
            addCriterion("f_transmitter_reflection_power >=", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerLessThan(String value) {
            addCriterion("f_transmitter_reflection_power <", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerLessThanOrEqualTo(String value) {
            addCriterion("f_transmitter_reflection_power <=", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerLike(String value) {
            addCriterion("f_transmitter_reflection_power like", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerNotLike(String value) {
            addCriterion("f_transmitter_reflection_power not like", value, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerIn(List<String> values) {
            addCriterion("f_transmitter_reflection_power in", values, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerNotIn(List<String> values) {
            addCriterion("f_transmitter_reflection_power not in", values, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerBetween(String value1, String value2) {
            addCriterion("f_transmitter_reflection_power between", value1, value2, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFTransmitterReflectionPowerNotBetween(String value1, String value2) {
            addCriterion("f_transmitter_reflection_power not between", value1, value2, "fTransmitterReflectionPower");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationIsNull() {
            addCriterion("f_left_channel_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationIsNotNull() {
            addCriterion("f_left_channel_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationEqualTo(String value) {
            addCriterion("f_left_channel_modulation =", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationNotEqualTo(String value) {
            addCriterion("f_left_channel_modulation <>", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationGreaterThan(String value) {
            addCriterion("f_left_channel_modulation >", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_left_channel_modulation >=", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationLessThan(String value) {
            addCriterion("f_left_channel_modulation <", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationLessThanOrEqualTo(String value) {
            addCriterion("f_left_channel_modulation <=", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationLike(String value) {
            addCriterion("f_left_channel_modulation like", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationNotLike(String value) {
            addCriterion("f_left_channel_modulation not like", value, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationIn(List<String> values) {
            addCriterion("f_left_channel_modulation in", values, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationNotIn(List<String> values) {
            addCriterion("f_left_channel_modulation not in", values, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationBetween(String value1, String value2) {
            addCriterion("f_left_channel_modulation between", value1, value2, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFLeftChannelModulationNotBetween(String value1, String value2) {
            addCriterion("f_left_channel_modulation not between", value1, value2, "fLeftChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationIsNull() {
            addCriterion("f_right_channel_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationIsNotNull() {
            addCriterion("f_right_channel_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationEqualTo(String value) {
            addCriterion("f_right_channel_modulation =", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationNotEqualTo(String value) {
            addCriterion("f_right_channel_modulation <>", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationGreaterThan(String value) {
            addCriterion("f_right_channel_modulation >", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_right_channel_modulation >=", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationLessThan(String value) {
            addCriterion("f_right_channel_modulation <", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationLessThanOrEqualTo(String value) {
            addCriterion("f_right_channel_modulation <=", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationLike(String value) {
            addCriterion("f_right_channel_modulation like", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationNotLike(String value) {
            addCriterion("f_right_channel_modulation not like", value, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationIn(List<String> values) {
            addCriterion("f_right_channel_modulation in", values, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationNotIn(List<String> values) {
            addCriterion("f_right_channel_modulation not in", values, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationBetween(String value1, String value2) {
            addCriterion("f_right_channel_modulation between", value1, value2, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRightChannelModulationNotBetween(String value1, String value2) {
            addCriterion("f_right_channel_modulation not between", value1, value2, "fRightChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationIsNull() {
            addCriterion("f_harmonic_channel_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationIsNotNull() {
            addCriterion("f_harmonic_channel_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationEqualTo(String value) {
            addCriterion("f_harmonic_channel_modulation =", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationNotEqualTo(String value) {
            addCriterion("f_harmonic_channel_modulation <>", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationGreaterThan(String value) {
            addCriterion("f_harmonic_channel_modulation >", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_harmonic_channel_modulation >=", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationLessThan(String value) {
            addCriterion("f_harmonic_channel_modulation <", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationLessThanOrEqualTo(String value) {
            addCriterion("f_harmonic_channel_modulation <=", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationLike(String value) {
            addCriterion("f_harmonic_channel_modulation like", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationNotLike(String value) {
            addCriterion("f_harmonic_channel_modulation not like", value, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationIn(List<String> values) {
            addCriterion("f_harmonic_channel_modulation in", values, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationNotIn(List<String> values) {
            addCriterion("f_harmonic_channel_modulation not in", values, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationBetween(String value1, String value2) {
            addCriterion("f_harmonic_channel_modulation between", value1, value2, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFHarmonicChannelModulationNotBetween(String value1, String value2) {
            addCriterion("f_harmonic_channel_modulation not between", value1, value2, "fHarmonicChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationIsNull() {
            addCriterion("f_differential_channel_modulation is null");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationIsNotNull() {
            addCriterion("f_differential_channel_modulation is not null");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationEqualTo(String value) {
            addCriterion("f_differential_channel_modulation =", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationNotEqualTo(String value) {
            addCriterion("f_differential_channel_modulation <>", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationGreaterThan(String value) {
            addCriterion("f_differential_channel_modulation >", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationGreaterThanOrEqualTo(String value) {
            addCriterion("f_differential_channel_modulation >=", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationLessThan(String value) {
            addCriterion("f_differential_channel_modulation <", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationLessThanOrEqualTo(String value) {
            addCriterion("f_differential_channel_modulation <=", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationLike(String value) {
            addCriterion("f_differential_channel_modulation like", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationNotLike(String value) {
            addCriterion("f_differential_channel_modulation not like", value, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationIn(List<String> values) {
            addCriterion("f_differential_channel_modulation in", values, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationNotIn(List<String> values) {
            addCriterion("f_differential_channel_modulation not in", values, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationBetween(String value1, String value2) {
            addCriterion("f_differential_channel_modulation between", value1, value2, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFDifferentialChannelModulationNotBetween(String value1, String value2) {
            addCriterion("f_differential_channel_modulation not between", value1, value2, "fDifferentialChannelModulation");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateIsNull() {
            addCriterion("f_rf_lock_state is null");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateIsNotNull() {
            addCriterion("f_rf_lock_state is not null");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateEqualTo(Integer value) {
            addCriterion("f_rf_lock_state =", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateNotEqualTo(Integer value) {
            addCriterion("f_rf_lock_state <>", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateGreaterThan(Integer value) {
            addCriterion("f_rf_lock_state >", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_rf_lock_state >=", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateLessThan(Integer value) {
            addCriterion("f_rf_lock_state <", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateLessThanOrEqualTo(Integer value) {
            addCriterion("f_rf_lock_state <=", value, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateIn(List<Integer> values) {
            addCriterion("f_rf_lock_state in", values, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateNotIn(List<Integer> values) {
            addCriterion("f_rf_lock_state not in", values, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateBetween(Integer value1, Integer value2) {
            addCriterion("f_rf_lock_state between", value1, value2, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andFRfLockStateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_rf_lock_state not between", value1, value2, "fRfLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateIsNull() {
            addCriterion("pll_lock_state is null");
            return (Criteria) this;
        }

        public Criteria andPllLockStateIsNotNull() {
            addCriterion("pll_lock_state is not null");
            return (Criteria) this;
        }

        public Criteria andPllLockStateEqualTo(Integer value) {
            addCriterion("pll_lock_state =", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateNotEqualTo(Integer value) {
            addCriterion("pll_lock_state <>", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateGreaterThan(Integer value) {
            addCriterion("pll_lock_state >", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pll_lock_state >=", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateLessThan(Integer value) {
            addCriterion("pll_lock_state <", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateLessThanOrEqualTo(Integer value) {
            addCriterion("pll_lock_state <=", value, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateIn(List<Integer> values) {
            addCriterion("pll_lock_state in", values, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateNotIn(List<Integer> values) {
            addCriterion("pll_lock_state not in", values, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateBetween(Integer value1, Integer value2) {
            addCriterion("pll_lock_state between", value1, value2, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andPllLockStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pll_lock_state not between", value1, value2, "pllLockState");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIsNull() {
            addCriterion("f_back_time is null");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIsNotNull() {
            addCriterion("f_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andFBackTimeEqualTo(String value) {
            addCriterion("f_back_time =", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotEqualTo(String value) {
            addCriterion("f_back_time <>", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeGreaterThan(String value) {
            addCriterion("f_back_time >", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("f_back_time >=", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeLessThan(String value) {
            addCriterion("f_back_time <", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeLessThanOrEqualTo(String value) {
            addCriterion("f_back_time <=", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeLike(String value) {
            addCriterion("f_back_time like", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotLike(String value) {
            addCriterion("f_back_time not like", value, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeIn(List<String> values) {
            addCriterion("f_back_time in", values, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotIn(List<String> values) {
            addCriterion("f_back_time not in", values, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeBetween(String value1, String value2) {
            addCriterion("f_back_time between", value1, value2, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFBackTimeNotBetween(String value1, String value2) {
            addCriterion("f_back_time not between", value1, value2, "fBackTime");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdIsNull() {
            addCriterion("f_adapter_id is null");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdIsNotNull() {
            addCriterion("f_adapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdEqualTo(Integer value) {
            addCriterion("f_adapter_id =", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdNotEqualTo(Integer value) {
            addCriterion("f_adapter_id <>", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdGreaterThan(Integer value) {
            addCriterion("f_adapter_id >", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_id >=", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdLessThan(Integer value) {
            addCriterion("f_adapter_id <", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_adapter_id <=", value, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdIn(List<Integer> values) {
            addCriterion("f_adapter_id in", values, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdNotIn(List<Integer> values) {
            addCriterion("f_adapter_id not in", values, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_id between", value1, value2, "fAdapterId");
            return (Criteria) this;
        }

        public Criteria andFAdapterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_adapter_id not between", value1, value2, "fAdapterId");
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