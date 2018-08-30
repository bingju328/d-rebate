package com.drebate.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by liming
 */
@RestController
@RequestMapping("/CatEye")
@Slf4j
public class CatEyeController {


	@PostMapping("/whereComing")
	@ApiOperation(value = "获取用户扫码位置", notes = "", httpMethod = "POST")
	public void hotelBillDetail(@RequestParam String userId, @RequestParam String qrCodeId) {

//		catEyeServiceImpl.insertQrCodeRecord(userId,qrCodeId);

	}

	public static void main(String[] args) {
		SpringApplication.run(CatEyeController.class, args);
	}
}
