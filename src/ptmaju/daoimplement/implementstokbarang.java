package ptmaju.daoimplement;

import ptmaju.model.stokbarang;
import java.util.List;

public interface implementstokbarang {
    public void insert(stokbarang b); //sesuaikan bukutelpon dgn nama class dlm packagemodel  
    public void update(stokbarang b);
    public void delete(int id);
    public List<stokbarang> getALL();
    public List<stokbarang> getCariBarang(String nm_barang);
}
