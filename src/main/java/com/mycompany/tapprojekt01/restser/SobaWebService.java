/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.restser;

import com.mycompany.tapprojekt.dao.SobaDao;
import com.mycompany.tapprojekt01.entities.Soba;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author hammond
 */
public class SobaWebService implements SobaWebServiceInterface {

    @Inject
    private SobaDao sobaDao;

    @Override
    public List<Soba> getAll() {
        return (sobaDao.getListaSvihSoba());
    }

    @Override
    public Soba getSoba(@PathParam("id") Integer id) {
        return sobaDao.getSobaById(id);
    }

    @Override
    public Response post(Soba soba) {
        sobaDao.dodajSoba(soba);
        return Response.ok().entity(soba).build();
    }
}
