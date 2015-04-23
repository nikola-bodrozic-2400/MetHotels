/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt01.services.ProtectedPage;
import javax.annotation.security.RolesAllowed;

/**
 *
 * @author nikola
 */
@ProtectedPage
@RolesAllowed(value={"Korisnik"})
public class AdminPanel {
    
}
