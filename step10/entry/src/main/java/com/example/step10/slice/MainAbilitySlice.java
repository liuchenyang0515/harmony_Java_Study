package com.example.step10.slice;

import com.zzrv5.mylibrary.ZZRCallBack;
import com.zzrv5.mylibrary.ZZRHttp;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.components.Text;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

public class MainAbilitySlice extends AbilitySlice {

    private DirectionalLayout myLayout = new DirectionalLayout(this);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        LayoutConfig config = new LayoutConfig(LayoutConfig.MATCH_PARENT, LayoutConfig.MATCH_PARENT);
        myLayout.setLayoutConfig(config);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(255, 255, 255));
        myLayout.setBackground(element);

        Text text = new Text(this);
        text.setLayoutConfig(config);
        text.setText("Hello World");
        text.setTextColor(new Color(0xFF000000));
        text.setTextSize(50);
        text.setTextAlignment(TextAlignment.CENTER);
        myLayout.addComponent(text);
        super.setUIContent(myLayout);
        text.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
//                String url = "https://www.baidu.com";
                String url = "https://zzrv5.github.io/test/zzr.html"; // 这个比较好看现象，百度的页面内容太长

                text.setText("正在请求网络，请稍后......");
                ZZRHttp.get(url, new ZZRCallBack.CallBackString() {
                    @Override
                    public void onFailure(int i, String s) {
                        text.setText("网络访问失败，请重试");
                    }

                    @Override
                    public void onResponse(String s) {
                        text.setText("服务器的内容为：" + s);
                    }
                });
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
