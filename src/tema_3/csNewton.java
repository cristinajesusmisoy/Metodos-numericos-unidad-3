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
public class csNewton {
    
    private double i;
    private double xi;
    private double fx;
    private double dfx;
    private double res;
    private double error;

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getXo() {
        return xi;
    }

    public void setXo(double xo) {
        this.xi = xo;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }

    public double getDfx() {
        return dfx;
    }

    public void setDfx(double dfx) {
        this.dfx = dfx;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "csFilaNewton{" + "i=" + i + ", xi=" + xi + ", fx=" + fx + ", dfx=" + dfx + ", res=" + res + ", error=" + error + '}';
    }
    
}
