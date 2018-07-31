package com.delabassee;

import java.util.*;

public class Country {

        private String iso;
        private String code;
        private String name;

        Country(String iso, String code, String name) {
            this.iso = iso;
            this.code = code;
            this.name = name;
        }

        public String getIso() {
            return iso;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return iso + " - " + code + " - " + name;
        }


    public static String getNameByCode(String countryCode) {

        String[] isoCountries = Locale.getISOCountries();
        String upperCode = countryCode.toUpperCase();

        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            if (country.equals(upperCode)) {
                return locale.getDisplayCountry();
            }
        }
        return "not found";
    }


    public static String getCodeByName(String countryName) {

        String[] isoCountries = Locale.getISOCountries();
        String upperName = countryName.toUpperCase();

        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            if (locale.getDisplayCountry().toUpperCase().equals(upperName)) {
                return locale.getCountry();
            }
        }
        return "not found";
    }


    public static List<Country> getAll() {

        List<Country> countries = new ArrayList<Country>();
        String[] isoCountries = Locale.getISOCountries();

        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
            String iso = locale.getISO3Country();
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
                countries.add(new Country(iso, code, name));
            }
        }
        return countries;

    }


}