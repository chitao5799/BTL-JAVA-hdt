/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class HoaDonBan {
    String maHD,maNV,maKH;
    Date ngayBan;

    public HoaDonBan() {
    }

    public HoaDonBan(String maHD, String maNV, String maKH, Date ngayBan) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayBan = ngayBan;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    @Override
    public String toString() {
        return "HoaDonBan{" + "maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", ngayBan=" + ngayBan + '}';
    }
    public void nhapHoaDon(DSNV dsnv,DSKH dskh){
        Scanner sc =new Scanner(System.in);
        System.out.print("\n Nhập mã hóa đơn:");
        maHD=sc.nextLine(); 
        int coNV=-1;//co=1 là mã nhân viên vừa nhập có trong danh sách nhân viên.
        do{
            System.out.print("\n Nhập mã nhân viên:");
             maNV=sc.nextLine();
             for (NHANVIEN temp : dsnv.listNV) {
                if(maNV.equals(temp.maNV))
                {
                    coNV=1;
                    break;
                }
            }
            if(coNV!=1)
                System.out.print("\n !!!!!! WRong.Trong danh sách nhân viên không có mã này. !!!!!! ");
         }while(coNV!=1);
        int coKh=-1;//co=1 là mã nhân viên vừa nhập có trong danh sách nhân viên.
        do{
            System.out.print("\n Nhập mã khách hàng:");
             maKH=sc.nextLine();
             for (KHACHHANG temp : dskh.listkh) {
                if(maKH.equals(temp.getMaKH()))
                {
                    coKh=1;
                    break;
                }
            }
            if(coKh!=1)
                System.out.print("\n !!!!!! WRong.Trong danh sách nhân viên không có mã này. !!!!!! ");
         }while(coKh!=1);
        String day;
        String[] arrday=new String[3];
        do{
        System.out.print("\n nhập ngày bán (dd/mm/yyyy:)");
        day=sc.nextLine();
         arrday=day.split("/");
        if(Integer.valueOf(arrday[0])>31||Integer.valueOf(arrday[0])<1)
             System.out.print("\n !!!!!! ngày tháng không chính xác. !!!!!! ");
        else if(Integer.valueOf(arrday[1])<1||Integer.valueOf(arrday[1])>12)
         System.out.print("\n  !!!!!! ngày tháng không chính xác. !!!!!! ");
        else if(Integer.valueOf(arrday[2])<0)
             System.out.print("\n !!!!!!  ngày tháng không chính xác. !!!!!! ");
        }while(Integer.valueOf(arrday[0])>31||Integer.valueOf(arrday[0])<1||
                Integer.valueOf(arrday[1])<1||Integer.valueOf(arrday[1])>12||
                Integer.valueOf(arrday[2])<0);
        ngayBan=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
    }
    public void xuatHD(){
        System.out.printf("%-10s%-10s%-10s%2d/%2d/%4d", maHD,maNV,maKH,ngayBan.getDate(),
                ngayBan.getMonth(),ngayBan.getYear());
    }
}
