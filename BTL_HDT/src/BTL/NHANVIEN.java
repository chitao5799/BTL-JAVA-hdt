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
public class NHANVIEN extends PerSon implements Comparable<NHANVIEN>,Serializable{
    private String maNV,chucVu;//, tenNV, diaChi,gt;
   // long dt;
    private static float luongCoBan;
    private int heSoLuong;
    private Date ngaySinh;
    private float luong;
    public NHANVIEN() {
        super();
        luongCoBan =1100.0f;
      //  ngaySinh=new Date(0, 0, 0);
    }
    
//    public NHANVIEN(String maNV, String tenNV, String diaChi, String gt,
//            String chucVu, long dt, float luong, Date ngaySinh) {
//        this.maNV = maNV;
//        this.tenNV = tenNV;
//        this.diaChi = diaChi;
//        this.gt = gt;
//        this.chucVu = chucVu;
//        this.dt = dt;
//        this.luong = luong;
//        this.ngaySinh = ngaySinh;
//    }

    public NHANVIEN(String maNV, String chucVu, int heSoLuong, Date ngaySinh) {
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.ngaySinh = ngaySinh;
    }

    public NHANVIEN(String maNV, String chucVu, int heSoLuong, Date ngaySinh, String hoTen, String diaChi, String gioiTinh, long dienThoai) {
        super(hoTen, diaChi, gioiTinh, dienThoai);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.ngaySinh = ngaySinh;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public static float getLuongCoBan() {
        return luongCoBan;
    }

    public static void setLuongCoBan( float luongCoBan) {
        NHANVIEN.luongCoBan = luongCoBan;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    

    
   
    public void nhap(){
        Scanner sc=new Scanner(System.in);        
        do {            
            System.out.print("\n Nhập mã nhân viên:");
            maNV=sc.nextLine();
            if(maNV.isEmpty())
                System.out.print("\n!!! mã nhân viên không được để trống.!!!");
        } while (maNV.isEmpty());
        super.nhapPerSon();
//        do {            
//            System.out.print("\n Nhập tên nhân viên:");
//             tenNV=sc.nextLine();
//            if(tenNV.isEmpty())
//                System.out.print("\n!!! Tên nhân viên không được để trống.!!!");
//        } while (tenNV.isEmpty());
        
//        System.out.print("\n Nhập địa chỉ của nhân viên:");
//        diaChi=sc.nextLine();
//        System.out.print("\n Nhập giới tính cho nhân viên:");
//        gt=sc.nextLine();
        System.out.print("\n Nhập chức vụ nhân viên:");
        chucVu=sc.nextLine();
//        System.out.print("\n Nhập điện thoại nhân viên:");
//        dt=sc.nextLong();
        do{
            System.out.print("\n Nhập hệ số lương nhân viên:");
            heSoLuong=sc.nextInt();
            if (heSoLuong<=0) {
                System.out.print("\n !!!hệ số lương phải lớn hơn 0.!!!");
            }
        }while(heSoLuong<=0);
        luong=luongCoBan*heSoLuong;
        sc.nextLine();
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
        
        String day;
        String[] arrday=new String[3];
        int  NgayThangNam=-1;//lưu trữ giá trị kiểm tra tính hợp lệ ngày nhập ,=1 thì nhập đúng ngày.
        do{
            do{
                System.out.print("\n nhập ngày sinh (dd/mm/yyyy):");
                day=sc.nextLine();
                if(day.split("/").length!=3)
                System.out.print("\n!!!!Bạn đã nhập ngày tháng sai !!!!."); 
            }while( day.split("/").length!=3);         
            arrday=day.split("/");
//         if(Integer.valueOf(arrday[0])>31||Integer.valueOf(arrday[0])<1)
//             System.out.print("\n !!!!!! ngày tháng không chính xác. !!!!!! ");
//        else if(Integer.valueOf(arrday[1])<1||Integer.valueOf(arrday[1])>12)
//                System.out.print("\n  !!!!!! ngày tháng không chính xác. !!!!!! ");
//        else if(Integer.valueOf(arrday[2])<=0)
//             System.out.print("\n !!!!!!  ngày tháng không chính xác. !!!!!! ");
          //  NgayThangNam=NgayHopLe(Integer.valueOf(arrday[0]), Integer.valueOf(arrday[1]), Integer.valueOf(arrday[2]));
           //  * //thay thế cho 2 hàm NanNhuan và NgayHopLe
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
           // * // 
            if(NgayThangNam==-1)
                System.out.print("\n  !!!!!! ngày tháng năm không chính xác. !!!!!! ");
        }while(NgayThangNam==-1);
//            while(Integer.valueOf(arrday[0])>31||Integer.valueOf(arrday[0])<1||
//                Integer.valueOf(arrday[1])<1||Integer.valueOf(arrday[1])>12||
//                Integer.valueOf(arrday[2])<=0 ); 
        ngaySinh=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
                Integer.valueOf(arrday[0]));
       // sc.nextLine();
        
    }
    /* //hai hàm này gây ra bị lỗi khi đọc file, vẫn không hiểu tại sao.
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
    } */
    @Override
    public void xuat(){
        System.out.printf("%-10s%-20s%-25s%-8s%-20s%-15d%-15.3f%-2d/%-2d/%-4d\n",
                maNV,this.getHoTen(),this.getDiaChi(),this.getGioiTinh(),chucVu,this.getDienThoai(),luong,ngaySinh.getDate(),
                (ngaySinh.getMonth()==0)?12:ngaySinh.getMonth(),
                (ngaySinh.getMonth()==0)?ngaySinh.getYear()-1:ngaySinh.getYear());
    }
//     public void Xuat(){
//        System.out.printf("%-7s%-15s%-15s%-5s%-10s%-12d%-10.3f,%-10s",
//                maNV,tenNV,diaChi,gt,chucVu,dt,luong,ngaySinh.toString());
//    }
//   test: NHANVIEN a=new NHANVIEN("sfsdf", "sdkf ksd", "dksd dsfk","dsf" , "xxxc",
//                351234, 344.687f,new Date(2002, 11,10) );//DateFormat.getDateInstance().parse("2001/29/11")
//        a.Xuat();
   
//    public float luong(){
//        return luongCoBan*heSoLuong;
//    }

    @Override
    public String toString() {
        return "NHANVIEN{" + "maNV=" + maNV +"hoTen=" + super.getHoTen() + 
                ", diaChi=" + super.getDiaChi() + ", gioiTinh=" + super.getGioiTinh() 
                + ", dienThoai=" + super.getDienThoai()+ ", chucVu=" + chucVu +
                ", heSoLuong=" + heSoLuong + ", ngaySinh=" + ngaySinh +", lương="+luong+ '}';
    }

   
    
 //   @Override

        public boolean equals(String obj){

           // if(obj instanceof NHANVIEN){
                String[] temp=(super.getHoTen()).split(" ");
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
		if (this.getLuong() == nv.getLuong())
			return 0;
		else if (this.getLuong() > nv.getLuong())
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
		if (s1.getNgaySinh().getYear() == s2.getNgaySinh().getYear())
                {	
                    if(s1.getNgaySinh().getMonth()==s2.getNgaySinh().getMonth())
                    {
                        if(s1.getNgaySinh().getDate()==s2.getNgaySinh().getDate())
                            return 0;
                        else
                            if(s1.getNgaySinh().getDate()>s2.getNgaySinh().getDate())
                                return 1;
                            else 
                                    return -1;
                    }
                    else                    
                        if(s1.getNgaySinh().getMonth()>s2.getNgaySinh().getMonth())
                            return 1;
                        else 
                            return -1;          
                }
		else 
                    if (s1.getNgaySinh().getYear() > s2.getNgaySinh().getYear())
			return 1;
                    else
			return -1;
	}

   
}
class NameComparator implements Comparator<NHANVIEN> {
        @Override
	public int compare(NHANVIEN s1, NHANVIEN s2) {
                String[] ten1=s1.getHoTen().split(" ");
                String[] ten2=s2.getHoTen().split(" ");
		return ten1[ten1.length-1].compareTo(ten2[ten2.length-1]);
	}
}