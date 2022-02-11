package com.test.calculator.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.calculator.calculator.dto.ResultOperationDto;
import com.test.calculator.calculator.exception.CalculatorException;
import com.test.calculator.calculator.service.IOperationService;
import com.test.calculator.calculator.utilities.Constant;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	private static Logger log = LoggerFactory.getLogger(CalculatorController.class);

	private final IOperationService iOperationService;

	CalculatorController(IOperationService iOperationService) {
		this.iOperationService = iOperationService;
	}

	/**
	 * Rest Controller method used to obtain the result of a sum.
	 * 
	 * @param num1 Double
	 * @param num2 Double
	 * @return Double
	 * @throws CalculatorException
	 */
	@GetMapping(Constant.OPERATIONSUM)
	public ResponseEntity<ResultOperationDto> getSum(@RequestParam Double num1, @RequestParam Double num2)
			throws CalculatorException {
		log.info("INIT - method Rest getSum()");
		ResultOperationDto responseSum = new ResultOperationDto(iOperationService.getSumService(num1, num2));
		log.info("END - method Rest getSum()");
		return new ResponseEntity<>(responseSum, HttpStatus.OK);
	}

	/**
	 * Rest Controller method used to obtain the result of a subtract.
	 * 
	 * @param num1 Double
	 * @param num2 Double
	 * @return Double
	 * @throws CalculatorException
	 */
	@GetMapping(Constant.OPERATIONSUBTRACT)
	public ResponseEntity<ResultOperationDto> getSubtract(@RequestParam Double num1, @RequestParam Double num2)
			throws CalculatorException {
		log.info("INIT: method Rest getSubtract()");
		ResultOperationDto responseSum = new ResultOperationDto(iOperationService.getSubtractService(num1, num2));
		log.info("END: method Rest getSubtract()");
		return new ResponseEntity<>(responseSum, HttpStatus.OK);
	}

}
