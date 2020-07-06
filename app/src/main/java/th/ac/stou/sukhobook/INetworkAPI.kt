package th.ac.stou.sukhobook

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("99422/stoubook.json")
    fun getAllPosts(): Observable<List<Magazine>>
}