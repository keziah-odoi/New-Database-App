/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDB;

/**
 *
 * @author kezia
 */
public class PersonInfo {
    
    private String lnameString, fnameString, minitialString, gender, designation;

    public PersonInfo(String lnameString, String fnameString, String minitialString, String gender, String designation) {
        this.lnameString = lnameString;
        this.fnameString = fnameString;
        this.minitialString = minitialString;
        this.gender = gender;
        this.designation = designation;
    }

    public String getLnameString() {
        return lnameString;
    }

    public void setLnameString(String lnameString) {
        this.lnameString = lnameString;
    }

    public String getFnameString() {
        return fnameString;
    }

    public void setFnameString(String fnameString) {
        this.fnameString = fnameString;
    }

    public String getMinitialString() {
        return minitialString;
    }

    public void setMinitialString(String minitialString) {
        this.minitialString = minitialString;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    
    
}
