package com.finasys.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finasys.api.services.StatusService;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService service;
}
