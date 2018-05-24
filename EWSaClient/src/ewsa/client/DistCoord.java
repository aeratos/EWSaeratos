/*
 * AERATOS TEAM
 */
package ewsa.client;

public class DistCoord {
    
    public DistCoord(){
        
    }
    
    public double getDist(double mylat, double mylong, double destlat, double destlong) {
        double rlat1 = Math.PI*mylat/180;
        double rlat2 = Math.PI*destlat/180;
        double theta = mylong - destlong;
        double rtheta = Math.PI*theta/180;
        double dist =
            Math.sin(rlat1)*Math.sin(rlat2) + Math.cos(rlat1)*
            Math.cos(rlat2)*Math.cos(rtheta);
        dist = Math.acos(dist);
        dist = dist*180/Math.PI;
        dist = dist*60*1.1515;

        return dist*1.609344;
    }
    
}
