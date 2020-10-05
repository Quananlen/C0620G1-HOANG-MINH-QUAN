package BO.service;

import DAO.service.ServiceDAO;
import model.Service;

public class ServiceBO {
    ServiceDAO serviceDAO = new ServiceDAO();

    public void add(Service service) {
        serviceDAO.add(service);
    }
}
