/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.apache.tapestry5.ioc.annotations.Inject;

public class Soba {

    private String imeSobe;
    private int sprat;

    @Inject
    public Soba() {
    }

    public Soba(String imeSobe, int sprat) {
        this.imeSobe = imeSobe;
        this.sprat = sprat;
    }

    public String getImeSobe() {
        return imeSobe;
    }

    public int getSprat() {
        return sprat;
    }

    public void setImeSobe(String imeSobe) {
        this.imeSobe = imeSobe;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }
    
}

