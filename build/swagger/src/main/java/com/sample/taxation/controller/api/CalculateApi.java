package com.sample.taxation.controller.api;

import com.sample.taxation.payload.TaxResponse;
import com.sample.taxation.payload.TaxRequest;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T20:31:48.489+05:30")

@Api(value = "calculate", description = "the calculate API")
public interface CalculateApi {

    @ApiOperation(value = "Create a Tax Calculation Record", notes = "Calculates the amount of tax owed for a purchase transaction.", response = TaxResponse.class, tags={ "taxation-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The tax calculation completed successfully.", response = TaxResponse.class),
        @ApiResponse(code = 404, message = "The product detail dose not exists.", response = TaxResponse.class),
        @ApiResponse(code = 500, message = "Bad request.", response = TaxResponse.class) })
    @RequestMapping(value = "/calculate",
        produces = { "*_/_*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<TaxResponse> calculate(

@ApiParam(value = "Information about the purchase and all associated details required to calculate the amount of tax owed by the customer." ,required=true ) @RequestBody TaxRequest taxCalculation

) {
        // do some magic!
        return new ResponseEntity<TaxResponse>(HttpStatus.OK);
    }

}
