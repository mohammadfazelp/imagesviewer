package com.faz.imagesviewer.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.faz.imagesviewer.di.PreferenceInfo
import com.faz.imagesviewer.utils.AppConstants
import javax.inject.Inject

class PreferenceHelper @Inject constructor(context: Context,
                                           @PreferenceInfo private val prefFileName: String) :
        IPreferenceHelper {

    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
            AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun getCurrentUserName(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC")

    override fun setCurrentUserName(userName: String?) = mPrefs.edit {
        putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL,
            "abc@gmail.com")

    override fun setCurrentUserEmail(email: String?) = mPrefs.edit {
        putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getAccessToken(): String = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) = mPrefs.edit {
        putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun getCurrentUserId(): Long? {
        val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return when (userId) {
            AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        mPrefs.edit { putLong(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }
}