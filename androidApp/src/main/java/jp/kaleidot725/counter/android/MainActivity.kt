package jp.kaleidot725.counter.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import jp.kaleidot725.counter.shared.MyCounter
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

val counter = MyCounter(min = 0, max = 100)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var count by remember { mutableStateOf(counter.value) }

            Column {
                Text(text = count.toString())

                Button(onClick = {
                    counter.plus()
                    count = counter.value
                }) {
                    Text(text = "PLUS")
                }

                Button(onClick = {
                    counter.minus()
                    count = counter.value
                }) {
                    Text(text = "MINUS")
                }
            }
        }
    }
}
