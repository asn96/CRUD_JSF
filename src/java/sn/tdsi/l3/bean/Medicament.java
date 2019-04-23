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
@ManagedBean(name="medicament")
@SessionScoped
public class Medicament {
    
    private String code;
    
    private String libelle;
    
    private ArrayList<Medicament> listmedicament = new ArrayList();
    
    private ArrayList list_code = new ArrayList();

    public ArrayList getList_code() {
        return list_code;
    }

    public void setList_code(ArrayList list_code) {
        this.list_code = list_code;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Medicament> getListmedicament() {
        return listmedicament;
    }

    public void setListmedicament(ArrayList<Medicament> listmedicament) {
        this.listmedicament = listmedicament;
    }

    public Medicament(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Medicament() {
    }
    
     public String enregistrer() {
        System.out.print(this.code);
        this.list_code.add(this.code);
        this.listmedicament.add(new Medicament(this.code, this.libelle));
       
        return "listemedicament";
    }
    
    public void supprimer(Medicament m) {
        for(int i=0; i<this.listmedicament.size(); i++){
            if(this.listmedicament.get(i).code.equals(m.code)){
                 this.listmedicament.remove(m);
            }
        }
    }
    
    public String editer(Medicament m) {
      
        for(int i=0; i<this.listmedicament.size(); i++){
            if(this.listmedicament.get(i).code.equals(m.code)){
                 this.code = this.listmedicament.get(i).code;
                 this.libelle = this.listmedicament.get(i).libelle;
            }
        }
        
        return "editmedicament";
    }
    
    public String update() {
        
       Medicament m = new Medicament(this.code, this.libelle);
        
       for(int i=0; i<this.listmedicament.size(); i++){
            System.out.println(this.listmedicament.get(i).code + "" + m.code );
            if(this.listmedicament.get(i).code.equals(m.code)){
                 this.listmedicament.get(i).libelle = this.libelle;
            }
        }
       
       
        
        return "listemedicament";
    }
   
    
}
