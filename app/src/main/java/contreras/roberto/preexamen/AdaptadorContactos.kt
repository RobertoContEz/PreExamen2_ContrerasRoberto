package contreras.roberto.preexamen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AdaptadorContactos (val contactos: List<Contacto>): RecyclerView.Adapter<AdaptadorContactos.ContactoViewHolder>() {

    class ContactoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imagen = itemView.findViewById(R.id.imagen) as ImageView
        var nombre = itemView.findViewById(R.id.nombre) as TextView
        var numero = itemView.findViewById(R.id.numero) as TextView

        var layout = itemView.findViewById(R.id.contacto_layout) as LinearLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contacto, parent, false)
        return ContactoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto: Contacto = contactos[position]
        holder.nombre.text = "${contacto.nombre} ${contacto.apellido}"
        holder.numero.text = contacto.numero

        val drawable = ContextCompat.getDrawable(holder.itemView.context!!, R.drawable.circle_shape)?.mutate()
        val color = ContextCompat.getColor(holder.itemView.context!!, contacto.color)
        drawable?.setTint(color)
        holder.imagen.setImageDrawable(drawable)

        holder.layout.setOnClickListener {
            var intent = Intent(holder.itemView.context, VerContacto::class.java)
            intent.putExtra("pos", position)
            holder.itemView.context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

}