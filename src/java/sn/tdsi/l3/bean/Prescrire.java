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
@ManagedBean(name="prescrire")
@SessionScoped
public class Prescrire {
    
    private String code;
    
    private String no_consultation;
    
    private String code_medicament;
    
    private int nbr_prise;
    
    private ArrayList<Prescrire> listprescire = new ArrayList();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    public String getNo_consultation() {
        return no_consultation;
    }

    public void setNo_consultation(String no_consultation) {
        this.no_consultation = no_consultation;
    }

    public String getCode_medicament() {
        return code_medicament;
    }

    public void setCode_medicament(String code_medicament) {
        this.code_medicament = code_medicament;
    }

    public int getNbr_prise() {
        return nbr_prise;
    }

    public void setNbr_prise(int nbr_prise) {
        this.nbr_prise = nbr_prise;
    }

    public ArrayList<Prescrire> getListprescire() {
        return listprescire;
    }

    public void setListprescire(ArrayList<Prescrire> listprescire) {
        this.listprescire = listprescire;
    }

    public Prescrire(String no_consultation, String code_medicament, int nbr_prise, String code) {
        this.no_consultation = no_consultation;
        this.code_medicament = code_medicament;
        this.nbr_prise = nbr_prise;
        this.code = code;
    }

    public Prescrire() {
    }
    
     public String enregistrer() {
         
         Date t = new Date();
         
         String c = t.getYear()+""+t.getMonth()+""+t.getDay()+""+t.getHours()+""+t.getMinutes()+""+t.getSeconds();
        
         System.out.print(c);
         
         this.code = c;
         
         this.listprescire.add(new Prescrire(this.no_consultation, this.code_medicament, this.nbr_prise, this.code));
        
         return "presincription";
    }
    
    public void supprimer(Prescrire pr) {
        for(int i=0; i<this.listprescire.size(); i++){
            if(this.listprescire.get(i).code.equals(pr.code)){
                 this.listprescire.remove(pr);
            }
        }
    }
    
    public String editer(Prescrire pr) {
      
        for(int i=0; i<this.listprescire.size(); i++){
            if(this.listprescire.get(i).code.equals(pr.code)){
                 this.code = this.listprescire.get(i).code;
                 this.code_medicament = this.listprescire.get(i).code_medicament;
                 this.no_consultation= this.listprescire.get(i).no_consultation;
                 this.listprescire.get(i).nbr_prise = this.nbr_prise;
            }
        }
        
        return "editprescire";
    }
    
    public String update() {
        
      Prescrire pr = new Prescrire(this.no_consultation, this.code_medicament, this.nbr_prise, this.code);
      
       for(int i=0; i<this.listprescire.size(); i++){
            if(this.listprescire.get(i).code.equals(pr.code)){
                 this.listprescire.get(i).code_medicament = this.code_medicament;
                 this.listprescire.get(i).no_consultation = this.no_consultation;
                 this.listprescire.get(i).nbr_prise = this.nbr_prise;
            }
        }
      
       
        
        return "presincription";
    }
    
    
}
