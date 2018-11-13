package com.microservice.poc.controllers;

import com.microservice.poc.domain.PersonLawfulDetail.PersonLawfulDetail;
import com.microservice.poc.services.VLPDbOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/vlpdbprocess/")
@Api(description = "Set of endpoints to Store and Retrieve the Lawful presence details  ")
public class VLPDbOperationController {

    @Autowired
    private VLPDbOperationService vLPDbProcessService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("${vLPDbProcessController.getall}")
    public List<PersonLawfulDetail> getAllPersonLawfulDetail() {
        return vLPDbProcessService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("${vLPDbProcessController.getbyid}")
    public PersonLawfulDetail getPersonById(@ApiParam("Id of the person's Person Lawful Detail to be obtained. Cannot be empty.")
                                            @PathVariable Long id) {
        return vLPDbProcessService.find(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("${vLPDbProcessController.delete}")
    public void deletePersonLawfulDetail(@ApiParam("Id of the person's Person Lawful Detail to be deleted. Cannot be empty.")
                                         @PathVariable Long id) {
        vLPDbProcessService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("${vLPDbProcessController.create}")
    public PersonLawfulDetail createPerson(@ApiParam("Person information for a new Person Lawful Detail to be created.")
                                           @RequestBody PersonLawfulDetail personLawfulDetail) {
        return vLPDbProcessService.create(personLawfulDetail);
    }


}
