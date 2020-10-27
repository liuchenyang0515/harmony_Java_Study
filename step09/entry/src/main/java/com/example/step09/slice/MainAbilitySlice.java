package com.example.step09.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
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
        text.setText("Hello World1");
        text.setTextColor(new Color(0xFF000000));
        text.setTextSize(50);
        text.setTextAlignment(TextAlignment.CENTER);
        myLayout.addComponent(text);


        text.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                Intent intent = new Intent();
                // 跳转Ability中指定action的其他slice
                intent.setAction("lcy");


//                跳转默认页的Slice
//                // 通过Intent中的OperationBuilder类构造operation对象，指定设备标识（空串表示当前设备）、应用包名、Ability名称
//                Operation operation = new Intent.OperationBuilder()
////                        .withDeviceId("")
//                        .withBundleName("com.example.step09")
//                        .withAbilityName(".LCYAbility") // 可省略包名，上面withBundleName已经指定
//                        .build();
//                // 把operation设置到intent中
//                intent.setOperation(operation);
                startAbility(intent);
            }
        });

        super.setUIContent(myLayout);
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
