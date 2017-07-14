package ptmaju.dao;

import ptmaju.koneksi.koneksi;
import ptmaju.model.stokbarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptmaju.daoimplement.implementstokbarang;

public class daostokbarang implements implementstokbarang{
    Connection connection;
    final String insert = "INSERT INTO material (nama,kategori,satuan,harga,stok) VALUES (?,?,?,?,?); ";
    final String update = "UPDATE material set nama=?,kategori=?,satuan=?,harga=?,satuan=? where id=?;";
    final String select = "SELECT * FROM material;";
    final String delete = "DELETE FROM material where id=?;";
    final String caribarang = "SELECT * FROM material where nm_barang like ?;";
        
    public daostokbarang(){
        connection = koneksi.connection();
    }
    
    public void insert (stokbarang b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNama());
            statement.setInt(2, b.getKategori());
            statement.setInt(3, b.getSatuan());
            statement.setInt(4, b.getHarga());
            statement.setInt(5, b.getStok());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setId(rs.getInt(1));
            }               
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void update (stokbarang b){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama());
            statement.setInt(2, b.getKategori());
            statement.setInt(3, b.getSatuan());
            statement.setInt(4, b.getHarga());
            statement.setInt(5, b.getStok());
            statement.setInt(6, b.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public List<stokbarang> getALL(){
        List<stokbarang> lb=null;
        try{
            lb=new ArrayList<stokbarang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                stokbarang b = new stokbarang();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setKategori(rs.getInt("kategori"));
                b.setSatuan(rs.getInt("satuan"));
                b.setHarga(rs.getInt("harga"));
                b.setStok(rs.getInt("stok"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daostokbarang.class.getName()).log(Level.SEVERE, null, ex);
        }return lb;
    }
    
    public List<stokbarang> getCariBarang(String nama){
        List<stokbarang> lb = null;
        try {
            lb = new ArrayList<stokbarang>();
            PreparedStatement st = connection.prepareStatement(caribarang);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                stokbarang b = new stokbarang();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setKategori(rs.getInt("kategori"));
                b.setSatuan(rs.getInt("satuan"));
                b.setHarga(rs.getInt("harga"));
                b.setStok(rs.getInt("stok"));
                       lb.add(b);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(daostokbarang.class.getName()).log(Level.SEVERE, null, ex);
               }return lb;
           }            
}


