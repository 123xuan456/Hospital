package d.hospital.bean;

/**
 * Created by de on 2016/12/19.
 */
public class Inquiry_picBean {

    /**
     * code : 200
     * area1 : {"area1_big1":"http://192.168.0.56:8080/homepic/1-1.jpg","area1_big2":"http://192.168.0.56:8080/homepic/1-2.jpg","area1_big3":"http://192.168.0.56:8080/homepic/1-3.jpg"}
     * area2 : {"area2_left1":"http://192.168.0.56:8080/homepic/1-4.jpg","area2_left2":"http://192.168.0.56:8080/homepic/1-5.jpg","area2_right":"http://192.168.0.56:8080/homepic/2-1.jpg"}
     */

    private int code;
    /**
     * area1_big1 : http://192.168.0.56:8080/homepic/1-1.jpg
     * area1_big2 : http://192.168.0.56:8080/homepic/1-2.jpg
     * area1_big3 : http://192.168.0.56:8080/homepic/1-3.jpg
     */

    private Area1Bean area1;
    /**
     * area2_left1 : http://192.168.0.56:8080/homepic/1-4.jpg
     * area2_left2 : http://192.168.0.56:8080/homepic/1-5.jpg
     * area2_right : http://192.168.0.56:8080/homepic/2-1.jpg
     */

    private Area2Bean area2;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Area1Bean getArea1() {
        return area1;
    }

    public void setArea1(Area1Bean area1) {
        this.area1 = area1;
    }

    public Area2Bean getArea2() {
        return area2;
    }

    public void setArea2(Area2Bean area2) {
        this.area2 = area2;
    }

    public static class Area1Bean {
        private String area1_big1;
        private String area1_big2;
        private String area1_big3;

        public String getArea1_big1() {
            return area1_big1;
        }

        public void setArea1_big1(String area1_big1) {
            this.area1_big1 = area1_big1;
        }

        public String getArea1_big2() {
            return area1_big2;
        }

        public void setArea1_big2(String area1_big2) {
            this.area1_big2 = area1_big2;
        }

        public String getArea1_big3() {
            return area1_big3;
        }

        public void setArea1_big3(String area1_big3) {
            this.area1_big3 = area1_big3;
        }
    }

    public static class Area2Bean {
        private String area2_left1;
        private String area2_left2;
        private String area2_right;

        public String getArea2_left1() {
            return area2_left1;
        }

        public void setArea2_left1(String area2_left1) {
            this.area2_left1 = area2_left1;
        }

        public String getArea2_left2() {
            return area2_left2;
        }

        public void setArea2_left2(String area2_left2) {
            this.area2_left2 = area2_left2;
        }

        public String getArea2_right() {
            return area2_right;
        }

        public void setArea2_right(String area2_right) {
            this.area2_right = area2_right;
        }
    }
}
