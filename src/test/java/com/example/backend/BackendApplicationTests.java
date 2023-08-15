package com.example.backend;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.entity.Cryptocurrency;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {
	@Autowired
	private CryptocurrencyRepository cryptocurrencyRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCrypto(){
		Cryptocurrency cryptocurrency = new Cryptocurrency();
		cryptocurrency.setNombre("Bitcoin");
		cryptocurrency.setSimbolo("BTC");
		cryptocurrencyRepository.save(cryptocurrency);

	}


}
