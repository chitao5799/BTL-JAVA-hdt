/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;


//import com.sun.jndi.url.ldap.ldapURLContext;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSKH extends DocGhiFile<KHACHHANG>{//implements Serializable
   
    public void NhapDSKH(){
        int i,n=-1;
        Scanner sc =new Scanner(System.in);
        
        
       // listDT;
         do{
           System.out.print("\n nhập số lượng khách hàng:");
            
            try {
                n=sc.nextInt();
                sc.nextLine();
                if(n <= 0)
                System.out.print("\n !!!!!! SỐ LƯỢNG PHẢI LỚN HƠN 0. !!!!!! ");
                
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }
        }while (n <=  0); 
        
        
        for(i=0;i<n;i++){
            KHACHHANG khachhang=new KHACHHANG();
            khachhang.nhap();
            KHACHHANG temp=new KHACHHANG();
            for ( int j=0;j<listDT.size();j++) {                    
                     temp=listDT.get(j);
                    if(khachhang.getMaKH().equals(temp.getMaKH()))//==temp.maNV
                    {
                        System.out.println("\nWRONG!!: bạn đã nhập trùng mã khách hàng,mời nhập lại");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho khách hàng:");
                        mamoi=sc.nextLine();
                        khachhang.setMaKH(mamoi);
                        j=-1;
                    }
                } 
            listDT.add(khachhang);
        }
    }
        public void XuatDSKH(){
            System.out.print("\ndanh sách khách hàng:");
            System.out.printf("\n%-10s%-20s%-25s%-15s%-7s","mã KH","tên KH","địa chỉ","số đt","GT");
            for (KHACHHANG x : listDT) {
                x.xuat();
            }
        }
    public void XemThongTinHD_DaMua(DSHD dshd,DSChiTietHD dscthd,DSSP dssp){
        if(this.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file khách hàng hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        if(dscthd.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file chi tiết hóa đơn hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        if(dshd.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file hóa đơn hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        if(dssp.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file sản phẩm hoặc đọc nhầm file hoặc file rỗng.!!!");
            return;
        }
        String dauVao;//đầu vào có thể là tên hoặc mã khách hàng.
        Scanner sc =new Scanner(System.in);
        System.out.print("\n Nhập mã hoặc tên khách hàng muốn xem hóa đơn:");
         dauVao=sc.nextLine();
         
       //  System.out.printf("\n%-7s%-20s%-14s%-7s%-15s","mã KH","Tên KH","Điện Thoại","mã HD","Ngày Bán"); 
        double TongTienHD=0.0;
         for (KHACHHANG kh : this.listDT) 
        { 
            
            if(kh.getMaKH().equals(dauVao) || kh.getHoTen().equals(dauVao))
            {
                String maKHDuocChon;
                maKHDuocChon=kh.getMaKH();
               // int DaChonKH=0;
                System.out.printf("\n**************************************************"); 
                System.out.printf("\nMã Khách Hàng:%-10s Tên Khách Hàng:%-20s Điện Thoại:%-14s",maKHDuocChon,kh.getHoTen(),kh.getDienThoai());
                for (HoaDonBan hdb : dshd.listDT)
                {
                    if(hdb.getMaKH().equals(maKHDuocChon))
                    {
                        String maHDDuocChon ;
                        maHDDuocChon=hdb.getMaHD();
                       
                       
                        System.out.printf("\nMã Hóa Đơn:%-10s Ngày Bán:%2d/%2d/%4d\n",maHDDuocChon,hdb.getNgayBan().getDate(),
                            (hdb.getNgayBan().getMonth()==0)?12:hdb.getNgayBan().getMonth(),
                            (hdb.getNgayBan().getMonth()==0)?hdb.getNgayBan().getYear()-1:hdb.getNgayBan().getYear());
                        for (int i = 0; i < 87; i++) {
                            System.out.print("-");
                        }
                        System.out.printf("\n%-15s%-15s%-15s%-8s%-12s%-12s%-15s\n",
                                        "Tên Sản Phẩm","Đơn Giá Bán","Chất Liệu","Size","Số Lượng","Giảm Giá","Thành Tiền");
                        for (int i = 0; i < 87; i++) {
                            System.out.print("-");
                        }
                        for (ChiTietHoaDon cthd : dscthd.listDT)
                        {
                            
                            if(cthd.getMaHD().equals(maHDDuocChon))
                            {
                                String maSPDuocMua = cthd.getMaSP();
                                
                                for (SanPham sp : dssp.listDT) 
                                {
                                   if(sp.getMaSP().equals(maSPDuocMua)) 
                                   {
                                        System.out.printf("\n%-15s%-15.2f%-15s%-8d%-12d%-12.2f%-15.2f",
                                                sp.getTenSP(),sp.getDonGiaBan(),sp.getChatLieuVai(),sp.getSize(),cthd.getSoLuong(),cthd.getGiamGia(),cthd.ThanhTien());
                                        TongTienHD+=cthd.ThanhTien();
                                   }
                                }
                            }
                        }
                        System.out.println("");
                         for (int i = 0; i < 87; i++) {
                            System.out.print("-");
                        }
                        System.out.printf("\n %80sTổng Tiền:%.3f"," ",TongTienHD);
                        TongTienHD=0;
                    }
                }
                //return;
            }
        }
         
    }
    public int countElement(){
            return listDT.size();
        }
}
