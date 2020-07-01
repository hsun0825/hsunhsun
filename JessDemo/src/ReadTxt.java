

//讀入一個txt檔, 寫出一個txt檔, 用try...catch捕捉錯誤
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.*;

class ReadTxt {
    public static void main(String[] args) throws Exception{
        // 宣告輸入及輸出變數
        BufferedReader br = null;
        BufferedWriter bw = null;        

        //------------------------------------------
        try{
            // 建立一個檔案讀取及寫出物件      
            br = new BufferedReader(new FileReader(new File("D:\\testout.txt")));   
            bw = new BufferedWriter(new FileWriter(new File("D:\\out.txt")));        

            // 逐行讀入檔案內容
            //---------------------
            String line; 
            boolean firstLine = true;                
            
            while ((line = br.readLine()) != null) {            
                // 顯示讀入內容          
                System.out.println(line);

                // 將內容寫出檔案
                if(firstLine){
                    bw.write(line);
                    firstLine=false;
                }else{
                    bw.write(("\n"));
                    bw.write(line);                
                }  
            } 
            //---------------------
        }catch(IOException e){
            System.out.println("發生錯誤, 原因: " + e);
            return;           
        }finally{
            // 關閉reader
            if(br != null){
                br.close(); 
            } 
            
            // 關閉writer, 強制輸出未寫出的暫存內容
            if(bw != null){
                bw.close(); 
            }    
        }  
        //------------------------------------------        
    }
} 


////您可以使用BufferedReader類 別，它是java.io套件 中所提供的一個類別，
//所以使用這個類別時必須先import java.io套件；
//使用BufferedReader物件的readLine()方法必須處理IOException例外 （exception），
//例外處理機制是Java提 供給程式設計人員捕捉程式中可能發生的錯誤所提供的機制，
//現階段您處理IOException的方法是在main()方法後，
//加上 throws IOException，這在以後會再詳細討論為何要這麼作。