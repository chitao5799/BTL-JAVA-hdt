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
    public void add1SP(){
        Scanner sc =new Scanner(System.in);
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
    public void SuaInforSP(){
        Scanner sc =new Scanner(System.in);              
        String maTim="";
        int index = -1;       
        System.out.print("\n Nhập mã của  sản phẩm muốn sửa:");
        maTim=sc.nextLine();        
        for (SanPham x : listSP) {
            if(maTim.equals(x.maSP))//if(x.maNV==maTim)
            {
                index=listSP.indexOf(x);
                break;
            }
        }
        if(index==-1)
            System.out.print("\ntrong danh sách không có mã sản phẩm muốn sửa thông tin.");
        else
        {
            SanPham temp=listSP.get(index);
            System.out.print("\n bạn muốn sửa thông tin gì, mời lựa chọn:");
            System.out.print("\n1.Số lượng; 2.Đơn giá bán; 3.size; 4.Chất liệu vải");
             //sc.nextLine();
            int luachon=-1;
            System.out.print("\nvui lòng nhập lựa chọn:");
            luachon=sc.nextInt();
           sc.nextLine();
            switch(luachon)
            {
                case 1:{
                    int sl;//số lượng
                    System.out.print("\n nhập số lượng mới cho sản phẩm \""+temp.tenSP+"\":");
                    sl=sc.nextInt();
                    sc.nextLine();
                    temp.SoLuong=sl;
                    listSP.set(index, temp);
                };break;
                case 2:{
                    double dgb;//đơn giá bán
                    System.out.print("\n nhập đơn giá bán mới cho sản phẩm \""+temp.tenSP+"\":");
                    dgb=sc.nextDouble();
                    sc.nextLine();
                    temp.DonGiaBan=dgb;
                    listSP.set(index, temp);
                };break;
                case 3:{
                    int kt;//kích thước
                    System.out.print("\n nhập size mới cho sản phẩm \""+temp.tenSP+"\":");
                    kt=sc.nextInt();
                    sc.nextLine();
                    temp.Size=kt;
                    listSP.set(index, temp);
                    
                };break;
                case 4:{
                    String clv;//chất liệu vải
                    System.out.print("\n nhập chất liệu vải mới cho sản phẩm \""+temp.tenSP+"\":");
                    clv=sc.nextLine();
                    //sc.nextLine();
                    temp.ChatLieuVai=clv;
                    listSP.set(index, temp);
                };break;
                default:System.out.println("bạn đã không lựa chọn mục để sửa nên thông "
                        + "tin của sản phẩm:\""+temp.tenSP+"\" sẽ giữ nguyên");
            } 
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

    public int countElement() {
        return listSP.size();
    }
}
