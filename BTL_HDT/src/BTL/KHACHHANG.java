/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.Serializable;
import java.util.Scanner;
//import java.util.logging.Logger;

/**
 *
 * @author NCT99
 */
public class KHACHHANG implements Serializable{
    private String maKH,tenKH, diaChi;
    private long dt;

    public KHACHHANG() {
    }

    public KHACHHANG(String maKH, String tenKH, String diaChi, long dt) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.dt = dt;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "KHACHHANG{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" 
                + diaChi + ", dt=" + dt + '}';
    }
    public  void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n nhập mã khách hàng:");
        maKH=sc.nextLine();
        System.out.print("\n nhập tên khách hàng:");
        tenKH=sc.nextLine();
        System.out.print("\n nhập địa chỉ khách hàng:");
        diaChi=sc.nextLine();
        System.out.print("\n nhập số điện thoại khách hàng:");
        dt=sc.nextLong();
    }
    public void xuat(){
         System.out.printf("\n%-10s%-20s%-25s%-15d",maKH,tenKH,diaChi,dt);
         
    }
}
