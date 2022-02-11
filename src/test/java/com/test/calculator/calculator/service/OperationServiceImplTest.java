package com.test.calculator.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.calculator.calculator.exception.CalculatorException;
import com.test.calculator.calculator.service.impl.OperationServiceImpl;

@SpringBootTest
public class OperationServiceImplTest {

	OperationServiceImpl operationServiceImpl;

	@BeforeEach
	public void init() {
		operationServiceImpl = new OperationServiceImpl();
	}

	@Test
	public void getSumServiceTestPositive() throws CalculatorException {
		Double expected = 2.2;
		Double result = operationServiceImpl.getSumService(1.1, 1.1);
		assertEquals(expected, result);
	}

	@Test
	public void getSumServiceTestExceptionArgumentNull() throws CalculatorException {
		assertThrows(CalculatorException.class, new Executable() {

			public void execute() throws Throwable {
				operationServiceImpl.getSumService(null, 2.2);
			}

		});
	}

	@Test
	public void getSubtractServiceTestPositive() throws CalculatorException {
		Double expected = 2.0;
		Double result = operationServiceImpl.getSubtractService(4.0, 2.0);
		assertEquals(expected, result);
	}

	@Test
	public void getSubtractServiceTestExceptionArgumentNull() throws CalculatorException {
		assertThrows(CalculatorException.class, new Executable() {

			public void execute() throws Throwable {
				operationServiceImpl.getSubtractService(null, null);
			}

		});
	}

}
