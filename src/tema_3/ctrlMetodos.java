/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema_3;

import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ctrlMetodos {
    
//METODOS DE Gauss-Seidel
//METODOS DE JACOBI
    
    
    
    
//METODOS DE PUNTO FIJO
public ArrayList<csPuntoFijo> PuntoFijo(double xi, double errorDeseado, int iteraciones){
    
    double errorCalculado=1;
    int  iteracion = 0;
    
    
    ArrayList<csPuntoFijo> lista = null;
    
        
        lista= new ArrayList<csPuntoFijo>();
        while(errorCalculado >= errorDeseado && iteraciones>0){
            
            csPuntoFijo fila= new csPuntoFijo();
            
            fila.setIteracion(iteracion+1);
            iteracion ++;
            
            fila.setXi(xi);
            
            fila.setGxi(this.getXIMAS1(xi));
            
            errorCalculado = this.getError2(xi, fila.getGxi());
            fila.setError(errorCalculado);
            
            lista.add(fila);
            System.out.println(fila.toString());
            
            xi = fila.getGxi();
        
          iteraciones--;
            
        }
        
        return lista;
    }

    private double getXIMAS1(double xi)
  {
     return Math.exp(-1*(xi));
  }
    
    private double getError2(double xi, double ximasuno)
  {
     return Math.abs((ximasuno-xi)/ximasuno);
  }
    
    //METODOS DE NEWTON
    public ArrayList<csNewton> Newton(double xo, double error){

        double errorCalculado = 1;
        double xanterior; 
        ArrayList<csNewton> lista;
        int i = 1;
        lista = new ArrayList<csNewton>();
        while (errorCalculado > error) {
            csNewton fila = new csNewton();
            fila.setI(i); 
            fila.setXo(xo); 
            double fxo = this.Funcion1(fila.getXo());
            double fxdo = this.Funcion2(fila.getXo());
            fila.setFx(fxo); 
            fila.setDfx(fxdo); 
            fila.setRes(fila.getXo() - (fxo / fxdo));
            xanterior = fila.getXo(); 
            xo = fila.getRes();          
            if (i > 1) {
                      
                errorCalculado = Math.abs((fila.getRes() - fila.getXo()) / fila.getRes());
                fila.setError(errorCalculado);

            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        if (errorCalculado < error) {
            return lista;
        } else {
            return null;
        }

    }
       
public double Funcion1(double x) {
        return Math.pow(2.7182818284590452353602874713527, -x) - x;
    }

    public double Funcion2(double x) {
        return -Math.pow(2.7182818284590452353602874713527, -x) - 1;
    }
    
} //Fin de la clase principal
