/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;


import java.util.Scanner;

/**
 *
 * @author NCT99
 */
public class DSKH extends DocGhiFile<KHACHHANG>{//implements Serializable
   
    public void NhapDSKH(){
        int i,n;
        Scanner sc =new Scanner(System.in);
        System.out.print("\n nhập số lượng khách hàng:");
        n=sc.nextInt();
       // listDT;
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

        public int countElement(){
            return listDT.size();
        }
}
