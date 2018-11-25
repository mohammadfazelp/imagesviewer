package com.faz.imagesviewer.utils

object AppConstants {

    internal val APP_DB_NAME = "imagesviewer.db"
    internal val PREF_NAME = "imagesviewer_pref"
    internal val NULL_INDEX = -1L

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}