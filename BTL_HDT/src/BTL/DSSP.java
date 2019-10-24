/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSSP {
    ArrayList<SanPham> listSP =new ArrayList<>();
    
    public void nhapDSSP(){
        int sl;
        
        Scanner sc =new Scanner(System.in);
        System.out.println("\n nhập số lượng các sản phẩm:");
        sl=sc.nextInt();
        
        for (int i = 0; i < sl; i++) {
            SanPham sp =new SanPham();
            sp.nhapSP();
            SanPham temp=new SanPham();
            for ( int j=0;j<listSP.size();j++) {                    
                     temp=listSP.get(j);
                    if(sp.getMaSP().equals(temp.getMaSP()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã sản phẩm,mời nhập lại  !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho sản phẩm:");
                        mamoi=sc.nextLine();
                        sp.setMaSP(mamoi);
                        j=-1;
                    }
                } 
            listSP.add(sp);
        }
    }
    public void xuatSP(){
        System.out.print("\ndanh sách các sản phẩm:");
        System.out.printf("\n%-10s%-15s%-15s%-7s%-7s%-15s%-15s","Mã SP","Tên SP",
                "Chất Liệu","Size","SL","Giá Nhập","Giá Bán");
        for (SanPham a : listSP) {
            a.xuat();
        }
    }
    public void TimSPHet(){
        System.out.print("\n các sản phẩm đã hết hàng:");
        System.out.printf("\n%-10s%-15s%-15s%-7s%-7s%-15s%-15s","Mã SP","Tên SP",
                "Chất Liệu","Size","SL","Giá Nhập","Giá Bán");
        for (SanPham x : listSP) {
            if(x.SoLuong<=0)
                x.xuat();
            
        }
    }
    public void ghiFile(String filename) throws FileNotFoundException, IOException{
//          
            
             FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream out =new ObjectOutputStream(fout);
            out.writeObject(listSP);
            out.close();
            fout.close();
        
        }
    public void docfile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fin =new FileInputStream(filename);
            ObjectInputStream obin =new ObjectInputStream(fin);
            listSP=(ArrayList)obin.readObject();
            obin.close();fin.close();
            
        }
}
