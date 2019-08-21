package com.otitan.grasslandecology.bean;

import java.util.List;

/**
 * Created by sp on 2019/7/23.
 * 文字识别
 */
public class BaikeText {

    private long log_id;

    private int words_result_num;

    private List<Words_result> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<Words_result> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<Words_result> words_result) {
        this.words_result = words_result;
    }

    public class Words_result {

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
