package com.project.graduatepj;

import java.sql.Date;

public class Tpr3Record {
    private String TransTime ;
    private String T;
    private String P ;
    private String R ;
    private String Bp;
    private Date RecordTime;
    private String RecordId ;

    public Tpr3Record(String transTime, String t, String p, String r, String bp) {
        TransTime = transTime;
        T = t;
        P = p;
        R = r;
        Bp = bp;
    }
}
