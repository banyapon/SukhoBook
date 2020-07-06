package th.ac.stou.sukhobook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import th.ac.stou.sukhobook.INetworkAPI
import th.ac.stou.sukhobook.MyAdapter
import th.ac.stou.sukhobook.R
import java.net.URL


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private val TAG : String = "MainActivity"

/**
 * A simple [Fragment] subclass.
 * Use the [MagazineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MagazineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_magazine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = getView()!!.findViewById(R.id.magazine_list) as RecyclerView
        recyclerView!!.layoutManager =  LinearLayoutManager(getContext());
        //val url = "https://vr-abcg.firebaseio.com/"
        val url = "https://scitechno.stou.ac.th/"
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(
                GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(url).build()

        val postsApi = retrofit.create(INetworkAPI::class.java)
        val response = postsApi.getAllPosts()
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            recyclerView!!.adapter = MyAdapter(it, getContext())
        }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MagazineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MagazineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }
}
