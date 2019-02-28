/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @author Chiquín, Jorge
 * @author Vargas, Alexander
 * @author Bonilla, José
 * @author Fernández, Ysidro
 * @author Rodríguez, Ronald
 */
package bean;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TablePropio extends JTable implements Serializable{
    CellRendererPropio renderer = new CellRendererPropio();

    public TablePropio() {
    this.addMouseListener(new TableMouseListener());
    }
    
    
    public void alinearHorizontal(int i){
        renderer.setAlignment(i);
        actualizarRender();
    }
    public void cambiarBorde(MatteBorder border){
        renderer.setBorder(border);
        actualizarRender();
    }
    
    public void cambiarColorFondo(Color color){
        renderer.setColorfondo(color);
        actualizarRender();
    }
    public void cambiarColorLetras(Color color){
        renderer.setColorletras(color);
        actualizarRender();
    }
    
    public void pintarRow(Integer i,Color color){
        renderer.agregarRowPintar(i, color);
        actualizarRender();
    }
    public void actualizarRender(){
        setDefaultRenderer(Object.class, renderer);
        repaint();
    }
    
    public void renderPorDefecto(){
        renderer = new CellRendererPropio();
        actualizarRender();
    }
    
    public void cargarTabla(int[] anchos,DefaultTableModel modelo) {
        setModel(modelo);
        getTableHeader().setReorderingAllowed(false);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void vaciarTabla() {
        String[] titulos = new String[getColumnCount()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = getColumnName(i);
        }

        setModel(new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        
    }
       private class TableMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			mostrarMensaje();
		}
	}

	private void mostrarMensaje() {
		int fila= getSelectedRow();
                String mensaje = new String();
                mensaje= "Datos de la fila "+fila+"\n";
                for(int i=0 ; i<getColumnCount();i++){
                    mensaje+=getColumnName(i)+" : "+getValueAt(fila, i).toString()+"\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);
	}
     
}
