/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

//import java.sql.Time;
//import java.util.Date;
//import java.sql.Date;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
//import jdk.nashorn.internal.parser.TokenType;
//import jdk.nashorn.internal.codegen.CompilerConstants;
//import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author NCT99
 */
public class NHANVIEN implements Comparable<NHANVIEN>,Serializable{
    String maNV, tenNV, diaChi,gt,chucVu;
    long dt;
    float luong;
    Date ngaySinh;

    public NHANVIEN() {
        ngaySinh=new Date(0, 0, 0);
    }
    
    public NHANVIEN(String maNV, String tenNV, String diaChi, String gt,
            String chucVu, long dt, float luong, Date ngaySinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.gt = gt;
        this.chucVu = chucVu;
        this.dt = dt;
        this.luong = luong;
        this.ngaySinh = ngaySinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);        
//       
        System.out.print("\n nhập mã nhân viên:");
        maNV=sc.nextLine();
        System.out.print("\n nhập tên nhân viên:");
        tenNV=sc.nextLine();
        System.out.print("\n nhập địa chỉ của nhân viên:");
        diaChi=sc.nextLine();
        System.out.print("\n nhập giới tính cho nhân viên:");
        gt=sc.nextLine();
        System.out.print("\n nhập chức vụ nhân viên:");
        chucVu=sc.nextLine();
        System.out.print("\n nhập điện thoại nhân viên:");
        dt=sc.nextLong();
        System.out.print("\n nhập lương nhân viên(. not ,):");
        luong=sc.nextFloat();
//        int day,month,year;
//        do {            
//            System.out.print("\n nhập ngày sinh nhân viên:");
//        day=sc.nextInt();
//        } while (day<1||day>31);
//        do {            
//            System.out.print("\n nhập tháng sinh nhân viên:");
//        month=sc.nextInt();
//        } while (month<1||month>12);
//        
//        System.out.print("\n nhập năm sinh nhân viên:");
//        year=sc.nextInt();
//        ngaySinh=new Date(year, month, day);
        
        sc.nextLine();
        String day;
        String[] arrday=new String[3];
        do{
        System.out.print("\n nhập ngày sinh (dd/mm/yyyy:)");
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
        ngaySinh=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
        
       // sc.nextLine();
        
    }
    public void Xuat(){
        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15d%-15.3f%-2d/%-2d/%-4d\n",
                maNV,tenNV,diaChi,gt,chucVu,dt,luong,ngaySinh.getDate(),
                (ngaySinh.getMonth()==0)?12:ngaySinh.getMonth(),ngaySinh.getYear());
    }
//     public void Xuat(){
//        System.out.printf("%-7s%-15s%-15s%-5s%-10s%-12d%-10.3f,%-10s",
//                maNV,tenNV,diaChi,gt,chucVu,dt,luong,ngaySinh.toString());
//    }
//   test: NHANVIEN a=new NHANVIEN("sfsdf", "sdkf ksd", "dksd dsfk","dsf" , "xxxc",
//                351234, 344.687f,new Date(2002, 11,10) );//DateFormat.getDateInstance().parse("2001/29/11")
//        a.Xuat();
   
    @Override
    public String toString() {
        return "NHANVIEN{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", diaChi=" 
                + diaChi + ", gt=" + gt + ", chucVu=" + chucVu + ", dt=" + dt 
                + ", luong=" + luong + ", ngaySinh=" + ngaySinh + '}';
    }
 //   @Override

        public boolean equals(String obj){

           // if(obj instanceof NHANVIEN){
                String[] temp=(this.tenNV).split(" ");
                for(int i=0;i<temp.length;i++)
                if(obj.equals(temp[i])){//(NHANVIEN)obj
                      return true;
                }
           // }
        return false;
        }
    @Override //hàm này cung cấp khả năng so sánh để sắp sếp danh sách nhân viên
    //Comparable interface:chỉ có thể sắp xếp theo duy nhất một thuộc  tính nào đó của nhân viên thôi
    //Cung cấp phương thức compareTo() và Sắp xếp sử dụng Collections.sort(List)
    public int compareTo(NHANVIEN nv) {
		if (this.luong == nv.luong)
			return 0;
		else if (this.luong > nv.luong)
			return 1;
		else
			return -1;
	}    
    
}
/*
Java Comparator interface được sử dụng để chỉ ra thứ tự của các đối tượng Người dùng 
tự định nghĩa(User-defined). Nó định nghĩa 2 phương thức compare(Object obj1,Object obj2)
và equals(Object element). Nó cung cấp nhiều trình tự sắp xếp.

public int compare(Object obj1,Object obj2): so sánh 2 object với nhau .
public void sort(List list, Comparator c): phương thức của Collections được sử 
dụng để sắp xếp các phần tử của list dựa trên Comparator.
*/
class NgaySinhComparator implements Comparator<NHANVIEN> {//sắp xếp theo ngày sinh , dùng comparator
        @Override
	public int compare(NHANVIEN s1, NHANVIEN s2) {
		if (s1.ngaySinh.getYear() == s2.ngaySinh.getYear())
                {	
                    if(s1.ngaySinh.getMonth()==s2.ngaySinh.getMonth())
                    {
                        if(s1.ngaySinh.getDate()==s2.ngaySinh.getDate())
                            return 0;
                        else
                            if(s1.ngaySinh.getDate()>s2.ngaySinh.getDate())
                                return 1;
                            else 
                                    return -1;
                    }
                    else                    
                        if(s1.ngaySinh.getMonth()>s2.ngaySinh.getMonth())
                            return 1;
                        else 
                            return -1;          
                }
		else 
                    if (s1.ngaySinh.getYear() > s2.ngaySinh.getYear())
			return 1;
                    else
			return -1;
	}

   
}
class NameComparator implements Comparator<NHANVIEN> {
        @Override
	public int compare(NHANVIEN s1, NHANVIEN s2) {
                String[] ten1=s1.tenNV.split(" ");
                String[] ten2=s2.tenNV.split(" ");
		return ten1[ten1.length-1].compareTo(ten2[ten2.length-1]);
	}
}