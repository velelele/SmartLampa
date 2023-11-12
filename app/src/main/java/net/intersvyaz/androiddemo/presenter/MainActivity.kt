package net.intersvyaz.androiddemo.presenter

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import net.intersvyaz.androiddemo.R
import net.intersvyaz.androiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

}