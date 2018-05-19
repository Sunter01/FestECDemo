package com.sunter.latte.app;

import java.util.HashMap;

public class Configurator {
    //不使用的时候自动回收   static final名字大写_分隔
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }
}
