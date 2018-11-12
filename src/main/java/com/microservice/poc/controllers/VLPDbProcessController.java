package com.microservice.poc.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/vlpdbprocess/")
@Api(description = "Set of endpoints to Store the Lawful presence details and Retrieves the Lawful presence details for a particular UUID on demand ")
public class VLPDbProcessController {


}
