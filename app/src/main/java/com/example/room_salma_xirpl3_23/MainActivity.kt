package com.example.room_salma_xirpl3_23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.room_salma_xirpl3_23.dataroom.dbuser
import com.example.room_salma_xirpl3_23.dataroom.user
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val db by lazy { dbuser (this) }

    private lateinit var inputid: EditText
    private lateinit var inputnama: EditText
    private lateinit var inputjekel: EditText
    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputid = findViewById(R.id.edid)
        inputnama = findViewById(R.id.ednama)
        inputjekel = findViewById(R.id.edjekel)
        save = findViewById(R.id.btnsave)

        simpandata()
    }

    fun simpandata(){
        save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userdao().insertData(
                    //userDAO mengikuti class dbuser
                    //insertdata mengikuti class userDAo
                    user(
                        inputid.text.toString(),
                        inputnama.text.toString(),
                        inputjekel.text.toString()
                    )
                )
            }
            //menampilkan data
            startActivity(Intent(applicationContext, ActivityData::class.java))
        }
    }
}