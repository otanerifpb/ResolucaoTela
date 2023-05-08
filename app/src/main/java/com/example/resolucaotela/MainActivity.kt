package com.example.resolucaotela

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: BroadcastReceiver
    private lateinit var tts: TextToSpeech
    private lateinit var crCabo: CarrenadorReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.tts = TextToSpeech(this, null)
        this.receiver = CarrenadorReceiver()
    }

//    override fun onResume() {
//        super.onResume()
//        var ifcarregador = IntentFilter().apply {
//            addAction(Intent.ACTION_POWER_CONNECTED)
//            addAction(Intent.ACTION_POWER_DISCONNECTED)
//        }
//        registerReceiver(this.crCabo, ifcarregador)
//        //Log.i("APP_LOG", "Cabo conectado")
//        //Toast.makeText(this@MainActivity, "Cabo conectado", Toast.LENGTH_SHORT).show()
//        //var texto = "Cabo conectado"
//        //this@MainActivity.tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null)
//    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.crCabo)
        //Log.i("APP_LOG", "Cabo desconectado")
        //Toast.makeText(this@MainActivity, "Cabo desconectado", Toast.LENGTH_SHORT).show()
        //var texto = "Cabo desconectado"
        //this@MainActivity.tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    inner class CarrenadorReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(this@MainActivity, "Cabo conectado", Toast.LENGTH_SHORT).show()
            //val status = intent?.getIntExtra("state", -1)
            Log.i("APP_LOG", "Conexão cabo")
            var texto = "Conexão cabo"
            this@MainActivity.tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }
}