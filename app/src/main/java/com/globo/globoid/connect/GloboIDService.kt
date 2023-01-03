package com.globo.globoid.connect

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.ResponseTypeValues
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_MUTABLE
import android.os.Build
import android.os.Build.VERSION.SDK_INT as API_LEVEL

class GloboIDService(
    private val context: Context
) : AuthorizationService(context) {

    fun authorize() = performAuthorizationRequest(
        request,
        PendingIntent.getActivity(context, 0, Intent(context, SuccessActivity::class.java), flags),
        PendingIntent.getActivity(context, 0, Intent(context, CancelledActivity::class.java), flags),
    )

    private val additionalParameters = mapOf(
        "f__ga" to "f__ga",
        "f_area" to "f_area",
        "f_cpnt" to "f_cpnt",
        "f_email" to "f_email",
        "f_glbproduct" to "f_glbproduct",
        "f_label" to "f_label",
        "f_origemId" to "f_origemId",
        "f_tparea" to "f_tparea",
        "f_tpcpnt" to "f_tpcpnt",
        "f_tpidtit" to "f_tpidtit",
        "f_tplabel" to "f_tplabel",
        "f_tppagorig" to "f_tppagorig"
    )

    private val authorizationRequestBuilder = AuthorizationRequest.Builder(
        OIDCConfiguration(),
        "globoid-connect-sdk",
        ResponseTypeValues.CODE,
        Uri.parse("com.globo.globoid.connect://callback"),
    )

    private val request = authorizationRequestBuilder
        .setScopes("glbid")
        .setAdditionalParameters(additionalParameters)
        .build()

    private val flags get() =
        if (apiLevel > Build.VERSION_CODES.S) FLAG_MUTABLE else 0

    private val apiLevel = BuildConfig.COMPILE_SDK_VERSION
}