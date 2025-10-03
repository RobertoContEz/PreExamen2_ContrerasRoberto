package contreras.roberto.preexamen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val agregarBtn = findViewById<Button>(R.id.agregarBtn)
        agregarBtn.setOnClickListener {
            val intent = Intent(this, AgregarContacto::class.java)
            startActivity(intent)
        }

        val adaptador = AdaptadorContactos(Contacto.lista)
        val rv = findViewById<RecyclerView>(R.id.contactos)
        rv.layoutManager = GridLayoutManager(this, 2)
        rv.adapter = adaptador
    }
}