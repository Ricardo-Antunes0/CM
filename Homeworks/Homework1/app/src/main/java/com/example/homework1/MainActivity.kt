package com.example.homework1

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var textview: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1: Button = findViewById(R.id.b1)
        val b2: Button = findViewById(R.id.b2)
        val b3: Button = findViewById(R.id.b3)
        val b4: Button = findViewById(R.id.b4)
        val b5: Button = findViewById(R.id.b5)
        val b6: Button = findViewById(R.id.b6)
        val b7: Button = findViewById(R.id.b7)
        val b8: Button = findViewById(R.id.b8)
        val b9: Button = findViewById(R.id.b9)
        val b10: Button = findViewById(R.id.b10)
        val b11: Button = findViewById(R.id.b11)
        val b12: Button = findViewById(R.id.b12)

        val delete: ImageButton = findViewById(R.id.delete)
        val call: ImageButton = findViewById(R.id.call)

        textview = findViewById(R.id.textphone)

        Dexter.withContext(this)
            .withPermission(Manifest.permission.CALL_PHONE)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    // Ação a ser realizada quando a permissão é concedida
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    // Ação a ser realizada quando a permissão é negada
                }

                override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                    // Ação a ser realizada quando uma explicação da permissão deve ser mostrada ao usuário
                }
            })
            .check()

        b1.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "1"
        }

        b2.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "2"
        }
        b3.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "3"
        }
        b4.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "4"
        }
        b5.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "5"
        }
        b6.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "6"
        }
        b7.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "7"
        }
        b8.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "8"
        }
        b9.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "9"
        }
        b10.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "*"
        }
        b11.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "0"
        }
        b12.setOnClickListener {
            val currentText: String = textview.text.toString()
            textview.text = currentText + "#"
        }
        delete.setOnClickListener {
            val stringBuilder = StringBuilder(textview.text.toString())
            stringBuilder.deleteCharAt(textview.text.length - 1)
            textview.text = stringBuilder.toString()
        }


        call.seClictOnkListener { makePhoneCall() }
    }
        private fun makePhoneCall() {
            val number = textview.text.toString()
            val dial = "tel:$number"
            val intent = Intent(Intent.ACTION_CALL, Uri.parse(dial))

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            else
                startActivity(intent)
    }
}


