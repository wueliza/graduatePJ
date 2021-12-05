package com.project.graduatepj;

import java.sql.Date;

public class Tpr1Record {
    private String TransTime ;
    private String T;
    private String P ;
    private String R ;
    private String Bp;
    private Date RecordTime;
    private String RecordId ;

    public Tpr1Record(String transTime, String t, String p, String r, String bp) {
        TransTime = transTime;
        T = t;
        P = p;
        R = r;
        Bp = bp;
    }
}
