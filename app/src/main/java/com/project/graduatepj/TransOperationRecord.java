package com.project.graduatepj;

import java.sql.Date;

public class TransOperationRecord {
    private String Rqno ;
    private String Name;
    private String BloodType ;
    private String BedNum ;
    private String QrChart ;
    private String Emid ;
    private String ConfrimId ;
    private Date RecordTime;
    private String RecordId ;

    public TransOperationRecord(String rqno, String name, String bloodType, String bedNum, String qrChart, String emid, String confrimId) {
        Rqno = rqno;
        Name = name;
        BloodType = bloodType;
        BedNum = bedNum;
        QrChart = qrChart;
        Emid = emid;
        ConfrimId = confrimId;
    }
}
