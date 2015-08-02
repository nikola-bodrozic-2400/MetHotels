/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.pages;

import org.apache.shiro.authz.annotation.RequiresRoles;

/**
 *
 * @author hammond
 */
@RequiresRoles("Admin")
public class ShiroAdminDemo {
    
}
