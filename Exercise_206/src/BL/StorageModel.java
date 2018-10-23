package BL;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class StorageModel extends AbstractTableModel {

    private LinkedList<Entry> entries = new LinkedList<>();
    private String[] columns = {"ID", "Description", "Amount", "Place"};

    public void add(Entry e) {
        entries.add(e);
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    public void delete(int i) {
        entries.remove(i);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return entries.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Entry getRow(int i) {
        return entries.get(i);
    }

    public void increase(int r) throws Exception {
        entries.get(r).incAmount();
        fireTableDataChanged();
    }

    public void decrease(int r) throws Exception {
        entries.get(r).decAmount();
        fireTableDataChanged();
    }

    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Entry e;

        try {
            while ((e = (Entry) ois.readObject()) != null) {
                entries.add(e);
            }
        } catch (EOFException eof) {
           
        }

    }

    public void save(File f) throws IOException {
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(f));

        for (Entry e : entries) {
            ous.writeObject(e);
        }
        ous.flush();
        ous.close();
    }

}
