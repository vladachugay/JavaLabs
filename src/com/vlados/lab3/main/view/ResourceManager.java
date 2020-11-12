package com.vlados.lab3.main.view;

import java.util.Locale;
import java.util.ResourceBundle;

class ResourceManager {
    private static Locale locale;
    private static ResourceBundle resourceBundle;

    ResourceManager() {
        locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("resources/lang");
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public String getCountry() {
        return locale.getCountry();
    }

    public void setLocale(Locale locale) {
        ResourceManager.locale = locale;
        Locale.setDefault(locale);
        resourceBundle = ResourceBundle.getBundle("resources/lang");
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}

