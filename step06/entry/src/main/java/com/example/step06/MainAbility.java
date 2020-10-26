package com.example.step06;

import com.example.step06.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbility extends Ability {
    public static final HiLogLabel HI_LOG_LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00104, "MainAbility");
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        HiLog.info(HI_LOG_LABEL, "onStart(Intent intent) 被调用");
    }
}
