package com.gientech.springbucks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.gientech.springbucks.util.OrderState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "T_ORDER")
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CoffeeOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146993811628495893L;

	private String customer;

	@ManyToMany
	@JoinTable(name = "T_ORDER_COFFEE")
	@OrderBy("id")
	private List<Coffee> items;

	@Enumerated
	@Column(nullable = false)
	private OrderState state;
}
