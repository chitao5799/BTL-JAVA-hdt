/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSNV {
    ArrayList<NHANVIEN> listNV=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        int i,soluong;
        
        System.out.print("\nnhập số lượng nhân viên:");
        soluong=sc.nextInt();
        //listNV;
        for(i=0;i<soluong;i++)
        {           
            NHANVIEN xNhanvien=new NHANVIEN();
            NHANVIEN temp=new NHANVIEN();                                              
            xNhanvien.nhap();
                //do{               
                for ( int j=0;j<listNV.size();j++) {                    
                     temp=listNV.get(j);
                    if(xNhanvien.maNV.equals(temp.maNV))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã nhân viên,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho nhân viên:");
                        mamoi=sc.nextLine();
                        xNhanvien.maNV=mamoi;
                        j=-1;
                    }
                }                
         //   }while(xNhanvien.maNV.equals(temp.maNV));          
            listNV.add(xNhanvien);           
        }                   
    }
    public  void xuat(){
        System.out.println("\ndanh sách nhân viên:");
        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15s%-15s%-8s\n","ma nv","ten nv",
                "dia chi","gt","chuc vu","DT","luong","NS");
        for (NHANVIEN temp : listNV) {
            temp.Xuat();
        }
    }
    public void timNV()
    {
        //sc.nextLine();
        System.out.print("\n nhập tên nhân viên muốn tìm:");
        String temp="";
        temp=sc.nextLine();
        System.out.print("\ndanh sách các nhân viên muốn tìm\n");
        for (NHANVIEN x : listNV) {
            if(x.equals(temp))
                x.Xuat();
            
        }
    }
    public float tongluong(){
        float sum=0;
        for (NHANVIEN temp : listNV) {
            sum+=temp.getLuong();
        }
        return sum;
    }
    public void add1NV(){
        NHANVIEN xNhanvien=new NHANVIEN();
        NHANVIEN temp=new NHANVIEN();        
            xNhanvien.nhap();
             for ( int j=0;j<listNV.size();j++) {                    
                     temp=listNV.get(j);
                    if(xNhanvien.maNV.equals(temp.maNV))//==temp.maNV
                    {
                        System.out.println("\n !!!!!! WRONG!!: bạn đã nhập trùng mã nhân viên,mời nhập lại !!!!!! ");
                        //break;
                        sc.nextLine();
                        String mamoi;                        
                        System.out.print("\n nhập mã mới cho nhân viên:");
                        mamoi=sc.nextLine();
                        xNhanvien.maNV=mamoi;
                        j=-1;
                    }
                }    
            listNV.add(xNhanvien);
    }
    public int TimViTriTheoMa(){
      //  sc.nextLine();
        String maTim="";
        int indexs = -1;       
        System.out.print("\n nhập mã của  nhân viên:");
        maTim=sc.nextLine();
        
        for (NHANVIEN x : listNV) {
            if(maTim.equals(x.maNV))//if(x.maNV==maTim)
            {
                indexs=listNV.indexOf(x);               
                return indexs;
            }
        }
        return -1;
    }
    public void xoa1NV(){
         //sc.nextLine();
//        String maXoa="";
//        int indexs = 0;
//        System.out.print("\n nhập mã cho nhân viên muốn xóa:");
//        maXoa=sc.nextLine();
//        
//        for (NHANVIEN x : listNV) {
//            if(maXoa.equals(x.maNV))//if(x.maNV==maXoa)
//            {
//                indexs=listNV.indexOf(x);
//                break;
//            }
//        }
        int x=TimViTriTheoMa();
        if(x==-1)
            System.out.print("\ntrong danh sách không có nhân viên muốn xóa.");
        else
            listNV.remove(x);
    }
    public void suaInfor(){
        int index=TimViTriTheoMa();
        if(index==-1)
            System.out.print("\ntrong danh sách không có nhân viên muốn sửa thông tin.");
        else
        {
            NHANVIEN temp=listNV.get(index);
            System.out.print("\n bạn muốn sửa thông tin gì, mời lựa chọn:");
            System.out.print("\n1.địa chỉ; 2.chức vụ; 3.số điện thoại; 4.lương");
             //sc.nextLine();
            int luachon=-1;
            System.out.print("\nvui lòng nhập lựa chọn:");
            luachon=sc.nextInt();
           sc.nextLine();
            switch(luachon)
            {
                case 1:{
                    String dc;
                    System.out.print("\n nhập địa chỉ mới cho nhân viên \""+temp.tenNV+"\":");
                    dc=sc.nextLine();
                    temp.diaChi=dc;
                    listNV.set(index, temp);
                };break;
                case 2:{
                    String cv;
                    System.out.print("\n nhập chức vụ mới cho nhân viên \""+temp.tenNV+"\":");
                    cv=sc.nextLine();
                    temp.chucVu=cv;
                    listNV.set(index, temp);
                };break;
                case 3:{
                    long dienthoai;
                    System.out.print("\n nhập số điện thoại mới cho nhân viên \""+temp.tenNV+"\":");
                    dienthoai=sc.nextLong();
                    sc.nextLine();
                    temp.dt=dienthoai;
                    listNV.set(index, temp);
                    
                };break;
                case 4:{
                    float l;
                    System.out.print("\n nhập lương mới cho nhân viên \""+temp.tenNV+"\":");
                    l=sc.nextFloat();
                    sc.nextLine();
                    temp.luong=l;
                    listNV.set(index, temp);
                };break;
                default:System.out.println("bạn đã không lựa chọn mục để sửa nên thông "
                        + "tin của nhân viên:\""+temp.tenNV+"\" sẽ giữ nguyên");
            } 
        }        
    }
    public void SortByLuong(){//sắp xếp lương giảm dần      
        Collections.sort(listNV);
       
    }
    //sắp xếp theo tên-===can sua
    public void SortByName(){
        Collections.sort(listNV, new NameComparator());
    }
    //sắp xếp theo ngày sinh
    public void SortByYear(){
        Collections.sort(listNV, new NgaySinhComparator());
    }
    public void ghiFile(String filename) throws FileNotFoundException, IOException{
//          
             FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream out =new ObjectOutputStream(fout);
            out.writeObject(listNV);
            out.close();
           fout.close();
        }
        public void docfile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fin =new FileInputStream(filename);
            ObjectInputStream obin =new ObjectInputStream(fin);           
            listNV=(ArrayList)obin.readObject();
            obin.close();fin.close();
            
        }

    public int countElement() {
        return listNV.size();
    }
}
