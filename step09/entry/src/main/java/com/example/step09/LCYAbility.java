package com.example.step09;

import com.example.step09.slice.LCYAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class LCYAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(LCYAbilitySlice.class.getName());
        addActionRoute("lcy", "com.example.step09.slice.LCYAbilitySlice2");
    }
}
