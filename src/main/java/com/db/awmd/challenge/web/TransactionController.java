package com.db.awmd.challenge.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.awmd.challenge.dto.TransferDto;
import com.db.awmd.challenge.exception.InsufficientBalenceException;
import com.db.awmd.challenge.service.TransactionService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/banking")
@Slf4j
public class TransactionController {

	private static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	@Autowired
	private TransactionService transactionService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transaction has been done successfully"),
			@ApiResponse(code = 4111, message = "account has not been registered"),
			@ApiResponse(code = 4333, message = "Insufficient balance to transfer the fund") })
	
	/**
	 * this method allows customer to transfer funds
	 * 
	 * @param TransactionDto provide account details to transfer amount
	 * @return ResponseEntity transfer status
	 * 
	 */
	@PutMapping(path = "/transfers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> transferAmount(@RequestBody @Valid TransferDto transferDto)
			throws InsufficientBalenceException {
		logger.info("transferring  account from id {} to {}", transferDto.getAccountFromId(),
				transferDto.getAccountToId());
		return new ResponseEntity<>(transactionService.transferAmount(transferDto.getAccountToId(),
				transferDto.getAccountFromId(), transferDto.getAmount()), HttpStatus.OK);
	}
}
