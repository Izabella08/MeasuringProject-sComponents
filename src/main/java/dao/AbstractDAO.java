package dao;

import java.lang.reflect.ParameterizedType;
import java.util.logging.Logger;

public class AbstractDAO<T>{
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
