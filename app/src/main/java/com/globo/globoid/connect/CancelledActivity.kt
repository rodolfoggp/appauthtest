package com.globo.globoid.connect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationResponse


class CancelledActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancelled)
        onComplete()
    }

    private fun onComplete() {
        val resp = AuthorizationResponse.fromIntent(intent)
        val ex = AuthorizationException.fromIntent(intent)
        if (resp != null) {
            // authorization completed
            print(resp)
        } else {
            // authorization failed, check ex for more details
            print(ex)
        }
    }
}