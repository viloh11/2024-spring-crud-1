package org.java.spring_boot_test4.db.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int saldo;

    public ContoBancario(){
    }

    public ContoBancario(int saldo){
        setSaldo(saldo);
    }
    
    public int getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public  int getDeposito(int deposito){
        if(deposito < 0){
            throw new IllegalArgumentException("Il deposito non e' andato a buon fine");
        }else{
            this.saldo += deposito;
            return saldo;
        }
    }

    public int getPrelievo(int prelievo){
        if(prelievo > saldo){
            throw new IllegalArgumentException("Il prelievo non e' andato a buon fine");
        }else{
            this.saldo -= prelievo;
            return saldo;
        }
    }

    @Override
    public String toString() {
        return (getId() + " Il tuo saldo ammonta a: " + getSaldo());
    }

}
