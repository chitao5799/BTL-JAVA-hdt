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
public class KHACHHANG extends PerSon implements Serializable{
    private String maKH;


    public KHACHHANG() {
    }

    public KHACHHANG(String maKH, String tenKH, String diaChi, long dt,String gt) {
      
       super(tenKH,diaChi,gt,dt);
       this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }


    @Override
    public String toString() {
        return "KHACHHANG{" + "maKH=" + maKH + ", tenKH=" + super.getHoTen() + ", diaChi=" 
                + super.getDiaChi() + ", dt=" + super.getDienThoai() +",giới tính="+super.getGioiTinh()+ '}';
    }
    public  void nhap(){
        Scanner sc=new Scanner(System.in);
        do {            
            System.out.print("\n nhập mã khách hàng:");
            maKH=sc.nextLine();
            if(maKH.isEmpty())
                System.out.print("\n!!! mã khách hàng không được để trống.!!!");
        } while (maKH.isEmpty());
       super.nhapPerSon();
        
       
    }
    @Override
    public void xuat(){
         System.out.printf("\n%-10s%-20s%-25s%-15d%-7s",maKH,this.getHoTen(),
                 this.getDiaChi(),this.getDienThoai(),this.getGioiTinh());
         
    }
}
