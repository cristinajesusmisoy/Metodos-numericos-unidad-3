/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema_3;

/**
 *
 * @author LENOVO2018
 */
public class csPuntoFijo {
   private int iteracion;
   private double xi;
   private double Gxi;
   private double error;

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getGxi() {
        return Gxi;
    }

    public void setGxi(double Gxi) {
        this.Gxi = Gxi;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "csPuntoFijo{" + "iteracion=" + iteracion + ", xi=" + xi + ", Gxi=" + Gxi + ", error=" + error + '}';
    }
   
   
    
}
