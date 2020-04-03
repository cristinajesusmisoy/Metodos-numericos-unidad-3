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
public class MetodosIterativos extends java.awt.Dialog {

    /**
     * Creates new form MetodosIterativos
     */
    //Declaracion de variables
    double arreglo_x []= new double[10000];  // arreglos donde se guardaran
    double arreglo_y []= new double[10000];  //los valores de x,y,z en cada   
    double arreglo_z []= new double[10000];  //en cada iteracion
   
    int metodo;  //guarda el numero de seleccion despeglable (para saber que metodo elige el usuario    (gauss o jacobi)
    int indice;  //indice para recorrer los arreglos
    double error;  // variable pal error que ingrese el usuario  
   
    double errorX ;  // arreglos donde almaceno los valores de errores de cada una
    double errorY ;  // de las incognitas X,Y,Z cada vez
    double errorZ ; 
   
    double X1,X2,X3,  Y1,Y2,Y3,   Z1,Z2,Z3;  // variables pa guardar los valores de los textfield
    double val1,val2,val3;         //variables de igualacion de la ecuacion;  osea despues del signo igual
    
    
    public MetodosIterativos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    //Metodos
    public void getvalors (){
            error = Double.parseDouble(valorerror.getText()); // guardadando el valor de error porcentual
     
            X1 = Double.parseDouble(jTextField1.getText());               
            X2 = Double.parseDouble(jTextField2.getText());
            X3 = Double.parseDouble(jTextField3.getText());
       
            Y1 = Double.parseDouble(jTextField4.getText());
            Y2 = Double.parseDouble(jTextField5.getText());
            Y3 = Double.parseDouble(jTextField6.getText());
       
            Z1 = Double.parseDouble(jTextField7.getText());
            Z2 = Double.parseDouble(jTextField8.getText());
            Z3 = Double.parseDouble(jTextField9.getText());
       
            val1 = Double.parseDouble(jTextField10.getText());
            val2 = Double.parseDouble(jTextField11.getText());
            val3 = Double.parseDouble(jTextField12.getText());
             
//asigno en la primera posicion de los arreglos el valor que nos dan de inicio
            arreglo_x [0] = Double.parseDouble(valx.getText());  
            arreglo_y [0] = Double.parseDouble(valy.getText());  
            arreglo_z [0] = Double.parseDouble(valz.getText());
            
//a variables error guardo el error porcentual +1  
            errorX = Double.parseDouble(valorerror.getText())+1;
            errorY = Double.parseDouble(valorerror.getText())+1;
            errorZ = Double.parseDouble(valorerror.getText())+1;
}//fin del metodo getvalors
    
    public void metodo_jacobi (){
    indice = 1;           
        while (errorX > error || errorY > error || errorZ > error){
            
           //despejo y guardo el valor nuevo de cada variable en el arreglo correspondiente
        arreglo_x [indice] = (val1-(Y1*arreglo_y[indice-1])-(Z1*arreglo_z[indice-1]))/X1;

        arreglo_y [indice] = (val2-(X2*arreglo_x[indice-1])-(Z2*arreglo_z[indice-1]))/Y2;
  
        arreglo_z [indice] = (val3-(X3*arreglo_x[indice-1])-(Y3*arreglo_y[indice-1]))/Z3;
       
           //calculamos los errorres de cada variables  
        errorX  = Math.abs((arreglo_x[indice] - arreglo_x[indice-1])/arreglo_x[indice])*100; 
        errorY  = Math.abs((arreglo_y[indice] - arreglo_y[indice-1])/arreglo_y[indice])*100; 
        errorZ  = Math.abs((arreglo_z[indice] - arreglo_z[indice-1])/arreglo_z[indice])*100; 
                       
  //aqui solo se manda a imprimir en TextArea los resultado de esta iteracion
            resultado.append("iteracion numero <-----> " + indice +"\n");
            resultado.append("valor de 'x' = "+ arreglo_x[indice]+"\n");
            resultado.append("valor de 'y' = "+ arreglo_y[indice]+"\n");
            resultado.append("valor de 'z' = "+ arreglo_z[indice]+"\n\n");
            resultado.append("el error de x es = " + errorX  +"\n");        
            resultado.append("el error de y es = " + errorY  +"\n");        
            resultado.append("el error de z es = " + errorZ  +"\n");           
            resultado.append("------------------------------------\n\n");           
           
            ++indice;
    }//fin del ciclo mientras
} // fin del metodo de calculo jacobi

public void gauss_seidel(){
 indice = 1;
       while (errorX > error || errorY > error || errorZ > error){
           
           arreglo_x [indice] = (val1-(Y1*arreglo_y[indice-1])-(Z1*arreglo_z[indice-1]))/X1; 
           arreglo_y [indice] = (val2-(X2*arreglo_x[indice])-(Z2*arreglo_z[indice-1]))/Y2; 
           arreglo_z [indice] = (val3-(X3*arreglo_x[indice])-(Y3*arreglo_y[indice]))/Z3; 
       
        errorX  = Math.abs((arreglo_x[indice] - arreglo_x[indice-1])/arreglo_x[indice])*100;
        errorY  = Math.abs((arreglo_y[indice] - arreglo_y[indice-1])/arreglo_y[indice])*100; 
        errorZ  = Math.abs((arreglo_z[indice] - arreglo_z[indice-1])/arreglo_z[indice])*100; 
                        
            
            resultado.append("iteracion numero <-----> " + indice +"\n");
            resultado.append("valor de 'x' = "+ arreglo_x[indice]+"\n");
            resultado.append("valor de 'y' = "+ arreglo_y[indice]+"\n");
            resultado.append("valor de 'z' = "+ arreglo_z[indice]+"\n\n");
            resultado.append("el error de x es = " + errorX  +"\n");         
            resultado.append("el error de y es = " + errorY  +"\n");         
            resultado.append("el error de z es = " + errorZ  +"\n");            
            resultado.append("------------------------------------\n\n");            
            
            ++indice;               
        }// fin del mientras
} //  fin del metodo gauss

public void clean () {  // para limpiar todos los campos
    jTextField1.setText("");    
    jTextField2.setText("");    
    jTextField3.setText("");    
    jTextField4.setText("");    
    jTextField5.setText("");    
    jTextField6.setText("");    
    jTextField7.setText("");    
    jTextField8.setText("");    
    jTextField9.setText("");    
    jTextField10.setText("");    
    jTextField11.setText("");    
    jTextField12.setText("");  
    valorerror.setText("");
    valx.setText("");
    valy.setText("");
    valz.setText("");
    resultado.setText("");    
    indice = 1;
} // fin del metodo clean

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        valx = new javax.swing.JTextField();
        valy = new javax.swing.JTextField();
        valz = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        valorerror = new javax.swing.JTextField();
        iterar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        metodoselected = new javax.swing.JComboBox<>();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("x1   +");

        jLabel2.setText("x2   +");

        jLabel3.setText("x3   +");

        jLabel4.setText("y1   +");

        jLabel5.setText("y2   +");

        jLabel6.setText("y3   +");

        jLabel7.setText("z1   =");

        jLabel8.setText("z2   =");

        jLabel9.setText("z3   =");

        jLabel10.setText("X:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Y:");

        jLabel12.setText("Z:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Métodos Iterativos");

        valx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valxActionPerformed(evt);
            }
        });

        valy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valyActionPerformed(evt);
            }
        });

        jLabel14.setText("Valores Iniciales");

        jLabel15.setText("Error =");

        jLabel16.setText("%");

        iterar.setText("Resolver");
        iterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iterarActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel17.setText("Zona de resultados");

        resultado.setColumns(20);
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        jLabel18.setText("Seleccionar Método");

        metodoselected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Método de Jacobi", "Método de Gauss-Seidel" }));
        metodoselected.setToolTipText("");
        metodoselected.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                metodoselectedItemStateChanged(evt);
            }
        });
        metodoselected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoselectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(iterar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel17)))
                                .addGap(65, 65, 65)))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(metodoselected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valz, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valorerror, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iterar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(valx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(valorerror, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(metodoselected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void valxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valxActionPerformed

    private void valyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valyActionPerformed

    private void metodoselectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoselectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodoselectedActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        clean();     
    }//GEN-LAST:event_jButton2MouseClicked

    private void metodoselectedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_metodoselectedItemStateChanged
        // TODO add your handling code here:
         //recuperamos el indice del combobox y lo guardamos en la variable metodo
        metodo = metodoselected.getSelectedIndex();
        resultado.setText("");  
    }//GEN-LAST:event_metodoselectedItemStateChanged

    private void iterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iterarActionPerformed
        // TODO add your handling code here:
        getvalors();  //llamo al metodo para recuperar los valores primero
        if (metodo == 0){
            metodo_jacobi();
        }else{
            gauss_seidel();
        }                       
    }//GEN-LAST:event_iterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MetodosIterativos dialog = new MetodosIterativos(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iterar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JComboBox<String> metodoselected;
    private javax.swing.JTextArea resultado;
    private javax.swing.JTextField valorerror;
    private javax.swing.JTextField valx;
    private javax.swing.JTextField valy;
    private javax.swing.JTextField valz;
    // End of variables declaration//GEN-END:variables
}
