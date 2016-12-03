package com.example.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        // もじ表示をする
        String str2 = "happyturn";
        TextView str2Test = (TextView) findViewById(R.id.happyturn);
        str2Test.setText(str2);
        //すうじじょうじ
        int suuji = 123;
        TextView intTest = (TextView) findViewById(R.id.suuji);
        intTest.setText(String.valueOf(suuji));

        // 現在日時を取得
        long millsec = System.currentTimeMillis();

        Date now = getSysDate(millsec);

        // 画面へセット
        TextView nowDate = (TextView) findViewById(R.id.now);
        nowDate.setText(now.toString());

        // ボタンクリック時のイベントを設定する
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                // ボタンがクリックされたときのイベントを書いていく
                TextView nowDate = (TextView) findViewById(R.id.now);
                nowDate.setText(String.valueOf(++count));

            }
        });

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
