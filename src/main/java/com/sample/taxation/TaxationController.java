package com.sample.taxation;

import static org.springframework.http.ResponseEntity.ok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.taxation.payload.TaxRequest;
import com.sample.taxation.payload.TaxResponse;
import com.sample.taxation.service.TaxationService;

/**
 * Manages interaction between API requests for Taxation.
 */
@RestController
@RequestMapping("/taxation/1.0")
public class TaxationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaxationController.class);
	private final TaxationService taxationService;

	/**
	 * Constructor for Bean injection.
	 *
	 * @param taxationService
	 *            to inject
	 */
	@Autowired
	TaxationController(final TaxationService taxationService) {
		this.taxationService = taxationService;
	}

	/**
	 * Calculate tax.
	 *
	 * @param taxationRequest
	 *            purchase product detail.
	 * @return TaxResponse purchase product with taxes.
	 */
	@RequestMapping(path = "/calculate", method = RequestMethod.POST)
	public ResponseEntity<TaxResponse> calculateTaxes(@RequestBody final TaxRequest taxationRequest) {
		LOGGER.info("Handling POST on /calculate.");
		TaxResponse taxationResponse = taxationService.calculateTax(taxationRequest);
		LOGGER.info("Done POST on /calculate.");
		return ok(taxationResponse);
	}

	/**
	 * Populate product and taxType mapping.
	 *
	 * @return Void
	 */
	@RequestMapping(path = "/dataStore", method = RequestMethod.POST)
	public ResponseEntity<Void> calculateTaxes() {
		ResponseEntity<Void> response;
		taxationService.populate();
		response = new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

}
