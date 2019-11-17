/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.ParseException;

import java.util.Scanner;


/**
 *
 * @author NCT99
 */
public class MAIN {
    
    public static void main(String[] args) throws ParseException, IOException, FileNotFoundException, ClassNotFoundException, InterruptedException{//throws ParseException 
        Scanner sc =new Scanner(System.in);
        DS_PERSON listPerSonDocFile =new DS_PERSON();
        DSHD listHDdocfile=new DSHD();//chứa danh sách đọc từ file.
        DSSP listSPdocfile=new DSSP();
        XuLyMeNu(listPerSonDocFile, listHDdocfile, listSPdocfile);
      
    } 
    static void XuLyMeNu(DS_PERSON listPerSonDocFile,DSHD listHDdocfile,DSSP listSPdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner sc =new Scanner(System.in);
        DS_PERSON ds_person=new DS_PERSON();
        DSSP dssp =new DSSP();
        DSHD dshd =new DSHD();
                
                
        int LuaChonChinh;
        do{           
            LuaChonChinh=-1;
            menu();
            System.out.print("\n Mời bạn nhập lựa chọn:");
            
            try {
                LuaChonChinh=sc.nextInt();                
                sc.nextLine();
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }
            switch(LuaChonChinh){
                case 1:{ ds_person.nhap();};break;
                case 2:{ 
                    if(ds_person.DSperson.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    ds_person.xuat(); sc.nextLine();
                };break;
                case 3:{ 
                    if(ds_person.DSperson.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    ds_person.ghiFilePerSon();
                };break;
                case 4:{ listPerSonDocFile.docFilePerSon();listPerSonDocFile.xuat();sc.nextLine();};break;
                case 5:{listPerSonDocFile.xuatDSNV();sc.nextLine();};break;
                case 6:{listPerSonDocFile.XuatDSKH();sc.nextLine();};break;
                case 7:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
                        break;
                    }
                     System.out.print("\n Tổng lương của các nhân viên là:"+listPerSonDocFile.tongluong());
                     sc.nextLine();
                };break;
                case 8:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
                        break;
                    }
                    listPerSonDocFile.suaInfor();
                };break;
                case 9:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
                        break;
                    }
                    listPerSonDocFile.add1PerSon();
                };break;
                case 10:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
                        sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.SortByName();
                    listPerSonDocFile.xuatDSNV();
                    sc.nextLine();
                };break;
                case 11:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.SortByLuong();
                    listPerSonDocFile.xuatDSNV();
                    sc.nextLine();
                };break;
                case 12:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.SortByYear();
                    listPerSonDocFile.xuatDSNV();
                    sc.nextLine();
                };break;
                case 13:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.timNV();
                    sc.nextLine();
                };break;
                case 14:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.xoa1PerSon();
                    listPerSonDocFile.xuatDSNV();
                    sc.nextLine();
                };break;
                case 15:{
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");sc.nextLine();
                        break;
                    }
                    listPerSonDocFile.sortByNameNSLuong();
                    listPerSonDocFile.xuatDSNV();
                    sc.nextLine();
                };break;
                case 16:{dssp.nhapDSSP(); };break;
                case 17:{
                    if(dssp.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    dssp.xuatSP();
                    sc.nextLine();
                };break;
                case 18:{
                    if(dssp.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    dssp.ghiFile("sanpham.dat");
                };break;
                case 19:{
                    listSPdocfile.docfile("sanpham.dat");
                    listSPdocfile.xuatSP();
                    sc.nextLine();
                };break;
                case 21:{
                    if(listSPdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file sản phẩm.");
                        sc.nextLine();
                        break;
                    }
                    listSPdocfile.TimSPHet();
                    sc.nextLine();
                };break;
                case 22:{
                    if(listSPdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file sản phẩm.");
                        sc.nextLine();
                        break;
                    }
                    listSPdocfile.add1SP();
                    listSPdocfile.ghiFile("sanpham.dat");
                    listSPdocfile.xuatSP();
                    sc.nextLine();
                    
                };break;
                case 23:{
                    if(listSPdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file sản phẩm.");
                        sc.nextLine();
                        break;
                    }
                    listSPdocfile.SuaInforSP();
                    listSPdocfile.ghiFile("sanpham.dat");
                    listSPdocfile.xuatSP();
                    sc.nextLine();
                    
                };break;
                case 24:{ 
                    if(listSPdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file sản phẩm,phải đọc file sản phẩm để có dữ liệu đối chiếu.");
                        sc.nextLine();
                        break;
                    }
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file người, phải đọc file để có dữ liệu đối chiếu.");sc.nextLine();
                        break;
                    }
                    dshd.nhapDSHD(listPerSonDocFile, listSPdocfile);
                    listSPdocfile.ghiFile("sanpham.dat");
                    };break;
                case 25:{
                    if(dshd.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    dshd.xuatDSHD();
                    sc.nextLine();
                };break;
                case 26:{
                    if(dshd.listDT.isEmpty()){
                        System.out.print("\n Danh sách trống.");
                        sc.nextLine();
                        break;
                    }
                    dshd.ghiFile("hoadon.dat");
                    //sc.nextLine();
                };break;
                case 27:{
                    
                    listHDdocfile.docfile("hoadon.dat");
                    listHDdocfile.xuatDSHD();
                    sc.nextLine();
                };break;
                case 28:{
                    if(listHDdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file hóa đơn.");
                        sc.nextLine();
                        break;
                    }
                    if(listSPdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file sản phẩm,phải đọc file sản phẩm để có dữ liệu đối chiếu.");
                        sc.nextLine();
                        break;
                    }
                     if(listPerSonDocFile.DSnhanVien.listDT.isEmpty()){
                        System.out.print("\n !!!Bạn chưa đọc file người, phải đọc file để có dữ liệu đối chiếu.");sc.nextLine();
                        break;
                    }
                    listHDdocfile.add1HD(listPerSonDocFile, listSPdocfile);
                    listHDdocfile.ghiFile("hoadon.dat");
                     listSPdocfile.ghiFile("sanpham.dat");
                    listHDdocfile.xuatDSHD();
                    sc.nextLine();
                };break;
                 case 29:{
                    if(listHDdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file hóa đơn.");
                        sc.nextLine();
                        break;
                    }
                   listHDdocfile.TinhTongTienCuaTatCaHD();
                    sc.nextLine();
                };break;
                 case 30:{
                    if(listHDdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file hóa đơn.");
                        sc.nextLine();
                        break;
                    }
                   listHDdocfile.TimHDtheoNgay();
                    sc.nextLine();
                };break;
                 case 31:{
                    if(listHDdocfile.listDT.isEmpty()){
                        System.out.print("\n Chưa đọc file hóa đơn.");
                        sc.nextLine();
                        break;
                    }
                   listHDdocfile.TimHDLapByNV();
                    sc.nextLine();
                };break;
                 case 32:{
                   listPerSonDocFile.XemThongTinHD_DaMua(listHDdocfile, listSPdocfile);
                   sc.nextLine();
                };break;
                default: break;
            }
        }while (LuaChonChinh!=0);
    }
//    static void XuLyNhanVien(DSNV listNVdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
//        Scanner sc =new Scanner(System.in);
//        int LuaChonNhanVien=-1;
//        DSNV listnv=new DSNV();
//        do{            
//            menuNV();
//            System.out.print("\n Mời bạn nhập lựa chọn:");
//            try {
//                LuaChonNhanVien=sc.nextInt();                
// 
//            } catch (Exception e) {
//                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");              
//                return;
//            }
//            switch(LuaChonNhanVien){
//                case 1:{
//                    listnv.nhap();
//                };break;
//                case 2:{
//                    listnv.xuat();
//                };break;
//                case 3:{
//                    sc.nextLine();
//                    if(listnv.countElement()<=0)
//                    { System.out.print("\n!!!Danh sách hiện tại rỗng, không thể ghi file.!!!");sc.nextLine();}
//                    else{
//                    String filename="nhanvien.dat",temp;
//                    System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                    listnv.ghiFile(filename);
//                    }
//                    
//                };break;
//                case 4:{
//                    sc.nextLine(); 
//                    
//                    String filename="nhanvien.dat",temp;
//                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                    listNVdocfile.docfile(filename); 
//                   
//                };break;
//                case 5:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else listNVdocfile.xuat();
//                };break;
//                case 6:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else 
//                        System.out.print("\n Tổng lương của các nhân viên."+listNVdocfile.tongluong());
//                };break;
//                case 7:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listNVdocfile.suaInfor();
//                        listNVdocfile.xuat();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi lại thông tin vừa sửa vào file không (y/n).");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="nhanvien.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                              listNVdocfile.ghiFile(filename);
//                            }
//                        }
//                };break;
//                case 8:{
//                    sc.nextLine();
//                   if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listNVdocfile.add1NV();
//                        listNVdocfile.xuat();
//                        sc.nextLine();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi thông tin vừa thêm vào file không (y/n):");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="nhanvien.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listNVdocfile.ghiFile(filename);
//                            }
//                        }
//                };break;
//                case 9:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo tên.\n");
//                    listNVdocfile.SortByName();
//                    listNVdocfile.xuat();                    
//                    }
//                };break;
//                case 10:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo lương.\n");
//                    listNVdocfile.SortByLuong();
//                    listNVdocfile.xuat();                    
//                    }
//                };break;
//                case 11:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo ngày sinh.\n");
//                    listNVdocfile.SortByYear();
//                    listNVdocfile.xuat();                    
//                    }
//                };break;
//                case 12:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listNVdocfile.timNV();
//                    }
//                };break;
//                case 13:{
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                    listNVdocfile.xoa1NV();
//                    System.out.print("\nDanh sách sau khi xóa.\n");
//                    listNVdocfile.xuat();
//                     String luachon="";
//                        System.out.print("\n Bạn có muốn ghi thông tin vừa thay đổi vào file không (y/n).");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="nhanvien.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: nhanvien.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                               listNVdocfile.ghiFile(filename);
//                            }
//                    }
//                };break;
//                case 14: {
//                    sc.nextLine();
//                    if(listNVdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file nhân viên chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                    System.out.print("\nDanh sách nhân viên sau khi được sắp xếp theo ngày sinh.\n");
//                    listNVdocfile.sortByNameNSLuong(); 
//                    listNVdocfile.xuat();
//                    }
//                };break;
//                default: break;
//            }
//        }while (LuaChonNhanVien!=0);
//    }
//    static void XuLyKhachHang(DSKH listKHdocfile,DSHD listHDdocfile, DSSP listSPdocfile, DSChiTietHD listCTHDdocfile)
//            throws IOException, FileNotFoundException, ClassNotFoundException{
//        Scanner sc =new Scanner(System.in);
//        int LuaChonKhachHang=-1;
//        DSKH listDT= new DSKH();
//        do{            
//            menuKH();
//            System.out.print("\n Mời bạn nhập lựa chọn:");
//           
//            try {
//                 LuaChonKhachHang=sc.nextInt();                
// 
//            } catch (Exception e) {
//                System.out.print("\n!!!Lỗi: "+e.toString());              
//                return;
//            }
//            switch(LuaChonKhachHang){
//                case 1:{
//                    listDT.NhapDSKH();
//                };break;
//                case 2:{
//                    listDT.XuatDSKH();
//                };break;
//                case 3:{
//                    sc.nextLine();
//                    if(listDT.countElement()<=0)
//                    { System.out.print("\n!!!Danh sách hiện tại rỗng, không thể ghi file.!!!");sc.nextLine();}
//                    else{
//                        String filename="khachhang.dat",temp;                   
//                        System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: khachhang.dat):");
//                        temp=sc.nextLine();
//                        if (!temp.isEmpty()) {
//                            filename=temp;
//                        }                                     
//                        listDT.ghiFile(filename);
//                    }
//                };break;
//                case 4:{
//                    sc.nextLine();
//                    String filename="khachhang.dat",temp;
//                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: khachhang.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                    listKHdocfile.docfile(filename);   
//                    listKHdocfile.XuatDSKH();
//                };break;
//                case 5:{
//                    listKHdocfile.XemThongTinHD_DaMua(listHDdocfile, listCTHDdocfile, listSPdocfile);
//                };break;
//                       
//                default: break;
//            }
//        }while (LuaChonKhachHang!=0);
//    }
//    static void XuLySanPham(DSSP listSPdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
//        Scanner sc =new Scanner(System.in);
//        int LuaChonSanPham=-1;
//        DSSP listsp= new DSSP();
//        do{            
//            menuSP();
//            System.out.print("\n Mời bạn nhập lựa chọn:");
//            
//            try {
//                LuaChonSanPham=sc.nextInt();                
// 
//            } catch (Exception e) {
//                System.out.print("\n!!!Lỗi: "+e.toString());              
//                return;
//            }
//            switch(LuaChonSanPham){
//                case 1:{
//                    listsp.nhapDSSP();
//                };break;
//                case 2:{
//                    listsp.xuatSP();
//                };break;
//                case 3:{
//                    sc.nextLine();
//                     if(listsp.countElement()<=0)
//                    { 
//                        System.out.print("\n!!!Danh sách hiện tại rỗng, không thể ghi file.!!!");
//                        sc.nextLine();
//                    }
//                    else{
//                        String filename="sanpham.dat",temp;
//                        System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                        temp=sc.nextLine();
//                        if (!temp.isEmpty()) {
//                            filename=temp;
//                        }
//                        listsp.ghiFile(filename);
//                    }
//                };break;
//                case 4:{
//                    sc.nextLine();
//                   
//                    String filename="sanpham.dat",temp;
//                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                    listSPdocfile.docfile(filename); 
//                      
//                    
//                };break; 
//                case 5:{
//                    sc.nextLine();
//                    if(listSPdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file sản phẩm chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else listSPdocfile.xuatSP();
//                };break;
//                case 6:{
//                   
//                    listSPdocfile.TimSPHet();
//                };break;
//                case 7:{
//                    sc.nextLine();
//                   if(listSPdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file sản phẩm chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listSPdocfile.add1SP();
//                        listSPdocfile.xuatSP();
//                        sc.nextLine();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi thông tin vừa thêm vào file không (y/n):");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="sanpham.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listSPdocfile.ghiFile(filename);
//                            }
//                    }
//                };break;
//                case 8:{
//                    sc.nextLine();
//                    if(listSPdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file sản phẩm chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listSPdocfile.SuaInforSP();
//                        listSPdocfile.xuatSP();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi lại thông tin vừa sửa vào file không (y/n).");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="sanpham.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listSPdocfile.ghiFile(filename);
//                            }
//                        }
//                };break;
//                default: break;
//            }
//        }while (LuaChonSanPham!=0);
//    }
//    static void XuLyHoaDon(DSNV listNVdocfile, DSKH listKHdocfile,DSHD listHDdocfile,DSChiTietHD lisCTHDdocfile) throws IOException, FileNotFoundException, ClassNotFoundException{
//        Scanner sc =new Scanner(System.in);
//        int LuaChonHoaDon=-1;
//        DSHD listDT= new DSHD();
//        do{            
//            menuHD();
//            System.out.print("\n Mời bạn nhập lựa chọn:");
//            
//            try {
//                LuaChonHoaDon=sc.nextInt();                
// 
//            } catch (Exception e) {
//                System.out.print("\n!!!Lỗi: "+e.toString());              
//                return;
//            }
//            switch(LuaChonHoaDon){
//                case 1:{
//                    if(listKHdocfile.listDT.isEmpty()){
//                        System.out.print("\n!!!! file khách hàng chưa được đọc,đọc file để có dữ liệu so sánh khi nhập hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listNVdocfile.listDT.isEmpty()){   
//                        System.out.print("\n!!!! file nhân viên chưa được đọc,đọc file để có dữ liệu so sánh khi nhập hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else listDT.nhapDSHD(listKHdocfile, listNVdocfile);
//                };break;
//                case 2:{
//                    listDT.xuatDSHD();
//                };break;
//                case 3:{
//                    sc.nextLine();
//                     if(listDT.countElement()<=0)
//                    { System.out.print("\n!!!Danh sách hiện tại rỗng, không thể ghi file.!!!");sc.nextLine();}
//                    else{
//                        String filename="hoadonban.dat",temp;
//                        System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: hoadonban.dat):");
//                        temp=sc.nextLine();
//                        if (!temp.isEmpty()) {
//                            filename=temp;
//                        }
//                        listDT.ghiFile(filename);
//                     }
//                };break;
//                case 4:{
//                    sc.nextLine();
//                   
//                    String filename="hoadonban.dat",temp;
//                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: hoadonban.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                   
//                    listHDdocfile.docfile(filename);   
//                    listHDdocfile.xuatDSHD();
//                    
//                };break;
//                case 5:{
//                   sc.nextLine();
//                   if(listKHdocfile.listDT.isEmpty()){
//                        System.out.print("\n!!!! file khách hàng chưa được đọc,đọc file để có dữ liệu so sánh khi nhập hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listNVdocfile.listDT.isEmpty()){   
//                        System.out.print("\n!!!! file nhân viên chưa được đọc,đọc file để có dữ liệu so sánh khi nhập hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listHDdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file hóa đơn chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listHDdocfile.add1HD(listKHdocfile, listNVdocfile);
//                        listHDdocfile.xuatDSHD();
//                        sc.nextLine();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi thông tin vừa thêm vào file không (y/n):");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="hoadonban.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: hoadonban.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listHDdocfile.ghiFile(filename);
//                            }
//                        } 
//                };break;
//                case 6:{
//                    listHDdocfile.TinhTongTien(lisCTHDdocfile);
//                };break;
//                case 7: listHDdocfile.TimHDtheoNgay();break;
//                case 8: listHDdocfile.TimHDLapByNV();break;
//                default: break;
//            }
//        }while (LuaChonHoaDon!=0);
//    }
//    static void XuLyChiTietHoaDon(DSChiTietHD listCTHDdocfile,DSHD listHDdocfile, DSSP listSPdocfile) 
//            throws IOException, FileNotFoundException, ClassNotFoundException
//    {
//        Scanner sc =new Scanner(System.in);
//        int LuaChonCTHoaDon=-1;
//        DSChiTietHD listCTHD= new DSChiTietHD();
//        do{            
//            menuCTHD();
//            System.out.print("\n Mời bạn nhập lựa chọn:");
//            
//            try {
//                LuaChonCTHoaDon=sc.nextInt();                
// 
//            } catch (Exception e) {
//                System.out.print("\n!!!Lỗi: "+e.toString());              
//                return;
//            }
//            switch(LuaChonCTHoaDon){
//                case 1:{
//                    if(listHDdocfile.listDT.isEmpty()){
//                        System.out.print("\n!!!! file hóa đơn chưa được đọc,đọc file để có dữ liệu so sánh khi nhập chi tiết hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listSPdocfile.listDT.isEmpty()){   
//                        System.out.print("\n!!!! file sản phẩm chưa được đọc,đọc file để có dữ liệu so sánh khi nhập chi tiết hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else {
//                    listCTHD.nhap(listHDdocfile, listSPdocfile);
//                    sc.nextLine();
//                    System.out.print("\n Số lượng sản phẩm đã thay đổi, bạn có "
//                            + "cập nhật thay đổi này vào file lưu danh sách sản phẩm không (y/n):");
//                    String luaChonCapNhap="";
//                    luaChonCapNhap=sc.nextLine();
//                            if(luaChonCapNhap.equals("y")|| luaChonCapNhap.equals("yes"))
//                            {
//                                String filename="sanpham.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listSPdocfile.ghiFile(filename);
//                            }
//                    }
//                };break;
//                case 2:{
//                    listCTHD.xuat();
//                };break;
//                case 3:{
//                    sc.nextLine();
//                    if(listCTHD.countElement()<=0)
//                    { System.out.print("\n!!!Danh sách hiện tại rỗng, không thể ghi file.!!!");sc.nextLine();}
//                    else{
//                        String filename="CTHoaDon.dat",temp;
//                        System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: CTHoaDon.dat):");
//                        temp=sc.nextLine();
//                        if (!temp.isEmpty()) {
//                            filename=temp;
//                        }
//                        listCTHD.ghiFile(filename);
//                    }
//                };break;
//                case 4:{
//                    sc.nextLine();
//                    
//                    String filename="CTHoaDon.dat",temp;
//                    System.out.print("\n nhập tên file muốn đọc, nhập cả phần mở rộng (tên mặc định: CTHoaDon.dat):");
//                    temp=sc.nextLine();
//                    if (!temp.isEmpty()) {
//                        filename=temp;
//                    }
//                    listCTHDdocfile.docfile(filename);   
//                    listCTHDdocfile.xuat();
//                    
//                };break;
//                case 5:{
//                    sc.nextLine();
//                    if(listHDdocfile.listDT.isEmpty()){
//                        System.out.print("\n!!!! file hóa đơn chưa được đọc,đọc file để có dữ liệu so sánh khi nhập chi tiết hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listSPdocfile.listDT.isEmpty()){   
//                        System.out.print("\n!!!! file sản phẩm chưa được đọc,đọc file để có dữ liệu so sánh khi nhập chi tiết hóa đơn.!!");
//                        sc.nextLine();sc.nextLine();
//                        }
//                    else if(listCTHDdocfile.listDT.isEmpty())
//                    { 
//                        System.out.print("\n !!!!!! file chi tiết hóa đơn chưa được đọc hoặc đọc nhần file hoặc file rỗng.");
//                        sc.nextLine();sc.nextLine();
//                    }else {
//                        listCTHDdocfile.add1CTHD(listHDdocfile, listSPdocfile);
//                        listCTHDdocfile.xuat();
//                        sc.nextLine();
//                        String luachon="";
//                        System.out.print("\n Bạn có muốn ghi thông tin vừa thêm vào file không (y/n):");
//                        luachon=sc.nextLine();
//                            if(luachon.equals("y")|| luachon.equals("yes"))
//                            {
//                                String filename="CTHoaDon.dat",temp;
//                                System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: CTHoaDon.dat):");
//                                temp=sc.nextLine();
//                                if (!temp.isEmpty()) {
//                                    filename=temp;
//                                }
//                                listCTHDdocfile.ghiFile(filename);
//                                /////
//                                 sc.nextLine();
//                                System.out.print("\n Số lượng sản phẩm đã thay đổi, bạn có "
//                                        + "cập nhật thay đổi này vào file lưu danh sách sản phẩm không (y/n):");
//                                String luaChonCapNhap="";
//                                luaChonCapNhap=sc.nextLine();
//                                if(luaChonCapNhap.equals("y")|| luaChonCapNhap.equals("yes"))
//                                {
//                                    String filenamesp="sanpham.dat",tempp;
//                                    System.out.print("\n nhập tên file muốn ghi, nhập cả phần mở rộng (tên mặc định: sanpham.dat):");
//                                    tempp=sc.nextLine();
//                                    if (!tempp.isEmpty()) {
//                                        filenamesp=tempp;
//                                    }
//                                    listSPdocfile.ghiFile(filenamesp);
//                                }
//                            }
//                       
//                    } 
//                };break;
//                default: break;
//            }
//        }while (LuaChonCTHoaDon!=0);
//    }

 
    static void menu(){ 
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        } 
         System.out.printf("\n%20s%35s%24s","|","MENU","|");
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }      
        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Người(Gồm Nhân Viên và Khách hàng).",'|');
        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Người.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Người vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Người từ file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","5.Xuất danh sách Nhân Viên đọc từ file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","6.Xuất danh sách Khách Hàng đọc từ file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","7.Tính tổng lương của các Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","8.Sửa thông tin Nhân Viên theo mã.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","9.Thêm 1 Người vào danh sách.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","10.Sắp xếp theo tên Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","11.Sắp sếp theo lương Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","12.Sắp xếp theo ngày sinh Nhân Viên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","13.Tìm Nhân Viên theo tên.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","14.Xóa 1 Người theo mã.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","15.Sắp xếp theo tên, ngày sinh, lương.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","------------------------------- ",'|');
        System.out.printf("\n%20s\t%-54s%c","|","16.Nhập danh sách Sản Phẩm.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","17.Xuất danh sách Sản Phẩm.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","18.Ghi danh sách Sản Phẩm vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","19.Đọc danh sách Sản Phẩm từ file.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","21.Tìm Sản Phẩm đã bán hết.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","22.Thêm 1 Sản Phẩm mới.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","23.Sửa thông tin Sản Phẩm đã tồn tại.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","------------------------------- ",'|');
        System.out.printf("\n%20s\t%-54s%c","|","24.Nhập danh sách Hóa Đơn.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","25.Xuất danh sách Hóa Đơn.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","26.Ghi danh sách Hóa Đơn vào file.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","27.Đọc danh sách Hóa Đơn từ file.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","28.Nhập thêm 1 bản ghi hóa đơn mới.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","29.Xuất tổng tiền của các hóa đơn.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","30.Tìm các hóa đơn được lập trong 1 khoảng thời gian.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","31.Tìm các hóa đơn được lập bởi nhân viên theo mã NV.",'|');
        System.out.printf("\n%20s\t%-54s%c","|","32.Tìm các hóa đơn của một khách hàng nào đó.",'|'); 
        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
        System.out.printf("\n%19s"," ");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }  
        
    }
}
//    static void menuCTHD(){
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s%35s%24s","|","MENU Chi Tiết Hóa Đơn","|");
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách  Chi Tiết Hóa Đơn.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Chi Tiết Hóa Đơn.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Chi Tiết Hóa Đơn vào file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Chi Tiết Hóa Đơn từ file.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","5.Thêm 1 bản ghi chi tiết hóa đơn.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//    }
//    static void menuHD(){
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s%35s%24s","|","MENU HÓA ĐƠN","|");
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Hóa Đơn.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Hóa Đơn.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Hóa Đơn vào file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Hóa Đơn từ file.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","5.Nhập thêm 1 bản ghi hóa đơn mới.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","6.Xuất tổng tiền của các hóa đơn.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","7.Tìm các hóa đơn được lập trong 1 khoảng thời gian.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","8.Tìm các hóa đơn được lập bởi nhân viên theo mã NV.",'|');
//
//        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//    }
//    static void menuNV(){
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s%35s%24s","|","MENU NHÂN VIÊN","|");
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Nhân Viên vào file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Nhân Viên từ file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","5.Xuất danh sách Nhân Viên đọc từ file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","6.Tính tổng lương của các Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","7.Sửa thông tin Nhân Viên theo mã.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","8.Thêm 1 Nhân Viên vào danh sách.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","9.Sắp xếp theo tên Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","10.Sắp sếp theo lương Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","11.Sắp xếp theo ngày sinh Nhân Viên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","12.Tìm Nhân Viên theo tên.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","13.Xóa 1 Nhân Viên theo mã.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","14.Sắp xếp theo tên, ngày sinh, lương.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//    }
//    static void menuKH(){
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s%35s%24s","|","MENU KHÁCH HÀNG","|");
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Khách Hàng.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Khách Hàng.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Khách Hàng vào file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Khách Hàng từ file.",'|');        
//        System.out.printf("\n%20s\t%-54s%c","|","5.Tìm các hóa đơn của khách hàng đã mua.",'|');        
//        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//    }
//    static void menuSP(){
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s%35s%24s","|","MENU Sản Phẩm","|");
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//        System.out.printf("\n%20s\t%-54s%c","|","1.Nhập danh sách Sản Phẩm.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","2.Xuất danh sách Sản Phẩm.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","3.Ghi danh sách Sản Phẩm vào file.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","4.Đọc danh sách Sản Phẩm từ file.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","5.Hiển thị danh sách Sản Phẩm đọc từ file.",'|'); 
//        System.out.printf("\n%20s\t%-54s%c","|","6.Tìm Sản Phẩm đã bán hết.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","7.Thêm 1 Sản Phẩm mới.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","8.Sửa thông tin Sản Phẩm đã tồn tại.",'|');
//        System.out.printf("\n%20s\t%-54s%c","|","0.Thoát.",'|');
//        System.out.printf("\n%19s"," ");
//        for (int i = 0; i < 60; i++) {
//            System.out.print("=");
//        }
//    }
//    
//}
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
        dskh.listDT=lsArrayList;
        dskh.XuatDSKH();
        ///*****============
//        DSSP dssp=new DSSP();
//        dssp.nhapDSSP();
//        dssp.xuatSP();
//        dssp.TimSPHet();
       //*********=========================
 */
