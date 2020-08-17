package org.suprun.filesearch.service;

import org.suprun.filesearch.service.impl.ApplianceServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory serviceInstance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {}

    public ApplianceService getApplianceService() {
        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return serviceInstance;
    }
}
