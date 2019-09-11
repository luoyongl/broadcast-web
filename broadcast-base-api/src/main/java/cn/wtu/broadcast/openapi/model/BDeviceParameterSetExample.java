package cn.wtu.broadcast.openapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDeviceParameterSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDeviceParameterSetExample() {
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

        public Criteria andFDeviceResourceCodeIsNull() {
            addCriterion("f_device_resource_code is null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIsNotNull() {
            addCriterion("f_device_resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeEqualTo(String value) {
            addCriterion("f_device_resource_code =", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotEqualTo(String value) {
            addCriterion("f_device_resource_code <>", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThan(String value) {
            addCriterion("f_device_resource_code >", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code >=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThan(String value) {
            addCriterion("f_device_resource_code <", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("f_device_resource_code <=", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeLike(String value) {
            addCriterion("f_device_resource_code like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotLike(String value) {
            addCriterion("f_device_resource_code not like", value, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeIn(List<String> values) {
            addCriterion("f_device_resource_code in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotIn(List<String> values) {
            addCriterion("f_device_resource_code not in", values, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeBetween(String value1, String value2) {
            addCriterion("f_device_resource_code between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFDeviceResourceCodeNotBetween(String value1, String value2) {
            addCriterion("f_device_resource_code not between", value1, value2, "fDeviceResourceCode");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdIsNull() {
            addCriterion("f_address_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdIsNotNull() {
            addCriterion("f_address_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdEqualTo(Boolean value) {
            addCriterion("f_address_setting_cmd =", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_address_setting_cmd <>", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_address_setting_cmd >", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_address_setting_cmd >=", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdLessThan(Boolean value) {
            addCriterion("f_address_setting_cmd <", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_address_setting_cmd <=", value, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdIn(List<Boolean> values) {
            addCriterion("f_address_setting_cmd in", values, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_address_setting_cmd not in", values, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_address_setting_cmd between", value1, value2, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAddressSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_address_setting_cmd not between", value1, value2, "fAddressSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressIsNull() {
            addCriterion("f_physical_address is null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressIsNotNull() {
            addCriterion("f_physical_address is not null");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressEqualTo(String value) {
            addCriterion("f_physical_address =", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressNotEqualTo(String value) {
            addCriterion("f_physical_address <>", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressGreaterThan(String value) {
            addCriterion("f_physical_address >", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("f_physical_address >=", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressLessThan(String value) {
            addCriterion("f_physical_address <", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressLessThanOrEqualTo(String value) {
            addCriterion("f_physical_address <=", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressLike(String value) {
            addCriterion("f_physical_address like", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressNotLike(String value) {
            addCriterion("f_physical_address not like", value, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressIn(List<String> values) {
            addCriterion("f_physical_address in", values, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressNotIn(List<String> values) {
            addCriterion("f_physical_address not in", values, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressBetween(String value1, String value2) {
            addCriterion("f_physical_address between", value1, value2, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFPhysicalAddressNotBetween(String value1, String value2) {
            addCriterion("f_physical_address not between", value1, value2, "fPhysicalAddress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressIsNull() {
            addCriterion("f_logic_ddress is null");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressIsNotNull() {
            addCriterion("f_logic_ddress is not null");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressEqualTo(String value) {
            addCriterion("f_logic_ddress =", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressNotEqualTo(String value) {
            addCriterion("f_logic_ddress <>", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressGreaterThan(String value) {
            addCriterion("f_logic_ddress >", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressGreaterThanOrEqualTo(String value) {
            addCriterion("f_logic_ddress >=", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressLessThan(String value) {
            addCriterion("f_logic_ddress <", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressLessThanOrEqualTo(String value) {
            addCriterion("f_logic_ddress <=", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressLike(String value) {
            addCriterion("f_logic_ddress like", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressNotLike(String value) {
            addCriterion("f_logic_ddress not like", value, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressIn(List<String> values) {
            addCriterion("f_logic_ddress in", values, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressNotIn(List<String> values) {
            addCriterion("f_logic_ddress not in", values, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressBetween(String value1, String value2) {
            addCriterion("f_logic_ddress between", value1, value2, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFLogicDdressNotBetween(String value1, String value2) {
            addCriterion("f_logic_ddress not between", value1, value2, "fLogicDdress");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdIsNull() {
            addCriterion("f_workmode_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdIsNotNull() {
            addCriterion("f_workmode_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdEqualTo(Boolean value) {
            addCriterion("f_workmode_setting_cmd =", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_workmode_setting_cmd <>", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_workmode_setting_cmd >", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_workmode_setting_cmd >=", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdLessThan(Boolean value) {
            addCriterion("f_workmode_setting_cmd <", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_workmode_setting_cmd <=", value, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdIn(List<Boolean> values) {
            addCriterion("f_workmode_setting_cmd in", values, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_workmode_setting_cmd not in", values, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_workmode_setting_cmd between", value1, value2, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_workmode_setting_cmd not between", value1, value2, "fWorkmodeSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeIsNull() {
            addCriterion("f_workmode is null");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeIsNotNull() {
            addCriterion("f_workmode is not null");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeEqualTo(Byte value) {
            addCriterion("f_workmode =", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeNotEqualTo(Byte value) {
            addCriterion("f_workmode <>", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeGreaterThan(Byte value) {
            addCriterion("f_workmode >", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_workmode >=", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeLessThan(Byte value) {
            addCriterion("f_workmode <", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeLessThanOrEqualTo(Byte value) {
            addCriterion("f_workmode <=", value, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeIn(List<Byte> values) {
            addCriterion("f_workmode in", values, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeNotIn(List<Byte> values) {
            addCriterion("f_workmode not in", values, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeBetween(Byte value1, Byte value2) {
            addCriterion("f_workmode between", value1, value2, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFWorkmodeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_workmode not between", value1, value2, "fWorkmode");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdIsNull() {
            addCriterion("f_freq_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdIsNotNull() {
            addCriterion("f_freq_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdEqualTo(Boolean value) {
            addCriterion("f_freq_setting_cmd =", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_freq_setting_cmd <>", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_freq_setting_cmd >", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_freq_setting_cmd >=", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdLessThan(Boolean value) {
            addCriterion("f_freq_setting_cmd <", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_freq_setting_cmd <=", value, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdIn(List<Boolean> values) {
            addCriterion("f_freq_setting_cmd in", values, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_freq_setting_cmd not in", values, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_freq_setting_cmd between", value1, value2, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFFreqSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_freq_setting_cmd not between", value1, value2, "fFreqSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcIsNull() {
            addCriterion("f_dtmb_or_dvbc is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcIsNotNull() {
            addCriterion("f_dtmb_or_dvbc is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcEqualTo(Boolean value) {
            addCriterion("f_dtmb_or_dvbc =", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcNotEqualTo(Boolean value) {
            addCriterion("f_dtmb_or_dvbc <>", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcGreaterThan(Boolean value) {
            addCriterion("f_dtmb_or_dvbc >", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_dtmb_or_dvbc >=", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcLessThan(Boolean value) {
            addCriterion("f_dtmb_or_dvbc <", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcLessThanOrEqualTo(Boolean value) {
            addCriterion("f_dtmb_or_dvbc <=", value, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcIn(List<Boolean> values) {
            addCriterion("f_dtmb_or_dvbc in", values, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcNotIn(List<Boolean> values) {
            addCriterion("f_dtmb_or_dvbc not in", values, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dtmb_or_dvbc between", value1, value2, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbOrDvbcNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dtmb_or_dvbc not between", value1, value2, "fDtmbOrDvbc");
            return (Criteria) this;
        }

        public Criteria andFDtmbIsNull() {
            addCriterion("f_dtmb is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbIsNotNull() {
            addCriterion("f_dtmb is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbEqualTo(Boolean value) {
            addCriterion("f_dtmb =", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbNotEqualTo(Boolean value) {
            addCriterion("f_dtmb <>", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbGreaterThan(Boolean value) {
            addCriterion("f_dtmb >", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_dtmb >=", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbLessThan(Boolean value) {
            addCriterion("f_dtmb <", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbLessThanOrEqualTo(Boolean value) {
            addCriterion("f_dtmb <=", value, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbIn(List<Boolean> values) {
            addCriterion("f_dtmb in", values, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbNotIn(List<Boolean> values) {
            addCriterion("f_dtmb not in", values, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dtmb between", value1, value2, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dtmb not between", value1, value2, "fDtmb");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqIsNull() {
            addCriterion("f_dtmb_freq is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqIsNotNull() {
            addCriterion("f_dtmb_freq is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqEqualTo(String value) {
            addCriterion("f_dtmb_freq =", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqNotEqualTo(String value) {
            addCriterion("f_dtmb_freq <>", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqGreaterThan(String value) {
            addCriterion("f_dtmb_freq >", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_freq >=", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqLessThan(String value) {
            addCriterion("f_dtmb_freq <", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_freq <=", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqLike(String value) {
            addCriterion("f_dtmb_freq like", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqNotLike(String value) {
            addCriterion("f_dtmb_freq not like", value, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqIn(List<String> values) {
            addCriterion("f_dtmb_freq in", values, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqNotIn(List<String> values) {
            addCriterion("f_dtmb_freq not in", values, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqBetween(String value1, String value2) {
            addCriterion("f_dtmb_freq between", value1, value2, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbFreqNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_freq not between", value1, value2, "fDtmbFreq");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateIsNull() {
            addCriterion("f_dtmb_symbolrate is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateIsNotNull() {
            addCriterion("f_dtmb_symbolrate is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateEqualTo(String value) {
            addCriterion("f_dtmb_symbolrate =", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateNotEqualTo(String value) {
            addCriterion("f_dtmb_symbolrate <>", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateGreaterThan(String value) {
            addCriterion("f_dtmb_symbolrate >", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateGreaterThanOrEqualTo(String value) {
            addCriterion("f_dtmb_symbolrate >=", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateLessThan(String value) {
            addCriterion("f_dtmb_symbolrate <", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateLessThanOrEqualTo(String value) {
            addCriterion("f_dtmb_symbolrate <=", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateLike(String value) {
            addCriterion("f_dtmb_symbolrate like", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateNotLike(String value) {
            addCriterion("f_dtmb_symbolrate not like", value, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateIn(List<String> values) {
            addCriterion("f_dtmb_symbolrate in", values, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateNotIn(List<String> values) {
            addCriterion("f_dtmb_symbolrate not in", values, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateBetween(String value1, String value2) {
            addCriterion("f_dtmb_symbolrate between", value1, value2, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbSymbolrateNotBetween(String value1, String value2) {
            addCriterion("f_dtmb_symbolrate not between", value1, value2, "fDtmbSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamIsNull() {
            addCriterion("f_dtmb_qam is null");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamIsNotNull() {
            addCriterion("f_dtmb_qam is not null");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamEqualTo(Byte value) {
            addCriterion("f_dtmb_qam =", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamNotEqualTo(Byte value) {
            addCriterion("f_dtmb_qam <>", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamGreaterThan(Byte value) {
            addCriterion("f_dtmb_qam >", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_dtmb_qam >=", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamLessThan(Byte value) {
            addCriterion("f_dtmb_qam <", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamLessThanOrEqualTo(Byte value) {
            addCriterion("f_dtmb_qam <=", value, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamIn(List<Byte> values) {
            addCriterion("f_dtmb_qam in", values, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamNotIn(List<Byte> values) {
            addCriterion("f_dtmb_qam not in", values, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamBetween(Byte value1, Byte value2) {
            addCriterion("f_dtmb_qam between", value1, value2, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDtmbQamNotBetween(Byte value1, Byte value2) {
            addCriterion("f_dtmb_qam not between", value1, value2, "fDtmbQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcIsNull() {
            addCriterion("f_dvbc is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcIsNotNull() {
            addCriterion("f_dvbc is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcEqualTo(Boolean value) {
            addCriterion("f_dvbc =", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcNotEqualTo(Boolean value) {
            addCriterion("f_dvbc <>", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcGreaterThan(Boolean value) {
            addCriterion("f_dvbc >", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_dvbc >=", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcLessThan(Boolean value) {
            addCriterion("f_dvbc <", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcLessThanOrEqualTo(Boolean value) {
            addCriterion("f_dvbc <=", value, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcIn(List<Boolean> values) {
            addCriterion("f_dvbc in", values, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcNotIn(List<Boolean> values) {
            addCriterion("f_dvbc not in", values, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dvbc between", value1, value2, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_dvbc not between", value1, value2, "fDvbc");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqIsNull() {
            addCriterion("f_dvbc_freq is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqIsNotNull() {
            addCriterion("f_dvbc_freq is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqEqualTo(String value) {
            addCriterion("f_dvbc_freq =", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqNotEqualTo(String value) {
            addCriterion("f_dvbc_freq <>", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqGreaterThan(String value) {
            addCriterion("f_dvbc_freq >", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_freq >=", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqLessThan(String value) {
            addCriterion("f_dvbc_freq <", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_freq <=", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqLike(String value) {
            addCriterion("f_dvbc_freq like", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqNotLike(String value) {
            addCriterion("f_dvbc_freq not like", value, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqIn(List<String> values) {
            addCriterion("f_dvbc_freq in", values, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqNotIn(List<String> values) {
            addCriterion("f_dvbc_freq not in", values, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqBetween(String value1, String value2) {
            addCriterion("f_dvbc_freq between", value1, value2, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcFreqNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_freq not between", value1, value2, "fDvbcFreq");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateIsNull() {
            addCriterion("f_dvbc_symbolrate is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateIsNotNull() {
            addCriterion("f_dvbc_symbolrate is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateEqualTo(String value) {
            addCriterion("f_dvbc_symbolrate =", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateNotEqualTo(String value) {
            addCriterion("f_dvbc_symbolrate <>", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateGreaterThan(String value) {
            addCriterion("f_dvbc_symbolrate >", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateGreaterThanOrEqualTo(String value) {
            addCriterion("f_dvbc_symbolrate >=", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateLessThan(String value) {
            addCriterion("f_dvbc_symbolrate <", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateLessThanOrEqualTo(String value) {
            addCriterion("f_dvbc_symbolrate <=", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateLike(String value) {
            addCriterion("f_dvbc_symbolrate like", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateNotLike(String value) {
            addCriterion("f_dvbc_symbolrate not like", value, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateIn(List<String> values) {
            addCriterion("f_dvbc_symbolrate in", values, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateNotIn(List<String> values) {
            addCriterion("f_dvbc_symbolrate not in", values, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateBetween(String value1, String value2) {
            addCriterion("f_dvbc_symbolrate between", value1, value2, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcSymbolrateNotBetween(String value1, String value2) {
            addCriterion("f_dvbc_symbolrate not between", value1, value2, "fDvbcSymbolrate");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamIsNull() {
            addCriterion("f_dvbc_qam is null");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamIsNotNull() {
            addCriterion("f_dvbc_qam is not null");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamEqualTo(Byte value) {
            addCriterion("f_dvbc_qam =", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamNotEqualTo(Byte value) {
            addCriterion("f_dvbc_qam <>", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamGreaterThan(Byte value) {
            addCriterion("f_dvbc_qam >", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_dvbc_qam >=", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamLessThan(Byte value) {
            addCriterion("f_dvbc_qam <", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamLessThanOrEqualTo(Byte value) {
            addCriterion("f_dvbc_qam <=", value, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamIn(List<Byte> values) {
            addCriterion("f_dvbc_qam in", values, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamNotIn(List<Byte> values) {
            addCriterion("f_dvbc_qam not in", values, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamBetween(Byte value1, Byte value2) {
            addCriterion("f_dvbc_qam between", value1, value2, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFDvbcQamNotBetween(Byte value1, Byte value2) {
            addCriterion("f_dvbc_qam not between", value1, value2, "fDvbcQam");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdIsNull() {
            addCriterion("f_rebacktype_and_address_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdIsNotNull() {
            addCriterion("f_rebacktype_and_address_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdEqualTo(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd =", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdNotEqualTo(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd <>", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdGreaterThan(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd >", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd >=", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdLessThan(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd <", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_rebacktype_and_address_cmd <=", value, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdIn(List<Boolean> values) {
            addCriterion("f_rebacktype_and_address_cmd in", values, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdNotIn(List<Boolean> values) {
            addCriterion("f_rebacktype_and_address_cmd not in", values, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_rebacktype_and_address_cmd between", value1, value2, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebacktypeAndAddressCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_rebacktype_and_address_cmd not between", value1, value2, "fRebacktypeAndAddressCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeIsNull() {
            addCriterion("f_reback_type is null");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeIsNotNull() {
            addCriterion("f_reback_type is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeEqualTo(Byte value) {
            addCriterion("f_reback_type =", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeNotEqualTo(Byte value) {
            addCriterion("f_reback_type <>", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeGreaterThan(Byte value) {
            addCriterion("f_reback_type >", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_reback_type >=", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeLessThan(Byte value) {
            addCriterion("f_reback_type <", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_reback_type <=", value, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeIn(List<Byte> values) {
            addCriterion("f_reback_type in", values, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeNotIn(List<Byte> values) {
            addCriterion("f_reback_type not in", values, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_reback_type between", value1, value2, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_reback_type not between", value1, value2, "fRebackType");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberIsNull() {
            addCriterion("f_reback_tel_number is null");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberIsNotNull() {
            addCriterion("f_reback_tel_number is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberEqualTo(String value) {
            addCriterion("f_reback_tel_number =", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberNotEqualTo(String value) {
            addCriterion("f_reback_tel_number <>", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberGreaterThan(String value) {
            addCriterion("f_reback_tel_number >", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_tel_number >=", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberLessThan(String value) {
            addCriterion("f_reback_tel_number <", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberLessThanOrEqualTo(String value) {
            addCriterion("f_reback_tel_number <=", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberLike(String value) {
            addCriterion("f_reback_tel_number like", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberNotLike(String value) {
            addCriterion("f_reback_tel_number not like", value, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberIn(List<String> values) {
            addCriterion("f_reback_tel_number in", values, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberNotIn(List<String> values) {
            addCriterion("f_reback_tel_number not in", values, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberBetween(String value1, String value2) {
            addCriterion("f_reback_tel_number between", value1, value2, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackTelNumberNotBetween(String value1, String value2) {
            addCriterion("f_reback_tel_number not between", value1, value2, "fRebackTelNumber");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1IsNull() {
            addCriterion("f_reback_IP_address1 is null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1IsNotNull() {
            addCriterion("f_reback_IP_address1 is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1EqualTo(String value) {
            addCriterion("f_reback_IP_address1 =", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1NotEqualTo(String value) {
            addCriterion("f_reback_IP_address1 <>", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1GreaterThan(String value) {
            addCriterion("f_reback_IP_address1 >", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1GreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_address1 >=", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1LessThan(String value) {
            addCriterion("f_reback_IP_address1 <", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1LessThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_address1 <=", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1Like(String value) {
            addCriterion("f_reback_IP_address1 like", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1NotLike(String value) {
            addCriterion("f_reback_IP_address1 not like", value, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1In(List<String> values) {
            addCriterion("f_reback_IP_address1 in", values, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1NotIn(List<String> values) {
            addCriterion("f_reback_IP_address1 not in", values, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1Between(String value1, String value2) {
            addCriterion("f_reback_IP_address1 between", value1, value2, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress1NotBetween(String value1, String value2) {
            addCriterion("f_reback_IP_address1 not between", value1, value2, "fRebackIpAddress1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2IsNull() {
            addCriterion("f_reback_IP_address2 is null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2IsNotNull() {
            addCriterion("f_reback_IP_address2 is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2EqualTo(String value) {
            addCriterion("f_reback_IP_address2 =", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2NotEqualTo(String value) {
            addCriterion("f_reback_IP_address2 <>", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2GreaterThan(String value) {
            addCriterion("f_reback_IP_address2 >", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2GreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_address2 >=", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2LessThan(String value) {
            addCriterion("f_reback_IP_address2 <", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2LessThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_address2 <=", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2Like(String value) {
            addCriterion("f_reback_IP_address2 like", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2NotLike(String value) {
            addCriterion("f_reback_IP_address2 not like", value, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2In(List<String> values) {
            addCriterion("f_reback_IP_address2 in", values, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2NotIn(List<String> values) {
            addCriterion("f_reback_IP_address2 not in", values, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2Between(String value1, String value2) {
            addCriterion("f_reback_IP_address2 between", value1, value2, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpAddress2NotBetween(String value1, String value2) {
            addCriterion("f_reback_IP_address2 not between", value1, value2, "fRebackIpAddress2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1IsNull() {
            addCriterion("f_reback_IP_port1 is null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1IsNotNull() {
            addCriterion("f_reback_IP_port1 is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1EqualTo(String value) {
            addCriterion("f_reback_IP_port1 =", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1NotEqualTo(String value) {
            addCriterion("f_reback_IP_port1 <>", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1GreaterThan(String value) {
            addCriterion("f_reback_IP_port1 >", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1GreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_port1 >=", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1LessThan(String value) {
            addCriterion("f_reback_IP_port1 <", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1LessThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_port1 <=", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1Like(String value) {
            addCriterion("f_reback_IP_port1 like", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1NotLike(String value) {
            addCriterion("f_reback_IP_port1 not like", value, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1In(List<String> values) {
            addCriterion("f_reback_IP_port1 in", values, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1NotIn(List<String> values) {
            addCriterion("f_reback_IP_port1 not in", values, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1Between(String value1, String value2) {
            addCriterion("f_reback_IP_port1 between", value1, value2, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort1NotBetween(String value1, String value2) {
            addCriterion("f_reback_IP_port1 not between", value1, value2, "fRebackIpPort1");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2IsNull() {
            addCriterion("f_reback_IP_port2 is null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2IsNotNull() {
            addCriterion("f_reback_IP_port2 is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2EqualTo(String value) {
            addCriterion("f_reback_IP_port2 =", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2NotEqualTo(String value) {
            addCriterion("f_reback_IP_port2 <>", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2GreaterThan(String value) {
            addCriterion("f_reback_IP_port2 >", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2GreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_port2 >=", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2LessThan(String value) {
            addCriterion("f_reback_IP_port2 <", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2LessThanOrEqualTo(String value) {
            addCriterion("f_reback_IP_port2 <=", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2Like(String value) {
            addCriterion("f_reback_IP_port2 like", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2NotLike(String value) {
            addCriterion("f_reback_IP_port2 not like", value, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2In(List<String> values) {
            addCriterion("f_reback_IP_port2 in", values, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2NotIn(List<String> values) {
            addCriterion("f_reback_IP_port2 not in", values, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2Between(String value1, String value2) {
            addCriterion("f_reback_IP_port2 between", value1, value2, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackIpPort2NotBetween(String value1, String value2) {
            addCriterion("f_reback_IP_port2 not between", value1, value2, "fRebackIpPort2");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameIsNull() {
            addCriterion("f_reback_domain_name is null");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameIsNotNull() {
            addCriterion("f_reback_domain_name is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameEqualTo(String value) {
            addCriterion("f_reback_domain_name =", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameNotEqualTo(String value) {
            addCriterion("f_reback_domain_name <>", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameGreaterThan(String value) {
            addCriterion("f_reback_domain_name >", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_domain_name >=", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameLessThan(String value) {
            addCriterion("f_reback_domain_name <", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameLessThanOrEqualTo(String value) {
            addCriterion("f_reback_domain_name <=", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameLike(String value) {
            addCriterion("f_reback_domain_name like", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameNotLike(String value) {
            addCriterion("f_reback_domain_name not like", value, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameIn(List<String> values) {
            addCriterion("f_reback_domain_name in", values, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameNotIn(List<String> values) {
            addCriterion("f_reback_domain_name not in", values, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameBetween(String value1, String value2) {
            addCriterion("f_reback_domain_name between", value1, value2, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameNotBetween(String value1, String value2) {
            addCriterion("f_reback_domain_name not between", value1, value2, "fRebackDomainName");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportIsNull() {
            addCriterion("f_reback_domain_nameport is null");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportIsNotNull() {
            addCriterion("f_reback_domain_nameport is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportEqualTo(String value) {
            addCriterion("f_reback_domain_nameport =", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportNotEqualTo(String value) {
            addCriterion("f_reback_domain_nameport <>", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportGreaterThan(String value) {
            addCriterion("f_reback_domain_nameport >", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportGreaterThanOrEqualTo(String value) {
            addCriterion("f_reback_domain_nameport >=", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportLessThan(String value) {
            addCriterion("f_reback_domain_nameport <", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportLessThanOrEqualTo(String value) {
            addCriterion("f_reback_domain_nameport <=", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportLike(String value) {
            addCriterion("f_reback_domain_nameport like", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportNotLike(String value) {
            addCriterion("f_reback_domain_nameport not like", value, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportIn(List<String> values) {
            addCriterion("f_reback_domain_nameport in", values, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportNotIn(List<String> values) {
            addCriterion("f_reback_domain_nameport not in", values, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportBetween(String value1, String value2) {
            addCriterion("f_reback_domain_nameport between", value1, value2, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFRebackDomainNameportNotBetween(String value1, String value2) {
            addCriterion("f_reback_domain_nameport not between", value1, value2, "fRebackDomainNameport");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdIsNull() {
            addCriterion("f_column_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdIsNotNull() {
            addCriterion("f_column_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdEqualTo(Boolean value) {
            addCriterion("f_column_setting_cmd =", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_column_setting_cmd <>", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_column_setting_cmd >", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_column_setting_cmd >=", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdLessThan(Boolean value) {
            addCriterion("f_column_setting_cmd <", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_column_setting_cmd <=", value, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdIn(List<Boolean> values) {
            addCriterion("f_column_setting_cmd in", values, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_column_setting_cmd not in", values, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_column_setting_cmd between", value1, value2, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_column_setting_cmd not between", value1, value2, "fColumnSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFColumnIsNull() {
            addCriterion("f_column is null");
            return (Criteria) this;
        }

        public Criteria andFColumnIsNotNull() {
            addCriterion("f_column is not null");
            return (Criteria) this;
        }

        public Criteria andFColumnEqualTo(Byte value) {
            addCriterion("f_column =", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnNotEqualTo(Byte value) {
            addCriterion("f_column <>", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnGreaterThan(Byte value) {
            addCriterion("f_column >", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_column >=", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnLessThan(Byte value) {
            addCriterion("f_column <", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnLessThanOrEqualTo(Byte value) {
            addCriterion("f_column <=", value, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnIn(List<Byte> values) {
            addCriterion("f_column in", values, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnNotIn(List<Byte> values) {
            addCriterion("f_column not in", values, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnBetween(Byte value1, Byte value2) {
            addCriterion("f_column between", value1, value2, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFColumnNotBetween(Byte value1, Byte value2) {
            addCriterion("f_column not between", value1, value2, "fColumn");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdIsNull() {
            addCriterion("f_reback_period_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdIsNotNull() {
            addCriterion("f_reback_period_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdEqualTo(Boolean value) {
            addCriterion("f_reback_period_setting_cmd =", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_reback_period_setting_cmd <>", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_reback_period_setting_cmd >", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_reback_period_setting_cmd >=", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdLessThan(Boolean value) {
            addCriterion("f_reback_period_setting_cmd <", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_reback_period_setting_cmd <=", value, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdIn(List<Boolean> values) {
            addCriterion("f_reback_period_setting_cmd in", values, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_reback_period_setting_cmd not in", values, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_reback_period_setting_cmd between", value1, value2, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_reback_period_setting_cmd not between", value1, value2, "fRebackPeriodSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodIsNull() {
            addCriterion("f_reback_period is null");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodIsNotNull() {
            addCriterion("f_reback_period is not null");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodEqualTo(Integer value) {
            addCriterion("f_reback_period =", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodNotEqualTo(Integer value) {
            addCriterion("f_reback_period <>", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodGreaterThan(Integer value) {
            addCriterion("f_reback_period >", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_reback_period >=", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodLessThan(Integer value) {
            addCriterion("f_reback_period <", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("f_reback_period <=", value, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodIn(List<Integer> values) {
            addCriterion("f_reback_period in", values, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodNotIn(List<Integer> values) {
            addCriterion("f_reback_period not in", values, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodBetween(Integer value1, Integer value2) {
            addCriterion("f_reback_period between", value1, value2, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRebackPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("f_reback_period not between", value1, value2, "fRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdIsNull() {
            addCriterion("f_rds_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdIsNotNull() {
            addCriterion("f_rds_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdEqualTo(Boolean value) {
            addCriterion("f_rds_setting_cmd =", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_rds_setting_cmd <>", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_rds_setting_cmd >", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_rds_setting_cmd >=", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdLessThan(Boolean value) {
            addCriterion("f_rds_setting_cmd <", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_rds_setting_cmd <=", value, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdIn(List<Boolean> values) {
            addCriterion("f_rds_setting_cmd in", values, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_rds_setting_cmd not in", values, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_rds_setting_cmd between", value1, value2, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRdsSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_rds_setting_cmd not between", value1, value2, "fRdsSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetIsNull() {
            addCriterion("f_terminal_rds_set is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetIsNotNull() {
            addCriterion("f_terminal_rds_set is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetEqualTo(Byte value) {
            addCriterion("f_terminal_rds_set =", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetNotEqualTo(Byte value) {
            addCriterion("f_terminal_rds_set <>", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetGreaterThan(Byte value) {
            addCriterion("f_terminal_rds_set >", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_terminal_rds_set >=", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetLessThan(Byte value) {
            addCriterion("f_terminal_rds_set <", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetLessThanOrEqualTo(Byte value) {
            addCriterion("f_terminal_rds_set <=", value, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetIn(List<Byte> values) {
            addCriterion("f_terminal_rds_set in", values, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetNotIn(List<Byte> values) {
            addCriterion("f_terminal_rds_set not in", values, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetBetween(Byte value1, Byte value2) {
            addCriterion("f_terminal_rds_set between", value1, value2, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsSetNotBetween(Byte value1, Byte value2) {
            addCriterion("f_terminal_rds_set not between", value1, value2, "fTerminalRdsSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataIsNull() {
            addCriterion("f_terminal_rds_data is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataIsNotNull() {
            addCriterion("f_terminal_rds_data is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataEqualTo(String value) {
            addCriterion("f_terminal_rds_data =", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataNotEqualTo(String value) {
            addCriterion("f_terminal_rds_data <>", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataGreaterThan(String value) {
            addCriterion("f_terminal_rds_data >", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataGreaterThanOrEqualTo(String value) {
            addCriterion("f_terminal_rds_data >=", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataLessThan(String value) {
            addCriterion("f_terminal_rds_data <", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataLessThanOrEqualTo(String value) {
            addCriterion("f_terminal_rds_data <=", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataLike(String value) {
            addCriterion("f_terminal_rds_data like", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataNotLike(String value) {
            addCriterion("f_terminal_rds_data not like", value, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataIn(List<String> values) {
            addCriterion("f_terminal_rds_data in", values, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataNotIn(List<String> values) {
            addCriterion("f_terminal_rds_data not in", values, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataBetween(String value1, String value2) {
            addCriterion("f_terminal_rds_data between", value1, value2, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalRdsDataNotBetween(String value1, String value2) {
            addCriterion("f_terminal_rds_data not between", value1, value2, "fTerminalRdsData");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdIsNull() {
            addCriterion("f_terminal_inspect_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdIsNotNull() {
            addCriterion("f_terminal_inspect_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdEqualTo(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd =", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd <>", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd >", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd >=", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdLessThan(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd <", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_terminal_inspect_setting_cmd <=", value, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdIn(List<Boolean> values) {
            addCriterion("f_terminal_inspect_setting_cmd in", values, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_terminal_inspect_setting_cmd not in", values, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_terminal_inspect_setting_cmd between", value1, value2, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalInspectSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_terminal_inspect_setting_cmd not between", value1, value2, "fTerminalInspectSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodIsNull() {
            addCriterion("f_terminal_reback_period is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodIsNotNull() {
            addCriterion("f_terminal_reback_period is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodEqualTo(Integer value) {
            addCriterion("f_terminal_reback_period =", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodNotEqualTo(Integer value) {
            addCriterion("f_terminal_reback_period <>", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodGreaterThan(Integer value) {
            addCriterion("f_terminal_reback_period >", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_terminal_reback_period >=", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodLessThan(Integer value) {
            addCriterion("f_terminal_reback_period <", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("f_terminal_reback_period <=", value, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodIn(List<Integer> values) {
            addCriterion("f_terminal_reback_period in", values, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodNotIn(List<Integer> values) {
            addCriterion("f_terminal_reback_period not in", values, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodBetween(Integer value1, Integer value2) {
            addCriterion("f_terminal_reback_period between", value1, value2, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("f_terminal_reback_period not between", value1, value2, "fTerminalRebackPeriod");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeIsNull() {
            addCriterion("f_terminal_reback_type is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeIsNotNull() {
            addCriterion("f_terminal_reback_type is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeEqualTo(Byte value) {
            addCriterion("f_terminal_reback_type =", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeNotEqualTo(Byte value) {
            addCriterion("f_terminal_reback_type <>", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeGreaterThan(Byte value) {
            addCriterion("f_terminal_reback_type >", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_terminal_reback_type >=", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeLessThan(Byte value) {
            addCriterion("f_terminal_reback_type <", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeLessThanOrEqualTo(Byte value) {
            addCriterion("f_terminal_reback_type <=", value, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeIn(List<Byte> values) {
            addCriterion("f_terminal_reback_type in", values, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeNotIn(List<Byte> values) {
            addCriterion("f_terminal_reback_type not in", values, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeBetween(Byte value1, Byte value2) {
            addCriterion("f_terminal_reback_type between", value1, value2, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalRebackTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_terminal_reback_type not between", value1, value2, "fTerminalRebackType");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdIsNull() {
            addCriterion("f_terminal_pid_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdIsNotNull() {
            addCriterion("f_terminal_pid_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdEqualTo(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd =", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd <>", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd >", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd >=", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdLessThan(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd <", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_terminal_pid_setting_cmd <=", value, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdIn(List<Boolean> values) {
            addCriterion("f_terminal_pid_setting_cmd in", values, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_terminal_pid_setting_cmd not in", values, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_terminal_pid_setting_cmd between", value1, value2, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_terminal_pid_setting_cmd not between", value1, value2, "fTerminalPidSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetIsNull() {
            addCriterion("f_terminal_pid_set is null");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetIsNotNull() {
            addCriterion("f_terminal_pid_set is not null");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetEqualTo(String value) {
            addCriterion("f_terminal_pid_set =", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetNotEqualTo(String value) {
            addCriterion("f_terminal_pid_set <>", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetGreaterThan(String value) {
            addCriterion("f_terminal_pid_set >", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetGreaterThanOrEqualTo(String value) {
            addCriterion("f_terminal_pid_set >=", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetLessThan(String value) {
            addCriterion("f_terminal_pid_set <", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetLessThanOrEqualTo(String value) {
            addCriterion("f_terminal_pid_set <=", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetLike(String value) {
            addCriterion("f_terminal_pid_set like", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetNotLike(String value) {
            addCriterion("f_terminal_pid_set not like", value, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetIn(List<String> values) {
            addCriterion("f_terminal_pid_set in", values, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetNotIn(List<String> values) {
            addCriterion("f_terminal_pid_set not in", values, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetBetween(String value1, String value2) {
            addCriterion("f_terminal_pid_set between", value1, value2, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFTerminalPidSetNotBetween(String value1, String value2) {
            addCriterion("f_terminal_pid_set not between", value1, value2, "fTerminalPidSet");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdIsNull() {
            addCriterion("f_record_extract_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdIsNotNull() {
            addCriterion("f_record_extract_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdEqualTo(Boolean value) {
            addCriterion("f_record_extract_setting_cmd =", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_record_extract_setting_cmd <>", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_record_extract_setting_cmd >", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_record_extract_setting_cmd >=", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdLessThan(Boolean value) {
            addCriterion("f_record_extract_setting_cmd <", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_record_extract_setting_cmd <=", value, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdIn(List<Boolean> values) {
            addCriterion("f_record_extract_setting_cmd in", values, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_record_extract_setting_cmd not in", values, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_record_extract_setting_cmd between", value1, value2, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordExtractSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_record_extract_setting_cmd not between", value1, value2, "fRecordExtractSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameIsNull() {
            addCriterion("f_record_file_name is null");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameIsNotNull() {
            addCriterion("f_record_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameEqualTo(String value) {
            addCriterion("f_record_file_name =", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameNotEqualTo(String value) {
            addCriterion("f_record_file_name <>", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameGreaterThan(String value) {
            addCriterion("f_record_file_name >", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_record_file_name >=", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameLessThan(String value) {
            addCriterion("f_record_file_name <", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameLessThanOrEqualTo(String value) {
            addCriterion("f_record_file_name <=", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameLike(String value) {
            addCriterion("f_record_file_name like", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameNotLike(String value) {
            addCriterion("f_record_file_name not like", value, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameIn(List<String> values) {
            addCriterion("f_record_file_name in", values, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameNotIn(List<String> values) {
            addCriterion("f_record_file_name not in", values, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameBetween(String value1, String value2) {
            addCriterion("f_record_file_name between", value1, value2, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFRecordFileNameNotBetween(String value1, String value2) {
            addCriterion("f_record_file_name not between", value1, value2, "fRecordFileName");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumIsNull() {
            addCriterion("f_start_package_num is null");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumIsNotNull() {
            addCriterion("f_start_package_num is not null");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumEqualTo(String value) {
            addCriterion("f_start_package_num =", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumNotEqualTo(String value) {
            addCriterion("f_start_package_num <>", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumGreaterThan(String value) {
            addCriterion("f_start_package_num >", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumGreaterThanOrEqualTo(String value) {
            addCriterion("f_start_package_num >=", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumLessThan(String value) {
            addCriterion("f_start_package_num <", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumLessThanOrEqualTo(String value) {
            addCriterion("f_start_package_num <=", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumLike(String value) {
            addCriterion("f_start_package_num like", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumNotLike(String value) {
            addCriterion("f_start_package_num not like", value, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumIn(List<String> values) {
            addCriterion("f_start_package_num in", values, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumNotIn(List<String> values) {
            addCriterion("f_start_package_num not in", values, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumBetween(String value1, String value2) {
            addCriterion("f_start_package_num between", value1, value2, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFStartPackageNumNotBetween(String value1, String value2) {
            addCriterion("f_start_package_num not between", value1, value2, "fStartPackageNum");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeIsNull() {
            addCriterion("f_audio_reback_mode is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeIsNotNull() {
            addCriterion("f_audio_reback_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode =", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeNotEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode <>", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeGreaterThan(Byte value) {
            addCriterion("f_audio_reback_mode >", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode >=", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeLessThan(Byte value) {
            addCriterion("f_audio_reback_mode <", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeLessThanOrEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode <=", value, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeIn(List<Byte> values) {
            addCriterion("f_audio_reback_mode in", values, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeNotIn(List<Byte> values) {
            addCriterion("f_audio_reback_mode not in", values, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeBetween(Byte value1, Byte value2) {
            addCriterion("f_audio_reback_mode between", value1, value2, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackModeNotBetween(Byte value1, Byte value2) {
            addCriterion("f_audio_reback_mode not between", value1, value2, "fAudioRebackMode");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripIsNull() {
            addCriterion("f_audio_reback_serverip is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripIsNotNull() {
            addCriterion("f_audio_reback_serverip is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripEqualTo(String value) {
            addCriterion("f_audio_reback_serverip =", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripNotEqualTo(String value) {
            addCriterion("f_audio_reback_serverip <>", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripGreaterThan(String value) {
            addCriterion("f_audio_reback_serverip >", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_serverip >=", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripLessThan(String value) {
            addCriterion("f_audio_reback_serverip <", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripLessThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_serverip <=", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripLike(String value) {
            addCriterion("f_audio_reback_serverip like", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripNotLike(String value) {
            addCriterion("f_audio_reback_serverip not like", value, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripIn(List<String> values) {
            addCriterion("f_audio_reback_serverip in", values, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripNotIn(List<String> values) {
            addCriterion("f_audio_reback_serverip not in", values, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripBetween(String value1, String value2) {
            addCriterion("f_audio_reback_serverip between", value1, value2, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServeripNotBetween(String value1, String value2) {
            addCriterion("f_audio_reback_serverip not between", value1, value2, "fAudioRebackServerip");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortIsNull() {
            addCriterion("f_audio_reback_port is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortIsNotNull() {
            addCriterion("f_audio_reback_port is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortEqualTo(String value) {
            addCriterion("f_audio_reback_port =", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortNotEqualTo(String value) {
            addCriterion("f_audio_reback_port <>", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortGreaterThan(String value) {
            addCriterion("f_audio_reback_port >", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortGreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_port >=", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortLessThan(String value) {
            addCriterion("f_audio_reback_port <", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortLessThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_port <=", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortLike(String value) {
            addCriterion("f_audio_reback_port like", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortNotLike(String value) {
            addCriterion("f_audio_reback_port not like", value, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortIn(List<String> values) {
            addCriterion("f_audio_reback_port in", values, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortNotIn(List<String> values) {
            addCriterion("f_audio_reback_port not in", values, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortBetween(String value1, String value2) {
            addCriterion("f_audio_reback_port between", value1, value2, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPortNotBetween(String value1, String value2) {
            addCriterion("f_audio_reback_port not between", value1, value2, "fAudioRebackPort");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdIsNull() {
            addCriterion("f_audio_reback_setting_cmd is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdIsNotNull() {
            addCriterion("f_audio_reback_setting_cmd is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdEqualTo(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd =", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdNotEqualTo(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd <>", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdGreaterThan(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd >", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd >=", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdLessThan(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd <", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdLessThanOrEqualTo(Boolean value) {
            addCriterion("f_audio_reback_setting_cmd <=", value, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdIn(List<Boolean> values) {
            addCriterion("f_audio_reback_setting_cmd in", values, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdNotIn(List<Boolean> values) {
            addCriterion("f_audio_reback_setting_cmd not in", values, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdBetween(Boolean value1, Boolean value2) {
            addCriterion("f_audio_reback_setting_cmd between", value1, value2, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackSettingCmdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_audio_reback_setting_cmd not between", value1, value2, "fAudioRebackSettingCmd");
            return (Criteria) this;
        }

        public Criteria andFKaiguanIsNull() {
            addCriterion("f_kaiguan is null");
            return (Criteria) this;
        }

        public Criteria andFKaiguanIsNotNull() {
            addCriterion("f_kaiguan is not null");
            return (Criteria) this;
        }

        public Criteria andFKaiguanEqualTo(Boolean value) {
            addCriterion("f_kaiguan =", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanNotEqualTo(Boolean value) {
            addCriterion("f_kaiguan <>", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanGreaterThan(Boolean value) {
            addCriterion("f_kaiguan >", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanGreaterThanOrEqualTo(Boolean value) {
            addCriterion("f_kaiguan >=", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanLessThan(Boolean value) {
            addCriterion("f_kaiguan <", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanLessThanOrEqualTo(Boolean value) {
            addCriterion("f_kaiguan <=", value, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanIn(List<Boolean> values) {
            addCriterion("f_kaiguan in", values, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanNotIn(List<Boolean> values) {
            addCriterion("f_kaiguan not in", values, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanBetween(Boolean value1, Boolean value2) {
            addCriterion("f_kaiguan between", value1, value2, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFKaiguanNotBetween(Boolean value1, Boolean value2) {
            addCriterion("f_kaiguan not between", value1, value2, "fKaiguan");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2IsNull() {
            addCriterion("f_audio_reback_mode_2 is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2IsNotNull() {
            addCriterion("f_audio_reback_mode_2 is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2EqualTo(Byte value) {
            addCriterion("f_audio_reback_mode_2 =", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2NotEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode_2 <>", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2GreaterThan(Byte value) {
            addCriterion("f_audio_reback_mode_2 >", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2GreaterThanOrEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode_2 >=", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2LessThan(Byte value) {
            addCriterion("f_audio_reback_mode_2 <", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2LessThanOrEqualTo(Byte value) {
            addCriterion("f_audio_reback_mode_2 <=", value, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2In(List<Byte> values) {
            addCriterion("f_audio_reback_mode_2 in", values, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2NotIn(List<Byte> values) {
            addCriterion("f_audio_reback_mode_2 not in", values, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2Between(Byte value1, Byte value2) {
            addCriterion("f_audio_reback_mode_2 between", value1, value2, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackMode2NotBetween(Byte value1, Byte value2) {
            addCriterion("f_audio_reback_mode_2 not between", value1, value2, "fAudioRebackMode2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2IsNull() {
            addCriterion("f_audio_reback_serverip_2 is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2IsNotNull() {
            addCriterion("f_audio_reback_serverip_2 is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2EqualTo(String value) {
            addCriterion("f_audio_reback_serverip_2 =", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2NotEqualTo(String value) {
            addCriterion("f_audio_reback_serverip_2 <>", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2GreaterThan(String value) {
            addCriterion("f_audio_reback_serverip_2 >", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2GreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_serverip_2 >=", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2LessThan(String value) {
            addCriterion("f_audio_reback_serverip_2 <", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2LessThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_serverip_2 <=", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2Like(String value) {
            addCriterion("f_audio_reback_serverip_2 like", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2NotLike(String value) {
            addCriterion("f_audio_reback_serverip_2 not like", value, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2In(List<String> values) {
            addCriterion("f_audio_reback_serverip_2 in", values, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2NotIn(List<String> values) {
            addCriterion("f_audio_reback_serverip_2 not in", values, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2Between(String value1, String value2) {
            addCriterion("f_audio_reback_serverip_2 between", value1, value2, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackServerip2NotBetween(String value1, String value2) {
            addCriterion("f_audio_reback_serverip_2 not between", value1, value2, "fAudioRebackServerip2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2IsNull() {
            addCriterion("f_audio_reback_port_2 is null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2IsNotNull() {
            addCriterion("f_audio_reback_port_2 is not null");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2EqualTo(String value) {
            addCriterion("f_audio_reback_port_2 =", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2NotEqualTo(String value) {
            addCriterion("f_audio_reback_port_2 <>", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2GreaterThan(String value) {
            addCriterion("f_audio_reback_port_2 >", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2GreaterThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_port_2 >=", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2LessThan(String value) {
            addCriterion("f_audio_reback_port_2 <", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2LessThanOrEqualTo(String value) {
            addCriterion("f_audio_reback_port_2 <=", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2Like(String value) {
            addCriterion("f_audio_reback_port_2 like", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2NotLike(String value) {
            addCriterion("f_audio_reback_port_2 not like", value, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2In(List<String> values) {
            addCriterion("f_audio_reback_port_2 in", values, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2NotIn(List<String> values) {
            addCriterion("f_audio_reback_port_2 not in", values, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2Between(String value1, String value2) {
            addCriterion("f_audio_reback_port_2 between", value1, value2, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFAudioRebackPort2NotBetween(String value1, String value2) {
            addCriterion("f_audio_reback_port_2 not between", value1, value2, "fAudioRebackPort2");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNull() {
            addCriterion("f_operator is null");
            return (Criteria) this;
        }

        public Criteria andFOperatorIsNotNull() {
            addCriterion("f_operator is not null");
            return (Criteria) this;
        }

        public Criteria andFOperatorEqualTo(Integer value) {
            addCriterion("f_operator =", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotEqualTo(Integer value) {
            addCriterion("f_operator <>", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThan(Integer value) {
            addCriterion("f_operator >", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_operator >=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThan(Integer value) {
            addCriterion("f_operator <", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("f_operator <=", value, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorIn(List<Integer> values) {
            addCriterion("f_operator in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotIn(List<Integer> values) {
            addCriterion("f_operator not in", values, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorBetween(Integer value1, Integer value2) {
            addCriterion("f_operator between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("f_operator not between", value1, value2, "fOperator");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNull() {
            addCriterion("f_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIsNotNull() {
            addCriterion("f_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeEqualTo(Date value) {
            addCriterion("f_operate_time =", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotEqualTo(Date value) {
            addCriterion("f_operate_time <>", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThan(Date value) {
            addCriterion("f_operate_time >", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_operate_time >=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThan(Date value) {
            addCriterion("f_operate_time <", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_operate_time <=", value, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeIn(List<Date> values) {
            addCriterion("f_operate_time in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotIn(List<Date> values) {
            addCriterion("f_operate_time not in", values, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeBetween(Date value1, Date value2) {
            addCriterion("f_operate_time between", value1, value2, "fOperateTime");
            return (Criteria) this;
        }

        public Criteria andFOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_operate_time not between", value1, value2, "fOperateTime");
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