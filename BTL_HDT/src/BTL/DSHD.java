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
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSHD extends DocGhiFile<HoaDonBan>{
    //ArrayList<HoaDonBan> listDT =new ArrayList<>();
    public void nhapDSHD(DSKH dskh,DSNV dsnv){
        int i,soLuong;
        Scanner sc =new Scanner(System.in);
        System.out.print("\n nhập số lượng hóa đơn:");
        soLuong=sc.nextInt();
        for ( i = 0; i < soLuong; i++) {
            HoaDonBan hdb=new HoaDonBan();
            hdb.nhapHoaDon(dsnv,dskh);
            HoaDonBan temp=new HoaDonBan();
            for ( int j=0;j<listDT.size();j++) {                    
                     temp=listDT.get(j);
                    if(hdb.getMaHD().equals(temp.getMaHD()))//==temp.maNV
                    {
                        System.out.println("\nWRONG!!: bạn đã nhập trùng mã hóa đơn,mời nhập lại");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho hóa đơn:");
                        mamoi=sc.nextLine();
                        hdb.setMaHD(mamoi);
                        j=-1;
                    }
                } 
            listDT.add(hdb);
        }
        
    }
    public void xuatDSHD(){
        System.out.printf("\n%-10s%-10s%-10s%s","mã HD","mã NV","mã KH","ngày bán");
        for (HoaDonBan x : listDT) {
            x.xuatHD();
        }
    }
    public void add1HD(DSKH dskh,DSNV dsnv){
        Scanner sc =new Scanner(System.in);
         HoaDonBan hdb=new HoaDonBan();
            hdb.nhapHoaDon(dsnv,dskh);
            HoaDonBan temp=new HoaDonBan();
            for ( int j=0;j<listDT.size();j++) {                    
                     temp=listDT.get(j);
                    if(hdb.getMaHD().equals(temp.getMaHD()))//==temp.maNV
                    {
                        System.out.println("\nWRONG!!: bạn đã nhập trùng mã hóa đơn,mời nhập lại");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho hóa đơn:");
                        mamoi=sc.nextLine();
                        hdb.setMaHD(mamoi);
                        j=-1;
                    }
                } 
            listDT.add(hdb);
    }
    
//    public void ghiFile(String filename) throws FileNotFoundException, IOException{
////          
//            
//             FileOutputStream fout = new FileOutputStream(filename);
//            ObjectOutputStream out =new ObjectOutputStream(fout);
//            out.writeObject(listDT);
//            out.close();
//            fout.close();
//        
//        }
//        public void docfile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
//            
//            FileInputStream fin =new FileInputStream(filename);             
//            ObjectInputStream obin =new ObjectInputStream(fin);             
//            listDT=(ArrayList)obin.readObject();             
//            obin.close();fin.close();
//            
//        }

    public int countElement() {
        return listDT.size();
    }
}
