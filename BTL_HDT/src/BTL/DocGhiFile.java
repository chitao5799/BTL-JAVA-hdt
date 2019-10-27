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

/**
 *
 * @author NCT99
 * @param <T>
 */
public class DocGhiFile <T>{
   ArrayList<T> listDT=new ArrayList<>();//lưu danh sách các đối tượng kiểu T
   /*thêm private cho các thuộc tính của đối tượng nhưng trước đó đã ghi file mà không
   có private ở các thuộc tính đó thì khi đọc sẽ báo lỗi ,phải nhập và ghi file lại mới đọc được*/
    public ArrayList<T> getListDT() {
        return listDT;
    }

    public void setListDT(ArrayList<T> listDT) {
        this.listDT = listDT;
    }
    
  
    public void ghiFile(String filename) throws FileNotFoundException, IOException{
//          
             FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream out =new ObjectOutputStream(fout);
            out.writeObject(listDT);           
            out.close();
           fout.close();
        }
    public void docfile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fin =new FileInputStream(filename);
            ObjectInputStream obin =new ObjectInputStream(fin);           
            listDT=(ArrayList)obin.readObject();
            obin.close();fin.close();
            
        }
}
