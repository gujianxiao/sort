package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sort {
	public static void main(String[] args) throws IOException{
		File f = new File("E:\\sumsung.txt");
		BufferedReader input = new BufferedReader(new FileReader(f));
		String s;
		s=input.readLine();
        String[] data=s.split(";");
        int waitsort[]=new int[data.length];
//        for(int j=0;j<data.length;j++){
//        	int k=data[j].indexOf(":");
//            String pnum=data[j].substring(0,k);
//            int num=Integer.parseInt(pnum);
//
//        }
        Arrays.sort(data);
        Arrays.sort(data, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Pattern p = Pattern.compile("(\\d+):");
				Matcher m1 = p.matcher(o1);
				Matcher m2 = p.matcher(o2);
				m1.find();
				m2.find();
				
				int n1 = Integer.parseInt(m1.group(1));
				int n2 = Integer.parseInt(m2.group(1));
				if(n1 < n2) return -1;
				if(n1 == n2) return 0;
				return 1;
			}
        	
		});
        for(String a : data){
        	System.out.println(a);
        }
        for(int k=0;k<data.length;k++){
		File f1 = new File("E:\\sortsumsung.txt");
		if(f1.exists()){
			System.out.print("文件存在");
		}else{
			System.out.print("文件不存在");
			f1.createNewFile();//不存在则创建
		}
		BufferedReader input1 = new BufferedReader(new FileReader(f1));

		String n;
        String sortd=null;
		while((n = input1.readLine())!=null){
			sortd += n;//获取原字符串
		}
		input1.close();	
	    sortd+=data[k].substring(data[k].length()-1);
		BufferedWriter output = new BufferedWriter(new FileWriter(f1));
		sortd+=";";
		output.write(sortd);
		output.close();
        }
	
        
        
		}




}

