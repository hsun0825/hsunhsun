

//Ū�J�@��txt��, �g�X�@��txt��, ��try...catch�������~
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.*;

class ReadTxt {
    public static void main(String[] args) throws Exception{
        // �ŧi��J�ο�X�ܼ�
        BufferedReader br = null;
        BufferedWriter bw = null;        

        //------------------------------------------
        try{
            // �إߤ@���ɮ�Ū���μg�X����      
            br = new BufferedReader(new FileReader(new File("D:\\testout.txt")));   
            bw = new BufferedWriter(new FileWriter(new File("D:\\out.txt")));        

            // �v��Ū�J�ɮפ��e
            //---------------------
            String line; 
            boolean firstLine = true;                
            
            while ((line = br.readLine()) != null) {            
                // ���Ū�J���e          
                System.out.println(line);

                // �N���e�g�X�ɮ�
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
            System.out.println("�o�Ϳ��~, ��]: " + e);
            return;           
        }finally{
            // ����reader
            if(br != null){
                br.close(); 
            } 
            
            // ����writer, �j���X���g�X���Ȧs���e
            if(bw != null){
                bw.close(); 
            }    
        }  
        //------------------------------------------        
    }
} 


////�z�i�H�ϥ�BufferedReader�� �O�A���Ojava.io�M�� ���Ҵ��Ѫ��@�����O�A
//�ҥH�ϥγo�����O�ɥ�����import java.io�M��F
//�ϥ�BufferedReader����readLine()��k�����B�zIOException�ҥ~ �]exception�^�A
//�ҥ~�B�z����OJava�� �ѵ��{���]�p�H�������{�����i��o�ͪ����~�Ҵ��Ѫ�����A
//�{���q�z�B�zIOException����k�O�bmain()��k��A
//�[�W throws IOException�A�o�b�H��|�A�ԲӰQ�׬���n�o��@�C