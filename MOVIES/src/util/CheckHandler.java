package util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckHandler {
    //检查用户下拉菜单项
    public static  int getSelectIndexById(int roleId){//管理权限的选择
        int i = 0;

        while(i<Constant.userRoleIds.length){
            if (Constant.userRoleIds[i]==roleId){
                return i;
            }
            i++;
        }//循环查询
        return -1;
        //如果没有就返回-1

    }

    //取下拉菜单编号
    public static int getCbIndex(String value, String[] arr){//传入目标值，查询数组
        int i = 0;
        while (i<arr.length){
            if (arr[i].equals(value)){
                return i;
            }
            i++;
        }

        return   -1;
    }

    //输入框是否为空
    //传入List<JTextField> ,检查每个数列，去除空格后长度是否为空
    public static boolean checkEmptyField(List<JTextField> textFields){
        for (JTextField x  : textFields){
            if(x.getText().trim().length() ==0){
                return true;//存在空值
            }
        }//遍历

        return false;//没有空值
    }


    //获取订单座位
    public static List<String> getSeats(String orderData){
        List<String> usedSeats =new ArrayList<String>();
        System.out.println(orderData);
        if (orderData.length()>0){
            System.out.println();
            String[] tickets = orderData.split(  "  ;  "  );
            for (String t:tickets){
                String[] ticketMeta = t.split(  "  \\|  "  );
                usedSeats.add(ticketMeta[0]);
            }//
        }//订单
        return usedSeats;
    }

    //输入是否为数字
    public static boolean isNumeric(String str){
        return str != null && str.matches(  "  [-+]?\\d*\\.?\\d+  "  );
    }

    //输入是含有数字
    public static boolean containsDigit(String str){
        boolean flag= false;
        Pattern pattern  = Pattern.compile(  "  .*\\d+.*  "  );
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            flag  = true;
        }

        return flag;
    }



    //是否含字母
    public static boolean containsChar(String str){
        String regex=  "  .*[a-zA-Z]+.*  "  ;
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.matches();
    }


    //输入是否为整数
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }catch (NullPointerException e){
            return false;
        }
        //到这里不报错则输入为整数

        return  true;

    }


    //是否为电话号码
    public static boolean isValidMobile(String str){
        Pattern pattern =Pattern.compile(  "  ^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$  "  );
        Matcher m = pattern.matcher(str);
        boolean idValid = false;
        idValid = m.matches();
        return  idValid;
    }



    //获取页面html展示订单
    public static String showOrder(String orderData){
        //订单为空，返回“ ”
        if (orderData.length()==0){
            return   "    "  ;
        }
        //html 首行标签 ，
        String outHtml =   "  <tr><th>放映场次</th><th>电影名称</th><th>时间</th><th>座位</th></tr>  "  ;
        String[] tickers = orderData.split(  ";"  );
        for (String t : tickers){
            String[] tMeta = t.split(  "\\|"  );
            String[] seat = tMeta[0].split(  " "  );
            String[] seatMeta = seat[1].split(  " , "  );
            outHtml +=  "  <tr><td>  "  +seat[0]+  "  </td><td>  "  
                    +tMeta[1]+  "  </td><td>  "  
                    +tMeta[2]+  "  </td><td>  "  
                    +seatMeta[0]+  "  行  "  
                    +seatMeta[1]+  "  列</td></tr>  "  ;

        }//每个订单
        outHtml =   "  <html><table border = 1>  "  +outHtml+  "  </table></html>  "  ;
        return outHtml;
    }



}
