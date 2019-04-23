/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.tdsi.l3.bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author babacar
 */
@ManagedBean(name="medecin")
@SessionScoped
public class Medecin {
    
    private String matricule;
    
    private String name;
    
    private ArrayList<Medecin> listmedecin = new ArrayList();
    
    private ArrayList listmatri = new ArrayList();

    public ArrayList getListmatri() {
        return listmatri;
    }

    public void setListmatri(ArrayList listmatri) {
        this.listmatri = listmatri;
    }
    
    

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Medecin> getListmedecin() {
        return listmedecin;
    }

    public void setListmedecin(ArrayList<Medecin> listmedecin) {
        this.listmedecin = listmedecin;
    }

    public Medecin() {
    }

    public Medecin(String matricule, String name) {
        this.matricule = matricule;
        this.name = name;
    }
    
    public String enregistrer() {
        System.out.print(this.name);
        this.listmedecin.add(new Medecin(this.matricule, this.name));
        this.listmatri.add(this.matricule);
        return "listemedecin";
    }
    
     public void supprimer(Medecin m) {
        for(int i=0; i<this.listmedecin.size(); i++){
            if(this.listmedecin.get(i).matricule.equals(m.matricule)){
                 this.listmedecin.remove(m);
            }
        }
    }
     
     
      public String editer(Medecin m) {
      
        for(int i=0; i<this.listmedecin.size(); i++){
            if(this.listmedecin.get(i).matricule.equals(m.matricule)){
                 this.matricule = this.listmedecin.get(i).matricule;
                 this.name = this.listmedecin.get(i).name;
            }
        }
        
        return "editermedecin";
    }
    
      public String update() {
        
       Medecin m = new Medecin(this.matricule, this.name);
        
       for(int i=0; i<this.listmedecin.size(); i++){
            System.out.println(this.listmedecin.get(i).matricule + "" + m.matricule );
            if(this.listmedecin.get(i).matricule.equals(m.matricule)){
                 this.listmedecin.get(i).name = this.name;
            }
        }
       
       
        
        return "listemedecin";
    }
    
    
    
    
}
