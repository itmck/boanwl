package com.boanwl.manager.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSendExample() {
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

        public Criteria andSeIdIsNull() {
            addCriterion("se_id is null");
            return (Criteria) this;
        }

        public Criteria andSeIdIsNotNull() {
            addCriterion("se_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeIdEqualTo(String value) {
            addCriterion("se_id =", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotEqualTo(String value) {
            addCriterion("se_id <>", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdGreaterThan(String value) {
            addCriterion("se_id >", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdGreaterThanOrEqualTo(String value) {
            addCriterion("se_id >=", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdLessThan(String value) {
            addCriterion("se_id <", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdLessThanOrEqualTo(String value) {
            addCriterion("se_id <=", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdLike(String value) {
            addCriterion("se_id like", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotLike(String value) {
            addCriterion("se_id not like", value, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdIn(List<String> values) {
            addCriterion("se_id in", values, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotIn(List<String> values) {
            addCriterion("se_id not in", values, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdBetween(String value1, String value2) {
            addCriterion("se_id between", value1, value2, "seId");
            return (Criteria) this;
        }

        public Criteria andSeIdNotBetween(String value1, String value2) {
            addCriterion("se_id not between", value1, value2, "seId");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNameEqualTo(String value) {
            addCriterion("sender_name =", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThan(String value) {
            addCriterion("sender_name >", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThan(String value) {
            addCriterion("sender_name <", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLike(String value) {
            addCriterion("sender_name like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotLike(String value) {
            addCriterion("sender_name not like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameIn(List<String> values) {
            addCriterion("sender_name in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotIn(List<String> values) {
            addCriterion("sender_name not in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberIsNull() {
            addCriterion("sender_id_number is null");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberIsNotNull() {
            addCriterion("sender_id_number is not null");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberEqualTo(String value) {
            addCriterion("sender_id_number =", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberNotEqualTo(String value) {
            addCriterion("sender_id_number <>", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberGreaterThan(String value) {
            addCriterion("sender_id_number >", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sender_id_number >=", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberLessThan(String value) {
            addCriterion("sender_id_number <", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberLessThanOrEqualTo(String value) {
            addCriterion("sender_id_number <=", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberLike(String value) {
            addCriterion("sender_id_number like", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberNotLike(String value) {
            addCriterion("sender_id_number not like", value, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberIn(List<String> values) {
            addCriterion("sender_id_number in", values, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberNotIn(List<String> values) {
            addCriterion("sender_id_number not in", values, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberBetween(String value1, String value2) {
            addCriterion("sender_id_number between", value1, value2, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderIdNumberNotBetween(String value1, String value2) {
            addCriterion("sender_id_number not between", value1, value2, "senderIdNumber");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIsNull() {
            addCriterion("sender_phone is null");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIsNotNull() {
            addCriterion("sender_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneEqualTo(String value) {
            addCriterion("sender_phone =", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotEqualTo(String value) {
            addCriterion("sender_phone <>", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneGreaterThan(String value) {
            addCriterion("sender_phone >", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sender_phone >=", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLessThan(String value) {
            addCriterion("sender_phone <", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLessThanOrEqualTo(String value) {
            addCriterion("sender_phone <=", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLike(String value) {
            addCriterion("sender_phone like", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotLike(String value) {
            addCriterion("sender_phone not like", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIn(List<String> values) {
            addCriterion("sender_phone in", values, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotIn(List<String> values) {
            addCriterion("sender_phone not in", values, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneBetween(String value1, String value2) {
            addCriterion("sender_phone between", value1, value2, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotBetween(String value1, String value2) {
            addCriterion("sender_phone not between", value1, value2, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIsNull() {
            addCriterion("sender_address is null");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIsNotNull() {
            addCriterion("sender_address is not null");
            return (Criteria) this;
        }

        public Criteria andSenderAddressEqualTo(String value) {
            addCriterion("sender_address =", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotEqualTo(String value) {
            addCriterion("sender_address <>", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressGreaterThan(String value) {
            addCriterion("sender_address >", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sender_address >=", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLessThan(String value) {
            addCriterion("sender_address <", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLessThanOrEqualTo(String value) {
            addCriterion("sender_address <=", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLike(String value) {
            addCriterion("sender_address like", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotLike(String value) {
            addCriterion("sender_address not like", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIn(List<String> values) {
            addCriterion("sender_address in", values, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotIn(List<String> values) {
            addCriterion("sender_address not in", values, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressBetween(String value1, String value2) {
            addCriterion("sender_address between", value1, value2, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotBetween(String value1, String value2) {
            addCriterion("sender_address not between", value1, value2, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailIsNull() {
            addCriterion("sender_adderss_detail is null");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailIsNotNull() {
            addCriterion("sender_adderss_detail is not null");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailEqualTo(String value) {
            addCriterion("sender_adderss_detail =", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailNotEqualTo(String value) {
            addCriterion("sender_adderss_detail <>", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailGreaterThan(String value) {
            addCriterion("sender_adderss_detail >", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailGreaterThanOrEqualTo(String value) {
            addCriterion("sender_adderss_detail >=", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailLessThan(String value) {
            addCriterion("sender_adderss_detail <", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailLessThanOrEqualTo(String value) {
            addCriterion("sender_adderss_detail <=", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailLike(String value) {
            addCriterion("sender_adderss_detail like", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailNotLike(String value) {
            addCriterion("sender_adderss_detail not like", value, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailIn(List<String> values) {
            addCriterion("sender_adderss_detail in", values, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailNotIn(List<String> values) {
            addCriterion("sender_adderss_detail not in", values, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailBetween(String value1, String value2) {
            addCriterion("sender_adderss_detail between", value1, value2, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andSenderAdderssDetailNotBetween(String value1, String value2) {
            addCriterion("sender_adderss_detail not between", value1, value2, "senderAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailIsNull() {
            addCriterion("receiver_adderss_detail is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailIsNotNull() {
            addCriterion("receiver_adderss_detail is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailEqualTo(String value) {
            addCriterion("receiver_adderss_detail =", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailNotEqualTo(String value) {
            addCriterion("receiver_adderss_detail <>", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailGreaterThan(String value) {
            addCriterion("receiver_adderss_detail >", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_adderss_detail >=", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailLessThan(String value) {
            addCriterion("receiver_adderss_detail <", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailLessThanOrEqualTo(String value) {
            addCriterion("receiver_adderss_detail <=", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailLike(String value) {
            addCriterion("receiver_adderss_detail like", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailNotLike(String value) {
            addCriterion("receiver_adderss_detail not like", value, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailIn(List<String> values) {
            addCriterion("receiver_adderss_detail in", values, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailNotIn(List<String> values) {
            addCriterion("receiver_adderss_detail not in", values, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailBetween(String value1, String value2) {
            addCriterion("receiver_adderss_detail between", value1, value2, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAdderssDetailNotBetween(String value1, String value2) {
            addCriterion("receiver_adderss_detail not between", value1, value2, "receiverAdderssDetail");
            return (Criteria) this;
        }

        public Criteria andCargoWeightIsNull() {
            addCriterion("cargo_weight is null");
            return (Criteria) this;
        }

        public Criteria andCargoWeightIsNotNull() {
            addCriterion("cargo_weight is not null");
            return (Criteria) this;
        }

        public Criteria andCargoWeightEqualTo(Double value) {
            addCriterion("cargo_weight =", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightNotEqualTo(Double value) {
            addCriterion("cargo_weight <>", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightGreaterThan(Double value) {
            addCriterion("cargo_weight >", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("cargo_weight >=", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightLessThan(Double value) {
            addCriterion("cargo_weight <", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightLessThanOrEqualTo(Double value) {
            addCriterion("cargo_weight <=", value, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightIn(List<Double> values) {
            addCriterion("cargo_weight in", values, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightNotIn(List<Double> values) {
            addCriterion("cargo_weight not in", values, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightBetween(Double value1, Double value2) {
            addCriterion("cargo_weight between", value1, value2, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andCargoWeightNotBetween(Double value1, Double value2) {
            addCriterion("cargo_weight not between", value1, value2, "cargoWeight");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataIsNull() {
            addCriterion("order_crate_data is null");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataIsNotNull() {
            addCriterion("order_crate_data is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataEqualTo(Date value) {
            addCriterion("order_crate_data =", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataNotEqualTo(Date value) {
            addCriterion("order_crate_data <>", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataGreaterThan(Date value) {
            addCriterion("order_crate_data >", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataGreaterThanOrEqualTo(Date value) {
            addCriterion("order_crate_data >=", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataLessThan(Date value) {
            addCriterion("order_crate_data <", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataLessThanOrEqualTo(Date value) {
            addCriterion("order_crate_data <=", value, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataIn(List<Date> values) {
            addCriterion("order_crate_data in", values, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataNotIn(List<Date> values) {
            addCriterion("order_crate_data not in", values, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataBetween(Date value1, Date value2) {
            addCriterion("order_crate_data between", value1, value2, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andOrderCrateDataNotBetween(Date value1, Date value2) {
            addCriterion("order_crate_data not between", value1, value2, "orderCrateData");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksIsNull() {
            addCriterion("sender_remarks is null");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksIsNotNull() {
            addCriterion("sender_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksEqualTo(String value) {
            addCriterion("sender_remarks =", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksNotEqualTo(String value) {
            addCriterion("sender_remarks <>", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksGreaterThan(String value) {
            addCriterion("sender_remarks >", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("sender_remarks >=", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksLessThan(String value) {
            addCriterion("sender_remarks <", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksLessThanOrEqualTo(String value) {
            addCriterion("sender_remarks <=", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksLike(String value) {
            addCriterion("sender_remarks like", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksNotLike(String value) {
            addCriterion("sender_remarks not like", value, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksIn(List<String> values) {
            addCriterion("sender_remarks in", values, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksNotIn(List<String> values) {
            addCriterion("sender_remarks not in", values, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksBetween(String value1, String value2) {
            addCriterion("sender_remarks between", value1, value2, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andSenderRemarksNotBetween(String value1, String value2) {
            addCriterion("sender_remarks not between", value1, value2, "senderRemarks");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andSeStateIsNull() {
            addCriterion("se_state is null");
            return (Criteria) this;
        }

        public Criteria andSeStateIsNotNull() {
            addCriterion("se_state is not null");
            return (Criteria) this;
        }

        public Criteria andSeStateEqualTo(String value) {
            addCriterion("se_state =", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateNotEqualTo(String value) {
            addCriterion("se_state <>", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateGreaterThan(String value) {
            addCriterion("se_state >", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateGreaterThanOrEqualTo(String value) {
            addCriterion("se_state >=", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateLessThan(String value) {
            addCriterion("se_state <", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateLessThanOrEqualTo(String value) {
            addCriterion("se_state <=", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateLike(String value) {
            addCriterion("se_state like", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateNotLike(String value) {
            addCriterion("se_state not like", value, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateIn(List<String> values) {
            addCriterion("se_state in", values, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateNotIn(List<String> values) {
            addCriterion("se_state not in", values, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateBetween(String value1, String value2) {
            addCriterion("se_state between", value1, value2, "seState");
            return (Criteria) this;
        }

        public Criteria andSeStateNotBetween(String value1, String value2) {
            addCriterion("se_state not between", value1, value2, "seState");
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