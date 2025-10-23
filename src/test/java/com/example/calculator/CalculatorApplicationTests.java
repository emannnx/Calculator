package com.example.calculator;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorApplicationTests {   // ✅ make it public
	private final CalculatorService calculatorService = new CalculatorService();

	@Test
	void testSum() {
		assertEquals(5, calculatorService.sum(2, 3));
	}
}
