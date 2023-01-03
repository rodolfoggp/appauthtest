package com.globo.globoid.connect

import android.net.Uri
import net.openid.appauth.AuthorizationServiceConfiguration

//private const val BASE_URL = "https://id.qa.globoi.com/auth/realms/globo.com/protocol/openid-connect/"
private const val BASE_URL = "https://id.globo.com/auth/realms/globo.com/protocol/openid-connect/"
private const val AUTH = "auth"
private const val TOKEN = "token"
private val AUTH_URL = Uri.parse(BASE_URL + AUTH)
private val TOKEN_URL = Uri.parse(BASE_URL + TOKEN)

class OIDCConfiguration: AuthorizationServiceConfiguration(AUTH_URL, TOKEN_URL)