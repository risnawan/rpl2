/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptmaju.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptmaju.daoimplement.implementskategori;
import ptmaju.koneksi.koneksi;
import ptmaju.model.kategori;
import ptmaju.model.stokbarang;

/**
 *
 * @author risnawan
 */
public class daokategori implements implementskategori{
    Connection connection;
//    final String insert = "INSERT INTO material (nama,kategori,satuan,harga,stok) VALUES (?,?,?,?,?); ";
//    final String update = "UPDATE material set nama=?,kategori=?,satuan=?,harga=?,satuan=? where id=?;";
    final String select = "SELECT * FROM kategori;";
//    final String delete = "DELETE FROM material where id=?;";
//    final String caribarang = "SELECT * FROM material where nm_barang like ?;";
    
    public daokategori(){
        connection = koneksi.connection();
    }
    
    public List<kategori> getALLKategori(){
        List<kategori> lb=null;
        try{
            lb=new ArrayList<kategori>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                kategori b = new kategori();
                b.setId(rs.getInt("id"));
                b.setKategori(rs.getString("kategori"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daostokbarang.class.getName()).log(Level.SEVERE, null, ex);
        }return lb;
    }
}
