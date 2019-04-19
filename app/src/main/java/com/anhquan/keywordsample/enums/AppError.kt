package com.anhquan.keywordsample.enums

import com.anhquan.keywordsample.MainApplication
import com.anhquan.keywordsample.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

enum class AppError(var code: Int) {

    REQUEST_INVALID(400),
    REQUEST_NOT_FOUND(404),
    REQUEST_TIME_OUT(408),

    SERVER_INTERNAL_ERROR(500),
    NETWORK_CONNECTION(-999),
    UNEXPECTED(-1);

    var errorMsg: String = ""
    val description: String
        get() {
            val resources = MainApplication.instance.resources
            return when (code) {
                400, 404 -> resources.getString(R.string.bad_request)
                408 -> resources.getString(R.string.time_out)
                500 -> resources.getString(R.string.internal_error)
                -999 -> resources.getString(R.string.no_network)
                else -> resources.getString(R.string.unexpected)
            }
        }

    companion object {
        fun parse(code: Int): AppError {
            val values = values()
            for (e in values) {
                if (code == e.code) {
                    return e
                }
            }

            return UNEXPECTED
        }

        fun parse(t: Throwable): AppError {
            if (t is UnknownHostException
                || t is ConnectException
            ) {
                return NETWORK_CONNECTION

            } else if (t is SocketTimeoutException) {
                return REQUEST_TIME_OUT

            } else if (t is HttpException) {
                return parse(t.code())

            } else {
                return UNEXPECTED.apply {
                    errorMsg = t.javaClass.simpleName
                }
            }
        }
    }


}