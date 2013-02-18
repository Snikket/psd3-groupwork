package uk.ac.glasgow.OfferManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class OfferStoreImpl implements OfferStore{
        private int lastIndex;
        private Map<String,Offer> offers;
	private File storeFile;
	
	/**
	 * Constructs a new store in the specified file location.
	 * @param fileName
	 */
	public OfferStoreImpl(String fileName){
		storeFile = new File(fileName);
		if (storeFile.exists()){
			try {
				ObjectInputStream ois = 
					new ObjectInputStream(new FileInputStream(storeFile));
				offers = (Map<String,Offer>)(ois.readObject());
                                lastIndex = offers.size();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else
			this.offers = new HashMap<String, Offer>();
                        lastIndex = 0;
	}
	


        @Override
        public void addOffer(Offer offer) {
            offers.put(offer.getStudent().getMatriculation(), offer);

            try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeFile));
                    oos.writeObject(offers);
                    oos.close();
            } catch (FileNotFoundException e) {
                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }

        @Override
        public Offer getOffer(String matriculation) {
            return offers.get(matriculation);
        }

        @Override
        public Map<String, Offer> getOffers() {
            return offers;
        }


}