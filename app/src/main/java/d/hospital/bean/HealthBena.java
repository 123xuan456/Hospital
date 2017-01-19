package d.hospital.bean;

import java.util.List;

/**
 * Created by de on 2017/1/18.
 */
public class HealthBena {


    /**
     * theheadlines : [{"id":2,"heatitle":"电话费就给大家","img":[{"liimg":"http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg"}]},{"id":1,"heatitle":"日本av作品颁奖礼","img":[{"liimg":"http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg"},{"liimg":"http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg"},{"liimg":"http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg"}]}]
     * code : 200
     */

    private int code;
    private List<TheheadlinesBean> theheadlines;

    public void setCode(int code) {
        this.code = code;
    }

    public void setTheheadlines(List<TheheadlinesBean> theheadlines) {
        this.theheadlines = theheadlines;
    }

    public int getCode() {
        return code;
    }

    public List<TheheadlinesBean> getTheheadlines() {
        return theheadlines;
    }

    public static class TheheadlinesBean {
        /**
         * id : 2
         * heatitle : 电话费就给大家
         * img : [{"liimg":"http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg"}]
         */

        private int id;
        private String heatitle;
        private List<ImgBean> img;

        public void setId(int id) {
            this.id = id;
        }

        public void setHeatitle(String heatitle) {
            this.heatitle = heatitle;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public int getId() {
            return id;
        }

        public String getHeatitle() {
            return heatitle;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public static class ImgBean {
            /**
             * liimg : http://192.168.0.43:8080/SafetyDoctor/health/20170112152821.jpg
             */

            private String liimg;

            public void setLiimg(String liimg) {
                this.liimg = liimg;
            }

            public String getLiimg() {
                return liimg;
            }
        }
    }
}
