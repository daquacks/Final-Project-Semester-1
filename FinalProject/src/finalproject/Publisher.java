package finalproject;
import java.util.*;

public class Publisher {
    private String pubName;
    private String country;
    
    public Publisher(String pubName, String country) {
        this.pubName=pubName;
        this.country=country;
    }
    
    public void setPubName(String pubName) {
        this.pubName=pubName;
    }
    
    public void setCountry(String country) {
        this.country=country;
    }
    
    public String getPubName() {
        return pubName;
    }
    
    public String getCountry() {
        return country;
    }
}
