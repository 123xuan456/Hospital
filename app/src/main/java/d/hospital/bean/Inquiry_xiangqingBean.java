package d.hospital.bean;

import java.util.List;

/**
 * Created by de on 2016/12/26.
 */
public class Inquiry_xiangqingBean {

    /**
     * code : 200
     * message : [{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":4,"classId":2,"className":"妇产科","doctorName":"老孙","doctorGoodAt":"治病"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":5,"classId":2,"className":"妇产科","doctorName":"老习","doctorGoodAt":"治病"},{"doctorPic":"http://192.168.0.56:8080/doctorpic/1-2.jpg","doctorId":6,"classId":2,"className":"妇产科","doctorName":"老常","doctorGoodAt":"治病"}]
     */

    private int code;
    private List<MessageBean> message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(List<MessageBean> message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    public static class MessageBean {
        /**
         * doctorPic : http://192.168.0.56:8080/doctorpic/1-2.jpg
         * doctorId : 4
         * classId : 2
         * className : 妇产科
         * doctorName : 老孙
         * doctorGoodAt : 治病
         */

        private String doctorPic;
        private int doctorId;
        private int classId;
        private String className;
        private String doctorName;
        private String doctorGoodAt;

        public void setDoctorPic(String doctorPic) {
            this.doctorPic = doctorPic;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public void setDoctorGoodAt(String doctorGoodAt) {
            this.doctorGoodAt = doctorGoodAt;
        }

        public String getDoctorPic() {
            return doctorPic;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public int getClassId() {
            return classId;
        }

        public String getClassName() {
            return className;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public String getDoctorGoodAt() {
            return doctorGoodAt;
        }
    }
}
