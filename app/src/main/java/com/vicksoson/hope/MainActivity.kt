package com.vicksoson.hope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicksoson.hope.api.ApiClient
import com.vicksoson.hope.api.DataAdapter
import com.vicksoson.hope.api.RecyclerResponse
import com.vicksoson.hope.databinding.ActivityMainBinding
import com.vicksoson.hope.model.Items
import com.vicksoson.hope.ui.homescreen.Clicks
import com.vicksoson.hope.ui.homescreen.ItemAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Clicks {

    private val  adapter = ItemAdapter(this)
    private lateinit var binding: ActivityMainBinding
    var dataList = ArrayList < RecyclerResponse > ()
    private lateinit var recyclerView: RecyclerView
    var myAdapter: DataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        recyclerView = findViewById(R.id.items_rv)
        //initiate the grid  view
        //in this case I make row grid in a row
        //if you want to change that change the number

        myAdapter = DataAdapter(dataList, this)
        recyclerView.adapter = myAdapter

        //val adapter = ItemAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        //recyclerView.adapter = adapter

        //add data
        getDat1a()

        val items = mutableListOf(
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4),
            Items("A pair of trousers","42cm","12",R.drawable.rectangle_4)
        )
        //adapter.setupItems(items)

    }

    override fun onClick(position: String) {
        TODO("Not yet implemented")
    }


    private fun getDat1a() {
        val call: Call<List<RecyclerResponse>> = ApiClient.getClient.getItems()
        call.enqueue(object: Callback<List<RecyclerResponse>> {
            override fun onResponse(call: Call < List < RecyclerResponse >> ? ,
                                    response : Response<List<RecyclerResponse>>? ) {
                dataList.addAll(response!!.body() !!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }
            override fun onFailure(call: Call < List < RecyclerResponse >> ? , t : Throwable ? ) {

            }
        })
    }
}