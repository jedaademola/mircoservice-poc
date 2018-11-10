package com.microservice.poc.controllers;

import com.microservice.poc.services.ApiMonitorService;
import com.microservice.poc.utility.Utility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/v1/monitoring/")
@Api(description = "Set of endpoints for checking Application Health.")
public class AppMonitorController {

    @Value("${behind.proxy}")
    boolean isBehindProxy;
    @Value("${proxy.servername}")
    String proxyServerName;
    @Value("${app.name}")
    String appName;

    @Autowired
    private ApiMonitorService apiMonitorService;


    @RequestMapping(value = "/checkdb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation("${appMonitorcontroller.checkdb}")
    public ResponseEntity<?> dbMonitor(HttpServletRequest request) throws Exception {

        HashMap<String, String> appProperties = apiMonitorService.getLookupValues();

        appProperties.put("Time", new Date().toString());
        appProperties.put("Application URL", Utility.getServerURl(request, isBehindProxy, proxyServerName));
        appProperties.put("App Name", appName);
        appProperties.put("Application Status", "Running");

        return new ResponseEntity<>(appProperties, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkdirectory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation("${appMonitorcontroller.checkDirectory}")
    public ResponseEntity<?> appMonitor(HttpServletRequest request) throws Exception {

        HashMap<String, String> appProperties = new HashMap<>();

        appProperties.put("Time", new Date().toString());
        appProperties.put("Application URL", Utility.getServerURl(request, isBehindProxy, proxyServerName));
        appProperties.put("App Name", appName);
        appProperties.put("Application Status", "Running");

        return new ResponseEntity<>(appProperties, HttpStatus.OK);
    }

}
