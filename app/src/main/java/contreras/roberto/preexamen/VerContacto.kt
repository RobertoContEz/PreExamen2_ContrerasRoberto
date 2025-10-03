package contreras.roberto.preexamen

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.volverBtn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        if (bundle != null) {
            val contacto = Contacto.lista[bundle.getInt("pos")]

            findViewById<TextView>(R.id.nombre).text = "Nombre: ${contacto.nombre}"
            findViewById<TextView>(R.id.apellido).text = "Apellido: ${contacto.apellido}"
            findViewById<TextView>(R.id.fecha).text = "Fecha de nacimiento: ${contacto.nacimiento}"
            findViewById<TextView>(R.id.numero).text = "Número de teléfono: ${contacto.numero}"

            val drawable = ContextCompat.getDrawable(this, R.drawable.circle_shape)?.mutate()
            val color = ContextCompat.getColor(this, contacto.color)
            drawable?.setTint(color)
            findViewById<ImageView>(R.id.imagen).setImageDrawable(drawable)
        }
    }
}