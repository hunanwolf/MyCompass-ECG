package com.compassecg.test720.compassecg.unitl;

/**
 * Created by anim on 2016/6/l1.
 */
public class Connector {
    int cityid = 0;

    public static String hedaer = "http://120.26.141.238/syqapp/index.php/home/index/getHeaderImg/user_account/";
    public static String lll = "http://120.26.141.238/syqapp/";
    //接口网址
    public static String staticUrl = "http://192.168.1.178/ygxd/ygxd.php/";

    //论坛
    public static String Forum = staticUrl + "Forum/";
    public static String index = Forum + "index";  //论坛搜索
    public static String problemDetails = Forum + "problemDetails";  //帖子(论坛)详情
    public static String answerDetails = Forum + "answerDetails";  //回答详情
    public static String report = Forum + "report";  //举报—论坛&会诊
    public static String addProblem = Forum + "addProblem";  //添加问题
    public static String addAnswer = Forum + "addAnswer";  //添加回答(论坛、会诊)
    public static String delProblem = Forum + "delProblem";  //删除问题—论坛&会诊
    public static String delAnswer = Forum + "delAnswer";  //删除回答—论坛&会诊


}
