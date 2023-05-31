package com.example.room_salma_xirpl3_23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room_salma_xirpl3_23.dataroom.dbuser
import com.example.room_salma_xirpl3_23.dataroom.user
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityData : AppCompatActivity() {

    private lateinit var activityAdapter: Adapter_Activity
    private lateinit var recyclerView: RecyclerView
    private val db by lazy { dbuser(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        recyclerView = findViewById(R.id.listdata)
        activityAdapter =
            Adapter_Activity(arrayListOf(), object : Adapter_Activity.onAdapterListener {
                override fun onClick(user: user) {
                    startActivity(
                        Intent(
                            applicationContext, ActivityData::class.java
                        ).putExtra("id", user.iduser)
                    )
                }
            })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = activityAdapter
        }

        CoroutineScope(Dispatchers.IO).launch {
            val data = db.userdao().getAll()
            //menampilkan data dr database
            withContext(Dispatchers.Main){
                activityAdapter.setdata(data)
            }
        }
    }
}



