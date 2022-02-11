package com.test.calculator.calculator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.calculator.calculator.exception.CalculatorException;
import com.test.calculator.calculator.service.IOperationService;

import io.corp.calculator.TracerImpl;

/**
 * Implementation Service IOperationService
 * 
 * @author Ruben Moral Lunar
 *
 */
@Service
public class OperationServiceImpl implements IOperationService {

	private static Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);

	private final TracerImpl tracer = new TracerImpl();

	@Override
	public Double getSumService(Double num1, Double num2) throws CalculatorException {
		try {
			log.info("INIT - method Service getSumService()");
			Double result = num1 + num2;
			tracer.trace(result);
			log.info("END - method Service getSumService()");
			return result;
		} catch (Exception ex) {
			log.error("Error: ", ex.getMessage());
			throw new CalculatorException("Error in the argument");
		}
	}

	@Override
	public Double getSubtractService(Double num1, Double num2) throws CalculatorException {
		try {
			log.info("INIT - method Service getSubtractService()");
			Double result = num1 - num2;
			tracer.trace(result);
			log.info("END - method Service getSubtractService()");
			return result;
		} catch (Exception ex) {
			log.error("Error: ", ex.getMessage());
			throw new CalculatorException("Error in the argument");
		}
	}

}
