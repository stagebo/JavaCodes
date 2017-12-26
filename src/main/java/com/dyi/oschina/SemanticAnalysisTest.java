package com.dyi.oschina;

import com.whos.sa.analysis.Analysis;

/**
 * 开源中古项目，
 */
public class SemanticAnalysisTest {
    public static void main(String[] args){
        Analysis an = new Analysis();
        String[] source = new String[]{
                "没有事 叫叫你而已"
                ,"我心情没有不好"
                ,"你走开，我又傻逼恐惧症"
                ,"你要这样想我也没办法"
                ,"你开心就好"
                ,"你开心就好’ 居然被分成了正面消息"
        };
        for(String s: source){
            System.out.println(""+s+": " + an.parse(s).getDisplay());
        }
    }
}
