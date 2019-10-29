/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class HoaDonBan implements Serializable{
    private String maHD,maNV,maKH;
    private Date ngayBan;

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
        do{
            System.out.print("\n Nhập mã hóa đơn:"); 
            maHD=sc.nextLine();
            if(maHD.isEmpty())
                System.out.print("\n!!!! Mã hóa đơn không được để trống.!!!");
        }while(maHD.isEmpty());
        
        int coNV=-1;//co=1 là mã nhân viên vừa nhập có trong danh sách nhân viên.
        do{
            System.out.print("\n Nhập mã nhân viên:");
             maNV=sc.nextLine();
             for (NHANVIEN temp : dsnv.listDT) {
                if(maNV.equals(temp.getMaNV()))
                {
                    coNV=1;
                    break;
                }
            }
            if(coNV!=1)
                System.out.print("\n !!!!!! WRong.Trong danh sách nhân viên không có mã này. !!!!!! ");
         }while(coNV!=1);
        int coKh=-1;//co=1 là mã kh vừa nhập có trong danh sách kh.
        do{
            System.out.print("\n Nhập mã khách hàng:");
             maKH=sc.nextLine();
             for (KHACHHANG temp : dskh.listDT) {
                if(maKH.equals(temp.getMaKH()))
                {
                    coKh=1;
                    break;
                }
            }
            if(coKh!=1)
                System.out.print("\n !!!!!! WRong.Trong danh sách khách hàng không có mã này. !!!!!! ");
         }while(coKh!=1);
         String day;
        String[] arrday=new String[3]; 
        //int //lưu trữ giá trị kiểm tra tính hợp lệ ngày nhập ,=1 thì nhập đúng ngày.
         boolean NgayThangNam=false;
        do{
            do{
                System.out.print("\n nhập ngày bán (dd/mm/yyyy):");
                day=sc.nextLine();
                if(day.split("/").length!=3)
                System.out.print("\n!!!!Bạn đã nhập ngày tháng sai !!!!."); 
            }while( day.split("/").length!=3);         
            arrday=day.split("/");

            NgayThangNam=NgayHopLe(Integer.valueOf(arrday[0]), Integer.valueOf(arrday[1]), Integer.valueOf(arrday[2]));
       
            if(NgayThangNam==false)
                System.out.print("\n  !!!!!! ngày tháng năm không chính xác. !!!!!! ");
        }while(NgayThangNam==false);

        ngayBan=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
    }
     public boolean NamNhuan(int year)
    {
         return(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public boolean NgayHopLe(int ngay, int thang,int nam)
    {
         int[] ngayTrongThang = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         if(thang <= 0 || thang > 12)
              return false;

         //Năm nhuận tháng 2 29 ngày:
         if(NamNhuan(nam))
              ngayTrongThang[1]++;
         if(nam<=0)
             return false;

         return (ngay > 0 && ngay <= ngayTrongThang[thang - 1]);
    } /**/
    public void xuatHD(){
        System.out.printf("\n%-10s%-10s%-10s%2d/%2d/%4d", maHD,maNV,maKH,ngayBan.getDate(),
                (ngayBan.getMonth()==0)?12:ngayBan.getMonth(),
                (ngayBan.getMonth()==0)?ngayBan.getYear()-1:ngayBan.getYear());
    }

}
