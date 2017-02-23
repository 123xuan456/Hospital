package d.hospital.view;


import java.util.List;

public class Health_GridViewBean {
    private int code;

    private List<Message> message ;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMessage(List<Message> message){
        this.message = message;
    }
    public List<Message> getMessage(){
        return this.message;
    }

    public class Message {
        private int heaId;

        private String heaname;

        private String heaimg;

        public void setHeaId(int heaId){
            this.heaId = heaId;
        }
        public int getHeaId(){
            return this.heaId;
        }
        public void setHeaname(String heaname){
            this.heaname = heaname;
        }
        public String getHeaname(){
            return this.heaname;
        }
        public void setHeaimg(String heaimg){
            this.heaimg = heaimg;
        }
        public String getHeaimg(){
            return this.heaimg;
        }

    }

}
