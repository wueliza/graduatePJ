package com.project.graduatepj;

public class eisaiData {
    private String inspetors_num , patient_num , equipment;

    public eisaiData(String i , String p , String e){
        setInspetors_num(i);
        setPatient_num(p);
        setEquipment(e);
    }

    public eisaiData(){
        setInspetors_num(this.inspetors_num);
        setPatient_num(this.patient_num);
        setEquipment(this.equipment);
    }


    public void setInspetors_num(String inspetors_num) {
        this.inspetors_num = inspetors_num;
    }

    public void setPatient_num(String patient_num) {
        this.patient_num = patient_num;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getInspetors_num() {
        return inspetors_num;
    }

    public String getPatient_num() {
        return patient_num;
    }

    public String getEquipment() {
        return equipment;
    }
}
