/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages.services;

/**
 *
 * @author hammond
 */
import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;

import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author hammond
 */
public class NadjiSobu {

    @Inject
    private Request request;
    
    @Property
    private List<Soba> sobe;
    
    @Property
    private Soba soba;
    
    @Inject
    private SobaDao sobaDao;

    Object onActivate(@RequestParameter("ime") String ime) {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
        String response = "<table class=\"navigation\" > <th>\n"
                + " Ime sobe\n"
                + " </th>\n"
                + " ";
        sobe = sobaDao.getListaSobaPoImenu(ime);
        for (Soba d : sobe) {
            response += (" <tr>\n"
                    + " <td> " + d.getImeSobe()+ "</td>\n"
                    + " </tr>");
        }
        response += "</table>";
        return new TextStreamResponse("text/plain", response);
    }
}

