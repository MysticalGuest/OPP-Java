package com.littleRedBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Program1 {
	
	static ArrayList<String> splitMsg(String text) {
        int MAX_SIZE = 20;
        char[] tempArray =new char[MAX_SIZE];
        int lastParagraphEnd=0,lastSentenceEnd=0 , pos=0,lastTextPos=0;
        ArrayList<String> ret =new ArrayList<>();
        char[] textChars = text.toCharArray();
        System.out.println(textChars);
        ArrayList<String> retArrayList = new ArrayList<>();
        int i =0;
        String s="";
        while (textChars[i]!='\0') {
        	s+=textChars[i];
        	if ('.' == textChars[i] || '!' == textChars[i]) {
				retArrayList.add(s);
				s="";
			}
		}

//        for (int textpos=0; textpos<textChars.length;) {
//            char c = textChars[textpos++];
//            tempArray[pos] = c ;
//            if (c == '\n'){
//                lastParagraphEnd = pos ;
//            }else if ('.' == c || '!' == c){
//                lastSentenceEnd = pos ;
//            }
//            pos++ ;
//        }
//        retArrayList.add();
        return retArrayList ;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;
        StringBuffer sb = new StringBuffer();
        while (in.hasNextLine()){
            String line = in.nextLine() ;
            if (line.length()==0)break;
            sb.append(line +"\n");
        }

        ArrayList<String> ret =new ArrayList<>();
//        res = splitMsg(sb.toString());
        ret = splitMsg(sb.toString());
//        for(int res_i=0; res_i < res.length; res_i++) {
//            System.out.println(String.format("msg%d:%s",res_i+1,res[res_i]));
//        }
        for(int res_i=0; res_i < ret.size(); res_i++) {
            System.out.println(String.format("msg%d:%s",res_i+1, ret.get(res_i)));
        }

    }

}
