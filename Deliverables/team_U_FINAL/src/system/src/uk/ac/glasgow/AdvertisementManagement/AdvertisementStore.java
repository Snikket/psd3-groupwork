/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.glasgow.AdvertisementManagement;

import java.util.Map;
import uk.ac.glasgow.AdvertisementManagement.Advertisement;

/**
 *
 * @author 2037876b
 */
public interface AdvertisementStore {
    /**
	 * Adds a new advert to the store.
	 * @param surname

	 */
	public void addAdvert(Advertisement ad);
		
	/**
	 * Returns an advert specified by its id
	 * 
	 * @param adId

	 */
	public Advertisement getAdvert(int adId);
        
        public Map<Integer, Advertisement> getAdverts();
}
