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
    public void TinhTongTien(DSChiTietHD dscthd){
        if(this.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file hóa đơn hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        if(dscthd.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file chi tiết hóa đơn hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        System.out.print("\nDanh sách tổng tiền của các hóa đơn.");
        System.out.printf("\n%-10s%-15s","Ma HD","Tổng tiền");
        double sums=0.0; //tổng tiền của tất cả các hóa đơn
        for (HoaDonBan hdb : this.listDT) {
            double sum=0.0;//tổng tiền của 1 hóa đơn
            for (ChiTietHoaDon cthd : dscthd.listDT) {
                if(hdb.getMaHD().equals(cthd.getMaHD()))
                    sum+=cthd.ThanhTien();
            }
            System.out.printf("\n%-10s%-15.2f",hdb.getMaHD(),sum);
            sums+=sum;
        }
        System.out.print("\n----------------------------------------------");
        System.out.printf("\n Tổng tiền của tất cả các hóa đơn là:%.3f",sums);
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
    


    public int countElement() {
        return listDT.size();
    }
    public void TimHDtheoNgay(){
        if(this.listDT.isEmpty())
        {
            System.out.print("\n!!!Danh sách hóa đơn chưa được đọc.!!!");
            return;
        }
        Date ngayBatDau=new Date(1970, 1, 1),ngayKetThuc=new Date(1970, 2, 1);
        int duocNgayBatDau=-1;//=1 khi đã xác nhận được ngày bắt đầu tìm kiếm.
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<2;i++)
        {
        String day;
        String[] arrday=new String[3]; 
        int NgayThangNam=-1;//lưu trữ giá trị kiểm tra tính hợp lệ ngày nhập ,=1 thì nhập đúng ngày.
         
        do{
            if(duocNgayBatDau==-1)
                do{
                    System.out.print("\n nhập ngày bắt đầu tìm kiếm (dd/mm/yyyy):");
                    day=sc.nextLine();
                    if(day.split("/").length!=3)
                    System.out.print("\n!!!!Bạn đã nhập ngày tháng sai !!!!."); 
                }while( day.split("/").length!=3);
            else
                do{
                    System.out.print("\n nhập ngày kết thúc tìm kiếm (dd/mm/yyyy):");
                    day=sc.nextLine();
                    if(day.split("/").length!=3)
                    System.out.print("\n!!!!Bạn đã nhập ngày tháng sai !!!!.");
                    
                }while( day.split("/").length!=3 );
            arrday=day.split("/");
            int[] ngayTrongThang = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if(Integer.valueOf(arrday[1]) <= 0 || Integer.valueOf(arrday[1]) > 12)
              NgayThangNam= -1;
            else {
                  if((((Integer.valueOf(arrday[2]) % 4 == 0) && (Integer.valueOf(arrday[2]) % 100 != 0)) || (Integer.valueOf(arrday[2]) % 400 == 0)))
                    ngayTrongThang[1]++;
                  if(Integer.valueOf(arrday[2])<=0)
                       NgayThangNam= -1;
                  else  if((Integer.valueOf(arrday[0]) > 0 && Integer.valueOf(arrday[0]) <= ngayTrongThang[Integer.valueOf(arrday[1]) - 1]))
                       NgayThangNam=1;
                        else NgayThangNam=-1;
            }
             if(NgayThangNam==-1)
                System.out.print("\n  !!!!!! ngày tháng năm không chính xác. !!!!!! ");
        }while(NgayThangNam==-1);
            if(duocNgayBatDau==-1)
            { 
                ngayBatDau=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
                duocNgayBatDau=1;
            }
            else{ 
                ngayKetThuc=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
                if(ngayKetThuc.before(ngayBatDau))
                {
                    System.out.print("!!!Wrong.Ngày kết thúc tìm kiếm phải sau ngày bắt đầu tìm kiếm.!!!");
                    i=0;
                }
            }
          
           
        }
        System.out.printf("\nDanh sách các hóa đơn được lập từ ngày %d/%d/%d đến ngày %d/%d/%d là",
                ngayBatDau.getDate(),(ngayBatDau.getMonth()==0)?12:ngayBatDau.getMonth(),
                (ngayBatDau.getMonth()==0)?ngayBatDau.getYear()-1:ngayBatDau.getYear(),ngayKetThuc.getDate(),
                (ngayKetThuc.getMonth()==0)?12:ngayKetThuc.getMonth(),
               (ngayKetThuc.getMonth()==0)?ngayKetThuc.getYear()-1:ngayKetThuc.getYear());
        System.out.printf("\n%-10s%-10s%-10s%s","mã HD","mã NV","mã KH","ngày bán");
        for (HoaDonBan hd : listDT) {
            if(hd.getNgayBan().after(ngayBatDau)&&hd.getNgayBan().before(ngayKetThuc))
                hd.xuatHD();
        }
    }
    public void TimHDLapByNV(){
        if(this.listDT.isEmpty())
        {
            System.out.print("\n!!!Danh sách hóa đơn chưa được đọc.!!!");
            return;
        }
        Scanner sc =new Scanner(System.in);
        String manv;
        System.out.print("\n Nhập mã nhân viên để tìm các hóa đơn do người này lập:");
        manv=sc.nextLine();
        System.out.printf("\nDanh sách các hóa đơn được lập bời nhân viên có mã \""+manv+"\" là:");
         System.out.printf("\n%-10s%-10s%-10s%s","mã HD","mã NV","mã KH","ngày bán");
         for (HoaDonBan hd : listDT) {
             if(hd.getMaNV().equals(manv))
                 hd.xuatHD();
         }
    }
}
