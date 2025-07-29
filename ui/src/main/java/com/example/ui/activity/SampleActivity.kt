package com.example.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui.data.WidgetEvent
import com.example.ui.databinding.ActivitySampleInMainBinding
import org.greenrobot.eventbus.EventBus

class SampleActivity : AppCompatActivity() {

    private val viewBinding: ActivitySampleInMainBinding by lazy {
        ActivitySampleInMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.finishButton.setOnClickListener {
            EventBus.getDefault().post(WidgetEvent(1,"SampleActivity에서 전달된 값입니다!"))
            finish()
        }
    }
}