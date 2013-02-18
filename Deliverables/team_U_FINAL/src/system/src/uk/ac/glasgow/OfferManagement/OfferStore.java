/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.glasgow.OfferManagement;

import java.util.Map;
import uk.ac.glasgow.AdvertisementManagement.Advertisement;
import uk.ac.glasgow.AdvertisementManagement.Advertisement;

/**
 *
 * @author 2037876b
 */
public interface OfferStore {
    /**
	 * Adds a new offer to the store.
	 * @param offer

	 */
	public void addOffer(Offer offer);
		
	/**
	 * Returns an offer specified by its target's matriculation
	 * 
	 * @param matriculation

	 */
	public Offer getOffer(String matriculation);
        
        public Map<String, Offer> getOffers();
}
