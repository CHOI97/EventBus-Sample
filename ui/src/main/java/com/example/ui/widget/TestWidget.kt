import com.example.ui.activity.SampleActivity

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ui.data.WidgetEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TestWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private val sendButton: Button
    private val receivedTextView: TextView

    init {
        orientation = VERTICAL

        sendButton = Button(context).apply {
            text = "SampleActivity 열기"
            setOnClickListener {
                context.startActivity(
                    Intent(context, SampleActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // context가 ApplicationContext일 경우 필요
                    }
                )
            }
        }

        receivedTextView = TextView(context).apply {
            text = "이벤트를 기다리는 중..."
        }

        addView(sendButton)
        addView(receivedTextView)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        EventBus.getDefault().register(this)
    }

    override fun onDetachedFromWindow() {
        EventBus.getDefault().unregister(this)
        super.onDetachedFromWindow()
    }

    @Suppress("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onWidgetEvent(event: WidgetEvent) {
        receivedTextView.text = "SampleActivity 종료 메시지: ${event.message}"
    }
}