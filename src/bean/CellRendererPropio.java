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
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRendererPropio extends DefaultTableCellRenderer {
    
    int alignment;
    MatteBorder border;
    Color colorfondo;
    Color colorletras;
    HashMap<Integer, Color> rowsPintar = new HashMap<>();
    //Es un mapa, es como un arreglo asociativo, donde a un Integer (número de row) le corresponde un Color
    //básicamente es: rowsPintar[Integer]=Color
    //En pocas palabras es un arreglo de colores porque usé un entero, pero lo usé por sus métodos para buscar e insertar que hace que no haya duplicados.
    
    public void setColorletras(Color colorletras) {
        this.colorletras = colorletras;
    }

    public void setColorfondo(Color colorfondo) {
        this.colorfondo = colorfondo;
    }

    public void setBorder(MatteBorder border) {
        this.border = border;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public CellRendererPropio() {
        alignment=SwingConstants.LEFT; //A la izquierda por defecto.
    }  
    
    public void agregarRowPintar(Integer i, Color color){
        rowsPintar.put(i, color);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        javax.swing.JLabel renderer = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        renderer.setBorder(border);
        renderer.setHorizontalAlignment(alignment);
        renderer.setBackground(colorfondo);
        renderer.setForeground(colorletras);
        
        if(rowsPintar.containsKey(row)) //Si la fila está en el mapa de filas a pintar
            renderer.setBackground(rowsPintar.get(row)); //Pintalo con el color que le corresponde.
        
        return renderer;
    }
}
