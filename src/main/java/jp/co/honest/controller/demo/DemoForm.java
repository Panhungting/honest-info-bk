package jp.co.honest.controller.demo;

import java.io.Serializable;

import lombok.Data;

@Data
// フォームクラス、画面から何か受け取る場合に定義
public class DemoForm implements Serializable {

    private static final long serialVersionUID = 1L;

    // 受け取る値の名前と一致させる
    private String title;
    private String price;
    private String summary;
}