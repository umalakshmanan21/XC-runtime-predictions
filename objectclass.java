/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningselenium;

import java.io.Serializable;
import org.openqa.selenium.By;
import java.text.NumberFormat;
import java.io.Serializable;
/**
 *
 * @author VP
 */
public class objectclass implements Serializable{


    
     private String SchoolName;
     private String SchoolLocality;
     private String Classification;


    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    public String getSchoolLocality() {
        return SchoolLocality;
    }

    public void setSchoolLocality(String SchoolLocality) {
        this.SchoolLocality = SchoolLocality;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }
    
}


