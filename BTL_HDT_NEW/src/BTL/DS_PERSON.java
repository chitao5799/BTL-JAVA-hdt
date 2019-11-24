/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author NCT99
 */
public class DS_PERSON {
    Scanner sc =new Scanner(System.in);
    DocGhiFile<PerSon> DSperson=new  DocGhiFile<>();
    DocGhiFile<NHANVIEN> DSnhanVien=new DocGhiFile<>();
    DocGhiFile<KHACHHANG> DSkhachHang=new DocGhiFile<>();
    public void nhap(){
        int i,soluong=-1;

        do{
          System.out.print("\nnhập số lượng người:");
            
            try {
                soluong=sc.nextInt();
                sc.nextLine();
                if(soluong <= 0)
                System.out.print("\n !!!!!! SỐ LƯỢNG PHẢI LỚN HƠN 0. !!!!!! ");
                
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }
        }while (soluong <=  0); 
        String loaiNguoi;
        for(i=0;i<soluong;i++)
        {         
            System.out.print("\n Nhập loại người (\"nhan vien\" HOẶC \"khach hang\"):");
            loaiNguoi=sc.nextLine();
            if(loaiNguoi.toLowerCase().equals("nhanvien")||loaiNguoi.toLowerCase().equals("nhan vien"))
            {
                NHANVIEN xNhanvien=new NHANVIEN();
                xNhanvien.nhap(); 
                PerSon temp=new PerSon();
                for ( int j=0;j<DSperson.listDT.size();j++) {                    
                     temp=DSperson.listDT.get(j);
                    if(xNhanvien.getMa().equals(temp.getMa()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã người,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n Nhập mã mới cho người này:");
                        mamoi=sc.nextLine();
                        xNhanvien.setMa(mamoi);//=mamoi;
                        j=-1;
                    }
                }    
                DSperson.listDT.add(xNhanvien);
                DSnhanVien.listDT.add(xNhanvien);
            }
            else if(loaiNguoi.toLowerCase().equals("khachhang")||loaiNguoi.toLowerCase().equals("khach hang"))
            {
                 KHACHHANG xKhachhang=new KHACHHANG();
                xKhachhang.nhap(); 
                PerSon temp=new PerSon();
                for ( int j=0;j<DSperson.listDT.size();j++) {                    
                     temp=DSperson.listDT.get(j);
                    if(xKhachhang.getMa().equals(temp.getMa()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã người,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n Nhập mã mới cho người này:");
                        mamoi=sc.nextLine();
                        xKhachhang.setMa(mamoi);//=mamoi;
                        j=-1;
                    }
                }    
                DSperson.listDT.add(xKhachhang);
                DSkhachHang.listDT.add(xKhachhang);
            }
            else i--;
        }                   
    }
    public void xuat(){
        
        for (PerSon x : DSperson.listDT) {
           
                System.out.print(x.toString()+"\n");
        }
    }
    public void ghiFilePerSon() throws IOException{
        DSperson.ghiFile("person.dat");
        DSnhanVien.ghiFile("nhanvien.dat");
        DSkhachHang.ghiFile("khachhang.dat");
    }
    public void ghiFileNhanVien() throws IOException{
        DSperson.ghiFile("person.dat");
        DSnhanVien.ghiFile("nhanvien.dat");
        
    }
    public void ghiFileKhachHang() throws IOException{
        DSperson.ghiFile("person.dat");
        DSkhachHang.ghiFile("khachhang.dat");
    }
    public void docFilePerSon() throws IOException, FileNotFoundException, ClassNotFoundException{
        DSperson.docfile("person.dat");
        DSnhanVien.docfile("nhanvien.dat");
        DSkhachHang.docfile("khachhang.dat");
    }
    public void XuatDSKH(){
         if(DSkhachHang.listDT.isEmpty()){
            System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
            return;
        }
            System.out.print("\ndanh sách khách hàng:");
            System.out.printf("\n%-10s%-20s%-25s%-15s%-7s","mã KH","tên KH","địa chỉ","số đt","GT");
            for (KHACHHANG x : DSkhachHang.listDT) {
                x.xuat();
            }
    }
//    public void XuatDSKHDocTuFile(ArrayList<KHACHHANG> listDT){
//            System.out.print("\ndanh sách khách hàng:");
//            System.out.printf("\n%-10s%-20s%-25s%-15s%-7s","mã KH","tên KH","địa chỉ","số đt","GT");
//            for (KHACHHANG x : listDT) {
//                x.xuat();
//            }
//    }
     public  void xuatDSNV(){
        if(DSnhanVien.listDT.isEmpty()){
            System.out.print("\n !!!Bạn chưa đọc file hoặc danh sách nhân viên trống.");
            return;
        }
        System.out.println("\ndanh sách nhân viên:");
        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15s%-15s%-8s\n","ma nv","ten nv",
                "dia chi","gt","chuc vu","DT","luong","NS");
        for (NHANVIEN temp : DSnhanVien.listDT) {
            temp.xuat();
        }
    }
//     public  void xuatDSNVDocTuFile(ArrayList<NHANVIEN> listDT){
//        System.out.println("\ndanh sách nhân viên:");
//        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15s%-15s%-8s\n","ma nv","ten nv",
//                "dia chi","gt","chuc vu","DT","luong","NS");
//        for (NHANVIEN temp : listDT) {
//            temp.xuat();
//        }
//    }
    public void XemThongTinHD_DaMua(DSHD dshd, DSSP dssp){
        if(this.DSperson.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file người hoặc file rỗng.!!!");
            sc.nextLine();
            return;
        }
        if(dshd.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file hóa đơn  hoặc file rỗng.!!!");
            sc.nextLine();
            return;
        }
        if(dssp.listDT.isEmpty())
        {
            System.out.print("\n!!!Chưa đọc file sản phẩm hoặc file rỗng.!!!");
            sc.nextLine();
            return;
        }
        String dauVao;//đầu vào có thể là tên hoặc mã khách hàng.
       // Scanner sc =new Scanner(System.in);
        System.out.print("\n Nhập mã hoặc tên khách hàng muốn xem hóa đơn:");
         dauVao=sc.nextLine();
         
       //  System.out.printf("\n%-7s%-20s%-14s%-7s%-15s","mã KH","Tên KH","Điện Thoại","mã HD","Ngày Bán"); 
      //  double TongTienHD=0.0;
         for (KHACHHANG kh : this.DSkhachHang.listDT) 
        { 
            
            if(kh.getMa().equals(dauVao) || kh.getHoTen().equals(dauVao))
            {
                String maKHDuocChon;
                maKHDuocChon=kh.getMa();
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
                                        "Tên Sản Phẩm","Đơn Giá Bán","Chất Liệu","Size","Số Lượng","Giảm Giá(%)","Thành Tiền");
                        for (int i = 0; i < 87; i++) {
                            System.out.print("-");
                        }
                        for (ChiTietHoaDon cthd : hdb.getListCTHD())
                        {
                            
                           
                                String maSPDuocMua = cthd.getMaSP();
                                
                                for (SanPham sp : dssp.listDT) 
                                {
                                   if(sp.getMaSP().equals(maSPDuocMua)) 
                                   {
                                        System.out.printf("\n%-15s%-15.2f%-15s%-8d%-12d%-12.2f%-15.2f",
                                                sp.getTenSP(),sp.getDonGiaBan(),sp.getChatLieuVai(),sp.getSize(),cthd.getSoLuong(),cthd.getGiamGia(),cthd.ThanhTien());
                                        
                                   }
                                }
                            
                        }
                        System.out.println("");
                         for (int i = 0; i < 87; i++) {
                            System.out.print("-");
                        }
                        System.out.printf("\n %70sTổng Tiền:%.3f"," ",hdb.TinhTongTien());
                       // TongTienHD=0;
                    }
                }
                //return;
            }
        }
    }
     public void timNV()
    {
        //sc.nextLine();
        
        System.out.print("\n nhập tên nhân viên muốn tìm:");
        String temp="";
        temp=sc.nextLine();
        System.out.print("\ndanh sách các nhân viên muốn tìm:\n");
         System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15s%-15s%-8s\n","ma nv","ten nv",
                "dia chi","gt","chuc vu","DT","luong","NS");
        for (NHANVIEN x : DSnhanVien.listDT) {
            if(x.equals(temp))
                x.xuat();
            
        }
    }
     public float tongluong(){
         
        float sum=0;
        for (NHANVIEN temp : DSnhanVien.listDT) {
            sum+=temp.getLuong();
        }
        return sum;
    }
    public void add1PerSon() throws IOException{
        String loaiNguoi;
        int i;
                 
            System.out.print("\n Nhập loại người (\"nhan vien\" HOẶC \"khach hang\"):");
            loaiNguoi=sc.nextLine();
            if(loaiNguoi.toLowerCase().equals("nhanvien")||loaiNguoi.toLowerCase().equals("nhan vien"))
            {
                NHANVIEN xNhanvien=new NHANVIEN();
                xNhanvien.nhap(); 
                PerSon temp=new PerSon();
                for ( int j=0;j<DSperson.listDT.size();j++) {                    
                     temp=DSperson.listDT.get(j);
                    if(xNhanvien.getMa().equals(temp.getMa()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã người,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n Nhập mã mới cho người này:");
                        mamoi=sc.nextLine();
                        xNhanvien.setMa(mamoi);//=mamoi;
                        j=-1;
                    }
                }    
                DSperson.listDT.add(xNhanvien);
                DSnhanVien.listDT.add(xNhanvien);
                ghiFileNhanVien();
            }
            else if(loaiNguoi.toLowerCase().equals("khachhang")||loaiNguoi.toLowerCase().equals("khach hang"))
            {
                 KHACHHANG xKhachhang=new KHACHHANG();
                xKhachhang.nhap(); 
                PerSon temp=new PerSon();
                for ( int j=0;j<DSperson.listDT.size();j++) {                    
                     temp=DSperson.listDT.get(j);
                    if(xKhachhang.getMa().equals(temp.getMa()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã người,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n Nhập mã mới cho người này:");
                        mamoi=sc.nextLine();
                        xKhachhang.setMa(mamoi);//=mamoi;
                        j=-1;
                    }
                }    
                DSperson.listDT.add(xKhachhang);
                DSkhachHang.listDT.add(xKhachhang);
                ghiFileKhachHang();
            }
            else System.out.print("\n!!!! Bạn đã không chọn đúng loại người muốn nhập.");
    }
     public int TimViTriTheoMa(){
      //  sc.nextLine();
        String maTim="";
        int indexs = -1;       
        System.out.print("\n nhập mã của người:");
        maTim=sc.nextLine();
        
        for (PerSon x : DSperson.listDT) {
            if(maTim.equals(x.getMa()))
            {
                indexs=DSperson.listDT.indexOf(x);               
                return indexs;
            }
        }
        return -1;
    }
    public void xoa1PerSon() throws IOException{

        int x=TimViTriTheoMa();
       
        
        if(x==-1)
            System.out.print("\ntrong danh sách không có người muốn xóa.");
        else{
            
            if(DSperson.listDT.get(x) instanceof NHANVIEN)
            { 
                int indexNV=-1;
                for (NHANVIEN itemNV : DSnhanVien.listDT) {
                    if(DSperson.listDT.get(x).getMa().equals(itemNV.getMa()))
                    {  
                        indexNV=DSnhanVien.getListDT().indexOf(itemNV);
                        break;
                    }
                }
                DSperson.listDT.remove(x);
                DSnhanVien.listDT.remove(indexNV);
                ghiFileNhanVien();
            }
            else if(DSperson.listDT.get(x) instanceof KHACHHANG)
            {
                int indexKH=-1;
                for (KHACHHANG itemKH : DSkhachHang.listDT) {
                    if(DSperson.listDT.get(x).getMa().equals(itemKH.getMa()))
                    {  
                        indexKH=DSkhachHang.getListDT().indexOf(itemKH);
                        break;
                    }
                }
                DSperson.listDT.remove(x);
                DSkhachHang.listDT.remove(indexKH);
                ghiFileKhachHang();
            }
            
        }
    }
    public void suaInfor() throws IOException{
        int index=TimViTriTheoMa();//chỉ số trong ds người
        int indexNV = -1;       //chỉ số trong ds nhân viên. 
        if(index==-1)
        {
            System.out.print("\n!!!trong danh sách không có người này.");sc.nextLine();
            return;
        }
        String maNV=DSperson.listDT.get(index).getMa();
       
        for (NHANVIEN x : DSnhanVien.listDT) {
            if(maNV.equals(x.getMa()))
            {
                indexNV=DSnhanVien.listDT.indexOf(x);               
                break;
            }
        }
        if(indexNV==-1 )
        {
            System.out.print("\n!!!trong danh sách không có nhân viên này.");
            sc.nextLine();
        }
        else
        {
            NHANVIEN temp=DSnhanVien.listDT.get(indexNV);
            System.out.print("\n bạn muốn sửa thông tin gì, mời lựa chọn:");
            System.out.print("\n1.địa chỉ; 2.chức vụ; 3.số điện thoại; 4. hệ số lương");
             //sc.nextLine();
            int luachon=-1;
            System.out.print("\nvui lòng nhập lựa chọn:");

           try {
                luachon=sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.print("\n!!!Lỗi: "+e.toString());
                return;
            }
            switch(luachon)
            {
                case 1:{
                    String dc;
                    System.out.print("\n nhập địa chỉ mới cho nhân viên \""+temp.getHoTen()+"\":");
                    dc=sc.nextLine();
                    temp.setDiaChi(dc);//=dc;
                    DSperson.listDT.set(index, temp);
                    DSnhanVien.listDT.set(indexNV, temp);
                    ghiFileNhanVien();
                };break;
                case 2:{
                    String cv;
                    System.out.print("\n nhập chức vụ mới cho nhân viên \""+temp.getHoTen()+"\":");
                    cv=sc.nextLine();
                    temp.setChucVu(cv);//=cv;
                    DSperson.listDT.set(index, temp);
                    DSnhanVien.listDT.set(indexNV, temp);
                    ghiFileNhanVien();
                };break;
                case 3:{
                    long dienthoai=0;
                    System.out.print("\n nhập số điện thoại mới cho nhân viên \""+temp.getHoTen()+"\":");
                    try {    
                        dienthoai=sc.nextLong();
                        sc.nextLine();
                       } catch (Exception e) {
                           System.out.print("\n!!!Lỗi :"+e);
                       }

                    temp.setDienThoai(dienthoai);//=dienthoai;
                   DSperson.listDT.set(index, temp);
                    DSnhanVien.listDT.set(indexNV, temp);
                    ghiFileNhanVien();
                };break;
                case 4:{
                    int hsl=0;
                    do{
                        System.out.print("\n nhập hệ sô lương mới cho nhân viên \""+temp.getHoTen()+"\":");
                       try {
                           hsl=sc.nextInt();
                            sc.nextLine();
                           if (hsl<=0) {
                           System.out.print("\n !!!hệ số lương phải lớn hơn 0.!!!");
                           }
                       } catch (Exception e) {                
                           System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                           sc.nextLine();
                       }     

                   }while(hsl<=0);
                  
                    temp.setHeSoLuong(hsl);//=l; 
                    //System.out.print("\n luong co ban:"+NHANVIEN.getLuongCoBan());
                    temp.setLuong(NHANVIEN.getLuongCoBan()*hsl);
                    DSperson.listDT.set(index, temp);
                    DSnhanVien.listDT.set(indexNV, temp);
                    ghiFileNhanVien();
                };break;
                default:System.out.println("bạn đã không lựa chọn mục để sửa nên thông "
                        + "tin của nhân viên:\""+temp.getHoTen()+"\" sẽ giữ nguyên");
            } 
        }        
    }
     public void SortByLuong(){//sắp xếp lương giảm dần      
        Collections.sort(DSnhanVien.listDT);
    }
    //sắp xếp theo tên-===can sua
    public void SortByName(){
        Collections.sort(DSnhanVien.listDT, new NameComparator());
    }
    //sắp xếp theo ngày sinh
    public void SortByYear(){
        Collections.sort(DSnhanVien.listDT, new NgaySinhComparator());
    }

    public void sortByNameNSLuong(){
        Collections.sort(DSnhanVien.listDT,new NameNgaysinhLuong());
    }
}
