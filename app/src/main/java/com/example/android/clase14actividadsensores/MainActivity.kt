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




    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {


        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER)
        {
            var axisX: Float = event.values[0]
            var axisY: Float = event.values[1]
            var axisZ: Float = event.values[2]
            if (event.values[0] == axisX){
            lblPosition.text = "arriba"
            }
            }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        var txtView : TextView? = findViewById<TextView>(R.id.lblPosition)
        val sensorManager: SensorManager? = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        //var sensorManager : SensorManager? = null
        var sensorPosition: Sensor? = null
        //var lblPosicion = getText(ById(R.id.lblPosition)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (sensorManager!!.getSensorList(Sensor.TYPE_LIGHT) != null) {
            sensorPosition = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        } else
            Toast.makeText(this, "Acelerometro no disponible", Toast.LENGTH_SHORT).show()

    }
}
