package com.emigreat.bank;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.emigreat.bank.*")
@ContextConfiguration(classes = BankingApplication.class)

public class BankTransactionControllerTest {

	private final String LOCALHOST = "http://localhost:5000";
	private final String SERVICE_NAME = "/";
	private static final Gson GSON = new GsonBuilder().create();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testDeposit() throws Exception {

		String gsonString = GSON.toJson(TransactionRequestFixture.TEST_DEPOSIT,
				TransactionRequestBuilder.class);
		System.out.println("BankTransactionControllerTest.testWithPositiveAmount()"+TransactionRequestFixture.TEST_DEPOSIT.getAccountId());
		mockMvc.perform(post(new URL(LOCALHOST + SERVICE_NAME + "/transactions").toString())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(gsonString))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(
						jsonPath("$.accountId", is(""+TransactionRequestFixture.TEST_DEPOSIT.getAccountId())))
				.andExpect(jsonPath("$.amount", is(1000.0)))
				.andExpect(jsonPath("$.message", is("Transferred 1000.0$ to Account "+TransactionRequestFixture.TEST_DEPOSIT.getAccountId())));
	}

	@Test
	public void testWithdrawal() throws Exception {

		String gsonString = GSON.toJson(TransactionRequestFixture.TEST_WITHDAWAL,
				TransactionRequestBuilder.class);

		mockMvc.perform(post(new URL(LOCALHOST + SERVICE_NAME + "/transactions").toString())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(gsonString))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(
						jsonPath("$.accountId", is(""+TransactionRequestFixture.TEST_WITHDAWAL.getAccountId())))
				.andExpect(jsonPath("$.amount", is(-500.0)))
				.andExpect(jsonPath("$.message", is("Transferred 500.0$ from Account "+TransactionRequestFixture.TEST_WITHDAWAL.getAccountId())));
	}
	
	

}
