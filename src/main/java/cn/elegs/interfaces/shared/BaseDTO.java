package cn.elegs.interfaces.shared;

import java.io.Serializable;

/**
 * DTO基类.
 */
public class BaseDTO implements Serializable {

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
