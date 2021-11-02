package com.project.graduatepj;

import net.sourceforge.jtds.jdbc.DateTime;

public class Patient_Api {
    public String QrChart ;
    public String Sex;
    public String Name ;
    public String Division ;
    public String Height ;
    public String Age ;
    public String Weight ;
    public String Bsnos ;
    public DateTime BirthDate ;
    public String Ora4Chart ;
    public String Emid ;
    public String BedNum ;

    public String getQrChart() {
        return QrChart;
    }

    public String getSex() {
        return Sex;
    }

    public String getName() {
        return Name;
    }

    public String getDivision() {
        return Division;
    }

    public String getHeight() {
        return Height;
    }

    public String getAge() {
        return Age;
    }

    public String getWeight() {
        return Weight;
    }

    public String getBsnos() {
        return Bsnos;
    }

    public DateTime getBirthDate() {
        return BirthDate;
    }

    public String getOra4Chart() {
        return Ora4Chart;
    }

    public String getEmid() {
        return Emid;
    }

    public String getBedNum() {
        return BedNum;
    }

    /*public virtual staff Em { get; set; }
    public virtual Ora4Chart Ora4ChartNavigation { get; set; }
    public virtual ICollection<BloodBank> BloodBanks { get; set; }
    public virtual ICollection<Medicine> Medicines { get; set; }
    public virtual ICollection<Tpr> Tprs { get; set; }
    public virtual ICollection<TransOperation> TransOperations { get; set; }*/



    /*private int patientNum;
    private String sex;
    private String birth;
    private String bedNum;
    private String bloodType;
    private String name;
    private String division;
    private String height;
    private String age;
    private String weight;
    private String bsno;

    public int getPatientNum() {
        return patientNum;
    }

    public String getSex() {
        return sex;
    }

    public String getBirth() {
        return birth;
    }

    public String getBedNum() {
        return bedNum;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getName() {
        return name;
    }

    public String getDivision() {
        return division;
    }

    public String getHeight() {
        return height;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getBsno() {
        return bsno;
    }

    public Patient_Api(int patientNum, String sex, String birth, String bedNum, String bloodType, String name, String division, String height, String age, String weight, String bsno) {
        this.patientNum = patientNum;
        this.sex = sex;
        this.birth = birth;
        this.bedNum = bedNum;
        this.bloodType = bloodType;
        this.name = name;
        this.division = division;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.bsno = bsno;
    }*/
}
