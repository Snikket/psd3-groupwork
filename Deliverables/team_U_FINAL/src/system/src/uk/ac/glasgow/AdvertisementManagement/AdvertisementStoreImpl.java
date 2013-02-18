package uk.ac.glasgow.AdvertisementManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AdvertisementStoreImpl implements AdvertisementStore{
        private int lastIndex;
        private Map<Integer,Advertisement> ads;
	private File storeFile;
	
	/**
	 * Constructs a new store in the specified file location.
	 * @param fileName
	 */
	public AdvertisementStoreImpl(String fileName){
		storeFile = new File(fileName);
		if (storeFile.exists()){
			try {
				ObjectInputStream ois = 
					new ObjectInputStream(new FileInputStream(storeFile));
				ads = (Map<Integer,Advertisement>)(ois.readObject());
                                lastIndex = ads.size();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
                else{
			this.ads = new HashMap<Integer,Advertisement>();
                        lastIndex = 0;
                        System.out.println("creating new hashmap");
                }
	}
	


        @Override
        public void addAdvert(Advertisement ad) {
            
            ads.put(lastIndex,ad);
            lastIndex++;
            try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeFile));
                    oos.writeObject(ads);
                    oos.close();
            } catch (FileNotFoundException e) {
                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }

        @Override
        public Advertisement getAdvert(int adId) {
            Advertisement ad = ads.get(adId);
            return ad;
        }

        @Override
        public Map<Integer, Advertisement> getAdverts() {
            return ads;
        }


}