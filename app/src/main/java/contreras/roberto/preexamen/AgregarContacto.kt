package contreras.roberto.preexamen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarContacto : AppCompatActivity() {
    val colores = listOf(
        R.color.rojo,
        R.color.azul,
        R.color.verde,
        R.color.amarillo,
        R.color.morado,
        R.color.naranja,
        R.color.cian,
        R.color.rosa
    )

    var color: Int = colores.random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        randomizarColor()

        findViewById<ImageView>(R.id.imagen).setOnClickListener {
            randomizarColor()
        }

        findViewById<Button>(R.id.agregarBtn).setOnClickListener {
            val contacto = Contacto(
                color = this.color,
                nombre = findViewById<EditText>(R.id.nombre).text.toString(),
                apellido = findViewById<EditText>(R.id.apellido).text.toString(),
                nacimiento = findViewById<EditText>(R.id.fecha).text.toString(),
                numero = findViewById<EditText>(R.id.numero).text.toString()
            )

            Contacto.lista.add(contacto)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }

    fun randomizarColor() {
        val imageView = findViewById<ImageView>(R.id.imagen)
        val drawable = ContextCompat.getDrawable(this, R.drawable.circle_shape)?.mutate()
        this.color = colores.random()
        val color = ContextCompat.getColor(this, this.color)
        drawable?.setTint(color)
        imageView.setImageDrawable(drawable)
    }
}