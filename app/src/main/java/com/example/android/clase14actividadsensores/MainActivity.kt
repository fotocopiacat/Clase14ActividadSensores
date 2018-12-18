package com.example.android.clase14actividadsensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_PROXIMITY
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.getSystemService
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.android.clase14actividadsensores.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), SensorEventListener {

    var txtView : TextView? = findViewById<TextView>(R.id.lblPosition)
    val sensorManager: SensorManager? = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    var sensorPosition: Sensor? = null
    var positionNumber : Float = 0.0f

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            lblPosition.text = event.values[0].toString()
            }
        }


    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (sensorManager?.getSensorList(Sensor.TYPE_LIGHT) != null) {
            sensorPosition = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        } else
            Toast.makeText(this, "Acelerometro no disponible", Toast.LENGTH_SHORT).show()

    }
}
