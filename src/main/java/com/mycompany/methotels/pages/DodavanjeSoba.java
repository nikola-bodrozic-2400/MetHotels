package com.mycompany.methotels.pages;

import com.mycompany.methotels.data.Soba;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
/**
 *
 * @author Nikola Bodrozic 2400
 */
public class DodavanjeSoba {
    @Persist
    @Property
    private ArrayList<Soba> sobe;
    @Property
    private Soba soba;

    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
    }

    Object onSuccess() {
        sobe.add(soba);
        return this;
    }    
}
