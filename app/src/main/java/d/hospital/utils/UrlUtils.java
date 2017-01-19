package d.hospital.utils;

/**
 * 接口
 *
 */
public class UrlUtils {

  public static String BASEURL=" http://192.168.0.56:8080/";//本地测试
  public static String BASEURL1="http://192.168.0.43:8080/";//本地测试


 public static String HOME_UP_MODULE=BASEURL+"home/homepiclist";
    //问诊页面轮播图
 public static String INQUIRY_PIC=BASEURL+"askDoctor/pic";
    //问诊页面科室
 public static String INQUIRY_KESHI=BASEURL+"askDoctor/allDoctorClass";
    //问诊页面详情
 public static String INQUIRY_XIANGQING=BASEURL+"askDoctor/classForDoctor?classId=";
    //问诊页面分科
 public static String INQUIRY_FENKE=BASEURL+"askDoctor/showDoctor";
    //健康圈上标
 public static String HEALTH_CIRCLE_TAB=BASEURL1+"SafetyDoctor/healthheadlines/selectHealthheadlinestitle";
    //健康圈
 public static String HEALTH_CIRCLE=BASEURL1+"SafetyDoctor/healthheadlines/selectconditionHealthheadlines?id=";



}
