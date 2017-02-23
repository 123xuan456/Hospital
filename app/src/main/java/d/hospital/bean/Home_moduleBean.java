package d.hospital.bean;


import java.util.List;

public class Home_moduleBean {
    private int code;

    private String healthNews;

    private List<Area1> area1 ;

    private List<Area2> area2 ;

    private List<Area3> area3 ;

    private List<Area4> area4 ;

    private List<HealthTest> healthTest ;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setHealthNews(String healthNews){
        this.healthNews = healthNews;
    }
    public String getHealthNews(){
        return this.healthNews;
    }
    public void setArea1(List<Area1> area1){
        this.area1 = area1;
    }
    public List<Area1> getArea1(){
        return this.area1;
    }
    public void setArea2(List<Area2> area2){
        this.area2 = area2;
    }
    public List<Area2> getArea2(){
        return this.area2;
    }
    public void setArea3(List<Area3> area3){
        this.area3 = area3;
    }
    public List<Area3> getArea3(){
        return this.area3;
    }
    public void setArea4(List<Area4> area4){
        this.area4 = area4;
    }
    public List<Area4> getArea4(){
        return this.area4;
    }
    public void setHealthTest(List<HealthTest> healthTest){
        this.healthTest = healthTest;
    }
    public List<HealthTest> getHealthTest(){
        return this.healthTest;
    }

    public class HealthTest {
        private String healthtest_1;

        private String healthtest_2;

        public void setHealthtest_1(String healthtest_1){
            this.healthtest_1 = healthtest_1;
        }
        public String getHealthtest_1(){
            return this.healthtest_1;
        }
        public void setHealthtest_2(String healthtest_2){
            this.healthtest_2 = healthtest_2;
        }
        public String getHealthtest_2(){
            return this.healthtest_2;
        }

    }

    public class Area4 {
        private String picUrl4;

        public void setPicUrl4(String picUrl4){
            this.picUrl4 = picUrl4;
        }
        public String getPicUrl4(){
            return this.picUrl4;
        }

    }

    public class Area3 {
        private String picUrl3;


        public void setPicUrl3(String picUrl3){
            this.picUrl3 = picUrl3;
        }
        public String getPicUrl3(){
            return this.picUrl3;
        }


    }

    public class Area2 {
        private String picUrl2;

        public void setPicUrl2(String picUrl2){
            this.picUrl2 = picUrl2;
        }
        public String getPicUrl2(){
            return this.picUrl2;
        }

    }

    public class Area1 {
        private String picUrl1;

        public void setPicUrl1(String picUrl1){
            this.picUrl1 = picUrl1;
        }
        public String getPicUrl1(){
            return this.picUrl1;
        }

    }

}
