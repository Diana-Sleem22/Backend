package com.example.demo;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exchangeRateController {
	@Autowired
	private exchangeRateRepository repository;

	@PostMapping("/registerRates")
	public int registration(@RequestBody exchangeRate exchangeRateDto) {
		repository.save(exchangeRateDto);
		return Response.SC_CREATED;

	}

	@GetMapping("/getAllExchangeRates")
	public List<exchangeRate> getAllExchangeRates() {
		return repository.findAll();

	}

	@PutMapping("/updateExchangeRate")
	private int update(@RequestBody exchangeRate exchangeRateDto) {
		repository.save(exchangeRateDto);

		return Response.SC_CREATED;
	}
}
