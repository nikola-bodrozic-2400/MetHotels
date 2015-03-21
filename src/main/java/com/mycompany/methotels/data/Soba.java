package com.mycompany.methotels.data;

import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Nikola Bodrozic 2400
 */

public class Soba {

    private String imeSobe;
    private int sprat;
    private boolean tv;
    private boolean internet;
    private boolean djakuzi;

    @Inject
    public Soba() {
    }

    public Soba(String imeSobe, int sprat) {
        this.imeSobe = imeSobe;
        this.sprat = sprat;
    }

    // soba
    public String getImeSobe() {
        return imeSobe;
    }
    
    public void setImeSobe(String imeSobe) {
        this.imeSobe = imeSobe;
    }

    // sprat
    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    // TV
    public boolean isTv() {
        return tv;
    }
    
    public void setTv(boolean tv) {
        this.tv = tv;
    }
    
    // Internet
    public boolean isInternet() {
        return internet;
    }
    
    public void setInternet(boolean internet) {
        this.internet = internet;
    }    

    // Djakuzi
    public boolean isDjakuzi() {
        return djakuzi;
    }
    
    public void setDjakuzi(boolean djakuzi) {
        this.djakuzi = djakuzi;
    }
    
}

