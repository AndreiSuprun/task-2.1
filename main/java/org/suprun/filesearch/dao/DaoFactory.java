package org.suprun.filesearch.dao;

import org.suprun.filesearch.dao.impl.ApplianceDaoImpl;

public final class DaoFactory {

    private static final DaoFactory daoInstance = new DaoFactory();

    private final ApplianceDao applianceDao = new ApplianceDaoImpl();

    private DaoFactory() {}

    public ApplianceDao getApplianceDao() {
        return applianceDao;
    }

    public static DaoFactory getInstance() {
        return daoInstance;
    }
}
