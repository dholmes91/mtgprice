package com.aca.mtgprice.model;

public enum Code {
    MID, VOW, NEO, SNC, DMU, BRO, ONE, MOM, MAT, WOE, WOT, LCI, MKM, OTJ, BIG, OTP;

    public static Code convertStringToSet(String value) {
        Code myCode = null;

        for (Code code : Code.values()) {
            if (code.toString().equalsIgnoreCase(value)) {
                myCode = code;
                break;
            }
        }
        return myCode;
    }

}
