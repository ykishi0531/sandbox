package com.example.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Date;
/**
 * 最初の画面関係の処理を行なうクラス
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 初期表示を行なう
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 初期設定
        super.onCreate(savedInstanceState);

        // 描画する画面のxmlを設定
        setContentView(R.layout.activity_main);

        // test 表示をする。
        String str = "test";

        TextView strTest = (TextView) findViewById(R.id.test);
        strTest.setText(str);
        // 現在日時を取得
       long millsec = System.currentTimeMillis();

        Date now = getSysDate(millsec);

        // 画面へセット
        TextView nowDate = (TextView) findViewById(R.id.now);
        nowDate.setText(now.toString());
    }

    /**
     * ミリ秒をDate型に変換する
     *
     * @param millsec
     * @return
     */
    private Date getSysDate(Long millsec) {
        Date now = new Date(millsec);

        return now;
    }

    //test
    // s\\ample
}
