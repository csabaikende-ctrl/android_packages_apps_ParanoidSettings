/*
 * SPDX-FileCopyrightText: 2026 Paranoid Android
 * SPDX-License-Identifier: Apache-2.0
 */

package co.aospa.settings.deviceinfo.firmwareversion

import android.content.Context
import android.os.SystemProperties
import com.android.settings.core.BasePreferenceController

class ParanoidAndroidMaintainerPreferenceController(
    context: Context,
    preferenceKey: String
) : BasePreferenceController(context, preferenceKey) {

    override fun getAvailabilityStatus(): Int =
        if (getSummary().isNotEmpty()) AVAILABLE_UNSEARCHABLE else UNSUPPORTED_ON_DEVICE

    override fun getSummary(): CharSequence =
        SystemProperties.get(PARANOID_ANDROID_MAINTAINER_PROP)

    companion object {
        private const val PARANOID_ANDROID_MAINTAINER_PROP = "ro.aospa.maintainer"
    }
}
