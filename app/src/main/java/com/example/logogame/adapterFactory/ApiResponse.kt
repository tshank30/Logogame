package com.airtel.kcore.entity

import com.airtel.kcore.util.API_FAILURE_DEFAULT
import com.airtel.kcore.util.DEFAULT_ERROR_MSG
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import java.io.Serializable


data class ApiResponse<T>(
    @SerializedName("status")
    var status: Status?,
    @SerializedName("statusType")
    var statusType: StatusType,
    @SerializedName("result")
    var result: T?
) : Serializable {
    constructor() : this(null, StatusType.SUCCESS, null)
    constructor(result: T?) : this(null, StatusType.SUCCESS, result)

    companion object {


        fun <T> create(error: Throwable): ApiResponse<T> {
            return ApiResponse(
                Status(
                    API_FAILURE_DEFAULT.toString(),
                    error.message ?: DEFAULT_ERROR_MSG
                ),
                StatusType.ERROR,
                null
            )
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {

            return if (response.code() == 401) {
                return ApiResponse(
                    Status(response.code().toString(), "UnAuthorized Request"),
                    StatusType.ERROR,
                    null
                )
            } else if (response.code() == 200 && response.body() != null) {
                val body = response.body() as T
                return ApiResponse(
                    Status(response.code().toString(), "success"),
                    StatusType.SUCCESS,
                    body
                )
            } else {
                return ApiResponse(
                    Status(response.code().toString(), DEFAULT_ERROR_MSG),
                    StatusType.ERROR,
                    null
                )

            }

        }
    }

}

data class Status(
    @SerializedName("code")
    val code: String,
    @SerializedName("message")
    val message: String?
) : Serializable

enum class StatusType {
    SUCCESS, ERROR, LOADING
}