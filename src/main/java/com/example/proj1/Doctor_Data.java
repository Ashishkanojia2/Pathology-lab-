package com.example.proj1;


public class Doctor_Data {
    private int D_id;
    private String D_Name;
    private int D_Age;
    private String D_Gender;
    private int D_Experience;
    private int D_NoT;
    private int D_Income;
    private int D_Treatment_Chrg;

/*
    private String D_Image;
*/

    public Doctor_Data(int D_id, String D_Name, int D_Age, String D_Gender, int D_Experience, int D_NoT
            , int D_Income, String D_Treatment_Chrg, /*, int D_Image*/int d_treatment_chrg) {
    }

    public void Doctor_Data( int D_id,String D_Name,int D_Age,String D_Gender,int D_Experience,int D_NoT,int D_Income,int D_Treatment_Chrg /*,String D_Image*/){
        this.D_id = D_id;
        this.D_Name = D_Name;
        this.D_Age = D_Age;
        this.D_Gender = D_Gender;
        this.D_Experience = D_Experience;
        this.D_NoT = D_NoT;
        this.D_Income = D_Income;
        this.D_Treatment_Chrg = D_Treatment_Chrg;
      /*  this.D_Image = D_Image;*/

    }
    public int getD_id(){
        return D_id;
    }
    public String getD_Name(){
        return D_Name;
    }

    public int getD_Age() {
        return D_Age;
    }

    public String getD_Gender() {
        return D_Gender;
    }

    public int getD_Experience() {
        return D_Experience;
    }

    public int getD_Income() {
        return D_Income;
    }

    public int getD_NoT() {
        return D_NoT;
    }

   /* public String getD_Image(){
        return D_Image;
    }*/

    public int getD_Treatment_Chrg() {
        return D_Treatment_Chrg;
    }

}
