/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptmaju.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelStokBarang extends AbstractTableModel {
    List<stokbarang> lb;
    
    public tableModelStokBarang(List<stokbarang> lb){
        this.lb = lb;
    }

    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Kategori";
            case 3:
                return "Satuan";
            case 4:
                return "Harga";
            case 5:
                return "Stok";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNama();
            case 2:
                return lb.get(row).getKategori();
            case 3:
                return lb.get(row).getSatuan();
            case 4:
                return lb.get(row).getHarga();
            case 5:
                return lb.get(row).getStok();
            default:
                return null;
        }
    }
    
}