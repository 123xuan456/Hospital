package d.hospital.bean;


import java.util.List;

public class Health_ListViewBean {
    private int code;

    private String hint;

    private List<ListForArea> listForArea ;

    private List<Result> result ;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setHint(String hint){
        this.hint = hint;
    }
    public String getHint(){
        return this.hint;
    }
    public void setListForArea(List<ListForArea> listForArea){
        this.listForArea = listForArea;
    }
    public List<ListForArea> getListForArea(){
        return this.listForArea;
    }
    public void setResult(List<Result> result){
        this.result = result;
    }
    public List<Result> getResult(){
        return this.result;
    }

    public class Result {
        private String imgurl;

        private List<Results> results ;

        public void setImgurl(String imgurl){
            this.imgurl = imgurl;
        }
        public String getImgurl(){
            return this.imgurl;
        }
        public void setResults(List<Results> results){
            this.results = results;
        }
        public List<Results> getResults(){
            return this.results;
        }

    }

    public class Results {
        private int id;

        private String img;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setImg(String img){
            this.img = img;
        }
        public String getImg(){
            return this.img;
        }

    }

    public class ListForArea {
        private String title;

        private List<ListForAreatitle> listForAreatitle ;

        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setListForAreatitle(List<ListForAreatitle> listForAreatitle){
            this.listForAreatitle = listForAreatitle;
        }
        public List<ListForAreatitle> getListForAreatitle(){
            return this.listForAreatitle;
        }

    }

    public class ListForAreatitle {
        private int id;

        private String img;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setImg(String img){
            this.img = img;
        }
        public String getImg(){
            return this.img;
        }

    }

}