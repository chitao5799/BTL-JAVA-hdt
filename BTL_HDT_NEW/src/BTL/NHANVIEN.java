/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;



import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
//import java.util.function.ToIntFunction;


/**
 *
 * @author NCT99
 */
public class NHANVIEN extends PerSon implements Comparable<NHANVIEN>,Serializable{
    private static final long serialVersionUID=123456L;
    private String maNV,chucVu;   
    private static float luongCoBan=1100.0f;
    private int heSoLuong;
    private Date ngaySinh;
    private float luong;
    public NHANVIEN() {
        super();
        //luongCoBan=;
      
    }
    public NHANVIEN(float lcb){
        luongCoBan=lcb;
    }


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
    
    @Override
    public String getMa() {
        return maNV;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    
    @Override
    public void setMa(String maNV) {
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

        System.out.print("\n Nhập chức vụ nhân viên:");
        chucVu=sc.nextLine();

        do{
                 System.out.print("\n Nhập hệ số lương nhân viên:");    
            try {
                heSoLuong=sc.nextInt();                
                sc.nextLine();
                if (heSoLuong<=0) {
                System.out.print("\n !!!hệ số lương phải lớn hơn 0.!!!");
                }
            } catch (Exception e) {                
                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
                sc.nextLine();
            }     
            
        }while(heSoLuong<=0);
        luong=luongCoBan*heSoLuong;
        sc.nextLine();

        String day;
        String[] arrday=new String[3];
      //lưu trữ giá trị kiểm tra tính hợp lệ ngày nhập ,=1 thì nhập đúng ngày.
       boolean NgayThangNam=false;
        do{
            do{
                System.out.print("\n nhập ngày sinh (dd/mm/yyyy):");
                day=sc.nextLine();
                if(day.split("/").length!=3)
                System.out.print("\n!!!!Bạn đã nhập ngày tháng sai !!!!."); 
            }while( day.split("/").length!=3);         
            arrday=day.split("/");
            NgayThangNam=NgayHopLe(Integer.valueOf(arrday[0]), Integer.valueOf(arrday[1]), Integer.valueOf(arrday[2]));

            if(NgayThangNam==false)
                System.out.print("\n  !!!!!! ngày tháng năm không chính xác. !!!!!! ");
        }while(NgayThangNam==false);

        ngaySinh=new Date(Integer.valueOf(arrday[2]),Integer.valueOf(arrday[1]),
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
    }/* */
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
   
    @Override
    public String toString() {
        return "NHANVIEN{" + "Mã Nhân Viên=" + maNV +super.toString()+ ", Chức vụ=" + chucVu +", Hệ Số Lương=" + heSoLuong 
                + ", Ngày Sinh=" + ngaySinh.getDate()+"/"+ ((ngaySinh.getMonth()==0)?12:ngaySinh.getMonth())+"/"+
               ((ngaySinh.getMonth()==0)?ngaySinh.getYear()-1:ngaySinh.getYear())+", lương="+luong+ '}';
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
class NameNgaysinhLuong implements Comparator<NHANVIEN>{
    @Override
    public int compare(NHANVIEN nv1,NHANVIEN nv2){
         String[] ten1=nv1.getHoTen().split(" ");
         String[] ten2=nv2.getHoTen().split(" ");
        int value1= ten1[ten1.length-1].compareTo(ten2[ten2.length-1]);
        if(value1==0)
        {
            int value2=nv1.getNgaySinh().compareTo(nv2.getNgaySinh());
            if(value2==0)
            {
                if (nv1.getLuong() == nv2.getLuong())
			return 0;
		else if (nv1.getLuong() > nv2.getLuong())
			return 1;
		else
			return -1;
            }
            else return value2;
        }
        return value1;
    }
//    @Override
//    public Comparator<NHANVIEN> thenComparing(Comparator<? super NHANVIEN> ngaySinh){
//        return Comparator.super.thenComparing(ngaySinh);
//    }
//    @Override
//    public Comparator<NHANVIEN> thenComparingInt(ToIntFunction<? super NHANVIEN> luong){
//        return Comparator.super.thenComparingInt(luong);
//    }
}