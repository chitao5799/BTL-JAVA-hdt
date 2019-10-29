/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSNV extends DocGhiFile<NHANVIEN>{
   
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        int i,soluong;
        
        System.out.print("\nnhập số lượng nhân viên:");
        soluong=sc.nextInt();
        
        for(i=0;i<soluong;i++)
        {           
            NHANVIEN xNhanvien=new NHANVIEN();
            NHANVIEN temp=new NHANVIEN();                                              
            xNhanvien.nhap();
                            
                for ( int j=0;j<listDT.size();j++) {                    
                     temp=listDT.get(j);
                    if(xNhanvien.getMaNV().equals(temp.getMaNV()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã nhân viên,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho nhân viên:");
                        mamoi=sc.nextLine();
                        xNhanvien.setMaNV(mamoi);//=mamoi;
                        j=-1;
                    }
                }                
               
            listDT.add(xNhanvien);           
        }                   
    }
    public  void xuat(){
        System.out.println("\ndanh sách nhân viên:");
        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15s%-15s%-8s\n","ma nv","ten nv",
                "dia chi","gt","chuc vu","DT","luong","NS");
        for (NHANVIEN temp : listDT) {
            temp.xuat();
        }
    }
    public void timNV()
    {
        //sc.nextLine();
        System.out.print("\n nhập tên nhân viên muốn tìm:");
        String temp="";
        temp=sc.nextLine();
        System.out.print("\ndanh sách các nhân viên muốn tìm\n");
        for (NHANVIEN x : listDT) {
            if(x.equals(temp))
                x.xuat();
            
        }
    }
    public float tongluong(){
        float sum=0;
        for (NHANVIEN temp : listDT) {
            sum+=temp.getLuong();
        }
        return sum;
    }
    public void add1NV(){
        NHANVIEN xNhanvien=new NHANVIEN();
        NHANVIEN temp=new NHANVIEN();  
         
            xNhanvien.nhap();
             for ( int j=0;j<listDT.size();j++) {                    
                     temp=listDT.get(j);
                    if(xNhanvien.getMaNV().equals(temp.getMaNV()))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã nhân viên,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho nhân viên:");
                        mamoi=sc.nextLine();
                        xNhanvien.setMaNV(mamoi);//=mamoi;
                        j=-1;
                    }
                }    
            listDT.add(xNhanvien);
    }
    public int TimViTriTheoMa(){
      //  sc.nextLine();
        String maTim="";
        int indexs = -1;       
        System.out.print("\n nhập mã của  nhân viên:");
        maTim=sc.nextLine();
        
        for (NHANVIEN x : listDT) {
            if(maTim.equals(x.getMaNV()))
            {
                indexs=listDT.indexOf(x);               
                return indexs;
            }
        }
        return -1;
    }
    public void xoa1NV(){

        int x=TimViTriTheoMa();
        if(x==-1)
            System.out.print("\ntrong danh sách không có nhân viên muốn xóa.");
        else
            listDT.remove(x);
    }
    public void suaInfor(){
        int index=TimViTriTheoMa();
        if(index==-1)
            System.out.print("\ntrong danh sách không có nhân viên muốn sửa thông tin.");
        else
        {
            NHANVIEN temp=listDT.get(index);
            System.out.print("\n bạn muốn sửa thông tin gì, mời lựa chọn:");
            System.out.print("\n1.địa chỉ; 2.chức vụ; 3.số điện thoại; 4. hệ số lương");
             //sc.nextLine();
            int luachon=-1;
            System.out.print("\nvui lòng nhập lựa chọn:");
            luachon=sc.nextInt();
           sc.nextLine();
            switch(luachon)
            {
                case 1:{
                    String dc;
                    System.out.print("\n nhập địa chỉ mới cho nhân viên \""+temp.getHoTen()+"\":");
                    dc=sc.nextLine();
                    temp.setDiaChi(dc);//=dc;
                    listDT.set(index, temp);
                };break;
                case 2:{
                    String cv;
                    System.out.print("\n nhập chức vụ mới cho nhân viên \""+temp.getHoTen()+"\":");
                    cv=sc.nextLine();
                    temp.setChucVu(cv);//=cv;
                    listDT.set(index, temp);
                };break;
                case 3:{
                    long dienthoai;
                    System.out.print("\n nhập số điện thoại mới cho nhân viên \""+temp.getHoTen()+"\":");
                    dienthoai=sc.nextLong();
                    sc.nextLine();
                    temp.setDienThoai(dienthoai);//=dienthoai;
                    listDT.set(index, temp);
                    
                };break;
                case 4:{
                    int hsl;
                    System.out.print("\n nhập hệ sô lương mới cho nhân viên \""+temp.getHoTen()+"\":");
                    hsl=sc.nextInt();
                    sc.nextLine();
                    temp.setHeSoLuong(hsl);//=l;
                    listDT.set(index, temp);
                };break;
                default:System.out.println("bạn đã không lựa chọn mục để sửa nên thông "
                        + "tin của nhân viên:\""+temp.getHoTen()+"\" sẽ giữ nguyên");
            } 
        }        
    }
    public void SortByLuong(){//sắp xếp lương giảm dần      
        Collections.sort(listDT);
       
    }
    //sắp xếp theo tên-===can sua
    public void SortByName(){
        Collections.sort(listDT, new NameComparator());
    }
    //sắp xếp theo ngày sinh
    public void SortByYear(){
        Collections.sort(listDT, new NgaySinhComparator());
    }

    
    public int countElement() {
        return listDT.size();
    }
}
