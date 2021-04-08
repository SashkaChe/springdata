package ru.springdata.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.neutrino.dao.EntityDAO;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

	@Autowired 
	private EntityDAO entitydao;
	
		
	
	public Planet newPlanet(String name) {
      return new Planet (name);
	}
	
	
	public void showallPlanet() throws SQLException {
		 for (Planet x : entitydao.allPlanets()) {
				System.out.println(x);
			}
	}
		 
		 
		 
	}
	

