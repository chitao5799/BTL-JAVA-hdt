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
public class SanPham implements Serializable{
    private static final long serialVersionUID=351289098L;
    private String maSP, tenSP,ChatLieuVai;//
    private int Size,SoLuong;//
    private double DonGiaNhap,DonGiaBan;//

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String ChatLieuVai, int Size, 
            int SoLuong, double DonGiaNhap, double DonGiaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ChatLieuVai = ChatLieuVai;
        this.Size = Size;
        this.SoLuong = SoLuong;
        this.DonGiaNhap = DonGiaNhap;
        this.DonGiaBan = DonGiaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getChatLieuVai() {
        return ChatLieuVai;
    }

    public void setChatLieuVai(String ChatLieuVai) {
        this.ChatLieuVai = ChatLieuVai;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(double DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public double getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(double DonGiaBan) {
        this.DonGiaBan = DonGiaBan;
    }
    public void nhapSP(){
        Scanner sc =new Scanner(System.in);
        do {            
            System.out.print("\n nhập mã sản phẩm:");
            maSP =sc.nextLine();
            if(maSP.isEmpty())
                System.out.print("\n!!!mã sản không được để trống.!!");
        } while (maSP.isEmpty());
        do {            
            System.out.print("\n nhập tên sản phẩm:");
            tenSP =sc.nextLine();
            if(tenSP.isEmpty())
                System.out.print("\n!!! Tên sản phẩm không được để trống.!!!");
        } while (tenSP.isEmpty());
        
        System.out.print("\n nhập chất liệu vải:");
        ChatLieuVai =sc.nextLine();
        do{
            System.out.print("\n nhập size sản phẩm \""+ this.tenSP+"\":");
            try {
                Size =sc.nextInt();                
                sc.nextLine();
                if(Size <= 0)
                System.out.print("\n !!!!!!  KÍCH CỠ PHẢI LỚN HƠN 0. !!!!!! ");
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }
  
        }while (Size<=  0); 
        do{
            System.out.print("\n nhập số lượng của sản phẩm \""+ this.tenSP+"\":");
            
            try {
                SoLuong =sc.nextInt();
                sc.nextLine();
                if(SoLuong <= 0)
                System.out.print("\n !!!!!! SỐ LƯỢNG PHẢI LỚN HƠN 0. !!!!!! ");
                
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }
        }while (SoLuong<=  0);          
            
        
        
        do{
        System.out.print("\n nhập đơn giá nhập của sản phẩm \""+ this.tenSP+"\":");
        try {
                DonGiaNhap =sc.nextDouble();                
                sc.nextLine();
                if(DonGiaNhap <= 0.0)
                System.out.print("\n !!!!!!  ĐƠN GIÁ NHẬP PHẢI LỚN HƠN 0. !!!!!! ");
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số thực.");                                      
                sc.nextLine();
            }
        }while (DonGiaNhap <= 0.0);           
        do{
            System.out.print("\n nhập đơn giá bán của sản phẩm \""+ this.tenSP+"\":");
            try {
                DonGiaBan =sc.nextDouble();                          
                sc.nextLine();
                if(DonGiaBan < DonGiaNhap )
                    System.out.print("\n !!!!!! ĐƠN GIÁ BÁN PHẢI LỚN HƠN ĐƠN GIÁ NHẬP !!!!!! ");
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số thực.");                                      
                sc.nextLine();
            }
            
        }while(DonGiaBan < DonGiaNhap);
        
    }
    public void xuat(){
        System.out.printf("\n%-10s%-15s%-15s%-7d%-7d%-15.2f%-15.2f",maSP,tenSP,
                ChatLieuVai,Size,SoLuong,DonGiaNhap,DonGiaBan);
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", ChatLieuVai=" 
                + ChatLieuVai + ", Size=" + Size + ", SoLuong=" + SoLuong + 
                ", DonGiaNhap=" + DonGiaNhap + ", DonGiaBan=" + DonGiaBan + '}';
    }
    
   
   
}
