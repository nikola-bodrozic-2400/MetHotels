/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages.services;

import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.TextStreamResponse;

/**
 *
 * @author hammond
 */
public class PaginationGrid {

    @Inject
    private SobaDao sobaDao;
    private int size = 20;

    Object onActivate(@RequestParameter("page") int page) {
        Class<?> act = null;
        int sizeOfAll = sobaDao.allActiveSizeSoba();
        List<Soba> lista = new ArrayList<Soba>();
        String response = "<table class=\"navigation\" > <th>\n"
                + " Ime Sobe\n"
                + " </th>\n"
                + " ";
        lista = sobaDao.loadActiveFromTo(page);
        for (Soba d : lista) {
            response += (" <tr>\n"
                    + " <td> " + d.getImeSobe()+ "</td>\n"
                    + " </tr>");
        }
        response += "</table>";
        float ceil = (float) sizeOfAll / (float) 20;
        int totalPageSizes = (int) Math.ceil(ceil);
        response += "<ul class=\"pagination\">";
        for (int i = 1; i <= totalPageSizes; i++) {
            if (page == i) {
                response += ("<li class=\"callservice active\"><a href=\"#\">" + i + "</a></li>\n");
            } else {
                response += ("<li class=\"callservice\"><a href=\"#\">" + i + "</a></li>\n");
            }
        }
        response += "</ul>";
        return new TextStreamResponse("text/plain", response);
    }
}
