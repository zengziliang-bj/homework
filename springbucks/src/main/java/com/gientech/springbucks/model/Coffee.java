package com.gientech.springbucks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.money.Money;

import lombok.Builder;
import lombok.ToString;


@Entity
@Table(name = "T_COFFEE")
@Builder
@ToString(callSuper = true)
public class Coffee extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7848403692043373774L;

	private String name;

	@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount", parameters = {
			@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY") })
	private Money price;
}
