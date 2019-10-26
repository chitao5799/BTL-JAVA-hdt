/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.Serializable;
import java.util.Scanner;
//import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author NCT99
 */
public class ChiTietHoaDon  implements Serializable
{
    String maSP,maHD;
    int soLuong=0;
    double giamGia=0.0;
    SanPham temp=new SanPham();
    int indexSP=-1;
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maSP, String maHD, int soLuong, float giamGia) {
        this.maSP = maSP;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "maSP=" + maSP + ", maHD=" + maHD + ", soLuong=" + soLuong + ", giamGia=" + giamGia + '}';
    }
    public void nhapCTHD(DSSP dssp,DSHD dshd){
        Scanner sc =new Scanner(System.in);
        int coHD=-1;//xác định xem có nhập đúng mã hóa đơn đã tồn tại không.
        do{
            System.out.print("\n Nhập mã hóa đơn bán:");
            maHD=sc.nextLine();
            for (HoaDonBan x : dshd.listDT) {
                if(maHD.equals(x.maHD))
                {
                    coHD=1;
                    break;
                }
            }
            if(coHD!=1)
                System.out.print("\n!!! Wrong.Trong danh sách hóa đơn không có mã này.!!!");
        }while(coHD!=1);
        int coSP=-1;
       // SanPham temp=new SanPham();
        do {            
            System.out.print("\n Nhập mã sản phẩm:");
            maSP=sc.nextLine();
            for (SanPham x : dssp.listDT) {
                if(maSP.equals(x.getMaSP()))
                {
                    coSP=1;
                    if(x.getSoLuong()<=0)
                        {
                           coSP=-2;
                           break;
                        }
                    temp=x;
                    indexSP=dssp.listDT.indexOf(x);
                    break;
                }
                
            }
            if(coSP==-1)
                System.out.print("\n!!!Trong danh sách sản phẩm không có mã này.!!!");
            if(coSP==-2)
                System.out.print("\n!!!Sản phẩm này đã hết hàng.!!!");
        } while (coSP!=1);
        do {            
            System.out.print("\n Nhập số lượng mua sản phẩm này:");
            soLuong=sc.nextInt();
            if(soLuong<=0)
                System.out.print("\n!!!Wrong. số lượng phải lớn hơn không.!!!");
            if(temp.getSoLuong()<soLuong)
                System.out.print("\n!!!Số lượng nhập vào lớn hơn số lượng hiện có của sản phẩm trong danh sách.!!");
            
        } while (soLuong<=0 || temp.getSoLuong()<soLuong);
        //cập nhật lại số lượng cho sản phẩm đang nhập này.
        dssp.listDT.get(indexSP).setSoLuong(dssp.listDT.get(indexSP).getSoLuong()-this.soLuong);
        
        do {            
            System.out.print("\n Nhập giảm giá (0 -> 100)%:");
            giamGia=sc.nextFloat();
            if(giamGia<0 ||giamGia>100)
                System.out.print("\n!!Wrong. nhập mức giảm giá sai.!!!");
        } while (giamGia<0 ||giamGia>100);
    }
    public void xuat(){
        System.out.format("\n%-10s%-10s%-10d%-10.2f%-15.3f", maHD,maSP,soLuong,giamGia,ThanhTien());
    }
    public double ThanhTien(){
        return soLuong*temp.getDonGiaBan()-soLuong*temp.getDonGiaBan()*giamGia/100;
    }
}
