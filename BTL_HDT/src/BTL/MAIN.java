/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

//import java.text.DateFormat;
//import java.text.ParseException;
//import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
//import java.awt.Color;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.NotSerializableException;
//import java.text.DateFormat;
import java.text.ParseException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
//import javafx.util.converter.LocalDateStringConverter;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import jdk.nashorn.internal.runtime.JSType;
//import java.util.Date;

/**
 *
 * @author NCT99
 */
public class MAIN {
    
    public static void main(String[] args) throws ParseException, IOException, FileNotFoundException, ClassNotFoundException, InterruptedException{//throws ParseException 
        Scanner sc =new Scanner(System.in);
        DSNV listNVdocfile=new DSNV();       
        DSKH listKHdocfile=new DSKH() ;
        DSSP listSPdocfile=new DSSP();
        int LuaChonChinh=-1;
        do{            
            menu();
            System.out.print("\n Mời bạn nhập lựa chọn:");
            LuaChonChinh=sc.nextInt();
            switch(LuaChonChinh){
                case 1:XuLyNhanVien(listNVdocfile);break;
                case 2: XuLyKhachHang(listKHdocfile);break;
                case 3: XuLySanPham(listSPdocfile);break;
                default: break;
            }
        }while (LuaChonChinh!=0);
    
    } 
    static void XuLyNhanVien(DSNV listNVdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc =new Scanner(System.in);
        int LuaChonNhanVien=-1;
        DSNV listnv=new DSNV();
        do{            
            menuNV();
            System.out.print("\n Mời bạn nhập lựa chọn:");
            LuaChonNhanVien=sc.nextInt();           
            switch(LuaChonNhanVien){
                case 1:{
                    listnv.nhap();
                };break;
                case 2:{
                    listnv.xuat();
                };break;
                case 3:{
                    sc.nextLine();
                    String filename="nhanvien.dat",temp;
                    System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listnv.ghiFile(filename);
                };break;
                case 4:{
                    sc.nextLine();
                    String filename="nhanvien.dat",temp;
                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listNVdocfile.docfile(filename);   
                    listNVdocfile.xuat();
                };break;
                case 5:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else 
                        System.out.print("\n Tổng lương của các nhân viên."+listNVdocfile.tongluong());
                };break;
                case 6:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                        listNVdocfile.suaInfor();
                        listNVdocfile.xuat();
                        String luachon="";
                        System.out.print("\n Bạn có muốn ghi lại thông tin vừa sửa vào file không (y/n).");
                        luachon=sc.nextLine();
                            if(luachon.equals("y")|| luachon.equals("yes"))
                            {
                                String filename="nhanvien.dat",temp;
                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
                                temp=sc.nextLine();
                                if (!temp.isEmpty()) {
                                    filename=temp;
                                }
                                listNVdocfile.ghiFile(filename);
                            }
                        }
                };break;
                case 7:{
                    sc.nextLine();
                   if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                        listNVdocfile.add1NV();
                        listNVdocfile.xuat();
                        sc.nextLine();
                        String luachon="";
                        System.out.print("\n Bạn có muốn ghi thông tin vừa thêm vào file không (y/n):");
                        luachon=sc.nextLine();
                            if(luachon.equals("y")|| luachon.equals("yes"))
                            {
                                String filename="nhanvien.dat",temp;
                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
                                temp=sc.nextLine();
                                if (!temp.isEmpty()) {
                                    filename=temp;
                                }
                                listNVdocfile.ghiFile(filename);
                            }
                        }
                };break;
                case 8:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo tên.\n");
                    listNVdocfile.SortByName();
                    listNVdocfile.xuat();                    
                    }
                };break;
                case 9:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo lương.\n");
                    listNVdocfile.SortByLuong();
                    listNVdocfile.xuat();                    
                    }
                };break;
                case 10:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo ngày sinh.\n");
                    listNVdocfile.SortByYear();
                    listNVdocfile.xuat();                    
                    }
                };break;
                case 11:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                        listNVdocfile.timNV();
                    }
                };break;
                case 12:{
                    sc.nextLine();
                    if(listNVdocfile.listNV.isEmpty())
                    { 
                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
                        sc.nextLine();sc.nextLine();
                    }else {
                    listNVdocfile.xoa1NV();
                    System.out.print("\nDanh sách sau khi xóa.\n");
                    listNVdocfile.xuat();
                     String luachon="";
                        System.out.print("\n Bạn có muốn ghi thông tin vừa thay đổi vào file không (y/n).");
                        luachon=sc.nextLine();
                            if(luachon.equals("y")|| luachon.equals("yes"))
                            {
                                String filename="nhanvien.dat",temp;
                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
                                temp=sc.nextLine();
                                if (!temp.isEmpty()) {
                                    filename=temp;
                                }
                                listNVdocfile.ghiFile(filename);
                            }
                    }
                };break;
                default: break;
            }
        }while (LuaChonNhanVien!=0);
    }
    static void XuLyKhachHang(DSKH listKHdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc =new Scanner(System.in);
        int LuaChonKhachHang=-1;
        DSKH listkh= new DSKH();
        do{            
            menuKH();
            System.out.print("\n Mời bạn nhập lựa chọn:");
            LuaChonKhachHang=sc.nextInt();           
            switch(LuaChonKhachHang){
                case 1:{
                    listkh.NhapDSKH();
                };break;
                case 2:{
                    listkh.XuatDSKH();
                };break;
                case 3:{
                    sc.nextLine();
                    String filename="khachhang.dat",temp;
                    System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: khachhang.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listkh.ghiFile(filename);
                };break;
                case 4:{
                    sc.nextLine();
                    String filename="khachhang.dat",temp;
                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: khachhang.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listKHdocfile.docfile(filename);   
                    listKHdocfile.XuatDSKH();
                };break;               
                default: break;
            }
        }while (LuaChonKhachHang!=0);
    }
    static void XuLySanPham(DSSP listSPdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc =new Scanner(System.in);
        int LuaChonSanPham=-1;
        DSSP listsp= new DSSP();
        do{            
            menuSP();
            System.out.print("\n Mời bạn nhập lựa chọn:");
            LuaChonSanPham=sc.nextInt();           
            switch(LuaChonSanPham){
                case 1:{
                    listsp.nhapDSSP();
                };break;
                case 2:{
                    listsp.xuatSP();
                };break;
                case 3:{
                    sc.nextLine();
                    String filename="sanpham.dat",temp;
                    System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listsp.ghiFile(filename);
                };break;
                case 4:{
                    sc.nextLine();
                    String filename="sanpham.dat",temp;
                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
                    temp=sc.nextLine();
                    if (!temp.isEmpty()) {
                        filename=temp;
                    }
                    listSPdocfile.docfile(filename);   
                    listSPdocfile.xuatSP();
                };break; 
                case 5:{
                   
                    listSPdocfile.TimSPHet();
                };break;
                default: break;
            }
        }while (LuaChonSanPham!=0);
    }

 
    static void menu(){     
        System.out.printf("\n%19s%-30s"," ","================MENU================");       
        System.out.printf("\n%20s\t%-30s%c","|","1.đối tượng Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-30s%c","|","2.đối tượng Khách Hàng.",'|');
        System.out.printf("\n%20s\t%-30s%c","|","3.đối tượng Sản Phẩm.",'|');
        System.out.printf("\n%20s\t%-30s%c","|","4.đối tượng Hóa Đơn.",'|');
        System.out.printf("\n%20s\t%-30s%c","|","5.đối tượng Chi Tiết Hóa Đơn.",'|');
        System.out.printf("\n%20s\t%-30s%c","|","0.Thoát.",'|');
        System.out.printf("\n%19s%-30s"," ","====================================");   
        
    }
    static void menuNV(){
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s%35s%24s","|","MENU NHÂN VIÊN","|");
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Nhân Viên vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Nhân Viên từ file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","5.Tính tổng lương của các Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","6.Sửa thông tin Nhân Viên theo mã.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","7.Thêm 1 Nhân Viên vào danh sách.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","8.Sắp xếp theo tên Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","9.Sắp sếp theo lương Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","10.Sắp xếp theo ngày sinh Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","11.Tìm Nhân Viên theo tên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","12.Xóa 1 Nhân Viên theo mã.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
    }
    static void menuKH(){
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s%35s%24s","|","MENU KHÁCH HÀNG","|");
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Khách Hàng.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Khách Hàng.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Khách Hàng vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Khách Hàng từ file.",'|');        
        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
    }
    static void menuSP(){
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s%35s%24s","|","MENU Sản Phẩm","|");
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Sản Phẩm.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Sản Phẩm.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Sản Phẩm vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Sản Phẩm từ file.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","5.Tìm Sản Phẩm đã bán hết.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
    }
    
}
/*
 //        DSNV dsnv=new DSNV();
//        dsnv.nhap();
//        dsnv.xuat();
//        System.out.print("\n ==================TIM NHÂN VIÊN:\n");
//        dsnv.timNV();
//        System.out.print("\n==================tong lương của các nhân viên:"+dsnv.tongluong());
//        System.out.print("\n ==================NHẬP THÊM 1 NHÂN VIÊN:\n");
//        dsnv.add1NV();
//        dsnv.xuat();
//         System.out.print("\n ==================xoa 1 NHÂN VIÊN THEO MÃ:\n");
//       dsnv.xoa1NV();
//       dsnv.xuat();
//        System.out.print("\n ==================SỬA THÔNG TIN 1 NHÂN VIÊN THEO MA:\n");
//        dsnv.suaInfor();
//        dsnv.xuat();
////         System.out.print("\n================== SẮP SẾP THEO LƯƠNG:\n");
//         DSNV temp;//=new DSNV();
//         temp=dsnv;
//         temp.SortByLuong();
//         temp.xuat();
//          System.out.print("\n ==================SẮP SẾP THEO TÊN:\n");
//          temp=dsnv;
//          temp.SortByName();
//          temp.xuat();
//           System.out.print("\n ==================SẮP SẾP THEO NGÀY SINH:\n");
//           temp=dsnv;
//           temp.SortByYear();
//           temp.xuat();
//-------------
        DSNV listNVdocfile;
        listNVdocfile=new DSNV();
        if(listNVdocfile.listNV==null)
            System.out.print("\nds rỗng");
        else System.out.print("\nds !+ rỗng");
        //*********=========================
//        DSKH ds =new DSKH();
//        ds.NhapDSKH();
//        ds.XuatDSKH();
//        ds.ghiFile();
//        System.out.print("\ndanh sách đọc từ file.\n");
//        ArrayList<KHACHHANG> lsArrayList=ds.docfile();
//        for (KHACHHANG x : lsArrayList) {
//            x.xuat();
//        }
*           //-----------
             DSKH ds =new DSKH();
        ds.NhapDSKH();
        ds.XuatDSKH();
        ds.ghiFile();
        System.out.print("\ndanh sách đọc từ file.\n");
        DSKH dskh =new DSKH();
        ArrayList<KHACHHANG> lsArrayList=ds.docfile();
        dskh.listkh=lsArrayList;
        dskh.XuatDSKH();
        ///*****============
//        DSSP dssp=new DSSP();
//        dssp.nhapDSSP();
//        dssp.xuatSP();
//        dssp.TimSPHet();
       //*********=========================
 */
