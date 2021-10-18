package com.project.graduatepj;

import net.sourceforge.jtds.jdbc.DateTime;

public class Eisai_Api {

    private String EisaiNum;
    private String Name;
    private String Expire;
    private DateTime Expiration ;

    public String getEisaiNum() {
        return EisaiNum;
    }

    public String getName() {
        return Name;
    }

    public String getExpire() {
        return Expire;
    }

    public DateTime getExpiration() {
        return Expiration;
    }
}
