package com.db.awmd.challenge.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDto {
	@NotNull
	@NotEmpty
	private String accountToId;
	@NotNull
	@NotEmpty
	private String accountFromId;
	@NotNull
	@Min(value = 1, message = "Transfer amount should be greater than zero")
	private BigDecimal amount;

	public String getAccountFromId() {
		return accountFromId;
	}

	public String getAccountToId() {
		return accountToId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
