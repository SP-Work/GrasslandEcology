package com.otitan.grasslandecology.bean;

import java.util.List;

/**
 * Created by sp on 2019/7/22.
 * 植物识别
 */
public class BaikePlant {

    private long log_id;

    private List<Result> result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {

        private double score;

        private String name;

        private Baike_info baike_info;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Baike_info getBaike_info() {
            return baike_info;
        }

        public void setBaike_info(Baike_info baike_info) {
            this.baike_info = baike_info;
        }

        public class Baike_info {

            private String baike_url;

            private String image_url;

            private String description;

            public String getBaike_url() {
                return baike_url;
            }

            public void setBaike_url(String baike_url) {
                this.baike_url = baike_url;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
