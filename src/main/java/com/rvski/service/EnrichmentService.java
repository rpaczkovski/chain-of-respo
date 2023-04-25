package com.rvski.service;


public class EnrichmentService {

  private EnrichmentHandler enrichmentHandler;

  public EnrichmentService() {
    this.enrichmentHandler = new DefaultEnrichmentHandler();
    this.enrichmentHandler.setNext(new GeocodeEnrichmentHandler());
    this.enrichmentHandler.setNext(new OtherEnrichmentHandler());
  }

  public String enrich(String response) {
    response = enrichmentHandler.handle(response);
    return response;
  }
}
