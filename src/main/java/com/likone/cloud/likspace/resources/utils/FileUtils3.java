package com.likone.cloud.likspace.resources.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By 灵控智能
 * Copyright: Copyright(C) 2017-2019
 * Company 湖南灵控智能科技有限公司
 *
 * @author 刘金妮
 * @version 1.0
 * @date 2020/2/6 10:16
 * @Description jpa-day01
 */
public class FileUtils3 {
    public static void main(String[] args) {
        List<String> listOne = new ArrayList<String>();
        try {
            String filepath = "C:\\Users\\Likone002\\Desktop\\likone_space_product\\likspace-cloud-product\\src\\main\\java\\com\\likone\\cloud\\likspace\\product\\controller";
            File file = new File(filepath);
            String[] list = file.list();
            File[] files1 = file.listFiles();

            for (File f : files1){

                if(f.isDirectory()){
                    File[] files2 = f.listFiles();
                    for(File dir : files2){
                        String strFile = dir + "";
                        if(strFile.contains(".java")){
                            listOne.add(strFile);
                        }
                    }
                }else{
                    String strFile = f + "";
                    if(strFile.contains(".java")){
                        listOne.add(strFile);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        int arrsIndex = 0;
        List<String> ch = ch(listOne.size());
        for(String strFile : listOne){
//            System.out.println(strFile);
            File dirFile = new File(strFile);
            BufferedReader br = null;
            BufferedWriter bw = null;
            try {
                br = new BufferedReader(new FileReader(strFile));
                bw = new BufferedWriter(new FileWriter("C:\\Users\\Likone002\\Desktop\\cloudproduct.md",true));
                String lineString = null;
                String a = "";
                int i = 0;
                String fileStr = dirFile.getName().toString().trim();
                String fileStrName = fileStr.substring(0,fileStr.length()-6);
                bw.write("## "+ch.get(arrsIndex)+"、"+fileStrName);
                arrsIndex++;
                bw.newLine();
                while (true) {

                    lineString = br.readLine();

                    if(lineString == null){
                        break;
                    }

                    if(!(lineString.length() == 0 || "".equals(lineString))){

                        String str = lineString.trim();
                        if(str.length() >= 2){
                            if(str.length() == 2 && "})".equals(str.substring(0,2))){
                                bw.write("* "+str);
                                bw.newLine();
                            }else if(str.length() > 9 &&
                                    ("@ApiO".equals(str.substring(0,5)) ||
                                    "@ApiI".equals(str.substring(0,5)) ||
                                    "@Get".equals(str.substring(0,4)) ||
                                    "@Pos".equals(str.substring(0,4)) ||
                                    "@Response".equals(str.substring(0,9)) ||
                                    "@RequestM".equals(str.substring(0,9)))){
                                boolean bool = false;
                                String e = "";

                                if(str.length() < 50 && "@RequestM".equals(str.substring(0,9))){
                                    if(str.contains("=")){
                                        String v = str.split("=")[1].trim();
                                        String h = v.substring(1,v.length()-2);
                                        int indexOfs = h.indexOf("/");
                                        if(indexOfs != 0){
                                            a = "/" + h;
                                        }else{
                                            a = h;
                                        }
                                    }else{
                                        String v = str.split("Mapping")[1];
                                        String h = v.substring(2,v.length()-2);
                                        int indexOfs = h.indexOf("/");
                                        if(indexOfs != 0){
                                            a = "/" +  h;
                                        }else{
                                            a = h;
                                        }
                                    }
                                }
                                if(str.length() > 50 && "@RequestM".equals(str.substring(0,9))){
                                    String[] split = str.split(",");
                                    String d = "";
                                    String c = "";
                                    if(split[0].contains("value")){
                                        d = split[0].trim();
                                        String b = d.split("=")[1].trim();
                                        c = b.substring(1,b.length()-1);
                                    }else{
                                        d = split[1].trim();
                                        String b = d.split("=")[1].trim();
                                        c = b.substring(1,b.length()-2);
                                    }
                                    int indexOfs = c.indexOf("/");
                                    if(indexOfs != 0){
                                        e = "/" + c;
                                    }else{
                                        e = c;
                                    }
                                    if(split[0].contains("value")){
                                        d = split[0];
                                        String[] b = d.split("=");
                                        str = b[0]+"= \""+a+e+"\","+split[1];
                                    }else{
                                        d = split[1];
                                        String[] b = d.split("=");
                                        str = split[0]+","+b[0]+"= \""+a+e+"\")";
                                    }
                                    bool = true;
                                    i++;
                                }
                                if("@Get".equals(str.substring(0,4)) ||
                                        "@Pos".equals(str.substring(0,4))){
                                    if(str.contains("=")){
                                        String stra = str.split("=")[1].trim();
                                        String strb = stra.substring(1,stra.length()-2);
                                        int indexOfs = strb.indexOf("/");
                                        if(indexOfs != 0){
                                            e = "/" + strb;
                                        }else{
                                            e = strb;
                                        }
                                        str = str.split("=")[0]+"= \""+a+e+"\")";
                                    }else{
                                        String split = str.split("Mapping")[1];
                                        String b = split.substring(2,split.length()-2);
                                        int indexOfs = b.indexOf("/");
                                        if(indexOfs != 0){
                                            e = "/" + b;
                                        }else{
                                            e = b;
                                        }
                                        str = str.split("Mapping")[0]+"Mapping123\\("+"\""+a+e+"\")";
                                    }
                                    int i1 = str.indexOf("123");
                                    if(i1 != -1){
                                        String[] split = str.split("123");
                                        str = split[0]+split[1].substring(1,split[1].length());
                                    }

                                    bool = true;
                                    i++;
                                }
                                if(!(str.length() < 50 && "@RequestM".equals(str.substring(0,9)))){
                                    if(bool){
                                        bw.write("* "+str);
                                        bw.newLine();
                                        bw.write("### "+i+". "+a+e);
                                        bool = false;
                                    }else{
                                        bw.write("* "+str);
                                    }
                                }

                                bw.newLine();
                            }else if(str.length() > 6 && "public".equals(str.substring(0,6))){
                                bw.write("\n");
                                bw.write("\n");
                                bw.newLine();
                            }
                    }
                }}
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    bw.close();
                    br.close();
                } catch (IOException e) {
                }
            }
        }

    }

    public static List<String> ch(int a){
        List<String> list = list = ch1(a);
        if(a >= 100){
            for(int i = 0; i < a-100; i++){
                if(i >= 0 && i < 10){
                    list.add("一百零"+list.get(i));
                }else{
                    list.add("一百"+list.get(i));
                }
            }
        }
        return list;
    }

    public static List<String> ch1(int a){
        String[] arrs = {"一","二","三","四","五","六","七","八","九","十"};
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < arrs.length; i++){
            list.add(arrs[i]);
        }
        if(a > 10){
            if(a > 100){
                a = 99;
            }
            int num1 = a / 10;//十位
            for(int i = 0; i < num1; i++){
                for(int j = 0; j < 10; j++){
                    if (i == 0) {
                        if (j == 9) {
                            list.add(arrs[i + 1] + arrs[9]);
                        } else {
                            list.add(arrs[9] + arrs[j]);
                        }
                    } else {
                        if (j == 9) {
                            list.add(arrs[i + 1] + arrs[9]);
                        } else {
                            list.add(arrs[i] + arrs[9] + arrs[j]);
                        }
                    }

                }
            }
        }
        if(list.size() == 100){
            list.remove(99);
            list.add("一百");
        }
        return list;
    }
}
