package d.hospital.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by de on 2016/12/19.
 */
public class Inquiry_keshiBean implements Serializable {

    /**
     * code : 200
     * message : [{"classId":1,"className":"儿科"},{"classId":2,"className":"妇产科"},{"classId":3,"className":"泌尿外科、肛肠科、男科"},{"classId":4,"className":"中医科"},{"classId":5,"className":"皮肤性病科"},{"classId":6,"className":"全科"},{"classId":7,"className":"心理咨询科"},{"classId":8,"className":"营养科"},{"classId":9,"className":"普外科"},{"classId":10,"className":"骨科"},{"classId":11,"className":"心内科"},{"classId":12,"className":"普内科"},{"classId":13,"className":"呼吸内科"},{"classId":14,"className":"神经内科"},{"classId":15,"className":"消化内科"},{"classId":16,"className":"内分泌内科"},{"classId":17,"className":"眼科"},{"classId":18,"className":"耳鼻喉科"},{"classId":19,"className":"口腔科"},{"classId":20,"className":"风湿免疫科"},{"classId":21,"className":"神经外科"},{"classId":22,"className":"心理科"}]
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
         * classId : 1
         * className : 儿科
         */

        private int classId;
        private String className;

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public int getClassId() {
            return classId;
        }

        public String getClassName() {
            return className;
        }
    }
}
