package com.example.broadcastservicetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import com.example.broadcastservicetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    private var networkSwitch: Switch?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.networkSwitch?.setOnCheckedChangeListener { _, isChecked ->
            val intent = Intent(this, NetworkService::class.java)
            if (isChecked) {
                startService(intent)
            } else {
                stopService(intent)
            }
        }
    }
}