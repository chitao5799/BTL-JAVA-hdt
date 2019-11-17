///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package BTL;
//
//import java.util.Scanner;
//
///**
// *
// * @author NCT99
// */
//public class DSChiTietHD extends DocGhiFile<ChiTietHoaDon>{
//  
//    public void nhap(DSHD dshd,DSSP dssp){
//        int soLuongHD=-1;
//        Scanner sc =new Scanner(System.in);
//        
//        
//         do{
//           System.out.print("\n Nhập số lượng chi tiết hóa đơn.");
//            
//            try {
//                soLuongHD=sc.nextInt();
//                sc.nextLine();
//                if(soLuongHD <= 0)
//                System.out.print("\n !!!!!! SỐ LƯỢNG PHẢI LỚN HƠN 0. !!!!!! ");
//                
//            } catch (Exception e) {                
//                System.out.print("\n!!!Lỗi: "+e.toString()+" ; phải nhập số nguyên.");                                      
//                sc.nextLine();
//            }
//        }while (soLuongHD <=  0); 
//        
//        for (int i = 0; i < soLuongHD; i++) {
//            ChiTietHoaDon cthd=new ChiTietHoaDon();
//            cthd.nhapCTHD(dssp, dshd);
//            int dung=1; //=1 là nhập đúng dữ liệu.
//            ChiTietHoaDon temporery=new ChiTietHoaDon();
//            for (int j = 0; j < listDT.size(); j++) {
//                    temporery=listDT.get(j);
//                    if(temporery.getMaSP().equals(cthd.getMaSP()) && temporery.getMaHD().equals(cthd.getMaHD()))
//                        {
//                            System.out.print("\n!!!Wrong. Bạn đã nhập trùng mã hóa đơn và mã sản phẩm 2 lần.!!!");
//                            System.out.print("\n *** Bản ghi này sẽ bị loại bỏ. Mời nhập lại.***");
//                            dung=-1;break;
//                        }
//                }
//            if(dung==1)
//             listDT.add(cthd);
//        }
//    }
//    public void xuat(){
//        System.out.print("\nDanh sách chi tiết hóa đơn.");
//        System.out.format("\n%-10s%-10s%-10s%-10s%-15s","Mã HD","Mã SP","số lượng","giảm giá","thành tiền");
//        for (ChiTietHoaDon xChiTietHoaDon : listDT) {
//            xChiTietHoaDon.xuat();
//        }
//    }
//
//    public void add1CTHD(DSHD dshd,DSSP dssp){
//        ChiTietHoaDon cthd=new ChiTietHoaDon();
//            cthd.nhapCTHD(dssp, dshd);
//            int dung=1; //=1 là nhập đúng dữ liệu.
//            ChiTietHoaDon temporery=new ChiTietHoaDon();
//            for (int j = 0; j < listDT.size(); j++) {
//                    temporery=listDT.get(j);
//                    if(temporery.getMaSP().equals(cthd.getMaSP()) && temporery.getMaHD().equals(cthd.getMaHD()))
//                        {
//                            System.out.print("\n!!!Wrong. Bạn đã nhập trùng mã hóa đơn và mã sản phẩm 2 lần.!!!");
//                            System.out.print("\n *** Bản ghi này sẽ bị loại bỏ. Mời nhập lại.***");
//                            dung=-1;break;
//                        }
//                }
//            if(dung==1)
//             listDT.add(cthd);
//    }
//    public int countElement() {
//        return listDT.size();
//    }
//}
