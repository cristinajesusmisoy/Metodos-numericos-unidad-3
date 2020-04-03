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
public class tblPuntoFijo extends AbstractTableModel{
    private String columnas[]={"Iteracion", "xi", "g(xi)", "error"};
    private ArrayList<csPuntoFijo>lista=null;

    public tblPuntoFijo(ArrayList<csPuntoFijo>lista) {
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
        
        csPuntoFijo registro = this.lista.get(fila);
        switch(columna){
        
            case 0:
                return registro.getIteracion();
            
            case 1:
                return registro.getXi();
                
            case 2:
                return registro.getGxi();

            case 3:
                return registro.getError();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return  this.columnas[i];
    }
    
    
    

}
