/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public abstract class PerSon implements Serializable{
    private String hoTen,diaChi,gioiTinh;
    private long dienThoai;

    public PerSon() {
    }
    
    public PerSon(String hoTen, String diaChi, String gioiTinh, long dienThoai) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public long getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(long dienThoai) {
        this.dienThoai = dienThoai;
    }

//    @Override
//    public String toString() {
//        return "PerSon{" + "hoTen=" + hoTen + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai + '}';
//    }
    public void nhapPerSon(){
        Scanner sc=new Scanner(System.in);        
       
        do {            
            System.out.print("\n Nhập tên cho Người này:");
             hoTen=sc.nextLine();
            if(hoTen.isEmpty())
                System.out.print("\n!!! Tên không được để trống.!!!");
        } while (hoTen.isEmpty());
        
        System.out.print("\n Nhập địa chỉ cho Người này:");
        diaChi=sc.nextLine();
        do {            
            System.out.print("\n Nhập giới tính cho Người này:");
            gioiTinh=sc.nextLine();
           if(!gioiTinh.toLowerCase().equals("nu") && !gioiTinh.toLowerCase().equals("nam") ) 
              System.out.print("\n!!!Wrong. bạn đã nhập sai giới tính.!!!!");
        } while (!gioiTinh.toLowerCase().equals("nu") && !gioiTinh.toLowerCase().equals("nam"));
        try {
             System.out.print("\n Nhập điện thoại cho Người này:");
             dienThoai=sc.nextLong();
        } catch (Exception e) {
            System.out.print("\n!!!Lỗi :"+e);
        }
        
    }
      public abstract void xuat();
    
}
