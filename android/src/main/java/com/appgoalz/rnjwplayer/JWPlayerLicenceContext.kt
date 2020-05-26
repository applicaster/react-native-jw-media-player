package com.appgoalz.rnjwplayer

import com.facebook.react.bridge.*
import com.longtailvideo.jwplayer.license.LicenseUtil


class JWPlayerLicenceContext(private val reactContext: ReactApplicationContext)
    : ReactContextBaseJavaModule(reactContext){

    private val bridgeName = "JWPlayerLicenceContext"

    override fun getName(): String {
        return bridgeName
    }

    @ReactMethod
    fun setLicenseKey(licenseKey: String?,
                      promise: Promise?) {
        if (licenseKey != null) {
            LicenseUtil.setLicenseKey(reactContext, licenseKey)
            promise?.resolve(true)
        } else {
            promise?.reject("Failed to add licence key", "Licence key was not passed or empty");
        }
    }


}