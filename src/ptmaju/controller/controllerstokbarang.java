
package ptmaju.controller;
import ptmaju.dao.daostokbarang;
import ptmaju.model.stokbarang;
import ptmaju.model.tableModelStokBarang;
import ptmaju.view.framestokbarang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import ptmaju.daoimplement.implementstokbarang;

public class controllerstokbarang {
    framestokbarang frame;
    implementstokbarang implstokbarang;
    List<stokbarang> lb;
    
    public controllerstokbarang(framestokbarang frame){
        this.frame = frame;
        implstokbarang = new daostokbarang();
        lb = implstokbarang.getALL();
    }
    
    public void isiTable(){
        lb = implstokbarang.getALL();
        tableModelStokBarang tmb = new tableModelStokBarang(lb);
        frame.getTableData().setModel((TableModel) tmb);
    } 
    
    public void isiField(int row){
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getTxtNama().setText(lb.get(row).getNama());
        frame.getCbKategori().setSelectedIndex(lb.get(row).getKategori());
        frame.getCbSatuan().setSelectedIndex(lb.get(row).getSatuan());
        frame.getTxtHarga().setText(lb.get(row).getHarga().toString());
        frame.getTxtStok().setText(lb.get(row).getStok().toString());
    }
    
    public void insert() {
        if(!frame.getTxtID().getText().trim().isEmpty()&!frame.getTxtHarga().getText().trim().isEmpty()&!frame.getTxtNama().getText().trim().isEmpty()&!frame.getTxtStok().getText().trim().isEmpty()){
            stokbarang b =new stokbarang();
            b.setNama(frame.getTxtNama().getText());
            b.setKategori(frame.getCbKategori().getSelectedIndex());
            b.setSatuan(frame.getCbSatuan().getSelectedIndex());
            b.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            b.setStok(Integer.parseInt(frame.getTxtStok().getText()));
            implstokbarang.insert(b);
            JOptionPane.showMessageDialog(null, "Simpan data sukses");
            } else{
                JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    
    public void update(){
        if(!frame.getTxtID().getText().trim().isEmpty()){
            stokbarang b = new stokbarang();
            b.setNama(frame.getTxtNama().getText());
            b.setKategori(frame.getCbKategori().getSelectedIndex());
            b.setSatuan(frame.getCbSatuan().getSelectedIndex());
            b.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            b.setStok(Integer.parseInt(frame.getTxtStok().getText()));
            b.setId(Integer.parseInt(frame.getTxtID().getText()));
            implstokbarang.update(b);
            
            JOptionPane.showMessageDialog(null, "Update Data Sukses");
            }else{
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di edit");
        }
    }
    
    public void delete(){
        if(!frame.getTxtID().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getTxtID().getText());
            implstokbarang.delete(id);
            JOptionPane.showMessageDialog(null, "Hapus data sukses");
        }else{
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus ");
        }
    }
  /*  
    public void isiTableCariNama(){
        lb = implstokbarang.getCariBarang(frame.getCariBarang().getText());
        tableModelStokBarang tmb = new tableModelStokBarang(lb);
        frame.getTabelData().setModel(tmb);
    }
    
    public void caribarang(){
         if(!frame.getCariBarang().getText().trim().isEmpty()){
             implstokbarang.getCariBarang(frame. getCariBarang().getText());
             isiTableCariNama();
         }else{
             JOptionPane.showMessageDialog(frame, "Silahkan Pilih data");
         }
    }
*/
    
        public void reset(){
        frame.getTxtID().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtHarga().setText("");
        frame.getTxtStok().setText("");
    }
}
