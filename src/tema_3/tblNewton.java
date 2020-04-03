/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema_3;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class tblNewton extends AbstractTableModel{
    private String []columnas = {"i", "Xo", "f(x)","f'(x)","xi+1","Error"};
    private ArrayList<csNewton>lista;

    public tblNewton(ArrayList<csNewton>lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {

        return columnas.length;
        
    }

    @Override
    public Object getValueAt(int fila, int columna) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     switch(columna){
         case 0: 
             return this.lista.get(fila).getI();
         case 1: 
             return this.lista.get(fila).getXo();
         case 2:
             return this.lista.get(fila).getFx();
         case 3:
             return this.lista.get(fila).getDfx();
         case 4:
             return this.lista.get(fila).getRes();
         case 5:
             return this.lista.get(fila).getError();
         default:return null;     
     }
    }

    @Override
    public String getColumnName(int i) {
        return  this.columnas[i];
    }
    
    
    

}
