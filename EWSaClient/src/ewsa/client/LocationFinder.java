/*
 * AERATOS TEAM
 */
package ewsa.client;

import java.math.BigDecimal;

import it.elbuild.jcoord.LatLng;
import it.elbuild.jcoord.resolver.GeoCodeResolver;

public class LocationFinder {    

    
    public LocationFinder(){
        
    }
    
    public String getCoord(String locName){
        
        try{
            String address = locName;

            LatLng coord = GeoCodeResolver.findCoordForAddress(address);

            BigDecimal lat = coord.getLat();
            BigDecimal lon = coord.getLng();

            //System.out.println("Lat " + lat + "\t Long: " + lon);

            return(lat+", "+lon);
        }catch (NullPointerException e) {
            return "error";
        }
    }
    
}
