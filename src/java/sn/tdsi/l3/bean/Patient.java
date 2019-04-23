package sn.tdsi.l3.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author babacar
 */
@ManagedBean(name="patient")
@SessionScoped
public class Patient {
    
    private String no_ss;
    
    private String name;
    
    private ArrayList<Patient> listptaient = new ArrayList();
    
    private ArrayList listno_ss = new ArrayList();

    public ArrayList getListno_ss() {
        return listno_ss;
    }

    public void setListno_ss(ArrayList listno_ss) {
        this.listno_ss = listno_ss;
    }
    
    

    public ArrayList getListptaient() {
        return listptaient;
    }

    public void setListptaient(ArrayList listptaient) {
        this.listptaient = listptaient;
    }
    
    

    public String getNo_ss() {
        return no_ss;
    }

    public void setNo_ss(String no_ss) {
        this.no_ss = no_ss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient() {
    }

    public Patient(String no_ss, String name) {
        this.no_ss = no_ss;
        this.name = name;
    }
    
    public String enregistrer() {
        System.out.print(this.name);
        this.listptaient.add(new Patient(this.no_ss, this.name));
        this.listno_ss.add(this.no_ss);
        for(int i = 0; i<=this.listptaient.size()-1; i++){
            System.out.println(this.listptaient.get(i).name);
        }
        
        return "listepatient";
    }
    
    public void supprimer(Patient p) {
        for(int i=0; i<this.listptaient.size(); i++){
            if(this.listptaient.get(i).no_ss.equals(p.no_ss)){
                 this.listptaient.remove(p);
            }
        }
    }
    
    public String editer(Patient p) {
      
        for(int i=0; i<this.listptaient.size(); i++){
            if(this.listptaient.get(i).no_ss.equals(p.no_ss)){
                 this.no_ss = this.listptaient.get(i).no_ss;
                 this.name = this.listptaient.get(i).name;
            }
        }
        
        return "editerpatient";
    }
    
    public String update() {
        
       Patient p = new Patient(this.no_ss, this.name);
        
       for(int i=0; i<this.listptaient.size(); i++){
            System.out.println(this.listptaient.get(i).no_ss + "" + p.no_ss );
            if(this.listptaient.get(i).no_ss.equals(p.no_ss)){
                 this.listptaient.get(i).name = this.name;
            }
        }
       
       
        
        return "listepatient";
    }
    
    
    
}
