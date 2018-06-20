package com.uade.ejb.startup;

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.uade.ejb.dao.CiudadDAO;
import com.uade.ejb.dao.HotelDAO;
import com.uade.ejb.entities.HotelEntity;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	HotelDAO hotelDao = new HotelDAO();
    	HotelEntity hotel = new HotelEntity("Sheraton");
    	hotelDao.createHotel(hotel);
    	
    	new CiudadDAO().loadCiudades();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}