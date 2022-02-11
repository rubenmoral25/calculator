package com.test.calculator.calculator.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.test.calculator.calculator.service.IOperationService;

@WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IOperationService iOperationService;

	@MockBean
	private TracerImpl tracer;

	@Test
	public void TestExceptionMethodArgumentTypeMismatchException() throws Exception {
		Mockito.when(iOperationService.getSumService(Mockito.anyDouble(), Mockito.anyDouble())).thenThrow(MethodArgumentTypeMismatchException.class);
		this.mockMvc.perform(get("/calculator/operation/sum?num1=4&num2=r"))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string(containsString("Error, Incorrect arguments.")));
	}
	
	@Test
	public void getSumTestControllerRestOk() throws Exception {
		Mockito.when(iOperationService.getSumService(4.0, 2.0)).thenReturn(6.0);
		this.mockMvc.perform(get("/calculator/operation/sum?num1=4&num2=2")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", is(6D)));
	}
	
	@Test
	public void getSubtractTestControllerRestOk() throws Exception {
		Mockito.when(iOperationService.getSubtractService(4.0, 2.0)).thenReturn(2.0);
		this.mockMvc.perform(get("/calculator/operation/subtract?num1=4&num2=2")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", is(2D)));
	}
	

}
