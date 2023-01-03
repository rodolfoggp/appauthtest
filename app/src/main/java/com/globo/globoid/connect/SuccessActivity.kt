package com.globo.globoid.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationResponse

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
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