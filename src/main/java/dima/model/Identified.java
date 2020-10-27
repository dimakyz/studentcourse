package dima.model;

import java.io.Serializable;

// нтерфейс идентифицируемых объектов.

public interface Identified<PK extends Serializable> extends Serializable {

    /**
     * Возвращает идентификатор объекта
     */
    PK getId();

}
