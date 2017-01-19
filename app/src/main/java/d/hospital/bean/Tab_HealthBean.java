package d.hospital.bean;

import java.util.List;

/**
 * Created by de on 2017/1/11.
 */
public class Tab_HealthBean {


    /**
     * healthheadlines : [{"id":1,"heatitle":"推荐"},{"id":2,"heatitle":"中医养生"},{"id":3,"heatitle":"减肥"},{"id":4,"heatitle":"常见病"},{"id":5,"heatitle":"女性"}]
     * code : 200
     */

    private int code;
    private List<HealthheadlinesBean> healthheadlines;

    public void setCode(int code) {
        this.code = code;
    }

    public void setHealthheadlines(List<HealthheadlinesBean> healthheadlines) {
        this.healthheadlines = healthheadlines;
    }

    public int getCode() {
        return code;
    }

    public List<HealthheadlinesBean> getHealthheadlines() {
        return healthheadlines;
    }

    public static class HealthheadlinesBean {
        /**
         * id : 1
         * heatitle : 推荐
         */

        private int id;
        private String heatitle;

        public void setId(int id) {
            this.id = id;
        }

        public void setHeatitle(String heatitle) {
            this.heatitle = heatitle;
        }

        public int getId() {
            return id;
        }

        public String getHeatitle() {
            return heatitle;
        }
    }
}
