package com.project.graduatepj;

import java.sql.Date;

public class MedSignRecord {
    private String Emid ;
    private String TransId;
    private String Tubg ;
    private String MedAmount;
    private String Name ;
    private Date RecordTime;
    private String RecordId ;

    public MedSignRecord(String emid, String transId, String tubg, String medAmount, String name) {
        Emid = emid;
        TransId = transId;
        Tubg = tubg;
        MedAmount = medAmount;
        Name = name;
    }
}
