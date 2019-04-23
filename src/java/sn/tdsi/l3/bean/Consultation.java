/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.tdsi.l3.bean;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author babacar
 */
@ManagedBean(name="consultation")
@SessionScoped
public class Consultation {
    
    private String no;
    
    private String date;
    
    private String matricule_medecin;
    
    private String noss_patient;
    
    private ArrayList<Consultation> listeconsultation = new ArrayList();
    
    private ArrayList listno = new ArrayList();

    public ArrayList getListno() {
        return listno;
    }

    public void setListno(ArrayList listno) {
        this.listno = listno;
    }
    
    
    

    public Consultation(String no, String date, String matricule_medecin, String noss_patient) {
        this.no = no;
        this.date = date;
        this.matricule_medecin = matricule_medecin;
        this.noss_patient = noss_patient;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMatricule_medecin() {
        return matricule_medecin;
    }

    public void setMatricule_medecin(String matricule_medecin) {
        this.matricule_medecin = matricule_medecin;
    }

    public String getNoss_patient() {
        return noss_patient;
    }

    public void setNoss_patient(String noss_patient) {
        this.noss_patient = noss_patient;
    }

    public ArrayList<Consultation> getListeconsultation() {
        return listeconsultation;
    }

    public void setListeconsultation(ArrayList<Consultation> listeconsultation) {
        this.listeconsultation = listeconsultation;
    }

    public Consultation() {
    }
    
     public String enregistrer() {
         
         Date t = new Date();
         
         String c = t.getYear()+""+t.getMonth()+""+t.getDay()+""+t.getHours()+""+t.getMinutes()+""+t.getSeconds();
        
         System.out.print(c);
         
         this.no = c;
         
         this.listno.add(this.no);
         
         this.listeconsultation.add(new Consultation(this.no, this.date, this.matricule_medecin, this.noss_patient));
        
         return "listeconsultation";
    }
    
    public void supprimer(Consultation c) {
        for(int i=0; i<this.listeconsultation.size(); i++){
            if(this.listeconsultation.get(i).no.equals(c.no)){
                 this.listeconsultation.remove(c);
            }
        }
    }
    
    public String editer(Consultation c) {
      
        for(int i=0; i<this.listeconsultation.size(); i++){
            if(this.listeconsultation.get(i).no.equals(c.no)){
                 this.no = this.listeconsultation.get(i).no;
                 this.date = this.listeconsultation.get(i).date;
                 this.matricule_medecin = this.listeconsultation.get(i).matricule_medecin;
                 this.noss_patient = this.listeconsultation.get(i).noss_patient;
            }
        }
        
        return "editconsultation";
    }
    
    public String update() {
        
       Consultation c = new Consultation(this.no, this.date, this.matricule_medecin, this.noss_patient);
        
       for(int i=0; i<this.listeconsultation.size(); i++){
            if(this.listeconsultation.get(i).no.equals(c.no)){
                 this.listeconsultation.get(i).date = this.date;
                 this.listeconsultation.get(i).matricule_medecin = this.matricule_medecin;
                 this.listeconsultation.get(i).noss_patient = this.noss_patient;
            }
        }
      
       
        
        return "listeconsultation";
    }
    
    
    
    
}
