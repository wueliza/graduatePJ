package com.project.graduatepj;

import java.sql.Date;

public class CheckOperationRecord {
    private String QrChart ;
    private String Bsno ;
    private String Emid ;
    private String ConfirmId ;
    private Date RecordTime;
    private String RecordId ;

    public CheckOperationRecord(String qrChart, String bsno, String emid, String confirmId) {
        QrChart = qrChart;
        Bsno = bsno;
        Emid = emid;
        ConfirmId = confirmId;
    }
}
