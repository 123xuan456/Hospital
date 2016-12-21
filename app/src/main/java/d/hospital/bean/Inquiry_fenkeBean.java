package d.hospital.bean;

import java.util.List;

/**
 * Created by de on 2016/12/20.
 */
public class Inquiry_fenkeBean {


    /**
     * code : 200
     * message1 : [{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":1,"classId":1,"className":"儿科","doctorName":"老张"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":2,"classId":1,"className":"儿科","doctorName":"老刘"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":3,"classId":1,"className":"儿科","doctorName":"老李"}]
     * message2 : [{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":4,"classId":2,"className":"妇产科","doctorName":"老孙"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":5,"classId":2,"className":"妇产科","doctorName":"老习"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":6,"classId":2,"className":"妇产科","doctorName":"老常"}]
     */

    private int code;
    /**
     * doctorPic : http://192.168.0.56:8080/doctorpic/1-2.jpg
     * doctorId : 1
     * classId : 1
     * className : 儿科
     * doctorName : 老张
     */

    private List<Message1Bean> message1;
    /**
     * doctorPic : http://192.168.0.56:8080/doctorpic/1-2.jpg
     * doctorId : 4
     * classId : 2
     * className : 妇产科
     * doctorName : 老孙
     */

    private List<Message2Bean> message2;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Message1Bean> getMessage1() {
        return message1;
    }

    public void setMessage1(List<Message1Bean> message1) {
        this.message1 = message1;
    }

    public List<Message2Bean> getMessage2() {
        return message2;
    }

    public void setMessage2(List<Message2Bean> message2) {
        this.message2 = message2;
    }

    public static class Message1Bean {
        private String doctorPic;
        private int doctorId;
        private int classId;
        private String className;
        private String doctorName;

        public String getDoctorPic() {
            return doctorPic;
        }

        public void setDoctorPic(String doctorPic) {
            this.doctorPic = doctorPic;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }
    }

    public static class Message2Bean {
        private String doctorPic;
        private int doctorId;
        private int classId;
        private String className;
        private String doctorName;

        public String getDoctorPic() {
            return doctorPic;
        }

        public void setDoctorPic(String doctorPic) {
            this.doctorPic = doctorPic;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }
    }
}
