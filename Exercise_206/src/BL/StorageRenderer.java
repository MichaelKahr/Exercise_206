package BL;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class StorageRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value == null ) return new JLabel();
        Entry e = (Entry)value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        if(e.getAmount()==0){
            label.setBackground(Color.red);
        }
        switch(column){
            case 0: label.setText(e.getId()+"");break;
            case 1: label.setText(e.getDesc());break;
            case 2: label.setText(e.getAmount()+"");break;
            case 3: label.setText(e.getPlace()+"");break;
        }
        return label;
    }

}
