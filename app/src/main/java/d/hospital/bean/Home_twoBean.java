package d.hospital.bean;


import java.util.List;

public class Home_twoBean {
    private int code;

    private String date_today;
    private int userId;

    private EveryStepGetGold everyStepGetGold;

    private List<HealthPlan> healthPlan ;

    private Menstruation menstruation;

    private List<HotPost> hotPost ;

    private List<HealthInformation> healthInformation ;


    public void setDate_today(String date_today){
        this.date_today = date_today;
    }
    public String getDate_today(){
        return this.date_today;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setEveryStepGetGold(EveryStepGetGold everyStepGetGold){
        this.everyStepGetGold = everyStepGetGold;
    }
    public EveryStepGetGold getEveryStepGetGold(){
        return this.everyStepGetGold;
    }
    public void setHealthPlan(List<HealthPlan> healthPlan){
        this.healthPlan = healthPlan;
    }
    public List<HealthPlan> getHealthPlan(){
        return this.healthPlan;
    }
    public void setMenstruation(Menstruation menstruation){
        this.menstruation = menstruation;
    }
    public Menstruation getMenstruation(){
        return this.menstruation;
    }
    public void setHotPost(List<HotPost> hotPost){
        this.hotPost = hotPost;
    }
    public List<HotPost> getHotPost(){
        return this.hotPost;
    }
    public void setHealthInformation(List<HealthInformation> healthInformation){
        this.healthInformation = healthInformation;
    }
    public List<HealthInformation> getHealthInformation(){
        return this.healthInformation;
    }

    public class HealthInformation {
        private int articleId;

        private String articleTitle;

        private String articlePic;

        private String articleClass;

        private int browseTime;

        public void setArticleId(int articleId){
            this.articleId = articleId;
        }
        public int getArticleId(){
            return this.articleId;
        }
        public void setArticleTitle(String articleTitle){
            this.articleTitle = articleTitle;
        }
        public String getArticleTitle(){
            return this.articleTitle;
        }
        public void setArticlePic(String articlePic){
            this.articlePic = articlePic;
        }
        public String getArticlePic(){
            return this.articlePic;
        }
        public void setArticleClass(String articleClass){
            this.articleClass = articleClass;
        }
        public String getArticleClass(){
            return this.articleClass;
        }
        public void setBrowseTime(int browseTime){
            this.browseTime = browseTime;
        }
        public int getBrowseTime(){
            return this.browseTime;
        }

    }

    public class HotPost {
        private int userId;

        private String userPic;

        private String userName;

        private String content;

        private String date;

        private int likeNum;

        private int commentNum;

        public void setUserId(int userId){
            this.userId = userId;
        }
        public int getUserId(){
            return this.userId;
        }
        public void setUserPic(String userPic){
            this.userPic = userPic;
        }
        public String getUserPic(){
            return this.userPic;
        }
        public void setUserName(String userName){
            this.userName = userName;
        }
        public String getUserName(){
            return this.userName;
        }
        public void setContent(String content){
            this.content = content;
        }
        public String getContent(){
            return this.content;
        }
        public void setDate(String date){
            this.date = date;
        }
        public String getDate(){
            return this.date;
        }
        public void setLikeNum(int likeNum){
            this.likeNum = likeNum;
        }
        public int getLikeNum(){
            return this.likeNum;
        }
        public void setCommentNum(int commentNum){
            this.commentNum = commentNum;
        }
        public int getCommentNum(){
            return this.commentNum;
        }

    }

    public class HealthPlan {
        private String plan;

        private int status;

        public void setPlan(String plan){
            this.plan = plan;
        }
        public String getPlan(){
            return this.plan;
        }
        public void setStatus(int status){
            this.status = status;
        }
        public int getStatus(){
            return this.status;
        }

    }

    public class Menstruation {
        private String status;

        private String today;

        private String week;

        private String fromTo;

        private int howDay;

        private String tips;

        public void setStatus(String status){
            this.status = status;
        }
        public String getStatus(){
            return this.status;
        }
        public void setToday(String today){
            this.today = today;
        }
        public String getToday(){
            return this.today;
        }
        public void setWeek(String week){
            this.week = week;
        }
        public String getWeek(){
            return this.week;
        }
        public void setFromTo(String fromTo){
            this.fromTo = fromTo;
        }
        public String getFromTo(){
            return this.fromTo;
        }
        public void setHowDay(int howDay){
            this.howDay = howDay;
        }
        public int getHowDay(){
            return this.howDay;
        }
        public void setTips(String tips){
            this.tips = tips;
        }
        public String getTips(){
            return this.tips;
        }

    }

    public class EveryStepGetGold {
        private String text;

        private int step;

        private int calorie;

        private int fat;

        public void setText(String text){
            this.text = text;
        }
        public String getText(){
            return this.text;
        }
        public void setStep(int step){
            this.step = step;
        }
        public int getStep(){
            return this.step;
        }
        public void setCalorie(int calorie){
            this.calorie = calorie;
        }
        public int getCalorie(){
            return this.calorie;
        }
        public void setFat(int fat){
            this.fat = fat;
        }
        public int getFat(){
            return this.fat;
        }

    }

}
