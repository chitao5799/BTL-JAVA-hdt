# Bài tập lớn môn lập trình hướng đối tượng - ngôn ngữ java
- có 2 forder là :BTL-HDT và BTL-HDT-NEW


======code để xóa màn hình console output trong netbean
'''java
public void cls(){
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key. 
        } catch (AWTException ex) {
            System.out.println("LỖi" + ex.getMessage());
        }
    }
    '''
    =======ép kiểu để dùng phương thức của 1 lớp con nào đấy trong đa hình.
    ví dụ:
    public class SP_ThoiTrang extends SANPHAM {  }
    
    -----
     ArrayList<SANPHAM> listDsSp =new ArrayList<>();
     
            ---
            SP_ThoiTrang x =new H_SP_ThoiTrang();
            x.nhap();
            listDsSp.add(x);
            ---
      ---       
    public void SapXepTheoSize(){
        for (int i = 0; i < listDsSp.size(); i++) {
                    for (int j = (i + 1); j < listDsSp.size(); j++) {
                        if(((SP_ThoiTrang)listDsSp.get(i)).getSize()> ((SP_ThoiTrang)listDsSp.get(j)).getSize()){
                            SP_ThoiTrang tg = (SP_ThoiTrang)listDsSp.get(i);
                            listDsSp.set(i, listDsSp.get(j)); 
                            listDsSp.set(j, tg);
                        }
                    }
                }
        this.xuat();
    }
